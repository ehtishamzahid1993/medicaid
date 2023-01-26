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

package com.medicaid.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CustomQueryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomQueryLocalService
 * @generated
 */
public class CustomQueryLocalServiceWrapper
	implements CustomQueryLocalService,
			   ServiceWrapper<CustomQueryLocalService> {

	public CustomQueryLocalServiceWrapper(
		CustomQueryLocalService customQueryLocalService) {

		_customQueryLocalService = customQueryLocalService;
	}

	/**
	 * Adds the custom query to the database. Also notifies the appropriate model listeners.
	 *
	 * @param customQuery the custom query
	 * @return the custom query that was added
	 */
	@Override
	public com.medicaid.liferay.model.CustomQuery addCustomQuery(
		com.medicaid.liferay.model.CustomQuery customQuery) {

		return _customQueryLocalService.addCustomQuery(customQuery);
	}

	/**
	 * Creates a new custom query with the primary key. Does not add the custom query to the database.
	 *
	 * @param sqlKey the primary key for the new custom query
	 * @return the new custom query
	 */
	@Override
	public com.medicaid.liferay.model.CustomQuery createCustomQuery(
		String sqlKey) {

		return _customQueryLocalService.createCustomQuery(sqlKey);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customQueryLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<String> customQuery(String query) {
		return _customQueryLocalService.customQuery(query);
	}

	/**
	 * Deletes the custom query from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customQuery the custom query
	 * @return the custom query that was removed
	 */
	@Override
	public com.medicaid.liferay.model.CustomQuery deleteCustomQuery(
		com.medicaid.liferay.model.CustomQuery customQuery) {

		return _customQueryLocalService.deleteCustomQuery(customQuery);
	}

	/**
	 * Deletes the custom query with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sqlKey the primary key of the custom query
	 * @return the custom query that was removed
	 * @throws PortalException if a custom query with the primary key could not be found
	 */
	@Override
	public com.medicaid.liferay.model.CustomQuery deleteCustomQuery(
			String sqlKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customQueryLocalService.deleteCustomQuery(sqlKey);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customQueryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _customQueryLocalService.dynamicQuery();
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

		return _customQueryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.liferay.model.impl.CustomQueryModelImpl</code>.
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

		return _customQueryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.liferay.model.impl.CustomQueryModelImpl</code>.
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

		return _customQueryLocalService.dynamicQuery(
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

		return _customQueryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _customQueryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.medicaid.liferay.model.CustomQuery fetchCustomQuery(
		String sqlKey) {

		return _customQueryLocalService.fetchCustomQuery(sqlKey);
	}

	/**
	 * Returns a range of all the custom queries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.liferay.model.impl.CustomQueryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom queries
	 * @param end the upper bound of the range of custom queries (not inclusive)
	 * @return the range of custom queries
	 */
	@Override
	public java.util.List<com.medicaid.liferay.model.CustomQuery>
		getCustomQueries(int start, int end) {

		return _customQueryLocalService.getCustomQueries(start, end);
	}

	/**
	 * Returns the number of custom queries.
	 *
	 * @return the number of custom queries
	 */
	@Override
	public int getCustomQueriesCount() {
		return _customQueryLocalService.getCustomQueriesCount();
	}

	/**
	 * Returns the custom query with the primary key.
	 *
	 * @param sqlKey the primary key of the custom query
	 * @return the custom query
	 * @throws PortalException if a custom query with the primary key could not be found
	 */
	@Override
	public com.medicaid.liferay.model.CustomQuery getCustomQuery(String sqlKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customQueryLocalService.getCustomQuery(sqlKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customQueryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customQueryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the custom query in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param customQuery the custom query
	 * @return the custom query that was updated
	 */
	@Override
	public com.medicaid.liferay.model.CustomQuery updateCustomQuery(
		com.medicaid.liferay.model.CustomQuery customQuery) {

		return _customQueryLocalService.updateCustomQuery(customQuery);
	}

	@Override
	public CustomQueryLocalService getWrappedService() {
		return _customQueryLocalService;
	}

	@Override
	public void setWrappedService(
		CustomQueryLocalService customQueryLocalService) {

		_customQueryLocalService = customQueryLocalService;
	}

	private CustomQueryLocalService _customQueryLocalService;

}