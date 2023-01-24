package com.medicaid.login;

import com.liferay.faces.portal.context.PortletHelperUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.medicaid.common.util.FormattingUtil;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	Log log = LogFactoryUtil.getLog(LoginBean.class);
	
	private String emailAddress;
	private String password;

	@PostConstruct
	public void init() {
		log.info("inside init");
		

	}

	public void login() {
		try {
			log.info("emailAdddress "+emailAddress);
			log.info("password "+password);
			
			PortletRequest portletRequest = PortletHelperUtil.getPortletRequest();
			PortletResponse portletResponse = PortletHelperUtil.getPortletResponse();
			HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(portletRequest);
			boolean rememberMe = false;
			//		String authType = CompanyConstants.AUTH_TYPE_EA;;
			HttpServletResponse httpServletResponse = PortalUtil.getHttpServletResponse(portletResponse);

			boolean authenticated = false;
			String authType = CompanyConstants.AUTH_TYPE_SN;
			try {
				log.info("authenticate()" + emailAddress + "-----invokeLogin Starts----");

				AuthenticatedSessionManagerUtil.login(httpServletRequest, httpServletResponse, emailAddress, password, rememberMe, authType);
				
				FacesContext context = FacesContext.getCurrentInstance();
				javax.faces.context.ExternalContext externalContext = context.getExternalContext();
				
				try {
					externalContext.redirect("/web/facility-admin/home");
				} catch (IOException e) {
					log.info(FormattingUtil.getMessage(e));
				}
				authenticated = true;
			} catch (Exception e) {
				log.error(FormattingUtil.getMessage(e));
			}
			
			
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
