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

package com.medicaid.app.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PatientLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PatientLocalService
 * @generated
 */
public class PatientLocalServiceWrapper
	implements PatientLocalService, ServiceWrapper<PatientLocalService> {

	public PatientLocalServiceWrapper(PatientLocalService patientLocalService) {
		_patientLocalService = patientLocalService;
	}

	/**
	 * Adds the patient to the database. Also notifies the appropriate model listeners.
	 *
	 * @param patient the patient
	 * @return the patient that was added
	 */
	@Override
	public com.medicaid.app.model.Patient addPatient(
		com.medicaid.app.model.Patient patient) {

		return _patientLocalService.addPatient(patient);
	}

	/**
	 * Creates a new patient with the primary key. Does not add the patient to the database.
	 *
	 * @param patientId the primary key for the new patient
	 * @return the new patient
	 */
	@Override
	public com.medicaid.app.model.Patient createPatient(long patientId) {
		return _patientLocalService.createPatient(patientId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patientId the primary key of the patient
	 * @return the patient that was removed
	 * @throws PortalException if a patient with the primary key could not be found
	 */
	@Override
	public com.medicaid.app.model.Patient deletePatient(long patientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientLocalService.deletePatient(patientId);
	}

	/**
	 * Deletes the patient from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patient the patient
	 * @return the patient that was removed
	 */
	@Override
	public com.medicaid.app.model.Patient deletePatient(
		com.medicaid.app.model.Patient patient) {

		return _patientLocalService.deletePatient(patient);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _patientLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _patientLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.app.model.impl.PatientModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _patientLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.app.model.impl.PatientModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _patientLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _patientLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _patientLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.medicaid.app.model.Patient fetchPatient(long patientId) {
		return _patientLocalService.fetchPatient(patientId);
	}

	@Override
	public java.util.List<com.medicaid.app.model.Patient> findByEmailAddress(
		String emailAddress) {

		return _patientLocalService.findByEmailAddress(emailAddress);
	}

	@Override
	public java.util.List<com.medicaid.app.model.Patient> findByFirstName(
		String firstName) {

		return _patientLocalService.findByFirstName(firstName);
	}

	@Override
	public java.util.List<com.medicaid.app.model.Patient> findByLastName(
		String lastName) {

		return _patientLocalService.findByLastName(lastName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _patientLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _patientLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _patientLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the patient with the primary key.
	 *
	 * @param patientId the primary key of the patient
	 * @return the patient
	 * @throws PortalException if a patient with the primary key could not be found
	 */
	@Override
	public com.medicaid.app.model.Patient getPatient(long patientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientLocalService.getPatient(patientId);
	}

	@Override
	public java.util.HashMap<Long, com.medicaid.app.model.Patient>
		getPatientMap() {

		return _patientLocalService.getPatientMap();
	}

	/**
	 * Returns a range of all the patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.app.model.impl.PatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of patients
	 */
	@Override
	public java.util.List<com.medicaid.app.model.Patient> getPatients(
		int start, int end) {

		return _patientLocalService.getPatients(start, end);
	}

	/**
	 * Returns the number of patients.
	 *
	 * @return the number of patients
	 */
	@Override
	public int getPatientsCount() {
		return _patientLocalService.getPatientsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the patient in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param patient the patient
	 * @return the patient that was updated
	 */
	@Override
	public com.medicaid.app.model.Patient updatePatient(
		com.medicaid.app.model.Patient patient) {

		return _patientLocalService.updatePatient(patient);
	}

	@Override
	public PatientLocalService getWrappedService() {
		return _patientLocalService;
	}

	@Override
	public void setWrappedService(PatientLocalService patientLocalService) {
		_patientLocalService = patientLocalService;
	}

	private PatientLocalService _patientLocalService;

}