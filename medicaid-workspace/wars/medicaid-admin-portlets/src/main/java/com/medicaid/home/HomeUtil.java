package com.medicaid.home;

import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.medicaid.app.model.Facility;
import com.medicaid.app.model.Patient;
import com.medicaid.app.service.FacilityLocalServiceUtil;
import com.medicaid.app.service.PatientLocalServiceUtil;
import com.medicaid.app.service.ReferralLocalServiceUtil;
import com.medicaid.common.util.FormattingUtil;
import com.medicaid.common.util.SessionUtil;
import com.medicaid.liferay.service.CustomQueryLocalServiceUtil;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	private List<Facility> facilities=new ArrayList<Facility>();
	private List<String> selectedFacilities=new ArrayList<String>();
	
	private List<String> selectedStates=new ArrayList<String>();
	private List<LocalDate> range;

	private ThemeDisplay themeDisplay;
	private User user;
	String facilityIds="";
	
	@PostConstruct
	public void init() {
		log.info("inside home init");
		allReferrals=(long) ReferralLocalServiceUtil.getReferrals(-1, -1).size();
		submittedReferrals=(long) ReferralLocalServiceUtil.findByStatus("Submitted").size();
		approvedReferrals=(long) ReferralLocalServiceUtil.findByStatus("Approved").size();
		deniedReferrals=(long) ReferralLocalServiceUtil.findByStatus("Denied").size();
		withdrawnReferral=(long) ReferralLocalServiceUtil.findByStatus("Withdrawn").size();
		pendingReferral=(long) ReferralLocalServiceUtil.findByStatus("Pending").size();
		
		themeDisplay = LiferayPortletHelperUtil.getThemeDisplay();
		user=themeDisplay.getUser();
		
		try {
			
			try {
				facilityIds=(String) user.getExpandoBridge().getAttribute("Facilities");
				log.info("facilityIds "+facilityIds);
			} catch (Exception e) {
				log.error(FormattingUtil.getMessage(e));
			}
			if(facilityIds!=null && !facilityIds.trim().equals(""))
			{
				String[] array=facilityIds.split(",");
				for (int i = 0; i < array.length; i++) {
					facilities.add(FacilityLocalServiceUtil.getFacility(Long.valueOf(array[i])));
				}
			}else
			{
				facilities=new ArrayList<Facility>();
			}
			log.info("facilities "+facilities.size());
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}

		themeDisplay = LiferayPortletHelperUtil.getThemeDisplay();
		user=themeDisplay.getUser();
	
	}
	
	public String search() {
		
		try {
			

			List<Patient> list=null;
			
			String[] array=facilityIds.split(",");
			
			
			try {
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Patient.class, PortalClassLoaderUtil.getClassLoader());
				for (int i = 0; i < array.length; i++) {
					dynamicQuery.add(PropertyFactoryUtil.forName("facilityId").like("%"+array[i]+",%"));
				}			
				dynamicQuery.add(PropertyFactoryUtil.forName("emailAddress").eq(searchText));
				list = PatientLocalServiceUtil.dynamicQuery(dynamicQuery);
			} catch (Exception e) {
				log.error(FormattingUtil.getMessage(e));
			}
			if(list!=null && list.size()>0)
			{
				SessionUtil.setSessionAttribute("patientList", list);
			}else{
				try {
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Patient.class, PortalClassLoaderUtil.getClassLoader());
					for (int i = 0; i < array.length; i++) {
						dynamicQuery.add(PropertyFactoryUtil.forName("facilityId").like("%"+array[i]+",%"));
					}			
					dynamicQuery.add(PropertyFactoryUtil.forName("firstName").eq(searchText));
					list = PatientLocalServiceUtil.dynamicQuery(dynamicQuery);
				} catch (Exception e) {
					log.error(FormattingUtil.getMessage(e));
				}
				if(list!=null && list.size()>0)
				{
					SessionUtil.setSessionAttribute("patientList", list);
				}else
				{
					try {
						DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Patient.class, PortalClassLoaderUtil.getClassLoader());
						for (int i = 0; i < array.length; i++) {
							dynamicQuery.add(PropertyFactoryUtil.forName("facilityId").like("%"+array[i]+",%"));
						}			
						dynamicQuery.add(PropertyFactoryUtil.forName("lastName").eq(searchText));
						list = PatientLocalServiceUtil.dynamicQuery(dynamicQuery);
					} catch (Exception e) {
						log.error(FormattingUtil.getMessage(e));
					}
					if(list!=null && list.size()>0)
					{
						SessionUtil.setSessionAttribute("patientList", list);
					}else
					{
						SessionUtil.setSessionAttribute("patientList", null);
					}
					
				}
			}
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		
		return "/WEB-INF/views/patient/view?faces-redirect=true";
	}
	
	public void setFacilityChange(){  
	    String query="select status from medicaid_referral where ";
	    if(selectedFacilities!=null && selectedFacilities.size()>0) {
			for (int i = 0; i < selectedFacilities.size(); i++) {
				try {
					String facility=selectedFacilities.get(i);
					String[] array=facility.split(",");
					String[] childArray=array[0].split("=");
					if(i==0) {
						query+="facilities like '%"+childArray[1]+",%'";
						
					}else
					{
						query+="or facilities like '%"+childArray[1]+",%'";
					}
					
					if(i==(selectedFacilities.size()-1)) {
						query+=" ;";
					}
					List<String> referralsList=new ArrayList<String>();
					try {
						referralsList=CustomQueryLocalServiceUtil.customQuery(query);
					} catch (Exception e) {
						log.error(FormattingUtil.getMessage(e));
					}
					allReferrals=0L;
					submittedReferrals=0L;
					approvedReferrals=0L;
					deniedReferrals=0L;
					withdrawnReferral=0L;
					pendingReferral=0L;
					if(referralsList!=null && referralsList.size()>0) {
						for (String value : referralsList) {
							if(value.equals("Submitted")) {
								submittedReferrals+=1L;
								allReferrals+=1L;
							}else if(value.equals("Approved")) {
								approvedReferrals+=1L;
								allReferrals+=1L;
							}else if(value.equals("Denied")) {
								deniedReferrals+=1L;
								allReferrals+=1L;
							}else if(value.equals("Withdrawn")) {
								withdrawnReferral+=1L;
								allReferrals+=1L;
							}else if(value.equals("Pending")) {
								pendingReferral+=1L;
								allReferrals+=1L;
							}
						}
					}
				} catch (Exception e) {
					log.error(FormattingUtil.getMessage(e));
				}
			}
			
		}else
		{
			allReferrals=(long) ReferralLocalServiceUtil.getReferrals(-1, -1).size();
			submittedReferrals=(long) ReferralLocalServiceUtil.findByStatus("Submitted").size();
			approvedReferrals=(long) ReferralLocalServiceUtil.findByStatus("Approved").size();
			deniedReferrals=(long) ReferralLocalServiceUtil.findByStatus("Denied").size();
			withdrawnReferral=(long) ReferralLocalServiceUtil.findByStatus("Withdrawn").size();
			pendingReferral=(long) ReferralLocalServiceUtil.findByStatus("Pending").size();
		}
	}
	
	
	public void setFacilityStateChange(){  
	    String mainQuery="select status from medicaid_referral where facilities like ";
	    if(selectedStates!=null && selectedStates.size()>0) {
			for (int i = 0; i < selectedStates.size(); i++) {
				try {
					String facility=selectedStates.get(i);
					String[] array=facility.split(",");
					String[] childArray=array[4].split("=");
					if(i==0) {
						mainQuery+="CONCAT('%',(select facilityId from medicaid_facility where state_ IN ('"+childArray[1]+"')), ',%')";
						
					}else
					{
						mainQuery+="or facilities like CONCAT('%',(select facilityId from medicaid_facility where state_ IN ('"+childArray[1]+"')), ',%')";
					}
					
					if(i==(selectedFacilities.size()-1)) {
						mainQuery+=" ;";
					}
					List<String> referralsList=new ArrayList<String>();
					try {
						referralsList=CustomQueryLocalServiceUtil.customQuery(mainQuery);
					} catch (Exception e) {
						log.error(FormattingUtil.getMessage(e));
					}
					allReferrals=0L;
					submittedReferrals=0L;
					approvedReferrals=0L;
					deniedReferrals=0L;
					withdrawnReferral=0L;
					pendingReferral=0L;
					if(referralsList!=null && referralsList.size()>0) {
						for (String value : referralsList) {
							if(value.equals("Submitted")) {
								submittedReferrals+=1L;
								allReferrals+=1L;
							}else if(value.equals("Approved")) {
								approvedReferrals+=1L;
								allReferrals+=1L;
							}else if(value.equals("Denied")) {
								deniedReferrals+=1L;
								allReferrals+=1L;
							}else if(value.equals("Withdrawn")) {
								withdrawnReferral+=1L;
								allReferrals+=1L;
							}else if(value.equals("Pending")) {
								pendingReferral+=1L;
								allReferrals+=1L;
							}
						}
					}
				} catch (Exception e) {
					log.error(FormattingUtil.getMessage(e));
				}
			}
			
		}else
		{
			allReferrals=(long) ReferralLocalServiceUtil.getReferrals(-1, -1).size();
			submittedReferrals=(long) ReferralLocalServiceUtil.findByStatus("Submitted").size();
			approvedReferrals=(long) ReferralLocalServiceUtil.findByStatus("Approved").size();
			deniedReferrals=(long) ReferralLocalServiceUtil.findByStatus("Denied").size();
			withdrawnReferral=(long) ReferralLocalServiceUtil.findByStatus("Withdrawn").size();
			pendingReferral=(long) ReferralLocalServiceUtil.findByStatus("Pending").size();
		}
	}
	
	
	public void dateRange()
	{
		  
			    String mainQuery="select status from medicaid_referral where datereferred>='";
			    if(range!=null && range.size()>0) {
			    	String rangeString=range.toString();
						try {
							rangeString=rangeString.replace("[", "");
							rangeString=rangeString.replace("]", "");
							String[] array=rangeString.split(",");
							array[1]=array[1].replace(" ", "");
							mainQuery+=array[0]+"' and datereferred<='"+array[1]+"';";
							
							List<String> referralsList=new ArrayList<String>();
							try {
								referralsList=CustomQueryLocalServiceUtil.customQuery(mainQuery);
							} catch (Exception e) {
								log.error(FormattingUtil.getMessage(e));
							}
							allReferrals=0L;
							submittedReferrals=0L;
							approvedReferrals=0L;
							deniedReferrals=0L;
							withdrawnReferral=0L;
							pendingReferral=0L;
							if(referralsList!=null && referralsList.size()>0) {
								for (String value : referralsList) {
									if(value.equals("Submitted")) {
										submittedReferrals+=1L;
										allReferrals+=1L;
									}else if(value.equals("Approved")) {
										approvedReferrals+=1L;
										allReferrals+=1L;
									}else if(value.equals("Denied")) {
										deniedReferrals+=1L;
										allReferrals+=1L;
									}else if(value.equals("Withdrawn")) {
										withdrawnReferral+=1L;
										allReferrals+=1L;
									}else if(value.equals("Pending")) {
										pendingReferral+=1L;
										allReferrals+=1L;
									}
								}
							}
						} catch (Exception e) {
							log.error(FormattingUtil.getMessage(e));
						}
					
					
				}else
				{
					allReferrals=(long) ReferralLocalServiceUtil.getReferrals(-1, -1).size();
					submittedReferrals=(long) ReferralLocalServiceUtil.findByStatus("Submitted").size();
					approvedReferrals=(long) ReferralLocalServiceUtil.findByStatus("Approved").size();
					deniedReferrals=(long) ReferralLocalServiceUtil.findByStatus("Denied").size();
					withdrawnReferral=(long) ReferralLocalServiceUtil.findByStatus("Withdrawn").size();
					pendingReferral=(long) ReferralLocalServiceUtil.findByStatus("Pending").size();
				}
			
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

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getSelectedStates() {
		return selectedStates;
	}

	public void setSelectedStates(List<String> selectedStates) {
		this.selectedStates = selectedStates;
	}

	public List<LocalDate> getRange() {
		return range;
	}

	public void setRange(List<LocalDate> range) {
		this.range = range;
	}
	
	
	

}
