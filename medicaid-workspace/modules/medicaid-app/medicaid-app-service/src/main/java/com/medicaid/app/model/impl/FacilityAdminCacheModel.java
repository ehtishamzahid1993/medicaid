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

import com.medicaid.app.model.FacilityAdmin;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FacilityAdmin in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FacilityAdminCacheModel
	implements CacheModel<FacilityAdmin>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FacilityAdminCacheModel)) {
			return false;
		}

		FacilityAdminCacheModel facilityAdminCacheModel =
			(FacilityAdminCacheModel)obj;

		if (userName.equals(facilityAdminCacheModel.userName)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userName);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{userName=");
		sb.append(userName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", title=");
		sb.append(title);
		sb.append(", facilityIds=");
		sb.append(facilityIds);
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
	public FacilityAdmin toEntityModel() {
		FacilityAdminImpl facilityAdminImpl = new FacilityAdminImpl();

		if (userName == null) {
			facilityAdminImpl.setUserName("");
		}
		else {
			facilityAdminImpl.setUserName(userName);
		}

		if (email == null) {
			facilityAdminImpl.setEmail("");
		}
		else {
			facilityAdminImpl.setEmail(email);
		}

		if (firstName == null) {
			facilityAdminImpl.setFirstName("");
		}
		else {
			facilityAdminImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			facilityAdminImpl.setLastName("");
		}
		else {
			facilityAdminImpl.setLastName(lastName);
		}

		facilityAdminImpl.setPhoneNumber(phoneNumber);

		if (title == null) {
			facilityAdminImpl.setTitle("");
		}
		else {
			facilityAdminImpl.setTitle(title);
		}

		if (facilityIds == null) {
			facilityAdminImpl.setFacilityIds("");
		}
		else {
			facilityAdminImpl.setFacilityIds(facilityIds);
		}

		if (createDate == Long.MIN_VALUE) {
			facilityAdminImpl.setCreateDate(null);
		}
		else {
			facilityAdminImpl.setCreateDate(new Date(createDate));
		}

		if (createdBy == null) {
			facilityAdminImpl.setCreatedBy("");
		}
		else {
			facilityAdminImpl.setCreatedBy(createdBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			facilityAdminImpl.setModifiedDate(null);
		}
		else {
			facilityAdminImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (modifiedBy == null) {
			facilityAdminImpl.setModifiedBy("");
		}
		else {
			facilityAdminImpl.setModifiedBy(modifiedBy);
		}

		facilityAdminImpl.resetOriginalValues();

		return facilityAdminImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userName = objectInput.readUTF();
		email = objectInput.readUTF();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();

		phoneNumber = objectInput.readLong();
		title = objectInput.readUTF();
		facilityIds = objectInput.readUTF();
		createDate = objectInput.readLong();
		createdBy = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

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

		objectOutput.writeLong(phoneNumber);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (facilityIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(facilityIds);
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

	public String userName;
	public String email;
	public String firstName;
	public String lastName;
	public long phoneNumber;
	public String title;
	public String facilityIds;
	public long createDate;
	public String createdBy;
	public long modifiedDate;
	public String modifiedBy;

}