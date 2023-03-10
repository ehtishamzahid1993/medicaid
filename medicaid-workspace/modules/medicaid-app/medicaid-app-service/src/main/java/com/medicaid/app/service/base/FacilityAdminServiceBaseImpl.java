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

package com.medicaid.app.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import com.medicaid.app.model.FacilityAdmin;
import com.medicaid.app.service.FacilityAdminService;
import com.medicaid.app.service.persistence.DocumentPersistence;
import com.medicaid.app.service.persistence.FacilityAdminPersistence;
import com.medicaid.app.service.persistence.FacilityPersistence;
import com.medicaid.app.service.persistence.NotePersistence;
import com.medicaid.app.service.persistence.PatientPersistence;
import com.medicaid.app.service.persistence.ReferralPersistence;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the facility admin remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.medicaid.app.service.impl.FacilityAdminServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.medicaid.app.service.impl.FacilityAdminServiceImpl
 * @generated
 */
public abstract class FacilityAdminServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, FacilityAdminService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>FacilityAdminService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.medicaid.app.service.FacilityAdminServiceUtil</code>.
	 */
	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			FacilityAdminService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		facilityAdminService = (FacilityAdminService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return FacilityAdminService.class.getName();
	}

	protected Class<?> getModelClass() {
		return FacilityAdmin.class;
	}

	protected String getModelClassName() {
		return FacilityAdmin.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = facilityAdminPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected DocumentPersistence documentPersistence;

	@Reference
	protected FacilityPersistence facilityPersistence;

	@Reference
	protected com.medicaid.app.service.FacilityAdminLocalService
		facilityAdminLocalService;

	protected FacilityAdminService facilityAdminService;

	@Reference
	protected FacilityAdminPersistence facilityAdminPersistence;

	@Reference
	protected NotePersistence notePersistence;

	@Reference
	protected PatientPersistence patientPersistence;

	@Reference
	protected ReferralPersistence referralPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}