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

import com.medicaid.app.model.Referral;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Referral in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ReferralCacheModel
	implements CacheModel<Referral>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReferralCacheModel)) {
			return false;
		}

		ReferralCacheModel referralCacheModel = (ReferralCacheModel)obj;

		if (referralId == referralCacheModel.referralId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, referralId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{referralId=");
		sb.append(referralId);
		sb.append(", dateReferred=");
		sb.append(dateReferred);
		sb.append(", submitDate=");
		sb.append(submitDate);
		sb.append(", approvedDate=");
		sb.append(approvedDate);
		sb.append(", pendingDate=");
		sb.append(pendingDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", cocEmailSent=");
		sb.append(cocEmailSent);
		sb.append(", resLiability=");
		sb.append(resLiability);
		sb.append(", emailSentDueDate=");
		sb.append(emailSentDueDate);
		sb.append(", facilityAdmin=");
		sb.append(facilityAdmin);
		sb.append(", facilities=");
		sb.append(facilities);
		sb.append(", patientId=");
		sb.append(patientId);
		sb.append(", noteId=");
		sb.append(noteId);
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
	public Referral toEntityModel() {
		ReferralImpl referralImpl = new ReferralImpl();

		referralImpl.setReferralId(referralId);

		if (dateReferred == Long.MIN_VALUE) {
			referralImpl.setDateReferred(null);
		}
		else {
			referralImpl.setDateReferred(new Date(dateReferred));
		}

		if (submitDate == Long.MIN_VALUE) {
			referralImpl.setSubmitDate(null);
		}
		else {
			referralImpl.setSubmitDate(new Date(submitDate));
		}

		if (approvedDate == Long.MIN_VALUE) {
			referralImpl.setApprovedDate(null);
		}
		else {
			referralImpl.setApprovedDate(new Date(approvedDate));
		}

		if (pendingDate == Long.MIN_VALUE) {
			referralImpl.setPendingDate(null);
		}
		else {
			referralImpl.setPendingDate(new Date(pendingDate));
		}

		if (status == null) {
			referralImpl.setStatus("");
		}
		else {
			referralImpl.setStatus(status);
		}

		if (cocEmailSent == null) {
			referralImpl.setCocEmailSent("");
		}
		else {
			referralImpl.setCocEmailSent(cocEmailSent);
		}

		referralImpl.setResLiability(resLiability);

		if (emailSentDueDate == Long.MIN_VALUE) {
			referralImpl.setEmailSentDueDate(null);
		}
		else {
			referralImpl.setEmailSentDueDate(new Date(emailSentDueDate));
		}

		if (facilityAdmin == null) {
			referralImpl.setFacilityAdmin("");
		}
		else {
			referralImpl.setFacilityAdmin(facilityAdmin);
		}

		if (facilities == null) {
			referralImpl.setFacilities("");
		}
		else {
			referralImpl.setFacilities(facilities);
		}

		referralImpl.setPatientId(patientId);
		referralImpl.setNoteId(noteId);

		if (createDate == Long.MIN_VALUE) {
			referralImpl.setCreateDate(null);
		}
		else {
			referralImpl.setCreateDate(new Date(createDate));
		}

		if (createdBy == null) {
			referralImpl.setCreatedBy("");
		}
		else {
			referralImpl.setCreatedBy(createdBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			referralImpl.setModifiedDate(null);
		}
		else {
			referralImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (modifiedBy == null) {
			referralImpl.setModifiedBy("");
		}
		else {
			referralImpl.setModifiedBy(modifiedBy);
		}

		referralImpl.resetOriginalValues();

		return referralImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		referralId = objectInput.readLong();
		dateReferred = objectInput.readLong();
		submitDate = objectInput.readLong();
		approvedDate = objectInput.readLong();
		pendingDate = objectInput.readLong();
		status = objectInput.readUTF();
		cocEmailSent = objectInput.readUTF();

		resLiability = objectInput.readDouble();
		emailSentDueDate = objectInput.readLong();
		facilityAdmin = objectInput.readUTF();
		facilities = objectInput.readUTF();

		patientId = objectInput.readLong();

		noteId = objectInput.readLong();
		createDate = objectInput.readLong();
		createdBy = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(referralId);
		objectOutput.writeLong(dateReferred);
		objectOutput.writeLong(submitDate);
		objectOutput.writeLong(approvedDate);
		objectOutput.writeLong(pendingDate);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (cocEmailSent == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cocEmailSent);
		}

		objectOutput.writeDouble(resLiability);
		objectOutput.writeLong(emailSentDueDate);

		if (facilityAdmin == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(facilityAdmin);
		}

		if (facilities == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(facilities);
		}

		objectOutput.writeLong(patientId);

		objectOutput.writeLong(noteId);
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

	public long referralId;
	public long dateReferred;
	public long submitDate;
	public long approvedDate;
	public long pendingDate;
	public String status;
	public String cocEmailSent;
	public double resLiability;
	public long emailSentDueDate;
	public String facilityAdmin;
	public String facilities;
	public long patientId;
	public long noteId;
	public long createDate;
	public String createdBy;
	public long modifiedDate;
	public String modifiedBy;

}