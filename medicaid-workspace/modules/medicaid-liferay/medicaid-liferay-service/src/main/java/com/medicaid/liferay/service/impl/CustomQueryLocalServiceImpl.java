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

package com.medicaid.liferay.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.medicaid.liferay.service.base.CustomQueryLocalServiceBaseImpl;
import com.medicaid.liferay.service.persistence.CustomQueryFinder;
import com.medicaid.liferay.util.FormattingUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the custom query local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.medicaid.liferay.service.CustomQueryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomQueryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.medicaid.liferay.model.CustomQuery",
	service = AopService.class
)
public class CustomQueryLocalServiceImpl
	extends CustomQueryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.medicaid.liferay.service.CustomQueryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.medicaid.liferay.service.CustomQueryLocalServiceUtil</code>.
	 */
	
	Log log = LogFactoryUtil.getLog("LR-" + getClass().getName());
	CustomQueryFinder customQueryFinder;

	public List<String> customQuery(String query) {
		try {
			
			List<String> list = customQueryFinder.getCustomScalarValue(query, null);
			
			return list;
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		return null;
	}
}