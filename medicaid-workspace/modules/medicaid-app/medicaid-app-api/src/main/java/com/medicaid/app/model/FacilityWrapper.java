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
 * This class is a wrapper for {@link Facility}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Facility
 * @generated
 */
public class FacilityWrapper
	extends BaseModelWrapper<Facility>
	implements Facility, ModelWrapper<Facility> {

	public FacilityWrapper(Facility facility) {
		super(facility);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("facilityId", getFacilityId());
		attributes.put("name", getName());
		attributes.put("address", getAddress());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("zipcode", getZipcode());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("faxNumber", getFaxNumber());
		attributes.put("email", getEmail());
		attributes.put("pointOfContact", getPointOfContact());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
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

		String zipcode = (String)attributes.get("zipcode");

		if (zipcode != null) {
			setZipcode(zipcode);
		}

		Long phoneNumber = (Long)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String faxNumber = (String)attributes.get("faxNumber");

		if (faxNumber != null) {
			setFaxNumber(faxNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String pointOfContact = (String)attributes.get("pointOfContact");

		if (pointOfContact != null) {
			setPointOfContact(pointOfContact);
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
	 * Returns the address of this facility.
	 *
	 * @return the address of this facility
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the city of this facility.
	 *
	 * @return the city of this facility
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the create date of this facility.
	 *
	 * @return the create date of this facility
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this facility.
	 *
	 * @return the created by of this facility
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the email of this facility.
	 *
	 * @return the email of this facility
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the facility ID of this facility.
	 *
	 * @return the facility ID of this facility
	 */
	@Override
	public long getFacilityId() {
		return model.getFacilityId();
	}

	/**
	 * Returns the fax number of this facility.
	 *
	 * @return the fax number of this facility
	 */
	@Override
	public String getFaxNumber() {
		return model.getFaxNumber();
	}

	/**
	 * Returns the modified by of this facility.
	 *
	 * @return the modified by of this facility
	 */
	@Override
	public String getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this facility.
	 *
	 * @return the modified date of this facility
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this facility.
	 *
	 * @return the name of this facility
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the phone number of this facility.
	 *
	 * @return the phone number of this facility
	 */
	@Override
	public long getPhoneNumber() {
		return model.getPhoneNumber();
	}

	/**
	 * Returns the point of contact of this facility.
	 *
	 * @return the point of contact of this facility
	 */
	@Override
	public String getPointOfContact() {
		return model.getPointOfContact();
	}

	/**
	 * Returns the primary key of this facility.
	 *
	 * @return the primary key of this facility
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state of this facility.
	 *
	 * @return the state of this facility
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the zipcode of this facility.
	 *
	 * @return the zipcode of this facility
	 */
	@Override
	public String getZipcode() {
		return model.getZipcode();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this facility.
	 *
	 * @param address the address of this facility
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the city of this facility.
	 *
	 * @param city the city of this facility
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the create date of this facility.
	 *
	 * @param createDate the create date of this facility
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this facility.
	 *
	 * @param createdBy the created by of this facility
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the email of this facility.
	 *
	 * @param email the email of this facility
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the facility ID of this facility.
	 *
	 * @param facilityId the facility ID of this facility
	 */
	@Override
	public void setFacilityId(long facilityId) {
		model.setFacilityId(facilityId);
	}

	/**
	 * Sets the fax number of this facility.
	 *
	 * @param faxNumber the fax number of this facility
	 */
	@Override
	public void setFaxNumber(String faxNumber) {
		model.setFaxNumber(faxNumber);
	}

	/**
	 * Sets the modified by of this facility.
	 *
	 * @param modifiedBy the modified by of this facility
	 */
	@Override
	public void setModifiedBy(String modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this facility.
	 *
	 * @param modifiedDate the modified date of this facility
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this facility.
	 *
	 * @param name the name of this facility
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the phone number of this facility.
	 *
	 * @param phoneNumber the phone number of this facility
	 */
	@Override
	public void setPhoneNumber(long phoneNumber) {
		model.setPhoneNumber(phoneNumber);
	}

	/**
	 * Sets the point of contact of this facility.
	 *
	 * @param pointOfContact the point of contact of this facility
	 */
	@Override
	public void setPointOfContact(String pointOfContact) {
		model.setPointOfContact(pointOfContact);
	}

	/**
	 * Sets the primary key of this facility.
	 *
	 * @param primaryKey the primary key of this facility
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state of this facility.
	 *
	 * @param state the state of this facility
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the zipcode of this facility.
	 *
	 * @param zipcode the zipcode of this facility
	 */
	@Override
	public void setZipcode(String zipcode) {
		model.setZipcode(zipcode);
	}

	@Override
	protected FacilityWrapper wrap(Facility facility) {
		return new FacilityWrapper(facility);
	}

}