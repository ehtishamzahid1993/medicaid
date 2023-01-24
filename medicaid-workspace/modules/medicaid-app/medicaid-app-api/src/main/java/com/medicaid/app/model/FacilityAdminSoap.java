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
 * This class is used by SOAP remote services, specifically {@link com.medicaid.app.service.http.FacilityAdminServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FacilityAdminSoap implements Serializable {

	public static FacilityAdminSoap toSoapModel(FacilityAdmin model) {
		FacilityAdminSoap soapModel = new FacilityAdminSoap();

		soapModel.setUserName(model.getUserName());
		soapModel.setEmail(model.getEmail());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setTitle(model.getTitle());
		soapModel.setFacilityIds(model.getFacilityIds());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static FacilityAdminSoap[] toSoapModels(FacilityAdmin[] models) {
		FacilityAdminSoap[] soapModels = new FacilityAdminSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FacilityAdminSoap[][] toSoapModels(FacilityAdmin[][] models) {
		FacilityAdminSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FacilityAdminSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FacilityAdminSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FacilityAdminSoap[] toSoapModels(List<FacilityAdmin> models) {
		List<FacilityAdminSoap> soapModels = new ArrayList<FacilityAdminSoap>(
			models.size());

		for (FacilityAdmin model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FacilityAdminSoap[soapModels.size()]);
	}

	public FacilityAdminSoap() {
	}

	public String getPrimaryKey() {
		return _userName;
	}

	public void setPrimaryKey(String pk) {
		setUserName(pk);
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
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

	public long getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getFacilityIds() {
		return _facilityIds;
	}

	public void setFacilityIds(String facilityIds) {
		_facilityIds = facilityIds;
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

	private String _userName;
	private String _email;
	private String _firstName;
	private String _lastName;
	private long _phoneNumber;
	private String _title;
	private String _facilityIds;
	private Date _createDate;
	private String _createdBy;
	private Date _modifiedDate;
	private String _modifiedBy;

}