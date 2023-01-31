package com.medicaid.facility;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.faces.portal.context.LiferayPortletHelperUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.medicaid.app.model.Facility;
import com.medicaid.app.service.FacilityLocalServiceUtil;
import com.medicaid.app.service.FacilityServiceUtil;
import com.medicaid.common.util.FormattingUtil;
import com.medicaid.common.util.SessionUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "facilityBean")
@ViewScoped
public class FacilityBean implements Serializable {

	private static final long serialVersionUID = 1L;
	Log log = LogFactoryUtil.getLog(FacilityBean.class);
	private List<Facility> facilitiesList=new ArrayList<Facility>();
	private Boolean isEdit=false;
	private Facility facility;
	private List<String> states=new ArrayList<String>();
	private JSONObject statesObject=null;
	private Boolean showButtons=true;
	private ThemeDisplay themeDisplay;
	private User user;
	
	private Boolean showViewPage=true;
	private String step="viewRegister";
	
	@PostConstruct
	public void init() {
		log.info("inside facility init");
		
		themeDisplay = LiferayPortletHelperUtil.getThemeDisplay();
		user=themeDisplay.getUser();
		try {
			List<Role> role=user.getRoles();
			for (Role role2 : role) {
				if(role2.getName().equals("Facility Admin"))
				{
					//showButtons=false;
				}
			}
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		try {
			String facilities="";
			try {
				facilities=(String) user.getExpandoBridge().getAttribute("Facilities");
			} catch (Exception e) {
				log.error(FormattingUtil.getMessage(e));
			}
			if(facilities!=null && !facilities.trim().equals(""))
			{
				String[] array=facilities.split(",");
				for (int i = 0; i < array.length; i++) {
					facilitiesList.add(FacilityLocalServiceUtil.getFacility(Long.valueOf(array[i])));
				}
			}else
			{
				facilitiesList=new ArrayList<Facility>();
			}
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		
		
		try {
			facility=(Facility) SessionUtil.getSessionAttribute("facility");
			isEdit= (Boolean) SessionUtil.getSessionAttribute("isEdit");
			if(isEdit==null) {
				isEdit=false;
			}
			log.info("isEdit "+isEdit);
			log.info("facility "+facility);
			
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		
		if(isEdit==null) {
			facility=FacilityLocalServiceUtil.createFacility(0);
		}else if(!isEdit ) {
			facility=FacilityLocalServiceUtil.createFacility(0);
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
			log.info("states "+states);
		}catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		
		
		
	}
	
	public void save()
	{
		if(facility.getFacilityId()==0) {
			facility.setFacilityId(CounterLocalServiceUtil.increment(Facility.class.getCanonicalName()));
		}
		log.info("facility "+facility);
		FacilityLocalServiceUtil.updateFacility(facility);
		step="viewRegister";
	}
	
	
	
	
	
	public void flowSwitch(String stepToShow) {
		log.info("stepToShow "+stepToShow);
		step=stepToShow;
		log.info("step "+step);
		if(step.equals("addRegister"))
		{
			facility=FacilityLocalServiceUtil.createFacility(0);
		}
		
	}

	public List<Facility> getFacilitiesList() {
		return facilitiesList;
	}

	public void setFacilitiesList(List<Facility> facilitiesList) {
		this.facilitiesList = facilitiesList;
	}


	public Log getLog() {
		return log;
	}


	public void setLog(Log log) {
		this.log = log;
	}


	public Boolean getIsEdit() {
		return isEdit;
	}


	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}


	public Facility getFacility() {
		return facility;
	}


	public void setFacility(Facility facility) {
		this.facility = facility;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public Boolean getShowButtons() {
		return showButtons;
	}

	public void setShowButtons(Boolean showButtons) {
		this.showButtons = showButtons;
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

	public Boolean getShowViewPage() {
		return showViewPage;
	}

	public void setShowViewPage(Boolean showViewPage) {
		this.showViewPage = showViewPage;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}
	
	

	
}
