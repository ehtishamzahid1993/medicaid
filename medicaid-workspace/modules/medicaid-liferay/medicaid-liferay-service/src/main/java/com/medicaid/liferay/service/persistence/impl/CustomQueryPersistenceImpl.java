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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.medicaid.liferay.exception.NoSuchCustomQueryException;
import com.medicaid.liferay.model.CustomQuery;
import com.medicaid.liferay.model.impl.CustomQueryImpl;
import com.medicaid.liferay.model.impl.CustomQueryModelImpl;
import com.medicaid.liferay.service.persistence.CustomQueryPersistence;
import com.medicaid.liferay.service.persistence.impl.constants.MedicaidPersistenceConstants;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the custom query service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CustomQueryPersistence.class)
public class CustomQueryPersistenceImpl
	extends BasePersistenceImpl<CustomQuery> implements CustomQueryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CustomQueryUtil</code> to access the custom query persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CustomQueryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CustomQueryPersistenceImpl() {
		setModelClass(CustomQuery.class);

		setModelImplClass(CustomQueryImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the custom query in the entity cache if it is enabled.
	 *
	 * @param customQuery the custom query
	 */
	@Override
	public void cacheResult(CustomQuery customQuery) {
		entityCache.putResult(
			entityCacheEnabled, CustomQueryImpl.class,
			customQuery.getPrimaryKey(), customQuery);

		customQuery.resetOriginalValues();
	}

	/**
	 * Caches the custom queries in the entity cache if it is enabled.
	 *
	 * @param customQueries the custom queries
	 */
	@Override
	public void cacheResult(List<CustomQuery> customQueries) {
		for (CustomQuery customQuery : customQueries) {
			if (entityCache.getResult(
					entityCacheEnabled, CustomQueryImpl.class,
					customQuery.getPrimaryKey()) == null) {

				cacheResult(customQuery);
			}
			else {
				customQuery.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all custom queries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CustomQueryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the custom query.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CustomQuery customQuery) {
		entityCache.removeResult(
			entityCacheEnabled, CustomQueryImpl.class,
			customQuery.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CustomQuery> customQueries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CustomQuery customQuery : customQueries) {
			entityCache.removeResult(
				entityCacheEnabled, CustomQueryImpl.class,
				customQuery.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CustomQueryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new custom query with the primary key. Does not add the custom query to the database.
	 *
	 * @param sqlKey the primary key for the new custom query
	 * @return the new custom query
	 */
	@Override
	public CustomQuery create(String sqlKey) {
		CustomQuery customQuery = new CustomQueryImpl();

		customQuery.setNew(true);
		customQuery.setPrimaryKey(sqlKey);

		return customQuery;
	}

	/**
	 * Removes the custom query with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sqlKey the primary key of the custom query
	 * @return the custom query that was removed
	 * @throws NoSuchCustomQueryException if a custom query with the primary key could not be found
	 */
	@Override
	public CustomQuery remove(String sqlKey) throws NoSuchCustomQueryException {
		return remove((Serializable)sqlKey);
	}

	/**
	 * Removes the custom query with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the custom query
	 * @return the custom query that was removed
	 * @throws NoSuchCustomQueryException if a custom query with the primary key could not be found
	 */
	@Override
	public CustomQuery remove(Serializable primaryKey)
		throws NoSuchCustomQueryException {

		Session session = null;

		try {
			session = openSession();

			CustomQuery customQuery = (CustomQuery)session.get(
				CustomQueryImpl.class, primaryKey);

			if (customQuery == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustomQueryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(customQuery);
		}
		catch (NoSuchCustomQueryException noSuchEntityException) {
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
	protected CustomQuery removeImpl(CustomQuery customQuery) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(customQuery)) {
				customQuery = (CustomQuery)session.get(
					CustomQueryImpl.class, customQuery.getPrimaryKeyObj());
			}

			if (customQuery != null) {
				session.delete(customQuery);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (customQuery != null) {
			clearCache(customQuery);
		}

		return customQuery;
	}

	@Override
	public CustomQuery updateImpl(CustomQuery customQuery) {
		boolean isNew = customQuery.isNew();

		Session session = null;

		try {
			session = openSession();

			if (customQuery.isNew()) {
				session.save(customQuery);

				customQuery.setNew(false);
			}
			else {
				customQuery = (CustomQuery)session.merge(customQuery);
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
			entityCacheEnabled, CustomQueryImpl.class,
			customQuery.getPrimaryKey(), customQuery, false);

		customQuery.resetOriginalValues();

		return customQuery;
	}

	/**
	 * Returns the custom query with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom query
	 * @return the custom query
	 * @throws NoSuchCustomQueryException if a custom query with the primary key could not be found
	 */
	@Override
	public CustomQuery findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustomQueryException {

		CustomQuery customQuery = fetchByPrimaryKey(primaryKey);

		if (customQuery == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustomQueryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return customQuery;
	}

	/**
	 * Returns the custom query with the primary key or throws a <code>NoSuchCustomQueryException</code> if it could not be found.
	 *
	 * @param sqlKey the primary key of the custom query
	 * @return the custom query
	 * @throws NoSuchCustomQueryException if a custom query with the primary key could not be found
	 */
	@Override
	public CustomQuery findByPrimaryKey(String sqlKey)
		throws NoSuchCustomQueryException {

		return findByPrimaryKey((Serializable)sqlKey);
	}

	/**
	 * Returns the custom query with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sqlKey the primary key of the custom query
	 * @return the custom query, or <code>null</code> if a custom query with the primary key could not be found
	 */
	@Override
	public CustomQuery fetchByPrimaryKey(String sqlKey) {
		return fetchByPrimaryKey((Serializable)sqlKey);
	}

	/**
	 * Returns all the custom queries.
	 *
	 * @return the custom queries
	 */
	@Override
	public List<CustomQuery> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the custom queries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomQueryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom queries
	 * @param end the upper bound of the range of custom queries (not inclusive)
	 * @return the range of custom queries
	 */
	@Override
	public List<CustomQuery> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the custom queries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomQueryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom queries
	 * @param end the upper bound of the range of custom queries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of custom queries
	 */
	@Override
	public List<CustomQuery> findAll(
		int start, int end, OrderByComparator<CustomQuery> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the custom queries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomQueryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom queries
	 * @param end the upper bound of the range of custom queries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of custom queries
	 */
	@Override
	public List<CustomQuery> findAll(
		int start, int end, OrderByComparator<CustomQuery> orderByComparator,
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

		List<CustomQuery> list = null;

		if (useFinderCache) {
			list = (List<CustomQuery>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CUSTOMQUERY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMQUERY;

				sql = sql.concat(CustomQueryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<CustomQuery>)QueryUtil.list(
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
	 * Removes all the custom queries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CustomQuery customQuery : findAll()) {
			remove(customQuery);
		}
	}

	/**
	 * Returns the number of custom queries.
	 *
	 * @return the number of custom queries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CUSTOMQUERY);

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
		return "sqlKey";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CUSTOMQUERY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CustomQueryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the custom query persistence.
	 */
	@Activate
	public void activate() {
		CustomQueryModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CustomQueryModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CustomQueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CustomQueryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CustomQueryImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.medicaid.liferay.model.CustomQuery"),
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

	private static final String _SQL_SELECT_CUSTOMQUERY =
		"SELECT customQuery FROM CustomQuery customQuery";

	private static final String _SQL_COUNT_CUSTOMQUERY =
		"SELECT COUNT(customQuery) FROM CustomQuery customQuery";

	private static final String _ORDER_BY_ENTITY_ALIAS = "customQuery.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CustomQuery exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CustomQueryPersistenceImpl.class);

	static {
		try {
			Class.forName(MedicaidPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}