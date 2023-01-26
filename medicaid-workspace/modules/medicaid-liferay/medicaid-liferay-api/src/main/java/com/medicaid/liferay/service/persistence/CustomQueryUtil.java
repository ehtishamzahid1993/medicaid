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

package com.medicaid.liferay.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.medicaid.liferay.model.CustomQuery;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the custom query service. This utility wraps <code>com.medicaid.liferay.service.persistence.impl.CustomQueryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomQueryPersistence
 * @generated
 */
public class CustomQueryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CustomQuery customQuery) {
		getPersistence().clearCache(customQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CustomQuery> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CustomQuery> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CustomQuery> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CustomQuery> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CustomQuery> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CustomQuery update(CustomQuery customQuery) {
		return getPersistence().update(customQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CustomQuery update(
		CustomQuery customQuery, ServiceContext serviceContext) {

		return getPersistence().update(customQuery, serviceContext);
	}

	/**
	 * Caches the custom query in the entity cache if it is enabled.
	 *
	 * @param customQuery the custom query
	 */
	public static void cacheResult(CustomQuery customQuery) {
		getPersistence().cacheResult(customQuery);
	}

	/**
	 * Caches the custom queries in the entity cache if it is enabled.
	 *
	 * @param customQueries the custom queries
	 */
	public static void cacheResult(List<CustomQuery> customQueries) {
		getPersistence().cacheResult(customQueries);
	}

	/**
	 * Creates a new custom query with the primary key. Does not add the custom query to the database.
	 *
	 * @param sqlKey the primary key for the new custom query
	 * @return the new custom query
	 */
	public static CustomQuery create(String sqlKey) {
		return getPersistence().create(sqlKey);
	}

	/**
	 * Removes the custom query with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sqlKey the primary key of the custom query
	 * @return the custom query that was removed
	 * @throws NoSuchCustomQueryException if a custom query with the primary key could not be found
	 */
	public static CustomQuery remove(String sqlKey)
		throws com.medicaid.liferay.exception.NoSuchCustomQueryException {

		return getPersistence().remove(sqlKey);
	}

	public static CustomQuery updateImpl(CustomQuery customQuery) {
		return getPersistence().updateImpl(customQuery);
	}

	/**
	 * Returns the custom query with the primary key or throws a <code>NoSuchCustomQueryException</code> if it could not be found.
	 *
	 * @param sqlKey the primary key of the custom query
	 * @return the custom query
	 * @throws NoSuchCustomQueryException if a custom query with the primary key could not be found
	 */
	public static CustomQuery findByPrimaryKey(String sqlKey)
		throws com.medicaid.liferay.exception.NoSuchCustomQueryException {

		return getPersistence().findByPrimaryKey(sqlKey);
	}

	/**
	 * Returns the custom query with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sqlKey the primary key of the custom query
	 * @return the custom query, or <code>null</code> if a custom query with the primary key could not be found
	 */
	public static CustomQuery fetchByPrimaryKey(String sqlKey) {
		return getPersistence().fetchByPrimaryKey(sqlKey);
	}

	/**
	 * Returns all the custom queries.
	 *
	 * @return the custom queries
	 */
	public static List<CustomQuery> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the custom queries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomQueryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom queries
	 * @param end the upper bound of the range of custom queries (not inclusive)
	 * @return the range of custom queries
	 */
	public static List<CustomQuery> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the custom queries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomQueryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom queries
	 * @param end the upper bound of the range of custom queries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of custom queries
	 */
	public static List<CustomQuery> findAll(
		int start, int end, OrderByComparator<CustomQuery> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the custom queries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomQueryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom queries
	 * @param end the upper bound of the range of custom queries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of custom queries
	 */
	public static List<CustomQuery> findAll(
		int start, int end, OrderByComparator<CustomQuery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the custom queries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of custom queries.
	 *
	 * @return the number of custom queries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CustomQueryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CustomQueryPersistence, CustomQueryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CustomQueryPersistence.class);

		ServiceTracker<CustomQueryPersistence, CustomQueryPersistence>
			serviceTracker =
				new ServiceTracker
					<CustomQueryPersistence, CustomQueryPersistence>(
						bundle.getBundleContext(), CustomQueryPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}