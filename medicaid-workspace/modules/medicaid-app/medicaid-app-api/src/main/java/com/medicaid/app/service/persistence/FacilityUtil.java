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

package com.medicaid.app.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.medicaid.app.model.Facility;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the facility service. This utility wraps <code>com.medicaid.app.service.persistence.impl.FacilityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacilityPersistence
 * @generated
 */
public class FacilityUtil {

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
	public static void clearCache(Facility facility) {
		getPersistence().clearCache(facility);
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
	public static Map<Serializable, Facility> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Facility> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Facility> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Facility> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Facility> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Facility update(Facility facility) {
		return getPersistence().update(facility);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Facility update(
		Facility facility, ServiceContext serviceContext) {

		return getPersistence().update(facility, serviceContext);
	}

	/**
	 * Caches the facility in the entity cache if it is enabled.
	 *
	 * @param facility the facility
	 */
	public static void cacheResult(Facility facility) {
		getPersistence().cacheResult(facility);
	}

	/**
	 * Caches the facilities in the entity cache if it is enabled.
	 *
	 * @param facilities the facilities
	 */
	public static void cacheResult(List<Facility> facilities) {
		getPersistence().cacheResult(facilities);
	}

	/**
	 * Creates a new facility with the primary key. Does not add the facility to the database.
	 *
	 * @param facilityId the primary key for the new facility
	 * @return the new facility
	 */
	public static Facility create(long facilityId) {
		return getPersistence().create(facilityId);
	}

	/**
	 * Removes the facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility that was removed
	 * @throws NoSuchFacilityException if a facility with the primary key could not be found
	 */
	public static Facility remove(long facilityId)
		throws com.medicaid.app.exception.NoSuchFacilityException {

		return getPersistence().remove(facilityId);
	}

	public static Facility updateImpl(Facility facility) {
		return getPersistence().updateImpl(facility);
	}

	/**
	 * Returns the facility with the primary key or throws a <code>NoSuchFacilityException</code> if it could not be found.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility
	 * @throws NoSuchFacilityException if a facility with the primary key could not be found
	 */
	public static Facility findByPrimaryKey(long facilityId)
		throws com.medicaid.app.exception.NoSuchFacilityException {

		return getPersistence().findByPrimaryKey(facilityId);
	}

	/**
	 * Returns the facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility, or <code>null</code> if a facility with the primary key could not be found
	 */
	public static Facility fetchByPrimaryKey(long facilityId) {
		return getPersistence().fetchByPrimaryKey(facilityId);
	}

	/**
	 * Returns all the facilities.
	 *
	 * @return the facilities
	 */
	public static List<Facility> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @return the range of facilities
	 */
	public static List<Facility> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of facilities
	 */
	public static List<Facility> findAll(
		int start, int end, OrderByComparator<Facility> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of facilities
	 */
	public static List<Facility> findAll(
		int start, int end, OrderByComparator<Facility> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the facilities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of facilities.
	 *
	 * @return the number of facilities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FacilityPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FacilityPersistence, FacilityPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FacilityPersistence.class);

		ServiceTracker<FacilityPersistence, FacilityPersistence>
			serviceTracker =
				new ServiceTracker<FacilityPersistence, FacilityPersistence>(
					bundle.getBundleContext(), FacilityPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}