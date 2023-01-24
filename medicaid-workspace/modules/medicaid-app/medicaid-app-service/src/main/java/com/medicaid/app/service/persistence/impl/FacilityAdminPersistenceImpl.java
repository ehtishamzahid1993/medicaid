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

import com.medicaid.app.exception.NoSuchFacilityAdminException;
import com.medicaid.app.model.FacilityAdmin;
import com.medicaid.app.model.impl.FacilityAdminImpl;
import com.medicaid.app.model.impl.FacilityAdminModelImpl;
import com.medicaid.app.service.persistence.FacilityAdminPersistence;
import com.medicaid.app.service.persistence.impl.constants.MedicaidPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the facility admin service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FacilityAdminPersistence.class)
public class FacilityAdminPersistenceImpl
	extends BasePersistenceImpl<FacilityAdmin>
	implements FacilityAdminPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FacilityAdminUtil</code> to access the facility admin persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FacilityAdminImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public FacilityAdminPersistenceImpl() {
		setModelClass(FacilityAdmin.class);

		setModelImplClass(FacilityAdminImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the facility admin in the entity cache if it is enabled.
	 *
	 * @param facilityAdmin the facility admin
	 */
	@Override
	public void cacheResult(FacilityAdmin facilityAdmin) {
		entityCache.putResult(
			entityCacheEnabled, FacilityAdminImpl.class,
			facilityAdmin.getPrimaryKey(), facilityAdmin);

		facilityAdmin.resetOriginalValues();
	}

	/**
	 * Caches the facility admins in the entity cache if it is enabled.
	 *
	 * @param facilityAdmins the facility admins
	 */
	@Override
	public void cacheResult(List<FacilityAdmin> facilityAdmins) {
		for (FacilityAdmin facilityAdmin : facilityAdmins) {
			if (entityCache.getResult(
					entityCacheEnabled, FacilityAdminImpl.class,
					facilityAdmin.getPrimaryKey()) == null) {

				cacheResult(facilityAdmin);
			}
			else {
				facilityAdmin.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all facility admins.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FacilityAdminImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the facility admin.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FacilityAdmin facilityAdmin) {
		entityCache.removeResult(
			entityCacheEnabled, FacilityAdminImpl.class,
			facilityAdmin.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FacilityAdmin> facilityAdmins) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FacilityAdmin facilityAdmin : facilityAdmins) {
			entityCache.removeResult(
				entityCacheEnabled, FacilityAdminImpl.class,
				facilityAdmin.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, FacilityAdminImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new facility admin with the primary key. Does not add the facility admin to the database.
	 *
	 * @param userName the primary key for the new facility admin
	 * @return the new facility admin
	 */
	@Override
	public FacilityAdmin create(String userName) {
		FacilityAdmin facilityAdmin = new FacilityAdminImpl();

		facilityAdmin.setNew(true);
		facilityAdmin.setPrimaryKey(userName);

		return facilityAdmin;
	}

	/**
	 * Removes the facility admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userName the primary key of the facility admin
	 * @return the facility admin that was removed
	 * @throws NoSuchFacilityAdminException if a facility admin with the primary key could not be found
	 */
	@Override
	public FacilityAdmin remove(String userName)
		throws NoSuchFacilityAdminException {

		return remove((Serializable)userName);
	}

	/**
	 * Removes the facility admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the facility admin
	 * @return the facility admin that was removed
	 * @throws NoSuchFacilityAdminException if a facility admin with the primary key could not be found
	 */
	@Override
	public FacilityAdmin remove(Serializable primaryKey)
		throws NoSuchFacilityAdminException {

		Session session = null;

		try {
			session = openSession();

			FacilityAdmin facilityAdmin = (FacilityAdmin)session.get(
				FacilityAdminImpl.class, primaryKey);

			if (facilityAdmin == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFacilityAdminException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(facilityAdmin);
		}
		catch (NoSuchFacilityAdminException noSuchEntityException) {
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
	protected FacilityAdmin removeImpl(FacilityAdmin facilityAdmin) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(facilityAdmin)) {
				facilityAdmin = (FacilityAdmin)session.get(
					FacilityAdminImpl.class, facilityAdmin.getPrimaryKeyObj());
			}

			if (facilityAdmin != null) {
				session.delete(facilityAdmin);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (facilityAdmin != null) {
			clearCache(facilityAdmin);
		}

		return facilityAdmin;
	}

	@Override
	public FacilityAdmin updateImpl(FacilityAdmin facilityAdmin) {
		boolean isNew = facilityAdmin.isNew();

		if (!(facilityAdmin instanceof FacilityAdminModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(facilityAdmin.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					facilityAdmin);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in facilityAdmin proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FacilityAdmin implementation " +
					facilityAdmin.getClass());
		}

		FacilityAdminModelImpl facilityAdminModelImpl =
			(FacilityAdminModelImpl)facilityAdmin;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (facilityAdmin.getCreateDate() == null)) {
			if (serviceContext == null) {
				facilityAdmin.setCreateDate(now);
			}
			else {
				facilityAdmin.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!facilityAdminModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				facilityAdmin.setModifiedDate(now);
			}
			else {
				facilityAdmin.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (facilityAdmin.isNew()) {
				session.save(facilityAdmin);

				facilityAdmin.setNew(false);
			}
			else {
				facilityAdmin = (FacilityAdmin)session.merge(facilityAdmin);
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
			entityCacheEnabled, FacilityAdminImpl.class,
			facilityAdmin.getPrimaryKey(), facilityAdmin, false);

		facilityAdmin.resetOriginalValues();

		return facilityAdmin;
	}

	/**
	 * Returns the facility admin with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the facility admin
	 * @return the facility admin
	 * @throws NoSuchFacilityAdminException if a facility admin with the primary key could not be found
	 */
	@Override
	public FacilityAdmin findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFacilityAdminException {

		FacilityAdmin facilityAdmin = fetchByPrimaryKey(primaryKey);

		if (facilityAdmin == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFacilityAdminException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return facilityAdmin;
	}

	/**
	 * Returns the facility admin with the primary key or throws a <code>NoSuchFacilityAdminException</code> if it could not be found.
	 *
	 * @param userName the primary key of the facility admin
	 * @return the facility admin
	 * @throws NoSuchFacilityAdminException if a facility admin with the primary key could not be found
	 */
	@Override
	public FacilityAdmin findByPrimaryKey(String userName)
		throws NoSuchFacilityAdminException {

		return findByPrimaryKey((Serializable)userName);
	}

	/**
	 * Returns the facility admin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userName the primary key of the facility admin
	 * @return the facility admin, or <code>null</code> if a facility admin with the primary key could not be found
	 */
	@Override
	public FacilityAdmin fetchByPrimaryKey(String userName) {
		return fetchByPrimaryKey((Serializable)userName);
	}

	/**
	 * Returns all the facility admins.
	 *
	 * @return the facility admins
	 */
	@Override
	public List<FacilityAdmin> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the facility admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacilityAdminModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facility admins
	 * @param end the upper bound of the range of facility admins (not inclusive)
	 * @return the range of facility admins
	 */
	@Override
	public List<FacilityAdmin> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the facility admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacilityAdminModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facility admins
	 * @param end the upper bound of the range of facility admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of facility admins
	 */
	@Override
	public List<FacilityAdmin> findAll(
		int start, int end,
		OrderByComparator<FacilityAdmin> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the facility admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacilityAdminModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facility admins
	 * @param end the upper bound of the range of facility admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of facility admins
	 */
	@Override
	public List<FacilityAdmin> findAll(
		int start, int end, OrderByComparator<FacilityAdmin> orderByComparator,
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

		List<FacilityAdmin> list = null;

		if (useFinderCache) {
			list = (List<FacilityAdmin>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FACILITYADMIN);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACILITYADMIN;

				sql = sql.concat(FacilityAdminModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<FacilityAdmin>)QueryUtil.list(
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
	 * Removes all the facility admins from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FacilityAdmin facilityAdmin : findAll()) {
			remove(facilityAdmin);
		}
	}

	/**
	 * Returns the number of facility admins.
	 *
	 * @return the number of facility admins
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FACILITYADMIN);

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
		return "userName";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FACILITYADMIN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FacilityAdminModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the facility admin persistence.
	 */
	@Activate
	public void activate() {
		FacilityAdminModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		FacilityAdminModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FacilityAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FacilityAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(FacilityAdminImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.medicaid.app.model.FacilityAdmin"),
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

	private static final String _SQL_SELECT_FACILITYADMIN =
		"SELECT facilityAdmin FROM FacilityAdmin facilityAdmin";

	private static final String _SQL_COUNT_FACILITYADMIN =
		"SELECT COUNT(facilityAdmin) FROM FacilityAdmin facilityAdmin";

	private static final String _ORDER_BY_ENTITY_ALIAS = "facilityAdmin.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FacilityAdmin exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		FacilityAdminPersistenceImpl.class);

	static {
		try {
			Class.forName(MedicaidPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}