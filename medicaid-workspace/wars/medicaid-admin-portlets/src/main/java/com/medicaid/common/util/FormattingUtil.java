package com.medicaid.common.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class FormattingUtil {
	public static Log log = LogFactoryUtil.getLog(FormattingUtil.class);
	private final static String PREFIX = " -ADMIN- ";

	public static String getMessage(Exception e) {
		String message = "";
		message = e.getMessage();
		if (message == null) {
			StackTraceElement[] stackTrace = e.getStackTrace();
			if (stackTrace != null && stackTrace.length > 0) {
				int length = stackTrace.length;
				message = "Null Pointer at:" + stackTrace[length - 1].toString();
			}
		}
		return PREFIX + message;
	}

}