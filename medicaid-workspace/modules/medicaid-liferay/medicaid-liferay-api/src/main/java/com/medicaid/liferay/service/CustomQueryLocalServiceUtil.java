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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CustomQuery. This utility wraps
 * <code>com.medicaid.liferay.service.impl.CustomQueryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CustomQueryLocalService
 * @generated
 */
public class CustomQueryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.medicaid.liferay.service.impl.CustomQueryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the custom query to the database. Also notifies the appropriate model listeners.
	 *
	 * @param customQuery the custom query
	 * @return the custom query that was added
	 */
	public static com.medicaid.liferay.model.CustomQuery addCustomQuery(
		com.medicaid.liferay.model.CustomQuery customQuery) {

		return getService().addCustomQuery(customQuery);
	}

	/**
	 * Creates a new custom query with the primary key. Does not add the custom query to the database.
	 *
	 * @param sqlKey the primary key for the new custom query
	 * @return the new custom query
	 */
	public static com.medicaid.liferay.model.CustomQuery createCustomQuery(
		String sqlKey) {

		return getService().createCustomQuery(sqlKey);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static java.util.List<String> customQuery(String query) {
		return getService().customQuery(query);
	}

	/**
	 * Deletes the custom query from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customQuery the custom query
	 * @return the custom query that was removed
	 */
	public static com.medicaid.liferay.model.CustomQuery deleteCustomQuery(
		com.medicaid.liferay.model.CustomQuery customQuery) {

		return getService().deleteCustomQuery(customQuery);
	}

	/**
	 * Deletes the custom query with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sqlKey the primary key of the custom query
	 * @return the custom query that was removed
	 * @throws PortalException if a custom query with the primary key could not be found
	 */
	public static com.medicaid.liferay.model.CustomQuery deleteCustomQuery(
			String sqlKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCustomQuery(sqlKey);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.liferay.model.impl.CustomQueryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.liferay.model.impl.CustomQueryModelImpl</code>.
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

	public static com.medicaid.liferay.model.CustomQuery fetchCustomQuery(
		String sqlKey) {

		return getService().fetchCustomQuery(sqlKey);
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
	public static java.util.List<com.medicaid.liferay.model.CustomQuery>
		getCustomQueries(int start, int end) {

		return getService().getCustomQueries(start, end);
	}

	/**
	 * Returns the number of custom queries.
	 *
	 * @return the number of custom queries
	 */
	public static int getCustomQueriesCount() {
		return getService().getCustomQueriesCount();
	}

	/**
	 * Returns the custom query with the primary key.
	 *
	 * @param sqlKey the primary key of the custom query
	 * @return the custom query
	 * @throws PortalException if a custom query with the primary key could not be found
	 */
	public static com.medicaid.liferay.model.CustomQuery getCustomQuery(
			String sqlKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCustomQuery(sqlKey);
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
	 * Updates the custom query in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param customQuery the custom query
	 * @return the custom query that was updated
	 */
	public static com.medicaid.liferay.model.CustomQuery updateCustomQuery(
		com.medicaid.liferay.model.CustomQuery customQuery) {

		return getService().updateCustomQuery(customQuery);
	}

	public static CustomQueryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CustomQueryLocalService, CustomQueryLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CustomQueryLocalService.class);

		ServiceTracker<CustomQueryLocalService, CustomQueryLocalService>
			serviceTracker =
				new ServiceTracker
					<CustomQueryLocalService, CustomQueryLocalService>(
						bundle.getBundleContext(),
						CustomQueryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}