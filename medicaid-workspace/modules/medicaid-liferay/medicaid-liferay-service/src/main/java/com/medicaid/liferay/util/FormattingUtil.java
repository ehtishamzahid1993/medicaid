package com.medicaid.liferay.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

public class FormattingUtil {
	private final static String PREFIX = " -Liferay- ";

	public static Log log = LogFactoryUtil.getLog(FormattingUtil.class);

	public static String getMessage(Exception exc) {
		String message = "";
		message = exc.getMessage();
		if (message == null) {
			StackTraceElement[] stackTrace = exc.getStackTrace();
			if (stackTrace != null && stackTrace.length > 0) {
				message = "Null Pointer at:" + stackTrace[0].toString() + ">" + stackTrace[1].toString();
			}
		} else {
			message = exc.getMessage() + " " + exc.getStackTrace()[0] + " " + exc.getStackTrace()[1] + " " + exc.getStackTrace()[2] + " "
					+ exc.getStackTrace()[3];
		}
		return PREFIX + message;
	}

}
