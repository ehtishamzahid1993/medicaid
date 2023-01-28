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

import com.medicaid.app.model.Patient;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the patient service. This utility wraps <code>com.medicaid.app.service.persistence.impl.PatientPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientPersistence
 * @generated
 */
public class PatientUtil {

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
	public static void clearCache(Patient patient) {
		getPersistence().clearCache(patient);
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
	public static Map<Serializable, Patient> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Patient> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Patient> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Patient> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Patient update(Patient patient) {
		return getPersistence().update(patient);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Patient update(
		Patient patient, ServiceContext serviceContext) {

		return getPersistence().update(patient, serviceContext);
	}

	/**
	 * Returns all the patients where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the matching patients
	 */
	public static List<Patient> findByFirstName(String firstName) {
		return getPersistence().findByFirstName(firstName);
	}

	/**
	 * Returns a range of all the patients where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of matching patients
	 */
	public static List<Patient> findByFirstName(
		String firstName, int start, int end) {

		return getPersistence().findByFirstName(firstName, start, end);
	}

	/**
	 * Returns an ordered range of all the patients where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patients
	 */
	public static List<Patient> findByFirstName(
		String firstName, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return getPersistence().findByFirstName(
			firstName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the patients where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patients
	 */
	public static List<Patient> findByFirstName(
		String firstName, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFirstName(
			firstName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByFirstName_First(
			String firstName, OrderByComparator<Patient> orderByComparator)
		throws com.medicaid.app.exception.NoSuchPatientException {

		return getPersistence().findByFirstName_First(
			firstName, orderByComparator);
	}

	/**
	 * Returns the first patient in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByFirstName_First(
		String firstName, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByFirstName_First(
			firstName, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByFirstName_Last(
			String firstName, OrderByComparator<Patient> orderByComparator)
		throws com.medicaid.app.exception.NoSuchPatientException {

		return getPersistence().findByFirstName_Last(
			firstName, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByFirstName_Last(
		String firstName, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByFirstName_Last(
			firstName, orderByComparator);
	}

	/**
	 * Returns the patients before and after the current patient in the ordered set where firstName = &#63;.
	 *
	 * @param patientId the primary key of the current patient
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public static Patient[] findByFirstName_PrevAndNext(
			long patientId, String firstName,
			OrderByComparator<Patient> orderByComparator)
		throws com.medicaid.app.exception.NoSuchPatientException {

		return getPersistence().findByFirstName_PrevAndNext(
			patientId, firstName, orderByComparator);
	}

	/**
	 * Removes all the patients where firstName = &#63; from the database.
	 *
	 * @param firstName the first name
	 */
	public static void removeByFirstName(String firstName) {
		getPersistence().removeByFirstName(firstName);
	}

	/**
	 * Returns the number of patients where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the number of matching patients
	 */
	public static int countByFirstName(String firstName) {
		return getPersistence().countByFirstName(firstName);
	}

	/**
	 * Returns all the patients where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching patients
	 */
	public static List<Patient> findByLastName(String lastName) {
		return getPersistence().findByLastName(lastName);
	}

	/**
	 * Returns a range of all the patients where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of matching patients
	 */
	public static List<Patient> findByLastName(
		String lastName, int start, int end) {

		return getPersistence().findByLastName(lastName, start, end);
	}

	/**
	 * Returns an ordered range of all the patients where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patients
	 */
	public static List<Patient> findByLastName(
		String lastName, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return getPersistence().findByLastName(
			lastName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the patients where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patients
	 */
	public static List<Patient> findByLastName(
		String lastName, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByLastName(
			lastName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByLastName_First(
			String lastName, OrderByComparator<Patient> orderByComparator)
		throws com.medicaid.app.exception.NoSuchPatientException {

		return getPersistence().findByLastName_First(
			lastName, orderByComparator);
	}

	/**
	 * Returns the first patient in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByLastName_First(
		String lastName, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByLastName_First(
			lastName, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByLastName_Last(
			String lastName, OrderByComparator<Patient> orderByComparator)
		throws com.medicaid.app.exception.NoSuchPatientException {

		return getPersistence().findByLastName_Last(
			lastName, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByLastName_Last(
		String lastName, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByLastName_Last(
			lastName, orderByComparator);
	}

	/**
	 * Returns the patients before and after the current patient in the ordered set where lastName = &#63;.
	 *
	 * @param patientId the primary key of the current patient
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public static Patient[] findByLastName_PrevAndNext(
			long patientId, String lastName,
			OrderByComparator<Patient> orderByComparator)
		throws com.medicaid.app.exception.NoSuchPatientException {

		return getPersistence().findByLastName_PrevAndNext(
			patientId, lastName, orderByComparator);
	}

	/**
	 * Removes all the patients where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 */
	public static void removeByLastName(String lastName) {
		getPersistence().removeByLastName(lastName);
	}

	/**
	 * Returns the number of patients where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching patients
	 */
	public static int countByLastName(String lastName) {
		return getPersistence().countByLastName(lastName);
	}

	/**
	 * Returns all the patients where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching patients
	 */
	public static List<Patient> findByEmailAddress(String emailAddress) {
		return getPersistence().findByEmailAddress(emailAddress);
	}

	/**
	 * Returns a range of all the patients where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of matching patients
	 */
	public static List<Patient> findByEmailAddress(
		String emailAddress, int start, int end) {

		return getPersistence().findByEmailAddress(emailAddress, start, end);
	}

	/**
	 * Returns an ordered range of all the patients where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patients
	 */
	public static List<Patient> findByEmailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return getPersistence().findByEmailAddress(
			emailAddress, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the patients where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patients
	 */
	public static List<Patient> findByEmailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByEmailAddress(
			emailAddress, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByEmailAddress_First(
			String emailAddress, OrderByComparator<Patient> orderByComparator)
		throws com.medicaid.app.exception.NoSuchPatientException {

		return getPersistence().findByEmailAddress_First(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the first patient in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByEmailAddress_First(
		String emailAddress, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByEmailAddress_First(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByEmailAddress_Last(
			String emailAddress, OrderByComparator<Patient> orderByComparator)
		throws com.medicaid.app.exception.NoSuchPatientException {

		return getPersistence().findByEmailAddress_Last(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByEmailAddress_Last(
		String emailAddress, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByEmailAddress_Last(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the patients before and after the current patient in the ordered set where emailAddress = &#63;.
	 *
	 * @param patientId the primary key of the current patient
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public static Patient[] findByEmailAddress_PrevAndNext(
			long patientId, String emailAddress,
			OrderByComparator<Patient> orderByComparator)
		throws com.medicaid.app.exception.NoSuchPatientException {

		return getPersistence().findByEmailAddress_PrevAndNext(
			patientId, emailAddress, orderByComparator);
	}

	/**
	 * Removes all the patients where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	public static void removeByEmailAddress(String emailAddress) {
		getPersistence().removeByEmailAddress(emailAddress);
	}

	/**
	 * Returns the number of patients where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching patients
	 */
	public static int countByEmailAddress(String emailAddress) {
		return getPersistence().countByEmailAddress(emailAddress);
	}

	/**
	 * Returns all the patients where facilityId LIKE &#63;.
	 *
	 * @param facilityId the facility ID
	 * @return the matching patients
	 */
	public static List<Patient> findByFacilityId(String facilityId) {
		return getPersistence().findByFacilityId(facilityId);
	}

	/**
	 * Returns a range of all the patients where facilityId LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param facilityId the facility ID
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of matching patients
	 */
	public static List<Patient> findByFacilityId(
		String facilityId, int start, int end) {

		return getPersistence().findByFacilityId(facilityId, start, end);
	}

	/**
	 * Returns an ordered range of all the patients where facilityId LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param facilityId the facility ID
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patients
	 */
	public static List<Patient> findByFacilityId(
		String facilityId, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return getPersistence().findByFacilityId(
			facilityId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the patients where facilityId LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param facilityId the facility ID
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patients
	 */
	public static List<Patient> findByFacilityId(
		String facilityId, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFacilityId(
			facilityId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient in the ordered set where facilityId LIKE &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByFacilityId_First(
			String facilityId, OrderByComparator<Patient> orderByComparator)
		throws com.medicaid.app.exception.NoSuchPatientException {

		return getPersistence().findByFacilityId_First(
			facilityId, orderByComparator);
	}

	/**
	 * Returns the first patient in the ordered set where facilityId LIKE &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByFacilityId_First(
		String facilityId, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByFacilityId_First(
			facilityId, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where facilityId LIKE &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByFacilityId_Last(
			String facilityId, OrderByComparator<Patient> orderByComparator)
		throws com.medicaid.app.exception.NoSuchPatientException {

		return getPersistence().findByFacilityId_Last(
			facilityId, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where facilityId LIKE &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByFacilityId_Last(
		String facilityId, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByFacilityId_Last(
			facilityId, orderByComparator);
	}

	/**
	 * Returns the patients before and after the current patient in the ordered set where facilityId LIKE &#63;.
	 *
	 * @param patientId the primary key of the current patient
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public static Patient[] findByFacilityId_PrevAndNext(
			long patientId, String facilityId,
			OrderByComparator<Patient> orderByComparator)
		throws com.medicaid.app.exception.NoSuchPatientException {

		return getPersistence().findByFacilityId_PrevAndNext(
			patientId, facilityId, orderByComparator);
	}

	/**
	 * Removes all the patients where facilityId LIKE &#63; from the database.
	 *
	 * @param facilityId the facility ID
	 */
	public static void removeByFacilityId(String facilityId) {
		getPersistence().removeByFacilityId(facilityId);
	}

	/**
	 * Returns the number of patients where facilityId LIKE &#63;.
	 *
	 * @param facilityId the facility ID
	 * @return the number of matching patients
	 */
	public static int countByFacilityId(String facilityId) {
		return getPersistence().countByFacilityId(facilityId);
	}

	/**
	 * Caches the patient in the entity cache if it is enabled.
	 *
	 * @param patient the patient
	 */
	public static void cacheResult(Patient patient) {
		getPersistence().cacheResult(patient);
	}

	/**
	 * Caches the patients in the entity cache if it is enabled.
	 *
	 * @param patients the patients
	 */
	public static void cacheResult(List<Patient> patients) {
		getPersistence().cacheResult(patients);
	}

	/**
	 * Creates a new patient with the primary key. Does not add the patient to the database.
	 *
	 * @param patientId the primary key for the new patient
	 * @return the new patient
	 */
	public static Patient create(long patientId) {
		return getPersistence().create(patientId);
	}

	/**
	 * Removes the patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patientId the primary key of the patient
	 * @return the patient that was removed
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public static Patient remove(long patientId)
		throws com.medicaid.app.exception.NoSuchPatientException {

		return getPersistence().remove(patientId);
	}

	public static Patient updateImpl(Patient patient) {
		return getPersistence().updateImpl(patient);
	}

	/**
	 * Returns the patient with the primary key or throws a <code>NoSuchPatientException</code> if it could not be found.
	 *
	 * @param patientId the primary key of the patient
	 * @return the patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public static Patient findByPrimaryKey(long patientId)
		throws com.medicaid.app.exception.NoSuchPatientException {

		return getPersistence().findByPrimaryKey(patientId);
	}

	/**
	 * Returns the patient with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patientId the primary key of the patient
	 * @return the patient, or <code>null</code> if a patient with the primary key could not be found
	 */
	public static Patient fetchByPrimaryKey(long patientId) {
		return getPersistence().fetchByPrimaryKey(patientId);
	}

	/**
	 * Returns all the patients.
	 *
	 * @return the patients
	 */
	public static List<Patient> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of patients
	 */
	public static List<Patient> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of patients
	 */
	public static List<Patient> findAll(
		int start, int end, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of patients
	 */
	public static List<Patient> findAll(
		int start, int end, OrderByComparator<Patient> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the patients from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of patients.
	 *
	 * @return the number of patients
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PatientPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PatientPersistence, PatientPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PatientPersistence.class);

		ServiceTracker<PatientPersistence, PatientPersistence> serviceTracker =
			new ServiceTracker<PatientPersistence, PatientPersistence>(
				bundle.getBundleContext(), PatientPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}