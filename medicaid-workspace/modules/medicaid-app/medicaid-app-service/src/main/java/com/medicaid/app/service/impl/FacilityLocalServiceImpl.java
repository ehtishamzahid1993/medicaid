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
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.medicaid.app.model.Facility;
import com.medicaid.app.service.base.FacilityLocalServiceBaseImpl;
import com.medicaid.app.util.FormattingUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the facility local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.medicaid.app.service.FacilityLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacilityLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.medicaid.app.model.Facility",
	service = AopService.class
)
public class FacilityLocalServiceImpl extends FacilityLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.medicaid.app.service.FacilityLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.medicaid.app.service.FacilityLocalServiceUtil</code>.
	 */
	static Log log = LogFactoryUtil.getLog(FacilityLocalServiceImpl.class);
	
	public HashMap<String, Facility> getFacilityMap(){
		HashMap<String, Facility> facilityMap=new HashMap<String, Facility>();
		try {
			List<Facility> facilities=facilityLocalService.getFacilities(-1, -1);
			for (Facility facility : facilities) {
				facilityMap.put(""+facility.getFacilityId(), facility);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return facilityMap;
	}
	
	
	
}