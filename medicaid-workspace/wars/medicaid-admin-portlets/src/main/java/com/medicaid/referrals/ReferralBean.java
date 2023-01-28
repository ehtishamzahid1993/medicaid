package com.medicaid.referrals;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.medicaid.app.model.Facility;
import com.medicaid.app.model.Note;
import com.medicaid.app.model.Patient;
import com.medicaid.app.model.Referral;
import com.medicaid.app.service.FacilityLocalServiceUtil;
import com.medicaid.app.service.NoteLocalServiceUtil;
import com.medicaid.app.service.PatientLocalServiceUtil;
import com.medicaid.app.service.ReferralLocalServiceUtil;
import com.medicaid.common.util.FormattingUtil;
import com.medicaid.common.util.SessionUtil;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "referralBean")
@ViewScoped
public class ReferralBean implements Serializable {

	private static final long serialVersionUID = 1L;
	Log log = LogFactoryUtil.getLog(ReferralBean.class);
	
	private List<Referral> referralList=new ArrayList<Referral>();
	private Referral referral;
	private List<Facility> facilities=new ArrayList<Facility>();
	private HashMap<String, Facility> facilitiesMap=new HashMap<String, Facility>();
	private HashMap<Long, Patient> pateientsMap=new HashMap<Long, Patient>();
	private List<User> facilityAdminList=new ArrayList<User>();
	private List<Patient> patientList=new ArrayList<Patient>();
	private List<String> referralStatus=new ArrayList<String>();
	private Boolean isEdit=false;
	private ThemeDisplay themeDisplay;
	private User user;

	private List<String> selectedFacilities=new ArrayList<String>();
	private Date todaysDate=new Date();
	private List<Note> notesList;
	private String notes="";
	private Note note;
	
	private Boolean editReferral=true;

	
	
	@PostConstruct
	public void init() {
		log.info("inside ReferralBean init");
		
		themeDisplay = LiferayPortletHelperUtil.getThemeDisplay();
		user=themeDisplay.getUser();
		
		

		try {
			String facilityIds="";
			try {
				facilityIds=(String) user.getExpandoBridge().getAttribute("Facilities");
				log.info("facilityIds "+facilityIds);
			} catch (Exception e) {
				log.error(FormattingUtil.getMessage(e));
			}
			if(facilityIds!=null && !facilityIds.trim().equals(""))
			{
				String[] array=facilityIds.split(",");
				try {
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Referral.class, PortalClassLoaderUtil.getClassLoader());
					for (int i = 0; i < array.length; i++) {
						dynamicQuery.add(PropertyFactoryUtil.forName("facilities").like("%"+array[i]+",%"));
					}					
					referralList = ReferralLocalServiceUtil.dynamicQuery(dynamicQuery);
				} catch (Exception e) {
					log.error(FormattingUtil.getMessage(e));
				}
				try {
					for (int i = 0; i < array.length; i++) {
						facilities.add(FacilityLocalServiceUtil.getFacility(Long.valueOf(array[i])));
					}
				} catch (Exception e) {
					log.error(FormattingUtil.getMessage(e));
				}
				log.info("facilities "+facilities.size());
				
			}else
			{
				referralList=new ArrayList<Referral>();
				facilities=new ArrayList<Facility>();
			}
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
	
		
		
		facilitiesMap=FacilityLocalServiceUtil.getFacilityMap();
		pateientsMap=PatientLocalServiceUtil.getPatientMap();
		try {
			Role role=RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), "Facility Admin");
			facilityAdminList=UserLocalServiceUtil.getInheritedRoleUsers(role.getRoleId(), -1, -1, null);
		} catch (PortalException e1) {
			log.error(FormattingUtil.getMessage(e1));
		}
		patientList=PatientLocalServiceUtil.getPatients(-1, -1);
		
		referralStatus.add("Approved");
		referralStatus.add("Submitted");
		referralStatus.add("Denied");
		referralStatus.add("Withdrawn");
		referralStatus.add("Pending");
		notesList=new ArrayList<Note>();
		
		try {
			referral=(Referral) SessionUtil.getSessionAttribute("referral");
			isEdit= (Boolean) SessionUtil.getSessionAttribute("isEdit");
			if(isEdit==null) {
				isEdit=false;
			}
			
			log.info("isEdit "+isEdit);
			log.info("referral "+referral);
			
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		if(isEdit==null) {
			referral=ReferralLocalServiceUtil.createReferral(0);
		}else if(!isEdit ) {
			referral=ReferralLocalServiceUtil.createReferral(0);
		}
		
		try {
			setFacilities();
		}catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		try {
			setNotes();
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		if(referral!=null)
		{	
			if(isEdit) {
				if(referral.getStatus().equals("Denied") || referral.getStatus().equals("Withdrawn")) {
					editReferral=false;
				}
			}
		}
		
	
	}
	
	private void setNotes() {
		try {
			if(isEdit && referral!=null) {
				notesList=NoteLocalServiceUtil.findByReferralId(referral.getReferralId());
			}
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		
	}

	private void setFacilities() {
		if(isEdit && referral!=null) {
		String facilityIds=referral.getFacilities();
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
	
	public String getNoteDate(Date commentDate) {
		return getStringDate(commentDate, "dd/MM/yyyy");
	}
	
	public static String getStringDate(Date date, String format) {
		try {
			if (date != null) {
				SimpleDateFormat formatter = new SimpleDateFormat(format);
				return formatter.format(date);
			}
		} catch (Exception ex) {
			
		}
		return null;
	}
	
	public String save()
	{
		if(referral.getReferralId()==0) {
			referral.setReferralId(CounterLocalServiceUtil.increment(Referral.class.getCanonicalName()));
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
			
			referral.setFacilities(selectedFacility);
		}
		
		
		log.info("referral "+referral);
		try {
			if(notes!=null && !notes.trim().equals("")) {
				note=NoteLocalServiceUtil.createNote(CounterLocalServiceUtil.increment(Note.class.getCanonicalName()));
				note.setCommentDate(new Date());
				note.setReferralId(referral.getReferralId());
				note.setComments(notes);
				NoteLocalServiceUtil.updateNote(note);
			}
			
			
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		log.info("note "+note);
		ReferralLocalServiceUtil.updateReferral(referral);
		SessionUtil.removeSessionAttribute("referral");
		SessionUtil.setSessionAttribute("isEdit", false);
		return "view?faces-redirect=true";
	}
	
	
	public String addNewReferral() {
		log.info("inside add referral");		
		log.info("referral "+referral );		
		return "addEdit?faces-redirect=true";
	}
	
	public String redirectToViewPage() {
		log.info("inside add referral");		
		log.info("referral "+referral );		
		return "view?faces-redirect=true";
	}
	public String editReferral()
	{
		isEdit=true;
		log.info("referral "+referral);
		
		if(referral.getStatus().equals("Denied") || referral.getStatus().equals("Withdrawn")) {
			FacesMessage message = new FacesMessage("Cannot Edit Denied and Withdrawn Referrals");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
		}else
		{
			SessionUtil.setSessionAttribute("referral", referral);
			SessionUtil.setSessionAttribute("isEdit", true);
			return "addEdit?faces-redirect=true";
		}
		
		
		
		
	}
	
	
	
	
	
	public String getFacilityName(String facilityIds) {
		String facilityNames="";
		try {
			String[] array=facilityIds.split(",");
			if(array!=null && array.length>0)
			{
				for (int i = 0; i < array.length; i++) {
					Facility facility=facilitiesMap.get(array[i]);
					facilityNames+=facility.getName();
					if(i<(array.length-1))
					{
						facilityNames+=", "; 
					}
				}
			}
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		return facilityNames;
	}
	
	public String getFacilityAdmin(String facilityAdmins)
	{
		String facilityAdminNames="";
		try {
				User user=UserLocalServiceUtil.getUserByScreenName(PortalUtil.getDefaultCompanyId(), facilityAdmins);
				
				facilityAdminNames+=user.getFirstName() +" "+user.getLastName();
			
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		return facilityAdminNames;
	}
	
	public String getPatientName(Long patientId) {
		return pateientsMap.get(patientId).getFirstName()+" "+pateientsMap.get(patientId).getLastName();
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public List<Referral> getReferralList() {
		return referralList;
	}

	public void setReferralList(List<Referral> referralList) {
		this.referralList = referralList;
	}

	public Referral getReferral() {
		return referral;
	}

	public void setReferral(Referral referral) {
		this.referral = referral;
	}

	public List<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<Facility> facilities) {
		this.facilities = facilities;
	}

	public HashMap<String, Facility> getFacilitiesMap() {
		return facilitiesMap;
	}

	public void setFacilitiesMap(HashMap<String, Facility> facilitiesMap) {
		this.facilitiesMap = facilitiesMap;
	}

	public HashMap<Long, Patient> getPateientsMap() {
		return pateientsMap;
	}

	public void setPateientsMap(HashMap<Long, Patient> pateientsMap) {
		this.pateientsMap = pateientsMap;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public List<String> getReferralStatus() {
		return referralStatus;
	}

	public void setReferralStatus(List<String> referralStatus) {
		this.referralStatus = referralStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public List<User> getFacilityAdminList() {
		return facilityAdminList;
	}

	public void setFacilityAdminList(List<User> facilityAdminList) {
		this.facilityAdminList = facilityAdminList;
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

	public List<String> getSelectedFacilities() {
		return selectedFacilities;
	}

	public void setSelectedFacilities(List<String> selectedFacilities) {
		this.selectedFacilities = selectedFacilities;
	}

	public Date getTodaysDate() {
		return todaysDate;
	}

	public void setTodaysDate(Date todaysDate) {
		this.todaysDate = todaysDate;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<Note> getNotesList() {
		return notesList;
	}

	public void setNotesList(List<Note> notesList) {
		this.notesList = notesList;
	}

	public Boolean getEditReferral() {
		return editReferral;
	}

	public void setEditReferral(Boolean editReferral) {
		this.editReferral = editReferral;
	}

	
	
	

	
	
}
