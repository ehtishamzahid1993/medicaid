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
 * Provides a wrapper for {@link FacilityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FacilityLocalService
 * @generated
 */
public class FacilityLocalServiceWrapper
	implements FacilityLocalService, ServiceWrapper<FacilityLocalService> {

	public FacilityLocalServiceWrapper(
		FacilityLocalService facilityLocalService) {

		_facilityLocalService = facilityLocalService;
	}

	/**
	 * Adds the facility to the database. Also notifies the appropriate model listeners.
	 *
	 * @param facility the facility
	 * @return the facility that was added
	 */
	@Override
	public com.medicaid.app.model.Facility addFacility(
		com.medicaid.app.model.Facility facility) {

		return _facilityLocalService.addFacility(facility);
	}

	/**
	 * Creates a new facility with the primary key. Does not add the facility to the database.
	 *
	 * @param facilityId the primary key for the new facility
	 * @return the new facility
	 */
	@Override
	public com.medicaid.app.model.Facility createFacility(long facilityId) {
		return _facilityLocalService.createFacility(facilityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facilityLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the facility from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facility the facility
	 * @return the facility that was removed
	 */
	@Override
	public com.medicaid.app.model.Facility deleteFacility(
		com.medicaid.app.model.Facility facility) {

		return _facilityLocalService.deleteFacility(facility);
	}

	/**
	 * Deletes the facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility that was removed
	 * @throws PortalException if a facility with the primary key could not be found
	 */
	@Override
	public com.medicaid.app.model.Facility deleteFacility(long facilityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facilityLocalService.deleteFacility(facilityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facilityLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _facilityLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _facilityLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _facilityLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _facilityLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _facilityLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _facilityLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.medicaid.app.model.Facility fetchFacility(long facilityId) {
		return _facilityLocalService.fetchFacility(facilityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _facilityLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List<com.medicaid.app.model.Facility> getFacilities(
		int start, int end) {

		return _facilityLocalService.getFacilities(start, end);
	}

	/**
	 * Returns the number of facilities.
	 *
	 * @return the number of facilities
	 */
	@Override
	public int getFacilitiesCount() {
		return _facilityLocalService.getFacilitiesCount();
	}

	/**
	 * Returns the facility with the primary key.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility
	 * @throws PortalException if a facility with the primary key could not be found
	 */
	@Override
	public com.medicaid.app.model.Facility getFacility(long facilityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facilityLocalService.getFacility(facilityId);
	}

	@Override
	public java.util.HashMap<String, com.medicaid.app.model.Facility>
		getFacilityMap() {

		return _facilityLocalService.getFacilityMap();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _facilityLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _facilityLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facilityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the facility in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param facility the facility
	 * @return the facility that was updated
	 */
	@Override
	public com.medicaid.app.model.Facility updateFacility(
		com.medicaid.app.model.Facility facility) {

		return _facilityLocalService.updateFacility(facility);
	}

	@Override
	public FacilityLocalService getWrappedService() {
		return _facilityLocalService;
	}

	@Override
	public void setWrappedService(FacilityLocalService facilityLocalService) {
		_facilityLocalService = facilityLocalService;
	}

	private FacilityLocalService _facilityLocalService;

}