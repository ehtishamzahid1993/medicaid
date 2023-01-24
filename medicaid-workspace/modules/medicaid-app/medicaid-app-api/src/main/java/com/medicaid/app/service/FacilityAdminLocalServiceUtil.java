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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for FacilityAdmin. This utility wraps
 * <code>com.medicaid.app.service.impl.FacilityAdminLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FacilityAdminLocalService
 * @generated
 */
public class FacilityAdminLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.medicaid.app.service.impl.FacilityAdminLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the facility admin to the database. Also notifies the appropriate model listeners.
	 *
	 * @param facilityAdmin the facility admin
	 * @return the facility admin that was added
	 */
	public static com.medicaid.app.model.FacilityAdmin addFacilityAdmin(
		com.medicaid.app.model.FacilityAdmin facilityAdmin) {

		return getService().addFacilityAdmin(facilityAdmin);
	}

	/**
	 * Creates a new facility admin with the primary key. Does not add the facility admin to the database.
	 *
	 * @param userName the primary key for the new facility admin
	 * @return the new facility admin
	 */
	public static com.medicaid.app.model.FacilityAdmin createFacilityAdmin(
		String userName) {

		return getService().createFacilityAdmin(userName);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the facility admin from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facilityAdmin the facility admin
	 * @return the facility admin that was removed
	 */
	public static com.medicaid.app.model.FacilityAdmin deleteFacilityAdmin(
		com.medicaid.app.model.FacilityAdmin facilityAdmin) {

		return getService().deleteFacilityAdmin(facilityAdmin);
	}

	/**
	 * Deletes the facility admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userName the primary key of the facility admin
	 * @return the facility admin that was removed
	 * @throws PortalException if a facility admin with the primary key could not be found
	 */
	public static com.medicaid.app.model.FacilityAdmin deleteFacilityAdmin(
			String userName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteFacilityAdmin(userName);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.app.model.impl.FacilityAdminModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.app.model.impl.FacilityAdminModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.medicaid.app.model.FacilityAdmin fetchFacilityAdmin(
		String userName) {

		return getService().fetchFacilityAdmin(userName);
	}

	/**
	 * Returns the facility admin with the primary key.
	 *
	 * @param userName the primary key of the facility admin
	 * @return the facility admin
	 * @throws PortalException if a facility admin with the primary key could not be found
	 */
	public static com.medicaid.app.model.FacilityAdmin getFacilityAdmin(
			String userName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFacilityAdmin(userName);
	}

	/**
	 * Returns a range of all the facility admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.app.model.impl.FacilityAdminModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facility admins
	 * @param end the upper bound of the range of facility admins (not inclusive)
	 * @return the range of facility admins
	 */
	public static java.util.List<com.medicaid.app.model.FacilityAdmin>
		getFacilityAdmins(int start, int end) {

		return getService().getFacilityAdmins(start, end);
	}

	/**
	 * Returns the number of facility admins.
	 *
	 * @return the number of facility admins
	 */
	public static int getFacilityAdminsCount() {
		return getService().getFacilityAdminsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the facility admin in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param facilityAdmin the facility admin
	 * @return the facility admin that was updated
	 */
	public static com.medicaid.app.model.FacilityAdmin updateFacilityAdmin(
		com.medicaid.app.model.FacilityAdmin facilityAdmin) {

		return getService().updateFacilityAdmin(facilityAdmin);
	}

	public static FacilityAdminLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<FacilityAdminLocalService, FacilityAdminLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			FacilityAdminLocalService.class);

		ServiceTracker<FacilityAdminLocalService, FacilityAdminLocalService>
			serviceTracker =
				new ServiceTracker
					<FacilityAdminLocalService, FacilityAdminLocalService>(
						bundle.getBundleContext(),
						FacilityAdminLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}