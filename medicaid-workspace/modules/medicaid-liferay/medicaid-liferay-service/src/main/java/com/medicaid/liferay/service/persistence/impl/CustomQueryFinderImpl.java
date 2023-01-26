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

package com.medicaid.liferay.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.medicaid.liferay.service.persistence.CustomQueryFinder;
import com.medicaid.liferay.service.persistence.CustomQueryPersistence;
import com.medicaid.liferay.util.FormattingUtil;

import java.math.BigInteger;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The persistence implementation for the custom query service.
 *
 * <p>
 * Caching information and settings can be found in
 * <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomQueryPersistence
 * @see com.dps.gigkw.db.service.persistence.CustomQueryUtil
 * @generated
 */
@Component(immediate = true)
public class CustomQueryFinderImpl extends CustomQueryFinderBaseImpl implements CustomQueryFinder {

	Log log = LogFactoryUtil.getLog(CustomQueryFinderImpl.class);

	public List<Object[]> getCustomQueryList(String sqlQuery, Object[] params) {
		Session session = null;
		try {
			//log.info("Sql:" + sqlQuery);
			session = openSession();
			SQLQuery queryObject = session.createSQLQuery(sqlQuery);
			queryObject.setCacheable(true);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			if (params != null) {
				for (Object param : params) {
					if (param != null)
						qPos.add(param);
				}
			}
			List<Object[]> result = queryObject.list();
			//log.info("Inside getCustomQueryList result size:" + result.size());
			return result;
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<Integer> getCustomCount(String sqlQuery, Object[] params) {
		Session session = null;
		try {
			session = openSession();
			SQLQuery queryObject = session.createSQLQuery(sqlQuery);
			queryObject.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			for (int i = 0; i < params.length; i++) {
				if (params[i] != null)
					qPos.add(params[i]);
			}
			List<Integer> result = queryObject.list();
			return result;
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<BigInteger> getCustomLongList(String sqlQuery, Object[] params) {
		Session session = null;
		try {
			session = openSession();
			SQLQuery queryObject = session.createSQLQuery(sqlQuery);
			queryObject.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					if (params[i] != null)
						qPos.add(params[i]);
				}
			}
			List<BigInteger> result = queryObject.list();
			return result;
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		} finally {
			closeSession(session);
		}
		return null;
	}

	/**
	 * This method will return List of Sting custom query
	 * 
	 */
	public List<String> getCustomScalarValue(String sqlQuery, Object[] params) {
		Session session = null;
		try {
			session = openSession();
			SQLQuery queryObject = session.createSQLQuery(sqlQuery);
			queryObject.setCacheable(true);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					if (params[i] != null)
						qPos.add(params[i]);
				}
			}
			List<String> result = queryObject.list();
			return result;
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		} finally {
			closeSession(session);
		}
		return null;
	}

	/**
	 * This method will Exceute delete query with params
	 */
	public void findCustomDeleteWithParam(String sqlQuery, Object[] params) {
		Session session = null;
		try {
			session = openSession();
			SQLQuery queryObject = session.createSQLQuery(sqlQuery);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			for (int i = 0; i < params.length; i++) {
				if (params[i] != null)
					qPos.add(params[i]);
			}
			queryObject.executeUpdate();
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		} finally {
			closeSession(session);
		}
	}

}