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
 * Provides the local service utility for Facility. This utility wraps
 * <code>com.medicaid.app.service.impl.FacilityLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FacilityLocalService
 * @generated
 */
public class FacilityLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.medicaid.app.service.impl.FacilityLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the facility to the database. Also notifies the appropriate model listeners.
	 *
	 * @param facility the facility
	 * @return the facility that was added
	 */
	public static com.medicaid.app.model.Facility addFacility(
		com.medicaid.app.model.Facility facility) {

		return getService().addFacility(facility);
	}

	/**
	 * Creates a new facility with the primary key. Does not add the facility to the database.
	 *
	 * @param facilityId the primary key for the new facility
	 * @return the new facility
	 */
	public static com.medicaid.app.model.Facility createFacility(
		long facilityId) {

		return getService().createFacility(facilityId);
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
	 * Deletes the facility from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facility the facility
	 * @return the facility that was removed
	 */
	public static com.medicaid.app.model.Facility deleteFacility(
		com.medicaid.app.model.Facility facility) {

		return getService().deleteFacility(facility);
	}

	/**
	 * Deletes the facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility that was removed
	 * @throws PortalException if a facility with the primary key could not be found
	 */
	public static com.medicaid.app.model.Facility deleteFacility(
			long facilityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteFacility(facilityId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.app.model.impl.FacilityModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.app.model.impl.FacilityModelImpl</code>.
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

	public static com.medicaid.app.model.Facility fetchFacility(
		long facilityId) {

		return getService().fetchFacility(facilityId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.app.model.impl.FacilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @return the range of facilities
	 */
	public static java.util.List<com.medicaid.app.model.Facility> getFacilities(
		int start, int end) {

		return getService().getFacilities(start, end);
	}

	/**
	 * Returns the number of facilities.
	 *
	 * @return the number of facilities
	 */
	public static int getFacilitiesCount() {
		return getService().getFacilitiesCount();
	}

	/**
	 * Returns the facility with the primary key.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility
	 * @throws PortalException if a facility with the primary key could not be found
	 */
	public static com.medicaid.app.model.Facility getFacility(long facilityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFacility(facilityId);
	}

	public static java.util.HashMap<String, com.medicaid.app.model.Facility>
		getFacilityMap() {

		return getService().getFacilityMap();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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
	 * Updates the facility in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param facility the facility
	 * @return the facility that was updated
	 */
	public static com.medicaid.app.model.Facility updateFacility(
		com.medicaid.app.model.Facility facility) {

		return getService().updateFacility(facility);
	}

	public static FacilityLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FacilityLocalService, FacilityLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FacilityLocalService.class);

		ServiceTracker<FacilityLocalService, FacilityLocalService>
			serviceTracker =
				new ServiceTracker<FacilityLocalService, FacilityLocalService>(
					bundle.getBundleContext(), FacilityLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}