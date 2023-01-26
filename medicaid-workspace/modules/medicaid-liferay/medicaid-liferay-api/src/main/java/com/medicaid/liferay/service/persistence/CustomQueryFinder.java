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

package com.medicaid.liferay.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface CustomQueryFinder {

	public java.util.List<Object[]> getCustomQueryList(
		String sqlQuery, Object[] params);

	public java.util.List<Integer> getCustomCount(
		String sqlQuery, Object[] params);

	public java.util.List<java.math.BigInteger> getCustomLongList(
		String sqlQuery, Object[] params);

	public java.util.List<String> getCustomScalarValue(
		String sqlQuery, Object[] params);

	public void findCustomDeleteWithParam(String sqlQuery, Object[] params);

}