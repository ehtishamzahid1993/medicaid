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

import com.medicaid.app.exception.NoSuchPatientException;
import com.medicaid.app.model.Patient;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the patient service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientUtil
 * @generated
 */
@ProviderType
public interface PatientPersistence extends BasePersistence<Patient> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PatientUtil} to access the patient persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the patients where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the matching patients
	 */
	public java.util.List<Patient> findByFirstName(String firstName);

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
	public java.util.List<Patient> findByFirstName(
		String firstName, int start, int end);

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
	public java.util.List<Patient> findByFirstName(
		String firstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

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
	public java.util.List<Patient> findByFirstName(
		String firstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first patient in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByFirstName_First(
			String firstName,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the first patient in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByFirstName_First(
		String firstName,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the last patient in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByFirstName_Last(
			String firstName,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the last patient in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByFirstName_Last(
		String firstName,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the patients before and after the current patient in the ordered set where firstName = &#63;.
	 *
	 * @param patientId the primary key of the current patient
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public Patient[] findByFirstName_PrevAndNext(
			long patientId, String firstName,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Removes all the patients where firstName = &#63; from the database.
	 *
	 * @param firstName the first name
	 */
	public void removeByFirstName(String firstName);

	/**
	 * Returns the number of patients where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the number of matching patients
	 */
	public int countByFirstName(String firstName);

	/**
	 * Returns all the patients where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching patients
	 */
	public java.util.List<Patient> findByEmailAddress(String emailAddress);

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
	public java.util.List<Patient> findByEmailAddress(
		String emailAddress, int start, int end);

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
	public java.util.List<Patient> findByEmailAddress(
		String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

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
	public java.util.List<Patient> findByEmailAddress(
		String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first patient in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByEmailAddress_First(
			String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the first patient in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByEmailAddress_First(
		String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the last patient in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByEmailAddress_Last(
			String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the last patient in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByEmailAddress_Last(
		String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the patients before and after the current patient in the ordered set where emailAddress = &#63;.
	 *
	 * @param patientId the primary key of the current patient
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public Patient[] findByEmailAddress_PrevAndNext(
			long patientId, String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Removes all the patients where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	public void removeByEmailAddress(String emailAddress);

	/**
	 * Returns the number of patients where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching patients
	 */
	public int countByEmailAddress(String emailAddress);

	/**
	 * Caches the patient in the entity cache if it is enabled.
	 *
	 * @param patient the patient
	 */
	public void cacheResult(Patient patient);

	/**
	 * Caches the patients in the entity cache if it is enabled.
	 *
	 * @param patients the patients
	 */
	public void cacheResult(java.util.List<Patient> patients);

	/**
	 * Creates a new patient with the primary key. Does not add the patient to the database.
	 *
	 * @param patientId the primary key for the new patient
	 * @return the new patient
	 */
	public Patient create(long patientId);

	/**
	 * Removes the patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patientId the primary key of the patient
	 * @return the patient that was removed
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public Patient remove(long patientId) throws NoSuchPatientException;

	public Patient updateImpl(Patient patient);

	/**
	 * Returns the patient with the primary key or throws a <code>NoSuchPatientException</code> if it could not be found.
	 *
	 * @param patientId the primary key of the patient
	 * @return the patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public Patient findByPrimaryKey(long patientId)
		throws NoSuchPatientException;

	/**
	 * Returns the patient with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patientId the primary key of the patient
	 * @return the patient, or <code>null</code> if a patient with the primary key could not be found
	 */
	public Patient fetchByPrimaryKey(long patientId);

	/**
	 * Returns all the patients.
	 *
	 * @return the patients
	 */
	public java.util.List<Patient> findAll();

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
	public java.util.List<Patient> findAll(int start, int end);

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
	public java.util.List<Patient> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

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
	public java.util.List<Patient> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the patients from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of patients.
	 *
	 * @return the number of patients
	 */
	public int countAll();

}