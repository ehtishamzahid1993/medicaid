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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.medicaid.app.service.http.PatientServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PatientSoap implements Serializable {

	public static PatientSoap toSoapModel(Patient model) {
		PatientSoap soapModel = new PatientSoap();

		soapModel.setPatientId(model.getPatientId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setPhoneNo(model.getPhoneNo());
		soapModel.setDateOfBirth(model.getDateOfBirth());
		soapModel.setAdmitDate(model.getAdmitDate());
		soapModel.setAdmitPayer(model.getAdmitPayer());
		soapModel.setMedicaidNeedDate(model.getMedicaidNeedDate());
		soapModel.setHaveMedicaid(model.isHaveMedicaid());
		soapModel.setResidentLiabilityEmailSent(
			model.isResidentLiabilityEmailSent());
		soapModel.setAddress(model.getAddress());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setZipCode(model.getZipCode());
		soapModel.setDocumentIds(model.getDocumentIds());
		soapModel.setReferralId(model.getReferralId());
		soapModel.setFacilityId(model.getFacilityId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static PatientSoap[] toSoapModels(Patient[] models) {
		PatientSoap[] soapModels = new PatientSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PatientSoap[][] toSoapModels(Patient[][] models) {
		PatientSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PatientSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PatientSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PatientSoap[] toSoapModels(List<Patient> models) {
		List<PatientSoap> soapModels = new ArrayList<PatientSoap>(
			models.size());

		for (Patient model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PatientSoap[soapModels.size()]);
	}

	public PatientSoap() {
	}

	public long getPrimaryKey() {
		return _patientId;
	}

	public void setPrimaryKey(long pk) {
		setPatientId(pk);
	}

	public long getPatientId() {
		return _patientId;
	}

	public void setPatientId(long patientId) {
		_patientId = patientId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public long getPhoneNo() {
		return _phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		_phoneNo = phoneNo;
	}

	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	public Date getAdmitDate() {
		return _admitDate;
	}

	public void setAdmitDate(Date admitDate) {
		_admitDate = admitDate;
	}

	public String getAdmitPayer() {
		return _admitPayer;
	}

	public void setAdmitPayer(String admitPayer) {
		_admitPayer = admitPayer;
	}

	public Date getMedicaidNeedDate() {
		return _medicaidNeedDate;
	}

	public void setMedicaidNeedDate(Date medicaidNeedDate) {
		_medicaidNeedDate = medicaidNeedDate;
	}

	public boolean getHaveMedicaid() {
		return _haveMedicaid;
	}

	public boolean isHaveMedicaid() {
		return _haveMedicaid;
	}

	public void setHaveMedicaid(boolean haveMedicaid) {
		_haveMedicaid = haveMedicaid;
	}

	public boolean getResidentLiabilityEmailSent() {
		return _residentLiabilityEmailSent;
	}

	public boolean isResidentLiabilityEmailSent() {
		return _residentLiabilityEmailSent;
	}

	public void setResidentLiabilityEmailSent(
		boolean residentLiabilityEmailSent) {

		_residentLiabilityEmailSent = residentLiabilityEmailSent;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getZipCode() {
		return _zipCode;
	}

	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	public String getDocumentIds() {
		return _documentIds;
	}

	public void setDocumentIds(String documentIds) {
		_documentIds = documentIds;
	}

	public String getReferralId() {
		return _referralId;
	}

	public void setReferralId(String referralId) {
		_referralId = referralId;
	}

	public String getFacilityId() {
		return _facilityId;
	}

	public void setFacilityId(String facilityId) {
		_facilityId = facilityId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	private long _patientId;
	private String _firstName;
	private String _lastName;
	private String _emailAddress;
	private long _phoneNo;
	private Date _dateOfBirth;
	private Date _admitDate;
	private String _admitPayer;
	private Date _medicaidNeedDate;
	private boolean _haveMedicaid;
	private boolean _residentLiabilityEmailSent;
	private String _address;
	private String _city;
	private String _state;
	private String _zipCode;
	private String _documentIds;
	private String _referralId;
	private String _facilityId;
	private Date _createDate;
	private String _createdBy;
	private Date _modifiedDate;
	private String _modifiedBy;

}