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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CustomQuery}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomQuery
 * @generated
 */
public class CustomQueryWrapper
	extends BaseModelWrapper<CustomQuery>
	implements CustomQuery, ModelWrapper<CustomQuery> {

	public CustomQueryWrapper(CustomQuery customQuery) {
		super(customQuery);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sqlKey", getSqlKey());
		attributes.put("sqlQuery", getSqlQuery());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String sqlKey = (String)attributes.get("sqlKey");

		if (sqlKey != null) {
			setSqlKey(sqlKey);
		}

		String sqlQuery = (String)attributes.get("sqlQuery");

		if (sqlQuery != null) {
			setSqlQuery(sqlQuery);
		}
	}

	/**
	 * Returns the primary key of this custom query.
	 *
	 * @return the primary key of this custom query
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sql key of this custom query.
	 *
	 * @return the sql key of this custom query
	 */
	@Override
	public String getSqlKey() {
		return model.getSqlKey();
	}

	/**
	 * Returns the sql query of this custom query.
	 *
	 * @return the sql query of this custom query
	 */
	@Override
	public String getSqlQuery() {
		return model.getSqlQuery();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this custom query.
	 *
	 * @param primaryKey the primary key of this custom query
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sql key of this custom query.
	 *
	 * @param sqlKey the sql key of this custom query
	 */
	@Override
	public void setSqlKey(String sqlKey) {
		model.setSqlKey(sqlKey);
	}

	/**
	 * Sets the sql query of this custom query.
	 *
	 * @param sqlQuery the sql query of this custom query
	 */
	@Override
	public void setSqlQuery(String sqlQuery) {
		model.setSqlQuery(sqlQuery);
	}

	@Override
	protected CustomQueryWrapper wrap(CustomQuery customQuery) {
		return new CustomQueryWrapper(customQuery);
	}

}