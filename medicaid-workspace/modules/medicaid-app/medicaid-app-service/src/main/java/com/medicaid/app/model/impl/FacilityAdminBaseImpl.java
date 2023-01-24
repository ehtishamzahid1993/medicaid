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

package com.medicaid.app.model.impl;

import com.medicaid.app.model.FacilityAdmin;
import com.medicaid.app.service.FacilityAdminLocalServiceUtil;

/**
 * The extended model base implementation for the FacilityAdmin service. Represents a row in the &quot;Medicaid_FacilityAdmin&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FacilityAdminImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacilityAdminImpl
 * @see FacilityAdmin
 * @generated
 */
public abstract class FacilityAdminBaseImpl
	extends FacilityAdminModelImpl implements FacilityAdmin {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a facility admin model instance should use the <code>FacilityAdmin</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			FacilityAdminLocalServiceUtil.addFacilityAdmin(this);
		}
		else {
			FacilityAdminLocalServiceUtil.updateFacilityAdmin(this);
		}
	}

}