package com.medicaid.common.util;

import javax.portlet.PortletSession;

import com.liferay.faces.portal.context.PortletHelperUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SessionUtil {
	static Log log = LogFactoryUtil.getLog(SessionUtil.class);
	/*private static PortletRequest request;
	private static HttpSession session;
	private static FacesContext facesContext;
	private static HttpServletRequest httpRequest;*/

	public static Object getSessionAttribute(String name) {
		try {
			return PortletHelperUtil.getPortletSession().getAttribute(name, PortletSession.APPLICATION_SCOPE);
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		return null;
	}

	public static void setSessionAttribute(String name, Object value) {
		try {
			PortletHelperUtil.getPortletSession().setAttribute(name, value, PortletSession.APPLICATION_SCOPE);
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
	}
	
	public static void removeSessionAttribute(String name) {
		try {
			PortletHelperUtil.getPortletSession().removeAttribute(name);
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
	}

}
