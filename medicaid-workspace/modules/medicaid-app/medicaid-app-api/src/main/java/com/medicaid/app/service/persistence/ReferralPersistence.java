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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.medicaid.app.exception.NoSuchReferralException;
import com.medicaid.app.model.Referral;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the referral service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReferralUtil
 * @generated
 */
@ProviderType
public interface ReferralPersistence extends BasePersistence<Referral> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReferralUtil} to access the referral persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the referrals where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching referrals
	 */
	public java.util.List<Referral> findByStatus(String status);

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
	public java.util.List<Referral> findByStatus(
		String status, int start, int end);

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
	public java.util.List<Referral> findByStatus(
		String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Referral>
			orderByComparator);

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
	public java.util.List<Referral> findByStatus(
		String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Referral>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first referral in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching referral
	 * @throws NoSuchReferralException if a matching referral could not be found
	 */
	public Referral findByStatus_First(
			String status,
			com.liferay.portal.kernel.util.OrderByComparator<Referral>
				orderByComparator)
		throws NoSuchReferralException;

	/**
	 * Returns the first referral in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching referral, or <code>null</code> if a matching referral could not be found
	 */
	public Referral fetchByStatus_First(
		String status,
		com.liferay.portal.kernel.util.OrderByComparator<Referral>
			orderByComparator);

	/**
	 * Returns the last referral in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching referral
	 * @throws NoSuchReferralException if a matching referral could not be found
	 */
	public Referral findByStatus_Last(
			String status,
			com.liferay.portal.kernel.util.OrderByComparator<Referral>
				orderByComparator)
		throws NoSuchReferralException;

	/**
	 * Returns the last referral in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching referral, or <code>null</code> if a matching referral could not be found
	 */
	public Referral fetchByStatus_Last(
		String status,
		com.liferay.portal.kernel.util.OrderByComparator<Referral>
			orderByComparator);

	/**
	 * Returns the referrals before and after the current referral in the ordered set where status = &#63;.
	 *
	 * @param referralId the primary key of the current referral
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next referral
	 * @throws NoSuchReferralException if a referral with the primary key could not be found
	 */
	public Referral[] findByStatus_PrevAndNext(
			long referralId, String status,
			com.liferay.portal.kernel.util.OrderByComparator<Referral>
				orderByComparator)
		throws NoSuchReferralException;

	/**
	 * Removes all the referrals where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(String status);

	/**
	 * Returns the number of referrals where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching referrals
	 */
	public int countByStatus(String status);

	/**
	 * Returns all the referrals where facilities = &#63;.
	 *
	 * @param facilities the facilities
	 * @return the matching referrals
	 */
	public java.util.List<Referral> findByFacilities(String facilities);

	/**
	 * Returns a range of all the referrals where facilities = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param facilities the facilities
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @return the range of matching referrals
	 */
	public java.util.List<Referral> findByFacilities(
		String facilities, int start, int end);

	/**
	 * Returns an ordered range of all the referrals where facilities = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param facilities the facilities
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching referrals
	 */
	public java.util.List<Referral> findByFacilities(
		String facilities, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Referral>
			orderByComparator);

	/**
	 * Returns an ordered range of all the referrals where facilities = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param facilities the facilities
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching referrals
	 */
	public java.util.List<Referral> findByFacilities(
		String facilities, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Referral>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first referral in the ordered set where facilities = &#63;.
	 *
	 * @param facilities the facilities
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching referral
	 * @throws NoSuchReferralException if a matching referral could not be found
	 */
	public Referral findByFacilities_First(
			String facilities,
			com.liferay.portal.kernel.util.OrderByComparator<Referral>
				orderByComparator)
		throws NoSuchReferralException;

	/**
	 * Returns the first referral in the ordered set where facilities = &#63;.
	 *
	 * @param facilities the facilities
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching referral, or <code>null</code> if a matching referral could not be found
	 */
	public Referral fetchByFacilities_First(
		String facilities,
		com.liferay.portal.kernel.util.OrderByComparator<Referral>
			orderByComparator);

	/**
	 * Returns the last referral in the ordered set where facilities = &#63;.
	 *
	 * @param facilities the facilities
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching referral
	 * @throws NoSuchReferralException if a matching referral could not be found
	 */
	public Referral findByFacilities_Last(
			String facilities,
			com.liferay.portal.kernel.util.OrderByComparator<Referral>
				orderByComparator)
		throws NoSuchReferralException;

	/**
	 * Returns the last referral in the ordered set where facilities = &#63;.
	 *
	 * @param facilities the facilities
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching referral, or <code>null</code> if a matching referral could not be found
	 */
	public Referral fetchByFacilities_Last(
		String facilities,
		com.liferay.portal.kernel.util.OrderByComparator<Referral>
			orderByComparator);

	/**
	 * Returns the referrals before and after the current referral in the ordered set where facilities = &#63;.
	 *
	 * @param referralId the primary key of the current referral
	 * @param facilities the facilities
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next referral
	 * @throws NoSuchReferralException if a referral with the primary key could not be found
	 */
	public Referral[] findByFacilities_PrevAndNext(
			long referralId, String facilities,
			com.liferay.portal.kernel.util.OrderByComparator<Referral>
				orderByComparator)
		throws NoSuchReferralException;

	/**
	 * Removes all the referrals where facilities = &#63; from the database.
	 *
	 * @param facilities the facilities
	 */
	public void removeByFacilities(String facilities);

	/**
	 * Returns the number of referrals where facilities = &#63;.
	 *
	 * @param facilities the facilities
	 * @return the number of matching referrals
	 */
	public int countByFacilities(String facilities);

	/**
	 * Caches the referral in the entity cache if it is enabled.
	 *
	 * @param referral the referral
	 */
	public void cacheResult(Referral referral);

	/**
	 * Caches the referrals in the entity cache if it is enabled.
	 *
	 * @param referrals the referrals
	 */
	public void cacheResult(java.util.List<Referral> referrals);

	/**
	 * Creates a new referral with the primary key. Does not add the referral to the database.
	 *
	 * @param referralId the primary key for the new referral
	 * @return the new referral
	 */
	public Referral create(long referralId);

	/**
	 * Removes the referral with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param referralId the primary key of the referral
	 * @return the referral that was removed
	 * @throws NoSuchReferralException if a referral with the primary key could not be found
	 */
	public Referral remove(long referralId) throws NoSuchReferralException;

	public Referral updateImpl(Referral referral);

	/**
	 * Returns the referral with the primary key or throws a <code>NoSuchReferralException</code> if it could not be found.
	 *
	 * @param referralId the primary key of the referral
	 * @return the referral
	 * @throws NoSuchReferralException if a referral with the primary key could not be found
	 */
	public Referral findByPrimaryKey(long referralId)
		throws NoSuchReferralException;

	/**
	 * Returns the referral with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param referralId the primary key of the referral
	 * @return the referral, or <code>null</code> if a referral with the primary key could not be found
	 */
	public Referral fetchByPrimaryKey(long referralId);

	/**
	 * Returns all the referrals.
	 *
	 * @return the referrals
	 */
	public java.util.List<Referral> findAll();

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
	public java.util.List<Referral> findAll(int start, int end);

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
	public java.util.List<Referral> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Referral>
			orderByComparator);

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
	public java.util.List<Referral> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Referral>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the referrals from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of referrals.
	 *
	 * @return the number of referrals
	 */
	public int countAll();

}