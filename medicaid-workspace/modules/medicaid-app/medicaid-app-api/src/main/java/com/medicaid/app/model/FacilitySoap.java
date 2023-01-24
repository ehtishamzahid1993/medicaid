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
 * This class is used by SOAP remote services, specifically {@link com.medicaid.app.service.http.FacilityServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FacilitySoap implements Serializable {

	public static FacilitySoap toSoapModel(Facility model) {
		FacilitySoap soapModel = new FacilitySoap();

		soapModel.setFacilityId(model.getFacilityId());
		soapModel.setName(model.getName());
		soapModel.setAddress(model.getAddress());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setZipcode(model.getZipcode());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setFaxNumber(model.getFaxNumber());
		soapModel.setEmail(model.getEmail());
		soapModel.setPointOfContact(model.getPointOfContact());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static FacilitySoap[] toSoapModels(Facility[] models) {
		FacilitySoap[] soapModels = new FacilitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FacilitySoap[][] toSoapModels(Facility[][] models) {
		FacilitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FacilitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new FacilitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FacilitySoap[] toSoapModels(List<Facility> models) {
		List<FacilitySoap> soapModels = new ArrayList<FacilitySoap>(
			models.size());

		for (Facility model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FacilitySoap[soapModels.size()]);
	}

	public FacilitySoap() {
	}

	public long getPrimaryKey() {
		return _facilityId;
	}

	public void setPrimaryKey(long pk) {
		setFacilityId(pk);
	}

	public long getFacilityId() {
		return _facilityId;
	}

	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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

	public String getZipcode() {
		return _zipcode;
	}

	public void setZipcode(String zipcode) {
		_zipcode = zipcode;
	}

	public long getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getFaxNumber() {
		return _faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		_faxNumber = faxNumber;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPointOfContact() {
		return _pointOfContact;
	}

	public void setPointOfContact(String pointOfContact) {
		_pointOfContact = pointOfContact;
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

	private long _facilityId;
	private String _name;
	private String _address;
	private String _city;
	private String _state;
	private String _zipcode;
	private long _phoneNumber;
	private String _faxNumber;
	private String _email;
	private String _pointOfContact;
	private Date _createDate;
	private String _createdBy;
	private Date _modifiedDate;
	private String _modifiedBy;

}