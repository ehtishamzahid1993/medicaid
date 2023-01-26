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

package com.medicaid.app.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Patient}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Patient
 * @generated
 */
public class PatientWrapper
	extends BaseModelWrapper<Patient>
	implements ModelWrapper<Patient>, Patient {

	public PatientWrapper(Patient patient) {
		super(patient);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("patientId", getPatientId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("phoneNo", getPhoneNo());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("admitDate", getAdmitDate());
		attributes.put("admitPayer", getAdmitPayer());
		attributes.put("medicaidNeedDate", getMedicaidNeedDate());
		attributes.put("haveMedicaid", isHaveMedicaid());
		attributes.put(
			"residentLiabilityEmailSent", isResidentLiabilityEmailSent());
		attributes.put("address", getAddress());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("zipCode", getZipCode());
		attributes.put("documentIds", getDocumentIds());
		attributes.put("referralId", getReferralId());
		attributes.put("facilityId", getFacilityId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long patientId = (Long)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Long phoneNo = (Long)attributes.get("phoneNo");

		if (phoneNo != null) {
			setPhoneNo(phoneNo);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		Date admitDate = (Date)attributes.get("admitDate");

		if (admitDate != null) {
			setAdmitDate(admitDate);
		}

		String admitPayer = (String)attributes.get("admitPayer");

		if (admitPayer != null) {
			setAdmitPayer(admitPayer);
		}

		Date medicaidNeedDate = (Date)attributes.get("medicaidNeedDate");

		if (medicaidNeedDate != null) {
			setMedicaidNeedDate(medicaidNeedDate);
		}

		Boolean haveMedicaid = (Boolean)attributes.get("haveMedicaid");

		if (haveMedicaid != null) {
			setHaveMedicaid(haveMedicaid);
		}

		Boolean residentLiabilityEmailSent = (Boolean)attributes.get(
			"residentLiabilityEmailSent");

		if (residentLiabilityEmailSent != null) {
			setResidentLiabilityEmailSent(residentLiabilityEmailSent);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		String documentIds = (String)attributes.get("documentIds");

		if (documentIds != null) {
			setDocumentIds(documentIds);
		}

		String referralId = (String)attributes.get("referralId");

		if (referralId != null) {
			setReferralId(referralId);
		}

		String facilityId = (String)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	/**
	 * Returns the address of this patient.
	 *
	 * @return the address of this patient
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the admit date of this patient.
	 *
	 * @return the admit date of this patient
	 */
	@Override
	public Date getAdmitDate() {
		return model.getAdmitDate();
	}

	/**
	 * Returns the admit payer of this patient.
	 *
	 * @return the admit payer of this patient
	 */
	@Override
	public String getAdmitPayer() {
		return model.getAdmitPayer();
	}

	/**
	 * Returns the city of this patient.
	 *
	 * @return the city of this patient
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the create date of this patient.
	 *
	 * @return the create date of this patient
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this patient.
	 *
	 * @return the created by of this patient
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the date of birth of this patient.
	 *
	 * @return the date of birth of this patient
	 */
	@Override
	public Date getDateOfBirth() {
		return model.getDateOfBirth();
	}

	/**
	 * Returns the document IDs of this patient.
	 *
	 * @return the document IDs of this patient
	 */
	@Override
	public String getDocumentIds() {
		return model.getDocumentIds();
	}

	/**
	 * Returns the email address of this patient.
	 *
	 * @return the email address of this patient
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the facility ID of this patient.
	 *
	 * @return the facility ID of this patient
	 */
	@Override
	public String getFacilityId() {
		return model.getFacilityId();
	}

	/**
	 * Returns the first name of this patient.
	 *
	 * @return the first name of this patient
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the have medicaid of this patient.
	 *
	 * @return the have medicaid of this patient
	 */
	@Override
	public boolean getHaveMedicaid() {
		return model.getHaveMedicaid();
	}

	/**
	 * Returns the last name of this patient.
	 *
	 * @return the last name of this patient
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the medicaid need date of this patient.
	 *
	 * @return the medicaid need date of this patient
	 */
	@Override
	public Date getMedicaidNeedDate() {
		return model.getMedicaidNeedDate();
	}

	/**
	 * Returns the modified by of this patient.
	 *
	 * @return the modified by of this patient
	 */
	@Override
	public String getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this patient.
	 *
	 * @return the modified date of this patient
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the patient ID of this patient.
	 *
	 * @return the patient ID of this patient
	 */
	@Override
	public long getPatientId() {
		return model.getPatientId();
	}

	/**
	 * Returns the phone no of this patient.
	 *
	 * @return the phone no of this patient
	 */
	@Override
	public long getPhoneNo() {
		return model.getPhoneNo();
	}

	/**
	 * Returns the primary key of this patient.
	 *
	 * @return the primary key of this patient
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the referral ID of this patient.
	 *
	 * @return the referral ID of this patient
	 */
	@Override
	public String getReferralId() {
		return model.getReferralId();
	}

	/**
	 * Returns the resident liability email sent of this patient.
	 *
	 * @return the resident liability email sent of this patient
	 */
	@Override
	public boolean getResidentLiabilityEmailSent() {
		return model.getResidentLiabilityEmailSent();
	}

	/**
	 * Returns the state of this patient.
	 *
	 * @return the state of this patient
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the zip code of this patient.
	 *
	 * @return the zip code of this patient
	 */
	@Override
	public String getZipCode() {
		return model.getZipCode();
	}

	/**
	 * Returns <code>true</code> if this patient is have medicaid.
	 *
	 * @return <code>true</code> if this patient is have medicaid; <code>false</code> otherwise
	 */
	@Override
	public boolean isHaveMedicaid() {
		return model.isHaveMedicaid();
	}

	/**
	 * Returns <code>true</code> if this patient is resident liability email sent.
	 *
	 * @return <code>true</code> if this patient is resident liability email sent; <code>false</code> otherwise
	 */
	@Override
	public boolean isResidentLiabilityEmailSent() {
		return model.isResidentLiabilityEmailSent();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this patient.
	 *
	 * @param address the address of this patient
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the admit date of this patient.
	 *
	 * @param admitDate the admit date of this patient
	 */
	@Override
	public void setAdmitDate(Date admitDate) {
		model.setAdmitDate(admitDate);
	}

	/**
	 * Sets the admit payer of this patient.
	 *
	 * @param admitPayer the admit payer of this patient
	 */
	@Override
	public void setAdmitPayer(String admitPayer) {
		model.setAdmitPayer(admitPayer);
	}

	/**
	 * Sets the city of this patient.
	 *
	 * @param city the city of this patient
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the create date of this patient.
	 *
	 * @param createDate the create date of this patient
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this patient.
	 *
	 * @param createdBy the created by of this patient
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the date of birth of this patient.
	 *
	 * @param dateOfBirth the date of birth of this patient
	 */
	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		model.setDateOfBirth(dateOfBirth);
	}

	/**
	 * Sets the document IDs of this patient.
	 *
	 * @param documentIds the document IDs of this patient
	 */
	@Override
	public void setDocumentIds(String documentIds) {
		model.setDocumentIds(documentIds);
	}

	/**
	 * Sets the email address of this patient.
	 *
	 * @param emailAddress the email address of this patient
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets the facility ID of this patient.
	 *
	 * @param facilityId the facility ID of this patient
	 */
	@Override
	public void setFacilityId(String facilityId) {
		model.setFacilityId(facilityId);
	}

	/**
	 * Sets the first name of this patient.
	 *
	 * @param firstName the first name of this patient
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets whether this patient is have medicaid.
	 *
	 * @param haveMedicaid the have medicaid of this patient
	 */
	@Override
	public void setHaveMedicaid(boolean haveMedicaid) {
		model.setHaveMedicaid(haveMedicaid);
	}

	/**
	 * Sets the last name of this patient.
	 *
	 * @param lastName the last name of this patient
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the medicaid need date of this patient.
	 *
	 * @param medicaidNeedDate the medicaid need date of this patient
	 */
	@Override
	public void setMedicaidNeedDate(Date medicaidNeedDate) {
		model.setMedicaidNeedDate(medicaidNeedDate);
	}

	/**
	 * Sets the modified by of this patient.
	 *
	 * @param modifiedBy the modified by of this patient
	 */
	@Override
	public void setModifiedBy(String modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this patient.
	 *
	 * @param modifiedDate the modified date of this patient
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the patient ID of this patient.
	 *
	 * @param patientId the patient ID of this patient
	 */
	@Override
	public void setPatientId(long patientId) {
		model.setPatientId(patientId);
	}

	/**
	 * Sets the phone no of this patient.
	 *
	 * @param phoneNo the phone no of this patient
	 */
	@Override
	public void setPhoneNo(long phoneNo) {
		model.setPhoneNo(phoneNo);
	}

	/**
	 * Sets the primary key of this patient.
	 *
	 * @param primaryKey the primary key of this patient
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the referral ID of this patient.
	 *
	 * @param referralId the referral ID of this patient
	 */
	@Override
	public void setReferralId(String referralId) {
		model.setReferralId(referralId);
	}

	/**
	 * Sets whether this patient is resident liability email sent.
	 *
	 * @param residentLiabilityEmailSent the resident liability email sent of this patient
	 */
	@Override
	public void setResidentLiabilityEmailSent(
		boolean residentLiabilityEmailSent) {

		model.setResidentLiabilityEmailSent(residentLiabilityEmailSent);
	}

	/**
	 * Sets the state of this patient.
	 *
	 * @param state the state of this patient
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the zip code of this patient.
	 *
	 * @param zipCode the zip code of this patient
	 */
	@Override
	public void setZipCode(String zipCode) {
		model.setZipCode(zipCode);
	}

	@Override
	protected PatientWrapper wrap(Patient patient) {
		return new PatientWrapper(patient);
	}

}