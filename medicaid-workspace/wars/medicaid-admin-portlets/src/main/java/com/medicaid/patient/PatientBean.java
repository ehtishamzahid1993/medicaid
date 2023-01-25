package com.medicaid.patient;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.medicaid.app.model.Document;
import com.medicaid.app.model.Facility;
import com.medicaid.app.model.Patient;
import com.medicaid.app.service.DocumentLocalServiceUtil;
import com.medicaid.app.service.FacilityLocalServiceUtil;
import com.medicaid.app.service.FacilityServiceUtil;
import com.medicaid.app.service.PatientLocalServiceUtil;
import com.medicaid.common.util.FormattingUtil;
import com.medicaid.common.util.SessionUtil;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FilesUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.model.file.UploadedFiles;
import org.primefaces.shaded.commons.io.FilenameUtils;

@ManagedBean(name = "patientBean")
@ViewScoped
public class PatientBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	Log log = LogFactoryUtil.getLog(PatientBean.class);
	
	private List<Patient> patientsList=new ArrayList<Patient>();
	private Boolean isEdit=false;
	private Patient patient;
	private ThemeDisplay themeDisplay;
	private User user;
	private Date todaysDate=new Date();
	
	private List<String> states=new ArrayList<String>();
	private JSONObject statesObject=null;
	
	private List<Facility> facilities;
	private List<String> selectedFacilities=new ArrayList<String>();
	
	 private UploadedFiles files;
	 List<UploadedFile> uploadedFiles=new ArrayList<UploadedFile>();
	 
	 private List<Document> documentsList;
	
	@PostConstruct
	public void init() {
		log.info("inside patient init");
		
		themeDisplay = LiferayPortletHelperUtil.getThemeDisplay();
		user=themeDisplay.getUser();
		patientsList=PatientLocalServiceUtil.getPatients(-1, -1);
		try {
			patient=(Patient) SessionUtil.getSessionAttribute("patient");
			isEdit= (Boolean) SessionUtil.getSessionAttribute("isEdit");
			
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		if(isEdit==null) {
			patient=PatientLocalServiceUtil.createPatient(0);
		}else if(!isEdit ) {
			patient=PatientLocalServiceUtil.createPatient(0);
		}
		
		try {
			statesObject=FacilityServiceUtil.retrieveStates();
			if(states!=null)
			{
				JSONArray array=statesObject.getJSONArray("states");
				for (int i = 0; i < array.length(); i++) {
					JSONObject jsonObject=array.getJSONObject(i);
					states.add(jsonObject.getString("name"));
				}
			}
		}catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		facilities=FacilityLocalServiceUtil.getFacilities(-1, -1);
		try {
			setFacilities();
		}catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		try {
			getDocuments(patient);
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
			
		
		
	}
	
	private void getDocuments(Patient patient2) {
		try {
			if(isEdit && patient!=null) {
				if(patient.getDocumentIds()!=null && !patient.getDocumentIds().trim().equals("")) {
					documentsList=DocumentLocalServiceUtil.findByPatientId(patient.getPatientId());
				}
			}
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		
	}
	
	public void deleteDocument(Document document)
	{
		try {
			DLFileEntryLocalServiceUtil.deleteDLFileEntry(document.getFileId());
			DocumentLocalServiceUtil.deleteDocument(document);
			log.info("document deleted");
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
	}

	
	public String returnFileUrl(Document document) {
		log.info("inside return label::" + document.getFileUrl());
		return document.getFileUrl();

	}
	
	public void handleFilesUpload(FilesUploadEvent event) {
        for (UploadedFile f : event.getFiles().getFiles()) {
        	
            FacesMessage message = new FacesMessage("Successful", f.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }


	private void setFacilities() {
		if(isEdit && patient!=null) {
		String facilityIds=patient.getFacilityId();
		if(facilityIds!=null && !facilityIds.trim().equals("")) {
			String[] array=facilityIds.split(",");
			for (int i = 0; i < array.length; i++) {
				try {
					Facility facility=FacilityLocalServiceUtil.getFacility(Long.valueOf(array[i]));
					String value=""+ facility;
					selectedFacilities.add(value);
				} catch (Exception e) {
					log.error(FormattingUtil.getMessage(e));
				}
			}
		}
		}
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		uploadedFiles.add(event.getFile());
        FacesMessage message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    }
	
	
	private File getFile(UploadedFile uploadedFile) {
	    try {
	        Path tmpFile = Files.createTempFile(FilenameUtils.getBaseName(uploadedFile.getFileName()), "." + FilenameUtils.getExtension(uploadedFile.getFileName()));
	        Files.copy(uploadedFile.getInputStream(), tmpFile, StandardCopyOption.REPLACE_EXISTING);
	        return tmpFile.toFile();
	    } catch (IOException e) {
	        log.error(FormattingUtil.getMessage(e));
	        return null;
	    }
	}
	
	public String save()
	{
		String dlFileEntryIds="";
		if(uploadedFiles!=null)
		{
			for (UploadedFile file : uploadedFiles) {
				try {
					File newFile = getFile(file);
					DLFileEntry dlFileEntry=com.medicaid.common.util.ImageUtil.createNewFileEntrybyDocumentPath(newFile, "patients/"+patient.getPatientId()+"/"+patient.getFirstName(),patient.getPatientId());
					dlFileEntryIds+=dlFileEntry.getFileEntryId()+",";
					
					
				} catch (Exception e) {
					log.error(FormattingUtil.getMessage(e));
				}
			}
		}
		patient.setDocumentIds(dlFileEntryIds);
		if(patient.getPatientId()==0) {
			patient.setPatientId(CounterLocalServiceUtil.increment(Patient.class.getCanonicalName()));
		}
		log.info("selectedFacilities "+selectedFacilities);
		if(selectedFacilities!=null) {
			String selectedFacility="";
			for (int i = 0; i < selectedFacilities.size(); i++) {
				try {
					String facility=selectedFacilities.get(i);
					String[] array=facility.split(",");
					String[] childArray=array[0].split("=");
					log.info("childArray "+childArray[1]);

					selectedFacility+=childArray[1]+",";
				} catch (Exception e) {
					log.error(FormattingUtil.getMessage(e));
				}
			}
			
			patient.setFacilityId(selectedFacility);
		}
		patient.setReferralId(0L); // need to remove
		try {
			PatientLocalServiceUtil.updatePatient(patient);
			log.info("patient saved");
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		SessionUtil.removeSessionAttribute("patient");
		SessionUtil.setSessionAttribute("isEdit", false);
		return "view?faces-redirect=true";
	}
	
	
	public String addNewPatient() {
		log.info("inside add patient");		
		log.info("patient "+patient );
		
		return "addEdit?faces-redirect=true";
	}
	public String editPatient()
	{
		isEdit=true;
		SessionUtil.setSessionAttribute("patient", patient);
		SessionUtil.setSessionAttribute("isEdit", true);
		return "addEdit?faces-redirect=true";
	}


	public Log getLog() {
		return log;
	}


	public void setLog(Log log) {
		this.log = log;
	}


	public List<Patient> getPatientsList() {
		return patientsList;
	}


	public void setPatientsList(List<Patient> patientsList) {
		this.patientsList = patientsList;
	}


	public Boolean getIsEdit() {
		return isEdit;
	}


	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public ThemeDisplay getThemeDisplay() {
		return themeDisplay;
	}


	public void setThemeDisplay(ThemeDisplay themeDisplay) {
		this.themeDisplay = themeDisplay;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<String> getStates() {
		return states;
	}


	public void setStates(List<String> states) {
		this.states = states;
	}


	public JSONObject getStatesObject() {
		return statesObject;
	}


	public void setStatesObject(JSONObject statesObject) {
		this.statesObject = statesObject;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Date getTodaysDate() {
		return todaysDate;
	}


	public void setTodaysDate(Date todaysDate) {
		this.todaysDate = todaysDate;
	}


	public List<Facility> getFacilities() {
		return facilities;
	}


	public void setFacilities(List<Facility> facilities) {
		this.facilities = facilities;
	}


	public List<String> getSelectedFacilities() {
		return selectedFacilities;
	}


	public void setSelectedFacilities(List<String> selectedFacilities) {
		this.selectedFacilities = selectedFacilities;
	}

	public UploadedFiles getFiles() {
		return files;
	}

	public void setFiles(UploadedFiles files) {
		this.files = files;
	}

	public List<UploadedFile> getUploadedFiles() {
		return uploadedFiles;
	}

	public void setUploadedFiles(List<UploadedFile> uploadedFiles) {
		this.uploadedFiles = uploadedFiles;
	}

	public List<Document> getDocumentsList() {
		return documentsList;
	}

	public void setDocumentsList(List<Document> documentsList) {
		this.documentsList = documentsList;
	}


	


	


	
	
	

}
