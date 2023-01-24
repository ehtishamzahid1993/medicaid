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
import com.liferay.portal.kernel.util.SetUtil;

import com.medicaid.app.exception.NoSuchFacilityException;
import com.medicaid.app.model.Facility;
import com.medicaid.app.model.impl.FacilityImpl;
import com.medicaid.app.model.impl.FacilityModelImpl;
import com.medicaid.app.service.persistence.FacilityPersistence;
import com.medicaid.app.service.persistence.impl.constants.MedicaidPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the facility service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FacilityPersistence.class)
public class FacilityPersistenceImpl
	extends BasePersistenceImpl<Facility> implements FacilityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FacilityUtil</code> to access the facility persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FacilityImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public FacilityPersistenceImpl() {
		setModelClass(Facility.class);

		setModelImplClass(FacilityImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("state", "state_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the facility in the entity cache if it is enabled.
	 *
	 * @param facility the facility
	 */
	@Override
	public void cacheResult(Facility facility) {
		entityCache.putResult(
			entityCacheEnabled, FacilityImpl.class, facility.getPrimaryKey(),
			facility);

		facility.resetOriginalValues();
	}

	/**
	 * Caches the facilities in the entity cache if it is enabled.
	 *
	 * @param facilities the facilities
	 */
	@Override
	public void cacheResult(List<Facility> facilities) {
		for (Facility facility : facilities) {
			if (entityCache.getResult(
					entityCacheEnabled, FacilityImpl.class,
					facility.getPrimaryKey()) == null) {

				cacheResult(facility);
			}
			else {
				facility.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all facilities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FacilityImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the facility.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Facility facility) {
		entityCache.removeResult(
			entityCacheEnabled, FacilityImpl.class, facility.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Facility> facilities) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Facility facility : facilities) {
			entityCache.removeResult(
				entityCacheEnabled, FacilityImpl.class,
				facility.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, FacilityImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new facility with the primary key. Does not add the facility to the database.
	 *
	 * @param facilityId the primary key for the new facility
	 * @return the new facility
	 */
	@Override
	public Facility create(long facilityId) {
		Facility facility = new FacilityImpl();

		facility.setNew(true);
		facility.setPrimaryKey(facilityId);

		return facility;
	}

	/**
	 * Removes the facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility that was removed
	 * @throws NoSuchFacilityException if a facility with the primary key could not be found
	 */
	@Override
	public Facility remove(long facilityId) throws NoSuchFacilityException {
		return remove((Serializable)facilityId);
	}

	/**
	 * Removes the facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the facility
	 * @return the facility that was removed
	 * @throws NoSuchFacilityException if a facility with the primary key could not be found
	 */
	@Override
	public Facility remove(Serializable primaryKey)
		throws NoSuchFacilityException {

		Session session = null;

		try {
			session = openSession();

			Facility facility = (Facility)session.get(
				FacilityImpl.class, primaryKey);

			if (facility == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFacilityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(facility);
		}
		catch (NoSuchFacilityException noSuchEntityException) {
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
	protected Facility removeImpl(Facility facility) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(facility)) {
				facility = (Facility)session.get(
					FacilityImpl.class, facility.getPrimaryKeyObj());
			}

			if (facility != null) {
				session.delete(facility);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (facility != null) {
			clearCache(facility);
		}

		return facility;
	}

	@Override
	public Facility updateImpl(Facility facility) {
		boolean isNew = facility.isNew();

		if (!(facility instanceof FacilityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(facility.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(facility);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in facility proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Facility implementation " +
					facility.getClass());
		}

		FacilityModelImpl facilityModelImpl = (FacilityModelImpl)facility;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (facility.getCreateDate() == null)) {
			if (serviceContext == null) {
				facility.setCreateDate(now);
			}
			else {
				facility.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!facilityModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				facility.setModifiedDate(now);
			}
			else {
				facility.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (facility.isNew()) {
				session.save(facility);

				facility.setNew(false);
			}
			else {
				facility = (Facility)session.merge(facility);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, FacilityImpl.class, facility.getPrimaryKey(),
			facility, false);

		facility.resetOriginalValues();

		return facility;
	}

	/**
	 * Returns the facility with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the facility
	 * @return the facility
	 * @throws NoSuchFacilityException if a facility with the primary key could not be found
	 */
	@Override
	public Facility findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFacilityException {

		Facility facility = fetchByPrimaryKey(primaryKey);

		if (facility == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFacilityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return facility;
	}

	/**
	 * Returns the facility with the primary key or throws a <code>NoSuchFacilityException</code> if it could not be found.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility
	 * @throws NoSuchFacilityException if a facility with the primary key could not be found
	 */
	@Override
	public Facility findByPrimaryKey(long facilityId)
		throws NoSuchFacilityException {

		return findByPrimaryKey((Serializable)facilityId);
	}

	/**
	 * Returns the facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility, or <code>null</code> if a facility with the primary key could not be found
	 */
	@Override
	public Facility fetchByPrimaryKey(long facilityId) {
		return fetchByPrimaryKey((Serializable)facilityId);
	}

	/**
	 * Returns all the facilities.
	 *
	 * @return the facilities
	 */
	@Override
	public List<Facility> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @return the range of facilities
	 */
	@Override
	public List<Facility> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of facilities
	 */
	@Override
	public List<Facility> findAll(
		int start, int end, OrderByComparator<Facility> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of facilities
	 */
	@Override
	public List<Facility> findAll(
		int start, int end, OrderByComparator<Facility> orderByComparator,
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

		List<Facility> list = null;

		if (useFinderCache) {
			list = (List<Facility>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FACILITY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACILITY;

				sql = sql.concat(FacilityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<Facility>)QueryUtil.list(
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
	 * Removes all the facilities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Facility facility : findAll()) {
			remove(facility);
		}
	}

	/**
	 * Returns the number of facilities.
	 *
	 * @return the number of facilities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FACILITY);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "facilityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FACILITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FacilityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the facility persistence.
	 */
	@Activate
	public void activate() {
		FacilityModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		FacilityModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(FacilityImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.medicaid.app.model.Facility"),
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

	private static final String _SQL_SELECT_FACILITY =
		"SELECT facility FROM Facility facility";

	private static final String _SQL_COUNT_FACILITY =
		"SELECT COUNT(facility) FROM Facility facility";

	private static final String _ORDER_BY_ENTITY_ALIAS = "facility.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Facility exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		FacilityPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"state"});

	static {
		try {
			Class.forName(MedicaidPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}