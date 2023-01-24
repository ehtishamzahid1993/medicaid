/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.medicaid.app.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.medicaid.app.service.base.FacilityServiceBaseImpl;
import com.medicaid.app.util.FormattingUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the facility remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.medicaid.app.service.FacilityService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacilityServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=medicaid",
		"json.web.service.context.path=Facility"
	},
	service = AopService.class
)
public class FacilityServiceImpl extends FacilityServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.medicaid.app.service.FacilityServiceUtil</code> to access the facility remote service.
	 */
	
	static Log log = LogFactoryUtil.getLog(FacilityServiceImpl.class);
	public JSONObject retrieveStates() {
		InputStream stream = null;

		try {
			log.info("retrieve States");
			URL res = getClass().getClassLoader().getResource("states.json"); //relative path
			if (Validator.isNotNull(res)) {

				stream = res.openStream();
				StringBuilder sb = new StringBuilder();
				for (int ch; (ch = stream.read()) != -1;) {
					sb.append((char) ch);
				}

				if (Validator.isNotNull(sb.toString())) {
					JSONArray array=JSONFactoryUtil.createJSONArray(sb.toString());
					JSONObject statesJson = JSONFactoryUtil.createJSONObject();
					statesJson.put("states", array);
					
					//					log.info("productFieldsJson" + productFieldsJson);
					return statesJson;

				} else {
					return null;
				}
			}
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error(FormattingUtil.getMessage(e));
			}

		}
		return null;
	}
}