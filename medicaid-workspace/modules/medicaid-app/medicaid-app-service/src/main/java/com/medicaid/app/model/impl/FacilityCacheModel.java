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

import com.medicaid.app.model.Facility;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Facility in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FacilityCacheModel
	implements CacheModel<Facility>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FacilityCacheModel)) {
			return false;
		}

		FacilityCacheModel facilityCacheModel = (FacilityCacheModel)obj;

		if (facilityId == facilityCacheModel.facilityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, facilityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{facilityId=");
		sb.append(facilityId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", address=");
		sb.append(address);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", zipcode=");
		sb.append(zipcode);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", faxNumber=");
		sb.append(faxNumber);
		sb.append(", email=");
		sb.append(email);
		sb.append(", pointOfContact=");
		sb.append(pointOfContact);
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
	public Facility toEntityModel() {
		FacilityImpl facilityImpl = new FacilityImpl();

		facilityImpl.setFacilityId(facilityId);

		if (name == null) {
			facilityImpl.setName("");
		}
		else {
			facilityImpl.setName(name);
		}

		if (address == null) {
			facilityImpl.setAddress("");
		}
		else {
			facilityImpl.setAddress(address);
		}

		if (city == null) {
			facilityImpl.setCity("");
		}
		else {
			facilityImpl.setCity(city);
		}

		if (state == null) {
			facilityImpl.setState("");
		}
		else {
			facilityImpl.setState(state);
		}

		if (zipcode == null) {
			facilityImpl.setZipcode("");
		}
		else {
			facilityImpl.setZipcode(zipcode);
		}

		facilityImpl.setPhoneNumber(phoneNumber);

		if (faxNumber == null) {
			facilityImpl.setFaxNumber("");
		}
		else {
			facilityImpl.setFaxNumber(faxNumber);
		}

		if (email == null) {
			facilityImpl.setEmail("");
		}
		else {
			facilityImpl.setEmail(email);
		}

		if (pointOfContact == null) {
			facilityImpl.setPointOfContact("");
		}
		else {
			facilityImpl.setPointOfContact(pointOfContact);
		}

		if (createDate == Long.MIN_VALUE) {
			facilityImpl.setCreateDate(null);
		}
		else {
			facilityImpl.setCreateDate(new Date(createDate));
		}

		if (createdBy == null) {
			facilityImpl.setCreatedBy("");
		}
		else {
			facilityImpl.setCreatedBy(createdBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			facilityImpl.setModifiedDate(null);
		}
		else {
			facilityImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (modifiedBy == null) {
			facilityImpl.setModifiedBy("");
		}
		else {
			facilityImpl.setModifiedBy(modifiedBy);
		}

		facilityImpl.resetOriginalValues();

		return facilityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		facilityId = objectInput.readLong();
		name = objectInput.readUTF();
		address = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		zipcode = objectInput.readUTF();

		phoneNumber = objectInput.readLong();
		faxNumber = objectInput.readUTF();
		email = objectInput.readUTF();
		pointOfContact = objectInput.readUTF();
		createDate = objectInput.readLong();
		createdBy = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(facilityId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

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

		if (zipcode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zipcode);
		}

		objectOutput.writeLong(phoneNumber);

		if (faxNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(faxNumber);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (pointOfContact == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pointOfContact);
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

	public long facilityId;
	public String name;
	public String address;
	public String city;
	public String state;
	public String zipcode;
	public long phoneNumber;
	public String faxNumber;
	public String email;
	public String pointOfContact;
	public long createDate;
	public String createdBy;
	public long modifiedDate;
	public String modifiedBy;

}