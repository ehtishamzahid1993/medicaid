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
 * Provides a wrapper for {@link FacilityAdminLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FacilityAdminLocalService
 * @generated
 */
public class FacilityAdminLocalServiceWrapper
	implements FacilityAdminLocalService,
			   ServiceWrapper<FacilityAdminLocalService> {

	public FacilityAdminLocalServiceWrapper(
		FacilityAdminLocalService facilityAdminLocalService) {

		_facilityAdminLocalService = facilityAdminLocalService;
	}

	/**
	 * Adds the facility admin to the database. Also notifies the appropriate model listeners.
	 *
	 * @param facilityAdmin the facility admin
	 * @return the facility admin that was added
	 */
	@Override
	public com.medicaid.app.model.FacilityAdmin addFacilityAdmin(
		com.medicaid.app.model.FacilityAdmin facilityAdmin) {

		return _facilityAdminLocalService.addFacilityAdmin(facilityAdmin);
	}

	/**
	 * Creates a new facility admin with the primary key. Does not add the facility admin to the database.
	 *
	 * @param userName the primary key for the new facility admin
	 * @return the new facility admin
	 */
	@Override
	public com.medicaid.app.model.FacilityAdmin createFacilityAdmin(
		String userName) {

		return _facilityAdminLocalService.createFacilityAdmin(userName);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facilityAdminLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the facility admin from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facilityAdmin the facility admin
	 * @return the facility admin that was removed
	 */
	@Override
	public com.medicaid.app.model.FacilityAdmin deleteFacilityAdmin(
		com.medicaid.app.model.FacilityAdmin facilityAdmin) {

		return _facilityAdminLocalService.deleteFacilityAdmin(facilityAdmin);
	}

	/**
	 * Deletes the facility admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userName the primary key of the facility admin
	 * @return the facility admin that was removed
	 * @throws PortalException if a facility admin with the primary key could not be found
	 */
	@Override
	public com.medicaid.app.model.FacilityAdmin deleteFacilityAdmin(
			String userName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facilityAdminLocalService.deleteFacilityAdmin(userName);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facilityAdminLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _facilityAdminLocalService.dynamicQuery();
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

		return _facilityAdminLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _facilityAdminLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _facilityAdminLocalService.dynamicQuery(
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

		return _facilityAdminLocalService.dynamicQueryCount(dynamicQuery);
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

		return _facilityAdminLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.medicaid.app.model.FacilityAdmin fetchFacilityAdmin(
		String userName) {

		return _facilityAdminLocalService.fetchFacilityAdmin(userName);
	}

	/**
	 * Returns the facility admin with the primary key.
	 *
	 * @param userName the primary key of the facility admin
	 * @return the facility admin
	 * @throws PortalException if a facility admin with the primary key could not be found
	 */
	@Override
	public com.medicaid.app.model.FacilityAdmin getFacilityAdmin(
			String userName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facilityAdminLocalService.getFacilityAdmin(userName);
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
	@Override
	public java.util.List<com.medicaid.app.model.FacilityAdmin>
		getFacilityAdmins(int start, int end) {

		return _facilityAdminLocalService.getFacilityAdmins(start, end);
	}

	/**
	 * Returns the number of facility admins.
	 *
	 * @return the number of facility admins
	 */
	@Override
	public int getFacilityAdminsCount() {
		return _facilityAdminLocalService.getFacilityAdminsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _facilityAdminLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facilityAdminLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the facility admin in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param facilityAdmin the facility admin
	 * @return the facility admin that was updated
	 */
	@Override
	public com.medicaid.app.model.FacilityAdmin updateFacilityAdmin(
		com.medicaid.app.model.FacilityAdmin facilityAdmin) {

		return _facilityAdminLocalService.updateFacilityAdmin(facilityAdmin);
	}

	@Override
	public FacilityAdminLocalService getWrappedService() {
		return _facilityAdminLocalService;
	}

	@Override
	public void setWrappedService(
		FacilityAdminLocalService facilityAdminLocalService) {

		_facilityAdminLocalService = facilityAdminLocalService;
	}

	private FacilityAdminLocalService _facilityAdminLocalService;

}