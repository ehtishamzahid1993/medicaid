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

import com.medicaid.app.exception.NoSuchFacilityAdminException;
import com.medicaid.app.model.FacilityAdmin;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the facility admin service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacilityAdminUtil
 * @generated
 */
@ProviderType
public interface FacilityAdminPersistence
	extends BasePersistence<FacilityAdmin> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FacilityAdminUtil} to access the facility admin persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the facility admin in the entity cache if it is enabled.
	 *
	 * @param facilityAdmin the facility admin
	 */
	public void cacheResult(FacilityAdmin facilityAdmin);

	/**
	 * Caches the facility admins in the entity cache if it is enabled.
	 *
	 * @param facilityAdmins the facility admins
	 */
	public void cacheResult(java.util.List<FacilityAdmin> facilityAdmins);

	/**
	 * Creates a new facility admin with the primary key. Does not add the facility admin to the database.
	 *
	 * @param userName the primary key for the new facility admin
	 * @return the new facility admin
	 */
	public FacilityAdmin create(String userName);

	/**
	 * Removes the facility admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userName the primary key of the facility admin
	 * @return the facility admin that was removed
	 * @throws NoSuchFacilityAdminException if a facility admin with the primary key could not be found
	 */
	public FacilityAdmin remove(String userName)
		throws NoSuchFacilityAdminException;

	public FacilityAdmin updateImpl(FacilityAdmin facilityAdmin);

	/**
	 * Returns the facility admin with the primary key or throws a <code>NoSuchFacilityAdminException</code> if it could not be found.
	 *
	 * @param userName the primary key of the facility admin
	 * @return the facility admin
	 * @throws NoSuchFacilityAdminException if a facility admin with the primary key could not be found
	 */
	public FacilityAdmin findByPrimaryKey(String userName)
		throws NoSuchFacilityAdminException;

	/**
	 * Returns the facility admin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userName the primary key of the facility admin
	 * @return the facility admin, or <code>null</code> if a facility admin with the primary key could not be found
	 */
	public FacilityAdmin fetchByPrimaryKey(String userName);

	/**
	 * Returns all the facility admins.
	 *
	 * @return the facility admins
	 */
	public java.util.List<FacilityAdmin> findAll();

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
	public java.util.List<FacilityAdmin> findAll(int start, int end);

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
	public java.util.List<FacilityAdmin> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacilityAdmin>
			orderByComparator);

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
	public java.util.List<FacilityAdmin> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacilityAdmin>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the facility admins from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of facility admins.
	 *
	 * @return the number of facility admins
	 */
	public int countAll();

}