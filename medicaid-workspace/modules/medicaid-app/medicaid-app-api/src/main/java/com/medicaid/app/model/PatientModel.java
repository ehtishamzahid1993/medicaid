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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Patient service. Represents a row in the &quot;Medicaid_Patient&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.medicaid.app.model.impl.PatientModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.medicaid.app.model.impl.PatientImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Patient
 * @generated
 */
@ProviderType
public interface PatientModel extends BaseModel<Patient> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a patient model instance should use the {@link Patient} interface instead.
	 */

	/**
	 * Returns the primary key of this patient.
	 *
	 * @return the primary key of this patient
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this patient.
	 *
	 * @param primaryKey the primary key of this patient
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the patient ID of this patient.
	 *
	 * @return the patient ID of this patient
	 */
	public long getPatientId();

	/**
	 * Sets the patient ID of this patient.
	 *
	 * @param patientId the patient ID of this patient
	 */
	public void setPatientId(long patientId);

	/**
	 * Returns the first name of this patient.
	 *
	 * @return the first name of this patient
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this patient.
	 *
	 * @param firstName the first name of this patient
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this patient.
	 *
	 * @return the last name of this patient
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this patient.
	 *
	 * @param lastName the last name of this patient
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the email address of this patient.
	 *
	 * @return the email address of this patient
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this patient.
	 *
	 * @param emailAddress the email address of this patient
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the phone no of this patient.
	 *
	 * @return the phone no of this patient
	 */
	public long getPhoneNo();

	/**
	 * Sets the phone no of this patient.
	 *
	 * @param phoneNo the phone no of this patient
	 */
	public void setPhoneNo(long phoneNo);

	/**
	 * Returns the date of birth of this patient.
	 *
	 * @return the date of birth of this patient
	 */
	public Date getDateOfBirth();

	/**
	 * Sets the date of birth of this patient.
	 *
	 * @param dateOfBirth the date of birth of this patient
	 */
	public void setDateOfBirth(Date dateOfBirth);

	/**
	 * Returns the admit date of this patient.
	 *
	 * @return the admit date of this patient
	 */
	public Date getAdmitDate();

	/**
	 * Sets the admit date of this patient.
	 *
	 * @param admitDate the admit date of this patient
	 */
	public void setAdmitDate(Date admitDate);

	/**
	 * Returns the admit payer of this patient.
	 *
	 * @return the admit payer of this patient
	 */
	@AutoEscape
	public String getAdmitPayer();

	/**
	 * Sets the admit payer of this patient.
	 *
	 * @param admitPayer the admit payer of this patient
	 */
	public void setAdmitPayer(String admitPayer);

	/**
	 * Returns the medicaid need date of this patient.
	 *
	 * @return the medicaid need date of this patient
	 */
	public Date getMedicaidNeedDate();

	/**
	 * Sets the medicaid need date of this patient.
	 *
	 * @param medicaidNeedDate the medicaid need date of this patient
	 */
	public void setMedicaidNeedDate(Date medicaidNeedDate);

	/**
	 * Returns the have medicaid of this patient.
	 *
	 * @return the have medicaid of this patient
	 */
	public boolean getHaveMedicaid();

	/**
	 * Returns <code>true</code> if this patient is have medicaid.
	 *
	 * @return <code>true</code> if this patient is have medicaid; <code>false</code> otherwise
	 */
	public boolean isHaveMedicaid();

	/**
	 * Sets whether this patient is have medicaid.
	 *
	 * @param haveMedicaid the have medicaid of this patient
	 */
	public void setHaveMedicaid(boolean haveMedicaid);

	/**
	 * Returns the resident liability email sent of this patient.
	 *
	 * @return the resident liability email sent of this patient
	 */
	public boolean getResidentLiabilityEmailSent();

	/**
	 * Returns <code>true</code> if this patient is resident liability email sent.
	 *
	 * @return <code>true</code> if this patient is resident liability email sent; <code>false</code> otherwise
	 */
	public boolean isResidentLiabilityEmailSent();

	/**
	 * Sets whether this patient is resident liability email sent.
	 *
	 * @param residentLiabilityEmailSent the resident liability email sent of this patient
	 */
	public void setResidentLiabilityEmailSent(
		boolean residentLiabilityEmailSent);

	/**
	 * Returns the address of this patient.
	 *
	 * @return the address of this patient
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this patient.
	 *
	 * @param address the address of this patient
	 */
	public void setAddress(String address);

	/**
	 * Returns the city of this patient.
	 *
	 * @return the city of this patient
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this patient.
	 *
	 * @param city the city of this patient
	 */
	public void setCity(String city);

	/**
	 * Returns the state of this patient.
	 *
	 * @return the state of this patient
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this patient.
	 *
	 * @param state the state of this patient
	 */
	public void setState(String state);

	/**
	 * Returns the zip code of this patient.
	 *
	 * @return the zip code of this patient
	 */
	@AutoEscape
	public String getZipCode();

	/**
	 * Sets the zip code of this patient.
	 *
	 * @param zipCode the zip code of this patient
	 */
	public void setZipCode(String zipCode);

	/**
	 * Returns the document IDs of this patient.
	 *
	 * @return the document IDs of this patient
	 */
	@AutoEscape
	public String getDocumentIds();

	/**
	 * Sets the document IDs of this patient.
	 *
	 * @param documentIds the document IDs of this patient
	 */
	public void setDocumentIds(String documentIds);

	/**
	 * Returns the referral ID of this patient.
	 *
	 * @return the referral ID of this patient
	 */
	@AutoEscape
	public String getReferralId();

	/**
	 * Sets the referral ID of this patient.
	 *
	 * @param referralId the referral ID of this patient
	 */
	public void setReferralId(String referralId);

	/**
	 * Returns the facility ID of this patient.
	 *
	 * @return the facility ID of this patient
	 */
	@AutoEscape
	public String getFacilityId();

	/**
	 * Sets the facility ID of this patient.
	 *
	 * @param facilityId the facility ID of this patient
	 */
	public void setFacilityId(String facilityId);

	/**
	 * Returns the create date of this patient.
	 *
	 * @return the create date of this patient
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this patient.
	 *
	 * @param createDate the create date of this patient
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by of this patient.
	 *
	 * @return the created by of this patient
	 */
	@AutoEscape
	public String getCreatedBy();

	/**
	 * Sets the created by of this patient.
	 *
	 * @param createdBy the created by of this patient
	 */
	public void setCreatedBy(String createdBy);

	/**
	 * Returns the modified date of this patient.
	 *
	 * @return the modified date of this patient
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this patient.
	 *
	 * @param modifiedDate the modified date of this patient
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this patient.
	 *
	 * @return the modified by of this patient
	 */
	@AutoEscape
	public String getModifiedBy();

	/**
	 * Sets the modified by of this patient.
	 *
	 * @param modifiedBy the modified by of this patient
	 */
	public void setModifiedBy(String modifiedBy);

}