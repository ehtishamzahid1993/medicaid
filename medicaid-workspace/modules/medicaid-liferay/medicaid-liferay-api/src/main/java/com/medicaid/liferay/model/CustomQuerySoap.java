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

package com.medicaid.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.medicaid.liferay.service.http.CustomQueryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomQuerySoap implements Serializable {

	public static CustomQuerySoap toSoapModel(CustomQuery model) {
		CustomQuerySoap soapModel = new CustomQuerySoap();

		soapModel.setSqlKey(model.getSqlKey());
		soapModel.setSqlQuery(model.getSqlQuery());

		return soapModel;
	}

	public static CustomQuerySoap[] toSoapModels(CustomQuery[] models) {
		CustomQuerySoap[] soapModels = new CustomQuerySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CustomQuerySoap[][] toSoapModels(CustomQuery[][] models) {
		CustomQuerySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CustomQuerySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CustomQuerySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CustomQuerySoap[] toSoapModels(List<CustomQuery> models) {
		List<CustomQuerySoap> soapModels = new ArrayList<CustomQuerySoap>(
			models.size());

		for (CustomQuery model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CustomQuerySoap[soapModels.size()]);
	}

	public CustomQuerySoap() {
	}

	public String getPrimaryKey() {
		return _sqlKey;
	}

	public void setPrimaryKey(String pk) {
		setSqlKey(pk);
	}

	public String getSqlKey() {
		return _sqlKey;
	}

	public void setSqlKey(String sqlKey) {
		_sqlKey = sqlKey;
	}

	public String getSqlQuery() {
		return _sqlQuery;
	}

	public void setSqlQuery(String sqlQuery) {
		_sqlQuery = sqlQuery;
	}

	private String _sqlKey;
	private String _sqlQuery;

}