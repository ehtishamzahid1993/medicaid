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

package com.medicaid.app.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.medicaid.app.exception.NoSuchReferralException;
import com.medicaid.app.model.Referral;
import com.medicaid.app.model.impl.ReferralImpl;
import com.medicaid.app.model.impl.ReferralModelImpl;
import com.medicaid.app.service.persistence.ReferralPersistence;
import com.medicaid.app.service.persistence.impl.constants.MedicaidPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the referral service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ReferralPersistence.class)
public class ReferralPersistenceImpl
	extends BasePersistenceImpl<Referral> implements ReferralPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ReferralUtil</code> to access the referral persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ReferralImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the referrals where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching referrals
	 */
	@Override
	public List<Referral> findByStatus(String status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the referrals where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @return the range of matching referrals
	 */
	@Override
	public List<Referral> findByStatus(String status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the referrals where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching referrals
	 */
	@Override
	public List<Referral> findByStatus(
		String status, int start, int end,
		OrderByComparator<Referral> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the referrals where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching referrals
	 */
	@Override
	public List<Referral> findByStatus(
		String status, int start, int end,
		OrderByComparator<Referral> orderByComparator, boolean useFinderCache) {

		status = Objects.toString(status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<Referral> list = null;

		if (useFinderCache) {
			list = (List<Referral>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Referral referral : list) {
					if (!status.equals(referral.getStatus())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_REFERRAL_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(ReferralModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				list = (List<Referral>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first referral in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching referral
	 * @throws NoSuchReferralException if a matching referral could not be found
	 */
	@Override
	public Referral findByStatus_First(
			String status, OrderByComparator<Referral> orderByComparator)
		throws NoSuchReferralException {

		Referral referral = fetchByStatus_First(status, orderByComparator);

		if (referral != null) {
			return referral;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchReferralException(msg.toString());
	}

	/**
	 * Returns the first referral in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching referral, or <code>null</code> if a matching referral could not be found
	 */
	@Override
	public Referral fetchByStatus_First(
		String status, OrderByComparator<Referral> orderByComparator) {

		List<Referral> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last referral in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching referral
	 * @throws NoSuchReferralException if a matching referral could not be found
	 */
	@Override
	public Referral findByStatus_Last(
			String status, OrderByComparator<Referral> orderByComparator)
		throws NoSuchReferralException {

		Referral referral = fetchByStatus_Last(status, orderByComparator);

		if (referral != null) {
			return referral;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchReferralException(msg.toString());
	}

	/**
	 * Returns the last referral in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching referral, or <code>null</code> if a matching referral could not be found
	 */
	@Override
	public Referral fetchByStatus_Last(
		String status, OrderByComparator<Referral> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Referral> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the referrals before and after the current referral in the ordered set where status = &#63;.
	 *
	 * @param referralId the primary key of the current referral
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next referral
	 * @throws NoSuchReferralException if a referral with the primary key could not be found
	 */
	@Override
	public Referral[] findByStatus_PrevAndNext(
			long referralId, String status,
			OrderByComparator<Referral> orderByComparator)
		throws NoSuchReferralException {

		status = Objects.toString(status, "");

		Referral referral = findByPrimaryKey(referralId);

		Session session = null;

		try {
			session = openSession();

			Referral[] array = new ReferralImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, referral, status, orderByComparator, true);

			array[1] = referral;

			array[2] = getByStatus_PrevAndNext(
				session, referral, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Referral getByStatus_PrevAndNext(
		Session session, Referral referral, String status,
		OrderByComparator<Referral> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REFERRAL_WHERE);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			query.append(_FINDER_COLUMN_STATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ReferralModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatus) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(referral)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Referral> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the referrals where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(String status) {
		for (Referral referral :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(referral);
		}
	}

	/**
	 * Returns the number of referrals where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching referrals
	 */
	@Override
	public int countByStatus(String status) {
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REFERRAL_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"referral.status = ?";

	private static final String _FINDER_COLUMN_STATUS_STATUS_3 =
		"(referral.status IS NULL OR referral.status = '')";

	private FinderPath _finderPathWithPaginationFindByFacilities;
	private FinderPath _finderPathWithoutPaginationFindByFacilities;
	private FinderPath _finderPathCountByFacilities;

	/**
	 * Returns all the referrals where facilities = &#63;.
	 *
	 * @param facilities the facilities
	 * @return the matching referrals
	 */
	@Override
	public List<Referral> findByFacilities(String facilities) {
		return findByFacilities(
			facilities, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the referrals where facilities = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param facilities the facilities
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @return the range of matching referrals
	 */
	@Override
	public List<Referral> findByFacilities(
		String facilities, int start, int end) {

		return findByFacilities(facilities, start, end, null);
	}

	/**
	 * Returns an ordered range of all the referrals where facilities = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param facilities the facilities
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching referrals
	 */
	@Override
	public List<Referral> findByFacilities(
		String facilities, int start, int end,
		OrderByComparator<Referral> orderByComparator) {

		return findByFacilities(
			facilities, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the referrals where facilities = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param facilities the facilities
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching referrals
	 */
	@Override
	public List<Referral> findByFacilities(
		String facilities, int start, int end,
		OrderByComparator<Referral> orderByComparator, boolean useFinderCache) {

		facilities = Objects.toString(facilities, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFacilities;
				finderArgs = new Object[] {facilities};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFacilities;
			finderArgs = new Object[] {
				facilities, start, end, orderByComparator
			};
		}

		List<Referral> list = null;

		if (useFinderCache) {
			list = (List<Referral>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Referral referral : list) {
					if (!facilities.equals(referral.getFacilities())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_REFERRAL_WHERE);

			boolean bindFacilities = false;

			if (facilities.isEmpty()) {
				query.append(_FINDER_COLUMN_FACILITIES_FACILITIES_3);
			}
			else {
				bindFacilities = true;

				query.append(_FINDER_COLUMN_FACILITIES_FACILITIES_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(ReferralModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFacilities) {
					qPos.add(facilities);
				}

				list = (List<Referral>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first referral in the ordered set where facilities = &#63;.
	 *
	 * @param facilities the facilities
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching referral
	 * @throws NoSuchReferralException if a matching referral could not be found
	 */
	@Override
	public Referral findByFacilities_First(
			String facilities, OrderByComparator<Referral> orderByComparator)
		throws NoSuchReferralException {

		Referral referral = fetchByFacilities_First(
			facilities, orderByComparator);

		if (referral != null) {
			return referral;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facilities=");
		msg.append(facilities);

		msg.append("}");

		throw new NoSuchReferralException(msg.toString());
	}

	/**
	 * Returns the first referral in the ordered set where facilities = &#63;.
	 *
	 * @param facilities the facilities
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching referral, or <code>null</code> if a matching referral could not be found
	 */
	@Override
	public Referral fetchByFacilities_First(
		String facilities, OrderByComparator<Referral> orderByComparator) {

		List<Referral> list = findByFacilities(
			facilities, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last referral in the ordered set where facilities = &#63;.
	 *
	 * @param facilities the facilities
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching referral
	 * @throws NoSuchReferralException if a matching referral could not be found
	 */
	@Override
	public Referral findByFacilities_Last(
			String facilities, OrderByComparator<Referral> orderByComparator)
		throws NoSuchReferralException {

		Referral referral = fetchByFacilities_Last(
			facilities, orderByComparator);

		if (referral != null) {
			return referral;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facilities=");
		msg.append(facilities);

		msg.append("}");

		throw new NoSuchReferralException(msg.toString());
	}

	/**
	 * Returns the last referral in the ordered set where facilities = &#63;.
	 *
	 * @param facilities the facilities
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching referral, or <code>null</code> if a matching referral could not be found
	 */
	@Override
	public Referral fetchByFacilities_Last(
		String facilities, OrderByComparator<Referral> orderByComparator) {

		int count = countByFacilities(facilities);

		if (count == 0) {
			return null;
		}

		List<Referral> list = findByFacilities(
			facilities, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the referrals before and after the current referral in the ordered set where facilities = &#63;.
	 *
	 * @param referralId the primary key of the current referral
	 * @param facilities the facilities
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next referral
	 * @throws NoSuchReferralException if a referral with the primary key could not be found
	 */
	@Override
	public Referral[] findByFacilities_PrevAndNext(
			long referralId, String facilities,
			OrderByComparator<Referral> orderByComparator)
		throws NoSuchReferralException {

		facilities = Objects.toString(facilities, "");

		Referral referral = findByPrimaryKey(referralId);

		Session session = null;

		try {
			session = openSession();

			Referral[] array = new ReferralImpl[3];

			array[0] = getByFacilities_PrevAndNext(
				session, referral, facilities, orderByComparator, true);

			array[1] = referral;

			array[2] = getByFacilities_PrevAndNext(
				session, referral, facilities, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Referral getByFacilities_PrevAndNext(
		Session session, Referral referral, String facilities,
		OrderByComparator<Referral> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REFERRAL_WHERE);

		boolean bindFacilities = false;

		if (facilities.isEmpty()) {
			query.append(_FINDER_COLUMN_FACILITIES_FACILITIES_3);
		}
		else {
			bindFacilities = true;

			query.append(_FINDER_COLUMN_FACILITIES_FACILITIES_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ReferralModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFacilities) {
			qPos.add(facilities);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(referral)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Referral> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the referrals where facilities = &#63; from the database.
	 *
	 * @param facilities the facilities
	 */
	@Override
	public void removeByFacilities(String facilities) {
		for (Referral referral :
				findByFacilities(
					facilities, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(referral);
		}
	}

	/**
	 * Returns the number of referrals where facilities = &#63;.
	 *
	 * @param facilities the facilities
	 * @return the number of matching referrals
	 */
	@Override
	public int countByFacilities(String facilities) {
		facilities = Objects.toString(facilities, "");

		FinderPath finderPath = _finderPathCountByFacilities;

		Object[] finderArgs = new Object[] {facilities};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REFERRAL_WHERE);

			boolean bindFacilities = false;

			if (facilities.isEmpty()) {
				query.append(_FINDER_COLUMN_FACILITIES_FACILITIES_3);
			}
			else {
				bindFacilities = true;

				query.append(_FINDER_COLUMN_FACILITIES_FACILITIES_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFacilities) {
					qPos.add(facilities);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FACILITIES_FACILITIES_2 =
		"referral.facilities = ?";

	private static final String _FINDER_COLUMN_FACILITIES_FACILITIES_3 =
		"(referral.facilities IS NULL OR referral.facilities = '')";

	public ReferralPersistenceImpl() {
		setModelClass(Referral.class);

		setModelImplClass(ReferralImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the referral in the entity cache if it is enabled.
	 *
	 * @param referral the referral
	 */
	@Override
	public void cacheResult(Referral referral) {
		entityCache.putResult(
			entityCacheEnabled, ReferralImpl.class, referral.getPrimaryKey(),
			referral);

		referral.resetOriginalValues();
	}

	/**
	 * Caches the referrals in the entity cache if it is enabled.
	 *
	 * @param referrals the referrals
	 */
	@Override
	public void cacheResult(List<Referral> referrals) {
		for (Referral referral : referrals) {
			if (entityCache.getResult(
					entityCacheEnabled, ReferralImpl.class,
					referral.getPrimaryKey()) == null) {

				cacheResult(referral);
			}
			else {
				referral.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all referrals.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ReferralImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the referral.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Referral referral) {
		entityCache.removeResult(
			entityCacheEnabled, ReferralImpl.class, referral.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Referral> referrals) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Referral referral : referrals) {
			entityCache.removeResult(
				entityCacheEnabled, ReferralImpl.class,
				referral.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ReferralImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new referral with the primary key. Does not add the referral to the database.
	 *
	 * @param referralId the primary key for the new referral
	 * @return the new referral
	 */
	@Override
	public Referral create(long referralId) {
		Referral referral = new ReferralImpl();

		referral.setNew(true);
		referral.setPrimaryKey(referralId);

		return referral;
	}

	/**
	 * Removes the referral with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param referralId the primary key of the referral
	 * @return the referral that was removed
	 * @throws NoSuchReferralException if a referral with the primary key could not be found
	 */
	@Override
	public Referral remove(long referralId) throws NoSuchReferralException {
		return remove((Serializable)referralId);
	}

	/**
	 * Removes the referral with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the referral
	 * @return the referral that was removed
	 * @throws NoSuchReferralException if a referral with the primary key could not be found
	 */
	@Override
	public Referral remove(Serializable primaryKey)
		throws NoSuchReferralException {

		Session session = null;

		try {
			session = openSession();

			Referral referral = (Referral)session.get(
				ReferralImpl.class, primaryKey);

			if (referral == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReferralException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(referral);
		}
		catch (NoSuchReferralException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Referral removeImpl(Referral referral) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(referral)) {
				referral = (Referral)session.get(
					ReferralImpl.class, referral.getPrimaryKeyObj());
			}

			if (referral != null) {
				session.delete(referral);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (referral != null) {
			clearCache(referral);
		}

		return referral;
	}

	@Override
	public Referral updateImpl(Referral referral) {
		boolean isNew = referral.isNew();

		if (!(referral instanceof ReferralModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(referral.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(referral);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in referral proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Referral implementation " +
					referral.getClass());
		}

		ReferralModelImpl referralModelImpl = (ReferralModelImpl)referral;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (referral.getCreateDate() == null)) {
			if (serviceContext == null) {
				referral.setCreateDate(now);
			}
			else {
				referral.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!referralModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				referral.setModifiedDate(now);
			}
			else {
				referral.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (referral.isNew()) {
				session.save(referral);

				referral.setNew(false);
			}
			else {
				referral = (Referral)session.merge(referral);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {referralModelImpl.getStatus()};

			finderCache.removeResult(_finderPathCountByStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatus, args);

			args = new Object[] {referralModelImpl.getFacilities()};

			finderCache.removeResult(_finderPathCountByFacilities, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFacilities, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((referralModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatus.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					referralModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);

				args = new Object[] {referralModelImpl.getStatus()};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);
			}

			if ((referralModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFacilities.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					referralModelImpl.getOriginalFacilities()
				};

				finderCache.removeResult(_finderPathCountByFacilities, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFacilities, args);

				args = new Object[] {referralModelImpl.getFacilities()};

				finderCache.removeResult(_finderPathCountByFacilities, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFacilities, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ReferralImpl.class, referral.getPrimaryKey(),
			referral, false);

		referral.resetOriginalValues();

		return referral;
	}

	/**
	 * Returns the referral with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the referral
	 * @return the referral
	 * @throws NoSuchReferralException if a referral with the primary key could not be found
	 */
	@Override
	public Referral findByPrimaryKey(Serializable primaryKey)
		throws NoSuchReferralException {

		Referral referral = fetchByPrimaryKey(primaryKey);

		if (referral == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchReferralException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return referral;
	}

	/**
	 * Returns the referral with the primary key or throws a <code>NoSuchReferralException</code> if it could not be found.
	 *
	 * @param referralId the primary key of the referral
	 * @return the referral
	 * @throws NoSuchReferralException if a referral with the primary key could not be found
	 */
	@Override
	public Referral findByPrimaryKey(long referralId)
		throws NoSuchReferralException {

		return findByPrimaryKey((Serializable)referralId);
	}

	/**
	 * Returns the referral with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param referralId the primary key of the referral
	 * @return the referral, or <code>null</code> if a referral with the primary key could not be found
	 */
	@Override
	public Referral fetchByPrimaryKey(long referralId) {
		return fetchByPrimaryKey((Serializable)referralId);
	}

	/**
	 * Returns all the referrals.
	 *
	 * @return the referrals
	 */
	@Override
	public List<Referral> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the referrals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @return the range of referrals
	 */
	@Override
	public List<Referral> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the referrals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of referrals
	 */
	@Override
	public List<Referral> findAll(
		int start, int end, OrderByComparator<Referral> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the referrals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of referrals
	 */
	@Override
	public List<Referral> findAll(
		int start, int end, OrderByComparator<Referral> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Referral> list = null;

		if (useFinderCache) {
			list = (List<Referral>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_REFERRAL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REFERRAL;

				sql = sql.concat(ReferralModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<Referral>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the referrals from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Referral referral : findAll()) {
			remove(referral);
		}
	}

	/**
	 * Returns the number of referrals.
	 *
	 * @return the number of referrals
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_REFERRAL);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "referralId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_REFERRAL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ReferralModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the referral persistence.
	 */
	@Activate
	public void activate() {
		ReferralModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ReferralModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReferralImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReferralImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReferralImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReferralImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {String.class.getName()},
			ReferralModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByFacilities = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReferralImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFacilities",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFacilities = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReferralImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFacilities",
			new String[] {String.class.getName()},
			ReferralModelImpl.FACILITIES_COLUMN_BITMASK);

		_finderPathCountByFacilities = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFacilities",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ReferralImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = MedicaidPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.medicaid.app.model.Referral"),
			true);
	}

	@Override
	@Reference(
		target = MedicaidPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MedicaidPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_REFERRAL =
		"SELECT referral FROM Referral referral";

	private static final String _SQL_SELECT_REFERRAL_WHERE =
		"SELECT referral FROM Referral referral WHERE ";

	private static final String _SQL_COUNT_REFERRAL =
		"SELECT COUNT(referral) FROM Referral referral";

	private static final String _SQL_COUNT_REFERRAL_WHERE =
		"SELECT COUNT(referral) FROM Referral referral WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "referral.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Referral exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Referral exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ReferralPersistenceImpl.class);

	static {
		try {
			Class.forName(MedicaidPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}