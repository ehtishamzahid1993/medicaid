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

import com.medicaid.app.model.Referral;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the referral service. This utility wraps <code>com.medicaid.app.service.persistence.impl.ReferralPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReferralPersistence
 * @generated
 */
public class ReferralUtil {

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
	public static void clearCache(Referral referral) {
		getPersistence().clearCache(referral);
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
	public static Map<Serializable, Referral> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Referral> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Referral> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Referral> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Referral> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Referral update(Referral referral) {
		return getPersistence().update(referral);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Referral update(
		Referral referral, ServiceContext serviceContext) {

		return getPersistence().update(referral, serviceContext);
	}

	/**
	 * Returns all the referrals where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching referrals
	 */
	public static List<Referral> findByStatus(String status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the referrals where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @return the range of matching referrals
	 */
	public static List<Referral> findByStatus(
		String status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the referrals where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching referrals
	 */
	public static List<Referral> findByStatus(
		String status, int start, int end,
		OrderByComparator<Referral> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the referrals where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching referrals
	 */
	public static List<Referral> findByStatus(
		String status, int start, int end,
		OrderByComparator<Referral> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first referral in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching referral
	 * @throws NoSuchReferralException if a matching referral could not be found
	 */
	public static Referral findByStatus_First(
			String status, OrderByComparator<Referral> orderByComparator)
		throws com.medicaid.app.exception.NoSuchReferralException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first referral in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching referral, or <code>null</code> if a matching referral could not be found
	 */
	public static Referral fetchByStatus_First(
		String status, OrderByComparator<Referral> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last referral in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching referral
	 * @throws NoSuchReferralException if a matching referral could not be found
	 */
	public static Referral findByStatus_Last(
			String status, OrderByComparator<Referral> orderByComparator)
		throws com.medicaid.app.exception.NoSuchReferralException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last referral in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching referral, or <code>null</code> if a matching referral could not be found
	 */
	public static Referral fetchByStatus_Last(
		String status, OrderByComparator<Referral> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the referrals before and after the current referral in the ordered set where status = &#63;.
	 *
	 * @param referralId the primary key of the current referral
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next referral
	 * @throws NoSuchReferralException if a referral with the primary key could not be found
	 */
	public static Referral[] findByStatus_PrevAndNext(
			long referralId, String status,
			OrderByComparator<Referral> orderByComparator)
		throws com.medicaid.app.exception.NoSuchReferralException {

		return getPersistence().findByStatus_PrevAndNext(
			referralId, status, orderByComparator);
	}

	/**
	 * Removes all the referrals where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(String status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of referrals where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching referrals
	 */
	public static int countByStatus(String status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Caches the referral in the entity cache if it is enabled.
	 *
	 * @param referral the referral
	 */
	public static void cacheResult(Referral referral) {
		getPersistence().cacheResult(referral);
	}

	/**
	 * Caches the referrals in the entity cache if it is enabled.
	 *
	 * @param referrals the referrals
	 */
	public static void cacheResult(List<Referral> referrals) {
		getPersistence().cacheResult(referrals);
	}

	/**
	 * Creates a new referral with the primary key. Does not add the referral to the database.
	 *
	 * @param referralId the primary key for the new referral
	 * @return the new referral
	 */
	public static Referral create(long referralId) {
		return getPersistence().create(referralId);
	}

	/**
	 * Removes the referral with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param referralId the primary key of the referral
	 * @return the referral that was removed
	 * @throws NoSuchReferralException if a referral with the primary key could not be found
	 */
	public static Referral remove(long referralId)
		throws com.medicaid.app.exception.NoSuchReferralException {

		return getPersistence().remove(referralId);
	}

	public static Referral updateImpl(Referral referral) {
		return getPersistence().updateImpl(referral);
	}

	/**
	 * Returns the referral with the primary key or throws a <code>NoSuchReferralException</code> if it could not be found.
	 *
	 * @param referralId the primary key of the referral
	 * @return the referral
	 * @throws NoSuchReferralException if a referral with the primary key could not be found
	 */
	public static Referral findByPrimaryKey(long referralId)
		throws com.medicaid.app.exception.NoSuchReferralException {

		return getPersistence().findByPrimaryKey(referralId);
	}

	/**
	 * Returns the referral with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param referralId the primary key of the referral
	 * @return the referral, or <code>null</code> if a referral with the primary key could not be found
	 */
	public static Referral fetchByPrimaryKey(long referralId) {
		return getPersistence().fetchByPrimaryKey(referralId);
	}

	/**
	 * Returns all the referrals.
	 *
	 * @return the referrals
	 */
	public static List<Referral> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the referrals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @return the range of referrals
	 */
	public static List<Referral> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the referrals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of referrals
	 */
	public static List<Referral> findAll(
		int start, int end, OrderByComparator<Referral> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the referrals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of referrals
	 */
	public static List<Referral> findAll(
		int start, int end, OrderByComparator<Referral> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the referrals from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of referrals.
	 *
	 * @return the number of referrals
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ReferralPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ReferralPersistence, ReferralPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ReferralPersistence.class);

		ServiceTracker<ReferralPersistence, ReferralPersistence>
			serviceTracker =
				new ServiceTracker<ReferralPersistence, ReferralPersistence>(
					bundle.getBundleContext(), ReferralPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}