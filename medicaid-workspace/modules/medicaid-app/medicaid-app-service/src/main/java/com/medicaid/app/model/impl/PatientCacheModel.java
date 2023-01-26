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

package com.medicaid.app.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.medicaid.app.model.Patient;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Patient in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PatientCacheModel implements CacheModel<Patient>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PatientCacheModel)) {
			return false;
		}

		PatientCacheModel patientCacheModel = (PatientCacheModel)obj;

		if (patientId == patientCacheModel.patientId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, patientId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{patientId=");
		sb.append(patientId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", phoneNo=");
		sb.append(phoneNo);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", admitDate=");
		sb.append(admitDate);
		sb.append(", admitPayer=");
		sb.append(admitPayer);
		sb.append(", medicaidNeedDate=");
		sb.append(medicaidNeedDate);
		sb.append(", haveMedicaid=");
		sb.append(haveMedicaid);
		sb.append(", residentLiabilityEmailSent=");
		sb.append(residentLiabilityEmailSent);
		sb.append(", address=");
		sb.append(address);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", documentIds=");
		sb.append(documentIds);
		sb.append(", referralId=");
		sb.append(referralId);
		sb.append(", facilityId=");
		sb.append(facilityId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Patient toEntityModel() {
		PatientImpl patientImpl = new PatientImpl();

		patientImpl.setPatientId(patientId);

		if (firstName == null) {
			patientImpl.setFirstName("");
		}
		else {
			patientImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			patientImpl.setLastName("");
		}
		else {
			patientImpl.setLastName(lastName);
		}

		if (emailAddress == null) {
			patientImpl.setEmailAddress("");
		}
		else {
			patientImpl.setEmailAddress(emailAddress);
		}

		patientImpl.setPhoneNo(phoneNo);

		if (dateOfBirth == Long.MIN_VALUE) {
			patientImpl.setDateOfBirth(null);
		}
		else {
			patientImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		if (admitDate == Long.MIN_VALUE) {
			patientImpl.setAdmitDate(null);
		}
		else {
			patientImpl.setAdmitDate(new Date(admitDate));
		}

		if (admitPayer == null) {
			patientImpl.setAdmitPayer("");
		}
		else {
			patientImpl.setAdmitPayer(admitPayer);
		}

		if (medicaidNeedDate == Long.MIN_VALUE) {
			patientImpl.setMedicaidNeedDate(null);
		}
		else {
			patientImpl.setMedicaidNeedDate(new Date(medicaidNeedDate));
		}

		patientImpl.setHaveMedicaid(haveMedicaid);
		patientImpl.setResidentLiabilityEmailSent(residentLiabilityEmailSent);

		if (address == null) {
			patientImpl.setAddress("");
		}
		else {
			patientImpl.setAddress(address);
		}

		if (city == null) {
			patientImpl.setCity("");
		}
		else {
			patientImpl.setCity(city);
		}

		if (state == null) {
			patientImpl.setState("");
		}
		else {
			patientImpl.setState(state);
		}

		if (zipCode == null) {
			patientImpl.setZipCode("");
		}
		else {
			patientImpl.setZipCode(zipCode);
		}

		if (documentIds == null) {
			patientImpl.setDocumentIds("");
		}
		else {
			patientImpl.setDocumentIds(documentIds);
		}

		if (referralId == null) {
			patientImpl.setReferralId("");
		}
		else {
			patientImpl.setReferralId(referralId);
		}

		if (facilityId == null) {
			patientImpl.setFacilityId("");
		}
		else {
			patientImpl.setFacilityId(facilityId);
		}

		if (createDate == Long.MIN_VALUE) {
			patientImpl.setCreateDate(null);
		}
		else {
			patientImpl.setCreateDate(new Date(createDate));
		}

		if (createdBy == null) {
			patientImpl.setCreatedBy("");
		}
		else {
			patientImpl.setCreatedBy(createdBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			patientImpl.setModifiedDate(null);
		}
		else {
			patientImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (modifiedBy == null) {
			patientImpl.setModifiedBy("");
		}
		else {
			patientImpl.setModifiedBy(modifiedBy);
		}

		patientImpl.resetOriginalValues();

		return patientImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		patientId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();

		phoneNo = objectInput.readLong();
		dateOfBirth = objectInput.readLong();
		admitDate = objectInput.readLong();
		admitPayer = objectInput.readUTF();
		medicaidNeedDate = objectInput.readLong();

		haveMedicaid = objectInput.readBoolean();

		residentLiabilityEmailSent = objectInput.readBoolean();
		address = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		zipCode = objectInput.readUTF();
		documentIds = objectInput.readUTF();
		referralId = objectInput.readUTF();
		facilityId = objectInput.readUTF();
		createDate = objectInput.readLong();
		createdBy = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(patientId);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeLong(phoneNo);
		objectOutput.writeLong(dateOfBirth);
		objectOutput.writeLong(admitDate);

		if (admitPayer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(admitPayer);
		}

		objectOutput.writeLong(medicaidNeedDate);

		objectOutput.writeBoolean(haveMedicaid);

		objectOutput.writeBoolean(residentLiabilityEmailSent);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (zipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zipCode);
		}

		if (documentIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentIds);
		}

		if (referralId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(referralId);
		}

		if (facilityId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(facilityId);
		}

		objectOutput.writeLong(createDate);

		if (createdBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		objectOutput.writeLong(modifiedDate);

		if (modifiedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modifiedBy);
		}
	}

	public long patientId;
	public String firstName;
	public String lastName;
	public String emailAddress;
	public long phoneNo;
	public long dateOfBirth;
	public long admitDate;
	public String admitPayer;
	public long medicaidNeedDate;
	public boolean haveMedicaid;
	public boolean residentLiabilityEmailSent;
	public String address;
	public String city;
	public String state;
	public String zipCode;
	public String documentIds;
	public String referralId;
	public String facilityId;
	public long createDate;
	public String createdBy;
	public long modifiedDate;
	public String modifiedBy;

}