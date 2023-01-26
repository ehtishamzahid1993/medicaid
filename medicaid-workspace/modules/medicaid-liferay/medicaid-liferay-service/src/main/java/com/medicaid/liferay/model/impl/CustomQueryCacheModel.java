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

package com.medicaid.liferay.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.medicaid.liferay.model.CustomQuery;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CustomQuery in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomQueryCacheModel
	implements CacheModel<CustomQuery>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomQueryCacheModel)) {
			return false;
		}

		CustomQueryCacheModel customQueryCacheModel =
			(CustomQueryCacheModel)obj;

		if (sqlKey.equals(customQueryCacheModel.sqlKey)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sqlKey);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{sqlKey=");
		sb.append(sqlKey);
		sb.append(", sqlQuery=");
		sb.append(sqlQuery);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CustomQuery toEntityModel() {
		CustomQueryImpl customQueryImpl = new CustomQueryImpl();

		if (sqlKey == null) {
			customQueryImpl.setSqlKey("");
		}
		else {
			customQueryImpl.setSqlKey(sqlKey);
		}

		if (sqlQuery == null) {
			customQueryImpl.setSqlQuery("");
		}
		else {
			customQueryImpl.setSqlQuery(sqlQuery);
		}

		customQueryImpl.resetOriginalValues();

		return customQueryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sqlKey = objectInput.readUTF();
		sqlQuery = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (sqlKey == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sqlKey);
		}

		if (sqlQuery == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sqlQuery);
		}
	}

	public String sqlKey;
	public String sqlQuery;

}