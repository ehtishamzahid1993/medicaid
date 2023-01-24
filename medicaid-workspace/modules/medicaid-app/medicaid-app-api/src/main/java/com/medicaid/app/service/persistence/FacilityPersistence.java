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

import com.medicaid.app.exception.NoSuchFacilityException;
import com.medicaid.app.model.Facility;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the facility service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacilityUtil
 * @generated
 */
@ProviderType
public interface FacilityPersistence extends BasePersistence<Facility> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FacilityUtil} to access the facility persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the facility in the entity cache if it is enabled.
	 *
	 * @param facility the facility
	 */
	public void cacheResult(Facility facility);

	/**
	 * Caches the facilities in the entity cache if it is enabled.
	 *
	 * @param facilities the facilities
	 */
	public void cacheResult(java.util.List<Facility> facilities);

	/**
	 * Creates a new facility with the primary key. Does not add the facility to the database.
	 *
	 * @param facilityId the primary key for the new facility
	 * @return the new facility
	 */
	public Facility create(long facilityId);

	/**
	 * Removes the facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility that was removed
	 * @throws NoSuchFacilityException if a facility with the primary key could not be found
	 */
	public Facility remove(long facilityId) throws NoSuchFacilityException;

	public Facility updateImpl(Facility facility);

	/**
	 * Returns the facility with the primary key or throws a <code>NoSuchFacilityException</code> if it could not be found.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility
	 * @throws NoSuchFacilityException if a facility with the primary key could not be found
	 */
	public Facility findByPrimaryKey(long facilityId)
		throws NoSuchFacilityException;

	/**
	 * Returns the facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility, or <code>null</code> if a facility with the primary key could not be found
	 */
	public Facility fetchByPrimaryKey(long facilityId);

	/**
	 * Returns all the facilities.
	 *
	 * @return the facilities
	 */
	public java.util.List<Facility> findAll();

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
	public java.util.List<Facility> findAll(int start, int end);

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
	public java.util.List<Facility> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Facility>
			orderByComparator);

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
	public java.util.List<Facility> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Facility>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the facilities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of facilities.
	 *
	 * @return the number of facilities
	 */
	public int countAll();

}