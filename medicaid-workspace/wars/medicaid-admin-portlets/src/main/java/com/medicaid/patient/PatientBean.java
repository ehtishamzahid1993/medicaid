package com.medicaid.patient;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.medicaid.app.model.Facility;
import com.medicaid.app.model.Patient;
import com.medicaid.app.service.FacilityLocalServiceUtil;
import com.medicaid.app.service.FacilityServiceUtil;
import com.medicaid.app.service.PatientLocalServiceUtil;
import com.medicaid.common.util.FormattingUtil;
import com.medicaid.common.util.SessionUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
	private List<Facility> selectedFacilities;
	
	@PostConstruct
	public void init() {
		log.info("inside patient init");
		
		themeDisplay = LiferayPortletHelperUtil.getThemeDisplay();
		user=themeDisplay.getUser();
		
		patientsList=PatientLocalServiceUtil.getPatients(-1, -1);
		try {
			patient=(Patient) SessionUtil.getSessionAttribute("patient");
			isEdit= (Boolean) SessionUtil.getSessionAttribute("isEdit");
			log.info("isEdit "+isEdit);
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		log.info("patient "+patient);
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
		log.info("facilities "+facilities);
		
	}
	
	
	public String save()
	{
		if(patient.getPatientId()==0) {
			patient.setPatientId(CounterLocalServiceUtil.increment(Patient.class.getCanonicalName()));
		}
		log.info("selectedFacilities "+selectedFacilities);
		if(selectedFacilities!=null) {
			String selectedFacility="";
			for (Facility facility : facilities) {
				selectedFacility+=facility.getFacilityId()+",";
			}
			patient.setFacilityId(selectedFacility);
		}
		log.info("patient "+patient);
		try {
			PatientLocalServiceUtil.updatePatient(patient);
			log.info("patient saved");
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		SessionUtil.removeSessionAttribute("patient");
		log.info(SessionUtil.getSessionAttribute("patient"));
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


	public List<Facility> getSelectedFacilities() {
		return selectedFacilities;
	}


	public void setSelectedFacilities(List<Facility> selectedFacilities) {
		this.selectedFacilities = selectedFacilities;
	}


	


	
	
	

}
