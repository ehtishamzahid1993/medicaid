package com.medicaid.common.util;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.exception.DuplicateFileEntryException;
import com.liferay.document.library.kernel.exception.DuplicateFolderNameException;
import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.medicaid.app.model.Document;
import com.medicaid.app.service.DocumentLocalServiceUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;

public class ImageUtil {
	static Log log = LogFactoryUtil.getLog(ImageUtil.class);
	
	public static DLFileEntry createNewFileEntrybyDocumentPath(File file, String documentPath,Long patientId) {
		log.info("createFileEntrybyDocumentPath:");
		log.info("documentPath "+documentPath);
		try {
			DLFolder dlfolder = null;
			com.liferay.portal.kernel.service.ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			log.info("serviceContext.getUserId():" + serviceContext.getUserId());
			long userId = serviceContext.getUserId();
			long groupId = GroupLocalServiceUtil.fetchFriendlyURLGroup(PortalUtil.getDefaultCompanyId(),"/facility-admin")
					.getGroupId();
			log.info("group id " + groupId);
			String[] paths = documentPath.split("/");
			
			for (int i = 0; i < paths.length; i++) {
				String folderName = paths[i];
				log.info("folders " + folderName);
				if (i == 0) {
					dlfolder = createFolder(userId, groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName, serviceContext);
				}
				if (dlfolder != null && !folderName.equals(paths[0])) {
					dlfolder = createFolder(userId, groupId, dlfolder.getFolderId(), folderName, serviceContext);
					log.info("dlfolder " + dlfolder.getFolderId() + "dlfolder name: " + dlfolder.getName());
				}
			}

			if (dlfolder != null && dlfolder.getName() != null) {
				return newdocumentUpload(file, dlfolder, file.getName(), userId, groupId, serviceContext,patientId);
			}
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		return null;
	}
	
	
	public static DLFileEntry newdocumentUpload(File file, DLFolder dlFolder, String rootFolderDesc, long userId, long groupId,
			ServiceContext serviceContext,Long patientId) {
		try {
			log.info("documentUpload:" + file.getName() + " dlfolder:" + dlFolder.getName());
			DLFileEntry dlFileEntry = null;
			String mimeType = MimeTypesUtil.getContentType(file);
			String title = file.getName();
			String changeLog = "upload documents";
			try {
				long fileEntryTypeId = dlFolder.getDefaultFileEntryTypeId();
				InputStream input = new FileInputStream(file);
				/***** Add Files into document and media **/
				try {
					dlFileEntry = DLFileEntryLocalServiceUtil.getFileEntry(groupId, dlFolder.getFolderId(), title);
					if (dlFileEntry != null && (dlFileEntry.getFileName().equals(file.getName()))) {
						log.info(":Deleted already exist file:");
						DLFileEntryLocalServiceUtil.deleteDLFileEntry(dlFileEntry);
					}
				} catch (PortalException e) {
					log.warn(FormattingUtil.getMessage(e));
				} catch (Exception e) {
					log.error(FormattingUtil.getMessage(e));
				}
				log.info(":File Uploaded Successfully:" + file.getName());
				dlFileEntry = DLFileEntryLocalServiceUtil.addFileEntry(userId, groupId, groupId, dlFolder.getFolderId(), file.getName(), mimeType,
						title, rootFolderDesc, changeLog, fileEntryTypeId, null, file, input, file.length(), serviceContext);
				dlFileEntry = DLFileEntryLocalServiceUtil.updateStatus(dlFileEntry.getUserId(), dlFileEntry.getFileVersion().getFileVersionId(),
						WorkflowConstants.STATUS_APPROVED, serviceContext, new HashMap<String, Serializable>());
				
				try {
					createDocument(dlFileEntry,patientId);
				} catch (Exception e) {
					log.error(FormattingUtil.getMessage(e));
				}
				
				return dlFileEntry;
			} catch (PortalException e) {
				log.error(FormattingUtil.getMessage(e));
			} catch (SystemException e) {
				log.error(FormattingUtil.getMessage(e));
			}
		} catch (IOException e) {
			log.error(FormattingUtil.getMessage(e));
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		return null;
	}
	
	
	private static void createDocument(DLFileEntry dlFileEntry,Long patientId) {
		try {
			Document document=DocumentLocalServiceUtil.createDocument(CounterLocalServiceUtil.increment(Document.class.getCanonicalName()));
			document.setPatientId(patientId);
			document.setFileId(dlFileEntry.getFileEntryId());
			document.setDocName(dlFileEntry.getFileName());
			document.setFileUrl("/documents/" + dlFileEntry.getRepositoryId() + "/" + dlFileEntry.getUuid());
			DocumentLocalServiceUtil.updateDocument(document);
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		
	}


	public static DLFolder createFolder(long userId, long groupId, long folderId, String folderName, ServiceContext serviceContext) {
		DLFolder dlroDlFolder = null;
		try {
			boolean mountPoint = false;
			boolean hidden = false;
			boolean folderExist = folderExist(groupId, folderName, folderId);
			if (!folderExist) {
				log.info(folderName + " :doesn't exist");
				serviceContext.setAddGuestPermissions(true);
				dlroDlFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, mountPoint, folderId, folderName, "BTIC", hidden,
						serviceContext);

				log.info(":::Folder created successfully:::");
			} else {
				log.info(folderName + " :already exist");
				dlroDlFolder = DLFolderLocalServiceUtil.getFolder(groupId, folderId, folderName);
			}
			try {
				changeFolderToGuest("" + dlroDlFolder.getFolderId());
			} catch (SystemException e) {
				log.error(FormattingUtil.getMessage(e));
			}
			return dlroDlFolder;
		} catch (Exception e) {
			if (e instanceof NoSuchFolderException || e instanceof DuplicateFileEntryException || e instanceof DuplicateFolderNameException) {
			} else {
				log.error(FormattingUtil.getMessage(e));
			}
		}

		return dlroDlFolder;

	}
	
	
	public static boolean folderExist(long groupId, String folderName, long folderId) {
		boolean folderExist = false;
		try {
			DLFolder folder = DLFolderLocalServiceUtil.getFolder(groupId, folderId, folderName);
			if (folder != null && folder.getName() != null) {
				folderExist = true;
			}
		} catch (Exception e) {
			if (e instanceof NoSuchFolderException || e instanceof DuplicateFileEntryException || e instanceof DuplicateFolderNameException) {
			} else {
				log.error(e.getMessage());
			}

		}
		return folderExist;
	}
	
	public static void changeFolderToGuest(String folderId) throws SystemException {
		log.info(":::::::Change folder ToGuest::::::::::::");
		final long companyId = PortalUtil.getDefaultCompanyId();
		String dlFileFolderResourceName = DLFolder.class.getName();
		String[] actionIds = new String[] { ActionKeys.VIEW };
		try {
			Role guestRole = RoleLocalServiceUtil.getRole(companyId, RoleConstants.GUEST);
			// Change Folder Permission to Guest View

			ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId, dlFileFolderResourceName, ResourceConstants.SCOPE_INDIVIDUAL,
					folderId, guestRole.getRoleId(), actionIds);

			log.info(":::::::Change folder ToGuest DONE::::::::::::");
		} catch (PortalException e) {
			log.error(FormattingUtil.getMessage(e));
		}
	}

}
