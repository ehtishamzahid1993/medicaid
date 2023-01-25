package com.medicaid.home;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.medicaid.app.service.PatientLocalServiceUtil;
import com.medicaid.app.service.ReferralLocalServiceUtil;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "homeBean")
@ViewScoped
public class HomeUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	Log log = LogFactoryUtil.getLog(HomeUtil.class);
	
	private String searchText;
	private Long allReferrals=1L;
	private Long submittedReferrals=2L;
	private Long approvedReferrals=3L;
	private Long deniedReferrals=4L;
	private Long withdrawnReferral=5L;
	private Long pendingReferral=6L;
	
	@PostConstruct
	public void init() {
		log.info("inside home init");
		allReferrals=(long) ReferralLocalServiceUtil.getReferrals(-1, -1).size();
		submittedReferrals=(long) ReferralLocalServiceUtil.findByStatus("Submitted").size();
		approvedReferrals=(long) ReferralLocalServiceUtil.findByStatus("Approved").size();
		deniedReferrals=(long) ReferralLocalServiceUtil.findByStatus("Denied").size();
		withdrawnReferral=(long) ReferralLocalServiceUtil.findByStatus("Withdrawn").size();
		pendingReferral=(long) ReferralLocalServiceUtil.findByStatus("Pending").size();
	
	}
	
	public void search() {
		log.info("inside search");
		log.info("search text "+searchText);
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Long getAllReferrals() {
		return allReferrals;
	}

	public void setAllReferrals(Long allReferrals) {
		this.allReferrals = allReferrals;
	}

	public Long getSubmittedReferrals() {
		return submittedReferrals;
	}

	public void setSubmittedReferrals(Long submittedReferrals) {
		this.submittedReferrals = submittedReferrals;
	}

	public Long getApprovedReferrals() {
		return approvedReferrals;
	}

	public void setApprovedReferrals(Long approvedReferrals) {
		this.approvedReferrals = approvedReferrals;
	}

	public Long getDeniedReferrals() {
		return deniedReferrals;
	}

	public void setDeniedReferrals(Long deniedReferrals) {
		this.deniedReferrals = deniedReferrals;
	}

	public Long getWithdrawnReferral() {
		return withdrawnReferral;
	}

	public void setWithdrawnReferral(Long withdrawnReferral) {
		this.withdrawnReferral = withdrawnReferral;
	}

	public Long getPendingReferral() {
		return pendingReferral;
	}

	public void setPendingReferral(Long pendingReferral) {
		this.pendingReferral = pendingReferral;
	}
	
	
	

}
