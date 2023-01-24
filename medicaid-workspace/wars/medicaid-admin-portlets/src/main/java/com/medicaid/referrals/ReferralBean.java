package com.medicaid.referrals;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.medicaid.app.model.Facility;
import com.medicaid.app.model.FacilityAdmin;
import com.medicaid.app.model.Patient;
import com.medicaid.app.model.Referral;
import com.medicaid.app.service.FacilityAdminLocalServiceUtil;
import com.medicaid.app.service.FacilityLocalServiceUtil;
import com.medicaid.app.service.PatientLocalServiceUtil;
import com.medicaid.app.service.ReferralLocalServiceUtil;
import com.medicaid.common.util.FormattingUtil;
import com.medicaid.common.util.SessionUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
	private List<FacilityAdmin> facilityAdminList=new ArrayList<FacilityAdmin>();
	private List<Patient> patientList=new ArrayList<Patient>();
	private List<String> referralStatus=new ArrayList<String>();
	private Boolean isEdit=false;
	

	
	
	@PostConstruct
	public void init() {
		log.info("inside ReferralBean init");
		referralList=ReferralLocalServiceUtil.getReferrals(-1, -1);
		facilities=FacilityLocalServiceUtil.getFacilities(-1,-1);
		facilitiesMap=FacilityLocalServiceUtil.getFacilityMap();
		pateientsMap=PatientLocalServiceUtil.getPatientMap();
		facilityAdminList=FacilityAdminLocalServiceUtil.getFacilityAdmins(-1, -1);
		patientList=PatientLocalServiceUtil.getPatients(-1, -1);
		
		referralStatus.add("Approved");
		referralStatus.add("Submitted");
		referralStatus.add("Denied");
		referralStatus.add("Withdrawn");
		
		
		try {
			referral=(Referral) SessionUtil.getSessionAttribute("referral");
			isEdit=true;
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		log.info("referral "+referral);
		if(referral==null) {
			referral=ReferralLocalServiceUtil.createReferral(0);
		}
		
	
	}
	
	public String save()
	{
		if(referral.getReferralId()==0) {
			referral.setReferralId(CounterLocalServiceUtil.increment(Referral.class.getCanonicalName()));
		}
		log.info("referral "+referral);
		ReferralLocalServiceUtil.updateReferral(referral);
		SessionUtil.removeSessionAttribute("referral");
		return "view?faces-redirect=true";
	}
	
	
	public String addNewReferral() {
		log.info("inside add referral");		
		log.info("referral "+referral );
		
		return "addEdit?faces-redirect=true";
	}
	public String editReferral()
	{
		isEdit=true;
		SessionUtil.setSessionAttribute("referral", referral);
		return "addEdit?faces-redirect=true";
	}
	
	
	
	
	
	public String getFacilityName(String facilityId) {
		return facilitiesMap.get(Long.valueOf(facilityId)).getName();
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

	public List<FacilityAdmin> getFacilityAdminList() {
		return facilityAdminList;
	}

	public void setFacilityAdminList(List<FacilityAdmin> facilityAdminList) {
		this.facilityAdminList = facilityAdminList;
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

	
	
}
