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

import com.medicaid.app.exception.NoSuchNoteException;
import com.medicaid.app.model.Note;
import com.medicaid.app.model.impl.NoteImpl;
import com.medicaid.app.model.impl.NoteModelImpl;
import com.medicaid.app.service.persistence.NotePersistence;
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
 * The persistence implementation for the note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = NotePersistence.class)
public class NotePersistenceImpl
	extends BasePersistenceImpl<Note> implements NotePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NoteUtil</code> to access the note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NoteImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByReferralId;
	private FinderPath _finderPathWithoutPaginationFindByReferralId;
	private FinderPath _finderPathCountByReferralId;

	/**
	 * Returns all the notes where referralId = &#63;.
	 *
	 * @param referralId the referral ID
	 * @return the matching notes
	 */
	@Override
	public List<Note> findByReferralId(Long referralId) {
		return findByReferralId(
			referralId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notes where referralId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param referralId the referral ID
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of matching notes
	 */
	@Override
	public List<Note> findByReferralId(Long referralId, int start, int end) {
		return findByReferralId(referralId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notes where referralId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param referralId the referral ID
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notes
	 */
	@Override
	public List<Note> findByReferralId(
		Long referralId, int start, int end,
		OrderByComparator<Note> orderByComparator) {

		return findByReferralId(
			referralId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notes where referralId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param referralId the referral ID
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notes
	 */
	@Override
	public List<Note> findByReferralId(
		Long referralId, int start, int end,
		OrderByComparator<Note> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByReferralId;
				finderArgs = new Object[] {referralId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByReferralId;
			finderArgs = new Object[] {
				referralId, start, end, orderByComparator
			};
		}

		List<Note> list = null;

		if (useFinderCache) {
			list = (List<Note>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Note note : list) {
					if (!Objects.equals(referralId, note.getReferralId())) {
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

			query.append(_SQL_SELECT_NOTE_WHERE);

			query.append(_FINDER_COLUMN_REFERRALID_REFERRALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(NoteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(referralId.longValue());

				list = (List<Note>)QueryUtil.list(q, getDialect(), start, end);

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
	 * Returns the first note in the ordered set where referralId = &#63;.
	 *
	 * @param referralId the referral ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	@Override
	public Note findByReferralId_First(
			Long referralId, OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		Note note = fetchByReferralId_First(referralId, orderByComparator);

		if (note != null) {
			return note;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("referralId=");
		msg.append(referralId);

		msg.append("}");

		throw new NoSuchNoteException(msg.toString());
	}

	/**
	 * Returns the first note in the ordered set where referralId = &#63;.
	 *
	 * @param referralId the referral ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByReferralId_First(
		Long referralId, OrderByComparator<Note> orderByComparator) {

		List<Note> list = findByReferralId(referralId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last note in the ordered set where referralId = &#63;.
	 *
	 * @param referralId the referral ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	@Override
	public Note findByReferralId_Last(
			Long referralId, OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		Note note = fetchByReferralId_Last(referralId, orderByComparator);

		if (note != null) {
			return note;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("referralId=");
		msg.append(referralId);

		msg.append("}");

		throw new NoSuchNoteException(msg.toString());
	}

	/**
	 * Returns the last note in the ordered set where referralId = &#63;.
	 *
	 * @param referralId the referral ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByReferralId_Last(
		Long referralId, OrderByComparator<Note> orderByComparator) {

		int count = countByReferralId(referralId);

		if (count == 0) {
			return null;
		}

		List<Note> list = findByReferralId(
			referralId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notes before and after the current note in the ordered set where referralId = &#63;.
	 *
	 * @param noteId the primary key of the current note
	 * @param referralId the referral ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	@Override
	public Note[] findByReferralId_PrevAndNext(
			long noteId, Long referralId,
			OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		Note note = findByPrimaryKey(noteId);

		Session session = null;

		try {
			session = openSession();

			Note[] array = new NoteImpl[3];

			array[0] = getByReferralId_PrevAndNext(
				session, note, referralId, orderByComparator, true);

			array[1] = note;

			array[2] = getByReferralId_PrevAndNext(
				session, note, referralId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Note getByReferralId_PrevAndNext(
		Session session, Note note, Long referralId,
		OrderByComparator<Note> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NOTE_WHERE);

		query.append(_FINDER_COLUMN_REFERRALID_REFERRALID_2);

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
			query.append(NoteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(referralId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(note)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Note> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notes where referralId = &#63; from the database.
	 *
	 * @param referralId the referral ID
	 */
	@Override
	public void removeByReferralId(Long referralId) {
		for (Note note :
				findByReferralId(
					referralId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(note);
		}
	}

	/**
	 * Returns the number of notes where referralId = &#63;.
	 *
	 * @param referralId the referral ID
	 * @return the number of matching notes
	 */
	@Override
	public int countByReferralId(Long referralId) {
		FinderPath finderPath = _finderPathCountByReferralId;

		Object[] finderArgs = new Object[] {referralId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NOTE_WHERE);

			query.append(_FINDER_COLUMN_REFERRALID_REFERRALID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(referralId.longValue());

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

	private static final String _FINDER_COLUMN_REFERRALID_REFERRALID_2 =
		"note.referralId = ?";

	public NotePersistenceImpl() {
		setModelClass(Note.class);

		setModelImplClass(NoteImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the note in the entity cache if it is enabled.
	 *
	 * @param note the note
	 */
	@Override
	public void cacheResult(Note note) {
		entityCache.putResult(
			entityCacheEnabled, NoteImpl.class, note.getPrimaryKey(), note);

		note.resetOriginalValues();
	}

	/**
	 * Caches the notes in the entity cache if it is enabled.
	 *
	 * @param notes the notes
	 */
	@Override
	public void cacheResult(List<Note> notes) {
		for (Note note : notes) {
			if (entityCache.getResult(
					entityCacheEnabled, NoteImpl.class, note.getPrimaryKey()) ==
						null) {

				cacheResult(note);
			}
			else {
				note.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all notes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NoteImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the note.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Note note) {
		entityCache.removeResult(
			entityCacheEnabled, NoteImpl.class, note.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Note> notes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Note note : notes) {
			entityCache.removeResult(
				entityCacheEnabled, NoteImpl.class, note.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, NoteImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new note with the primary key. Does not add the note to the database.
	 *
	 * @param noteId the primary key for the new note
	 * @return the new note
	 */
	@Override
	public Note create(long noteId) {
		Note note = new NoteImpl();

		note.setNew(true);
		note.setPrimaryKey(noteId);

		return note;
	}

	/**
	 * Removes the note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noteId the primary key of the note
	 * @return the note that was removed
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	@Override
	public Note remove(long noteId) throws NoSuchNoteException {
		return remove((Serializable)noteId);
	}

	/**
	 * Removes the note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the note
	 * @return the note that was removed
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	@Override
	public Note remove(Serializable primaryKey) throws NoSuchNoteException {
		Session session = null;

		try {
			session = openSession();

			Note note = (Note)session.get(NoteImpl.class, primaryKey);

			if (note == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNoteException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(note);
		}
		catch (NoSuchNoteException noSuchEntityException) {
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
	protected Note removeImpl(Note note) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(note)) {
				note = (Note)session.get(
					NoteImpl.class, note.getPrimaryKeyObj());
			}

			if (note != null) {
				session.delete(note);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (note != null) {
			clearCache(note);
		}

		return note;
	}

	@Override
	public Note updateImpl(Note note) {
		boolean isNew = note.isNew();

		if (!(note instanceof NoteModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(note.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(note);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in note proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Note implementation " +
					note.getClass());
		}

		NoteModelImpl noteModelImpl = (NoteModelImpl)note;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (note.getCreateDate() == null)) {
			if (serviceContext == null) {
				note.setCreateDate(now);
			}
			else {
				note.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!noteModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				note.setModifiedDate(now);
			}
			else {
				note.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (note.isNew()) {
				session.save(note);

				note.setNew(false);
			}
			else {
				note = (Note)session.merge(note);
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
			Object[] args = new Object[] {noteModelImpl.getReferralId()};

			finderCache.removeResult(_finderPathCountByReferralId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByReferralId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((noteModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByReferralId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					noteModelImpl.getOriginalReferralId()
				};

				finderCache.removeResult(_finderPathCountByReferralId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByReferralId, args);

				args = new Object[] {noteModelImpl.getReferralId()};

				finderCache.removeResult(_finderPathCountByReferralId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByReferralId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, NoteImpl.class, note.getPrimaryKey(), note,
			false);

		note.resetOriginalValues();

		return note;
	}

	/**
	 * Returns the note with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the note
	 * @return the note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	@Override
	public Note findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNoteException {

		Note note = fetchByPrimaryKey(primaryKey);

		if (note == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNoteException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return note;
	}

	/**
	 * Returns the note with the primary key or throws a <code>NoSuchNoteException</code> if it could not be found.
	 *
	 * @param noteId the primary key of the note
	 * @return the note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	@Override
	public Note findByPrimaryKey(long noteId) throws NoSuchNoteException {
		return findByPrimaryKey((Serializable)noteId);
	}

	/**
	 * Returns the note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param noteId the primary key of the note
	 * @return the note, or <code>null</code> if a note with the primary key could not be found
	 */
	@Override
	public Note fetchByPrimaryKey(long noteId) {
		return fetchByPrimaryKey((Serializable)noteId);
	}

	/**
	 * Returns all the notes.
	 *
	 * @return the notes
	 */
	@Override
	public List<Note> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of notes
	 */
	@Override
	public List<Note> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notes
	 */
	@Override
	public List<Note> findAll(
		int start, int end, OrderByComparator<Note> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of notes
	 */
	@Override
	public List<Note> findAll(
		int start, int end, OrderByComparator<Note> orderByComparator,
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

		List<Note> list = null;

		if (useFinderCache) {
			list = (List<Note>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_NOTE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NOTE;

				sql = sql.concat(NoteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<Note>)QueryUtil.list(q, getDialect(), start, end);

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
	 * Removes all the notes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Note note : findAll()) {
			remove(note);
		}
	}

	/**
	 * Returns the number of notes.
	 *
	 * @return the number of notes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NOTE);

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
		return "noteId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_NOTE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NoteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the note persistence.
	 */
	@Activate
	public void activate() {
		NoteModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		NoteModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByReferralId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReferralId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByReferralId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReferralId",
			new String[] {Long.class.getName()},
			NoteModelImpl.REFERRALID_COLUMN_BITMASK);

		_finderPathCountByReferralId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReferralId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(NoteImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.medicaid.app.model.Note"),
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

	private static final String _SQL_SELECT_NOTE = "SELECT note FROM Note note";

	private static final String _SQL_SELECT_NOTE_WHERE =
		"SELECT note FROM Note note WHERE ";

	private static final String _SQL_COUNT_NOTE =
		"SELECT COUNT(note) FROM Note note";

	private static final String _SQL_COUNT_NOTE_WHERE =
		"SELECT COUNT(note) FROM Note note WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "note.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Note exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Note exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		NotePersistenceImpl.class);

	static {
		try {
			Class.forName(MedicaidPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}