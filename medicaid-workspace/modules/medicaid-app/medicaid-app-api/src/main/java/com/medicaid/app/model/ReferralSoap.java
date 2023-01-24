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
 * This class is used by SOAP remote services, specifically {@link com.medicaid.app.service.http.ReferralServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ReferralSoap implements Serializable {

	public static ReferralSoap toSoapModel(Referral model) {
		ReferralSoap soapModel = new ReferralSoap();

		soapModel.setReferralId(model.getReferralId());
		soapModel.setDateReferred(model.getDateReferred());
		soapModel.setSubmitDate(model.getSubmitDate());
		soapModel.setApprovedDate(model.getApprovedDate());
		soapModel.setPendingDate(model.getPendingDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setCocEmailSent(model.getCocEmailSent());
		soapModel.setResLiability(model.getResLiability());
		soapModel.setEmailSentDueDate(model.getEmailSentDueDate());
		soapModel.setFacilityAdmin(model.getFacilityAdmin());
		soapModel.setFacilities(model.getFacilities());
		soapModel.setPatientId(model.getPatientId());
		soapModel.setNoteId(model.getNoteId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static ReferralSoap[] toSoapModels(Referral[] models) {
		ReferralSoap[] soapModels = new ReferralSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReferralSoap[][] toSoapModels(Referral[][] models) {
		ReferralSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ReferralSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReferralSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReferralSoap[] toSoapModels(List<Referral> models) {
		List<ReferralSoap> soapModels = new ArrayList<ReferralSoap>(
			models.size());

		for (Referral model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReferralSoap[soapModels.size()]);
	}

	public ReferralSoap() {
	}

	public long getPrimaryKey() {
		return _referralId;
	}

	public void setPrimaryKey(long pk) {
		setReferralId(pk);
	}

	public long getReferralId() {
		return _referralId;
	}

	public void setReferralId(long referralId) {
		_referralId = referralId;
	}

	public Date getDateReferred() {
		return _dateReferred;
	}

	public void setDateReferred(Date dateReferred) {
		_dateReferred = dateReferred;
	}

	public Date getSubmitDate() {
		return _submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		_submitDate = submitDate;
	}

	public Date getApprovedDate() {
		return _approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		_approvedDate = approvedDate;
	}

	public Date getPendingDate() {
		return _pendingDate;
	}

	public void setPendingDate(Date pendingDate) {
		_pendingDate = pendingDate;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getCocEmailSent() {
		return _cocEmailSent;
	}

	public void setCocEmailSent(String cocEmailSent) {
		_cocEmailSent = cocEmailSent;
	}

	public String getResLiability() {
		return _resLiability;
	}

	public void setResLiability(String resLiability) {
		_resLiability = resLiability;
	}

	public Date getEmailSentDueDate() {
		return _emailSentDueDate;
	}

	public void setEmailSentDueDate(Date emailSentDueDate) {
		_emailSentDueDate = emailSentDueDate;
	}

	public String getFacilityAdmin() {
		return _facilityAdmin;
	}

	public void setFacilityAdmin(String facilityAdmin) {
		_facilityAdmin = facilityAdmin;
	}

	public String getFacilities() {
		return _facilities;
	}

	public void setFacilities(String facilities) {
		_facilities = facilities;
	}

	public long getPatientId() {
		return _patientId;
	}

	public void setPatientId(long patientId) {
		_patientId = patientId;
	}

	public long getNoteId() {
		return _noteId;
	}

	public void setNoteId(long noteId) {
		_noteId = noteId;
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

	private long _referralId;
	private Date _dateReferred;
	private Date _submitDate;
	private Date _approvedDate;
	private Date _pendingDate;
	private String _status;
	private String _cocEmailSent;
	private String _resLiability;
	private Date _emailSentDueDate;
	private String _facilityAdmin;
	private String _facilities;
	private long _patientId;
	private long _noteId;
	private Date _createDate;
	private String _createdBy;
	private Date _modifiedDate;
	private String _modifiedBy;

}