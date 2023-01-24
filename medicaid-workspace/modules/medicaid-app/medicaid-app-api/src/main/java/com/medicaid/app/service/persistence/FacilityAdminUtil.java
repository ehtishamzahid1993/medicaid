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

import com.medicaid.app.model.FacilityAdmin;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the facility admin service. This utility wraps <code>com.medicaid.app.service.persistence.impl.FacilityAdminPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacilityAdminPersistence
 * @generated
 */
public class FacilityAdminUtil {

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
	public static void clearCache(FacilityAdmin facilityAdmin) {
		getPersistence().clearCache(facilityAdmin);
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
	public static Map<Serializable, FacilityAdmin> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FacilityAdmin> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FacilityAdmin> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FacilityAdmin> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FacilityAdmin> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FacilityAdmin update(FacilityAdmin facilityAdmin) {
		return getPersistence().update(facilityAdmin);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FacilityAdmin update(
		FacilityAdmin facilityAdmin, ServiceContext serviceContext) {

		return getPersistence().update(facilityAdmin, serviceContext);
	}

	/**
	 * Caches the facility admin in the entity cache if it is enabled.
	 *
	 * @param facilityAdmin the facility admin
	 */
	public static void cacheResult(FacilityAdmin facilityAdmin) {
		getPersistence().cacheResult(facilityAdmin);
	}

	/**
	 * Caches the facility admins in the entity cache if it is enabled.
	 *
	 * @param facilityAdmins the facility admins
	 */
	public static void cacheResult(List<FacilityAdmin> facilityAdmins) {
		getPersistence().cacheResult(facilityAdmins);
	}

	/**
	 * Creates a new facility admin with the primary key. Does not add the facility admin to the database.
	 *
	 * @param userName the primary key for the new facility admin
	 * @return the new facility admin
	 */
	public static FacilityAdmin create(String userName) {
		return getPersistence().create(userName);
	}

	/**
	 * Removes the facility admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userName the primary key of the facility admin
	 * @return the facility admin that was removed
	 * @throws NoSuchFacilityAdminException if a facility admin with the primary key could not be found
	 */
	public static FacilityAdmin remove(String userName)
		throws com.medicaid.app.exception.NoSuchFacilityAdminException {

		return getPersistence().remove(userName);
	}

	public static FacilityAdmin updateImpl(FacilityAdmin facilityAdmin) {
		return getPersistence().updateImpl(facilityAdmin);
	}

	/**
	 * Returns the facility admin with the primary key or throws a <code>NoSuchFacilityAdminException</code> if it could not be found.
	 *
	 * @param userName the primary key of the facility admin
	 * @return the facility admin
	 * @throws NoSuchFacilityAdminException if a facility admin with the primary key could not be found
	 */
	public static FacilityAdmin findByPrimaryKey(String userName)
		throws com.medicaid.app.exception.NoSuchFacilityAdminException {

		return getPersistence().findByPrimaryKey(userName);
	}

	/**
	 * Returns the facility admin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userName the primary key of the facility admin
	 * @return the facility admin, or <code>null</code> if a facility admin with the primary key could not be found
	 */
	public static FacilityAdmin fetchByPrimaryKey(String userName) {
		return getPersistence().fetchByPrimaryKey(userName);
	}

	/**
	 * Returns all the facility admins.
	 *
	 * @return the facility admins
	 */
	public static List<FacilityAdmin> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the facility admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacilityAdminModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facility admins
	 * @param end the upper bound of the range of facility admins (not inclusive)
	 * @return the range of facility admins
	 */
	public static List<FacilityAdmin> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the facility admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacilityAdminModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facility admins
	 * @param end the upper bound of the range of facility admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of facility admins
	 */
	public static List<FacilityAdmin> findAll(
		int start, int end,
		OrderByComparator<FacilityAdmin> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the facility admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacilityAdminModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facility admins
	 * @param end the upper bound of the range of facility admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of facility admins
	 */
	public static List<FacilityAdmin> findAll(
		int start, int end, OrderByComparator<FacilityAdmin> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the facility admins from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of facility admins.
	 *
	 * @return the number of facility admins
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FacilityAdminPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<FacilityAdminPersistence, FacilityAdminPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FacilityAdminPersistence.class);

		ServiceTracker<FacilityAdminPersistence, FacilityAdminPersistence>
			serviceTracker =
				new ServiceTracker
					<FacilityAdminPersistence, FacilityAdminPersistence>(
						bundle.getBundleContext(),
						FacilityAdminPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}