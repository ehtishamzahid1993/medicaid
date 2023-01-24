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
 * This class is a wrapper for {@link FacilityAdmin}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacilityAdmin
 * @generated
 */
public class FacilityAdminWrapper
	extends BaseModelWrapper<FacilityAdmin>
	implements FacilityAdmin, ModelWrapper<FacilityAdmin> {

	public FacilityAdminWrapper(FacilityAdmin facilityAdmin) {
		super(facilityAdmin);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userName", getUserName());
		attributes.put("email", getEmail());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("title", getTitle());
		attributes.put("facilityIds", getFacilityIds());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		Long phoneNumber = (Long)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String facilityIds = (String)attributes.get("facilityIds");

		if (facilityIds != null) {
			setFacilityIds(facilityIds);
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
	 * Returns the create date of this facility admin.
	 *
	 * @return the create date of this facility admin
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this facility admin.
	 *
	 * @return the created by of this facility admin
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the email of this facility admin.
	 *
	 * @return the email of this facility admin
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the facility IDs of this facility admin.
	 *
	 * @return the facility IDs of this facility admin
	 */
	@Override
	public String getFacilityIds() {
		return model.getFacilityIds();
	}

	/**
	 * Returns the first name of this facility admin.
	 *
	 * @return the first name of this facility admin
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the last name of this facility admin.
	 *
	 * @return the last name of this facility admin
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the modified by of this facility admin.
	 *
	 * @return the modified by of this facility admin
	 */
	@Override
	public String getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this facility admin.
	 *
	 * @return the modified date of this facility admin
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the phone number of this facility admin.
	 *
	 * @return the phone number of this facility admin
	 */
	@Override
	public long getPhoneNumber() {
		return model.getPhoneNumber();
	}

	/**
	 * Returns the primary key of this facility admin.
	 *
	 * @return the primary key of this facility admin
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this facility admin.
	 *
	 * @return the title of this facility admin
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user name of this facility admin.
	 *
	 * @return the user name of this facility admin
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this facility admin.
	 *
	 * @param createDate the create date of this facility admin
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this facility admin.
	 *
	 * @param createdBy the created by of this facility admin
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the email of this facility admin.
	 *
	 * @param email the email of this facility admin
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the facility IDs of this facility admin.
	 *
	 * @param facilityIds the facility IDs of this facility admin
	 */
	@Override
	public void setFacilityIds(String facilityIds) {
		model.setFacilityIds(facilityIds);
	}

	/**
	 * Sets the first name of this facility admin.
	 *
	 * @param firstName the first name of this facility admin
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the last name of this facility admin.
	 *
	 * @param lastName the last name of this facility admin
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the modified by of this facility admin.
	 *
	 * @param modifiedBy the modified by of this facility admin
	 */
	@Override
	public void setModifiedBy(String modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this facility admin.
	 *
	 * @param modifiedDate the modified date of this facility admin
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the phone number of this facility admin.
	 *
	 * @param phoneNumber the phone number of this facility admin
	 */
	@Override
	public void setPhoneNumber(long phoneNumber) {
		model.setPhoneNumber(phoneNumber);
	}

	/**
	 * Sets the primary key of this facility admin.
	 *
	 * @param primaryKey the primary key of this facility admin
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this facility admin.
	 *
	 * @param title the title of this facility admin
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user name of this facility admin.
	 *
	 * @param userName the user name of this facility admin
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	@Override
	protected FacilityAdminWrapper wrap(FacilityAdmin facilityAdmin) {
		return new FacilityAdminWrapper(facilityAdmin);
	}

}