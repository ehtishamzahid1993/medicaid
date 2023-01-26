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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.medicaid.liferay.exception.NoSuchCustomQueryException;
import com.medicaid.liferay.model.CustomQuery;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the custom query service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomQueryUtil
 * @generated
 */
@ProviderType
public interface CustomQueryPersistence extends BasePersistence<CustomQuery> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomQueryUtil} to access the custom query persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the custom query in the entity cache if it is enabled.
	 *
	 * @param customQuery the custom query
	 */
	public void cacheResult(CustomQuery customQuery);

	/**
	 * Caches the custom queries in the entity cache if it is enabled.
	 *
	 * @param customQueries the custom queries
	 */
	public void cacheResult(java.util.List<CustomQuery> customQueries);

	/**
	 * Creates a new custom query with the primary key. Does not add the custom query to the database.
	 *
	 * @param sqlKey the primary key for the new custom query
	 * @return the new custom query
	 */
	public CustomQuery create(String sqlKey);

	/**
	 * Removes the custom query with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sqlKey the primary key of the custom query
	 * @return the custom query that was removed
	 * @throws NoSuchCustomQueryException if a custom query with the primary key could not be found
	 */
	public CustomQuery remove(String sqlKey) throws NoSuchCustomQueryException;

	public CustomQuery updateImpl(CustomQuery customQuery);

	/**
	 * Returns the custom query with the primary key or throws a <code>NoSuchCustomQueryException</code> if it could not be found.
	 *
	 * @param sqlKey the primary key of the custom query
	 * @return the custom query
	 * @throws NoSuchCustomQueryException if a custom query with the primary key could not be found
	 */
	public CustomQuery findByPrimaryKey(String sqlKey)
		throws NoSuchCustomQueryException;

	/**
	 * Returns the custom query with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sqlKey the primary key of the custom query
	 * @return the custom query, or <code>null</code> if a custom query with the primary key could not be found
	 */
	public CustomQuery fetchByPrimaryKey(String sqlKey);

	/**
	 * Returns all the custom queries.
	 *
	 * @return the custom queries
	 */
	public java.util.List<CustomQuery> findAll();

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
	public java.util.List<CustomQuery> findAll(int start, int end);

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
	public java.util.List<CustomQuery> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomQuery>
			orderByComparator);

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
	public java.util.List<CustomQuery> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomQuery>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the custom queries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of custom queries.
	 *
	 * @return the number of custom queries
	 */
	public int countAll();

}