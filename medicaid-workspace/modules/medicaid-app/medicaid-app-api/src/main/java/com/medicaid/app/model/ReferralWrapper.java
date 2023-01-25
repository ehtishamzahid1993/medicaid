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
 * This class is a wrapper for {@link Referral}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Referral
 * @generated
 */
public class ReferralWrapper
	extends BaseModelWrapper<Referral>
	implements ModelWrapper<Referral>, Referral {

	public ReferralWrapper(Referral referral) {
		super(referral);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("referralId", getReferralId());
		attributes.put("dateReferred", getDateReferred());
		attributes.put("submitDate", getSubmitDate());
		attributes.put("approvedDate", getApprovedDate());
		attributes.put("pendingDate", getPendingDate());
		attributes.put("status", getStatus());
		attributes.put("cocEmailSent", getCocEmailSent());
		attributes.put("resLiability", getResLiability());
		attributes.put("emailSentDueDate", getEmailSentDueDate());
		attributes.put("facilityAdmin", getFacilityAdmin());
		attributes.put("facilities", getFacilities());
		attributes.put("patientId", getPatientId());
		attributes.put("noteId", getNoteId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long referralId = (Long)attributes.get("referralId");

		if (referralId != null) {
			setReferralId(referralId);
		}

		Date dateReferred = (Date)attributes.get("dateReferred");

		if (dateReferred != null) {
			setDateReferred(dateReferred);
		}

		Date submitDate = (Date)attributes.get("submitDate");

		if (submitDate != null) {
			setSubmitDate(submitDate);
		}

		Date approvedDate = (Date)attributes.get("approvedDate");

		if (approvedDate != null) {
			setApprovedDate(approvedDate);
		}

		Date pendingDate = (Date)attributes.get("pendingDate");

		if (pendingDate != null) {
			setPendingDate(pendingDate);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String cocEmailSent = (String)attributes.get("cocEmailSent");

		if (cocEmailSent != null) {
			setCocEmailSent(cocEmailSent);
		}

		Double resLiability = (Double)attributes.get("resLiability");

		if (resLiability != null) {
			setResLiability(resLiability);
		}

		Date emailSentDueDate = (Date)attributes.get("emailSentDueDate");

		if (emailSentDueDate != null) {
			setEmailSentDueDate(emailSentDueDate);
		}

		String facilityAdmin = (String)attributes.get("facilityAdmin");

		if (facilityAdmin != null) {
			setFacilityAdmin(facilityAdmin);
		}

		String facilities = (String)attributes.get("facilities");

		if (facilities != null) {
			setFacilities(facilities);
		}

		Long patientId = (Long)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
		}

		Long noteId = (Long)attributes.get("noteId");

		if (noteId != null) {
			setNoteId(noteId);
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
	 * Returns the approved date of this referral.
	 *
	 * @return the approved date of this referral
	 */
	@Override
	public Date getApprovedDate() {
		return model.getApprovedDate();
	}

	/**
	 * Returns the coc email sent of this referral.
	 *
	 * @return the coc email sent of this referral
	 */
	@Override
	public String getCocEmailSent() {
		return model.getCocEmailSent();
	}

	/**
	 * Returns the create date of this referral.
	 *
	 * @return the create date of this referral
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this referral.
	 *
	 * @return the created by of this referral
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the date referred of this referral.
	 *
	 * @return the date referred of this referral
	 */
	@Override
	public Date getDateReferred() {
		return model.getDateReferred();
	}

	/**
	 * Returns the email sent due date of this referral.
	 *
	 * @return the email sent due date of this referral
	 */
	@Override
	public Date getEmailSentDueDate() {
		return model.getEmailSentDueDate();
	}

	/**
	 * Returns the facilities of this referral.
	 *
	 * @return the facilities of this referral
	 */
	@Override
	public String getFacilities() {
		return model.getFacilities();
	}

	/**
	 * Returns the facility admin of this referral.
	 *
	 * @return the facility admin of this referral
	 */
	@Override
	public String getFacilityAdmin() {
		return model.getFacilityAdmin();
	}

	/**
	 * Returns the modified by of this referral.
	 *
	 * @return the modified by of this referral
	 */
	@Override
	public String getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this referral.
	 *
	 * @return the modified date of this referral
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the note ID of this referral.
	 *
	 * @return the note ID of this referral
	 */
	@Override
	public long getNoteId() {
		return model.getNoteId();
	}

	/**
	 * Returns the patient ID of this referral.
	 *
	 * @return the patient ID of this referral
	 */
	@Override
	public long getPatientId() {
		return model.getPatientId();
	}

	/**
	 * Returns the pending date of this referral.
	 *
	 * @return the pending date of this referral
	 */
	@Override
	public Date getPendingDate() {
		return model.getPendingDate();
	}

	/**
	 * Returns the primary key of this referral.
	 *
	 * @return the primary key of this referral
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the referral ID of this referral.
	 *
	 * @return the referral ID of this referral
	 */
	@Override
	public long getReferralId() {
		return model.getReferralId();
	}

	/**
	 * Returns the res liability of this referral.
	 *
	 * @return the res liability of this referral
	 */
	@Override
	public double getResLiability() {
		return model.getResLiability();
	}

	/**
	 * Returns the status of this referral.
	 *
	 * @return the status of this referral
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the submit date of this referral.
	 *
	 * @return the submit date of this referral
	 */
	@Override
	public Date getSubmitDate() {
		return model.getSubmitDate();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the approved date of this referral.
	 *
	 * @param approvedDate the approved date of this referral
	 */
	@Override
	public void setApprovedDate(Date approvedDate) {
		model.setApprovedDate(approvedDate);
	}

	/**
	 * Sets the coc email sent of this referral.
	 *
	 * @param cocEmailSent the coc email sent of this referral
	 */
	@Override
	public void setCocEmailSent(String cocEmailSent) {
		model.setCocEmailSent(cocEmailSent);
	}

	/**
	 * Sets the create date of this referral.
	 *
	 * @param createDate the create date of this referral
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this referral.
	 *
	 * @param createdBy the created by of this referral
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the date referred of this referral.
	 *
	 * @param dateReferred the date referred of this referral
	 */
	@Override
	public void setDateReferred(Date dateReferred) {
		model.setDateReferred(dateReferred);
	}

	/**
	 * Sets the email sent due date of this referral.
	 *
	 * @param emailSentDueDate the email sent due date of this referral
	 */
	@Override
	public void setEmailSentDueDate(Date emailSentDueDate) {
		model.setEmailSentDueDate(emailSentDueDate);
	}

	/**
	 * Sets the facilities of this referral.
	 *
	 * @param facilities the facilities of this referral
	 */
	@Override
	public void setFacilities(String facilities) {
		model.setFacilities(facilities);
	}

	/**
	 * Sets the facility admin of this referral.
	 *
	 * @param facilityAdmin the facility admin of this referral
	 */
	@Override
	public void setFacilityAdmin(String facilityAdmin) {
		model.setFacilityAdmin(facilityAdmin);
	}

	/**
	 * Sets the modified by of this referral.
	 *
	 * @param modifiedBy the modified by of this referral
	 */
	@Override
	public void setModifiedBy(String modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this referral.
	 *
	 * @param modifiedDate the modified date of this referral
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the note ID of this referral.
	 *
	 * @param noteId the note ID of this referral
	 */
	@Override
	public void setNoteId(long noteId) {
		model.setNoteId(noteId);
	}

	/**
	 * Sets the patient ID of this referral.
	 *
	 * @param patientId the patient ID of this referral
	 */
	@Override
	public void setPatientId(long patientId) {
		model.setPatientId(patientId);
	}

	/**
	 * Sets the pending date of this referral.
	 *
	 * @param pendingDate the pending date of this referral
	 */
	@Override
	public void setPendingDate(Date pendingDate) {
		model.setPendingDate(pendingDate);
	}

	/**
	 * Sets the primary key of this referral.
	 *
	 * @param primaryKey the primary key of this referral
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the referral ID of this referral.
	 *
	 * @param referralId the referral ID of this referral
	 */
	@Override
	public void setReferralId(long referralId) {
		model.setReferralId(referralId);
	}

	/**
	 * Sets the res liability of this referral.
	 *
	 * @param resLiability the res liability of this referral
	 */
	@Override
	public void setResLiability(double resLiability) {
		model.setResLiability(resLiability);
	}

	/**
	 * Sets the status of this referral.
	 *
	 * @param status the status of this referral
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the submit date of this referral.
	 *
	 * @param submitDate the submit date of this referral
	 */
	@Override
	public void setSubmitDate(Date submitDate) {
		model.setSubmitDate(submitDate);
	}

	@Override
	protected ReferralWrapper wrap(Referral referral) {
		return new ReferralWrapper(referral);
	}

}