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

package com.medicaid.app.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FacilityService}.
 *
 * @author Brian Wing Shun Chan
 * @see FacilityService
 * @generated
 */
public class FacilityServiceWrapper
	implements FacilityService, ServiceWrapper<FacilityService> {

	public FacilityServiceWrapper(FacilityService facilityService) {
		_facilityService = facilityService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _facilityService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject retrieveStates() {
		return _facilityService.retrieveStates();
	}

	@Override
	public FacilityService getWrappedService() {
		return _facilityService;
	}

	@Override
	public void setWrappedService(FacilityService facilityService) {
		_facilityService = facilityService;
	}

	private FacilityService _facilityService;

}