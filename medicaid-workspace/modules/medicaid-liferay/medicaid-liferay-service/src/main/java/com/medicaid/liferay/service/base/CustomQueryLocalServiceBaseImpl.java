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

package com.medicaid.liferay.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import com.medicaid.liferay.model.CustomQuery;
import com.medicaid.liferay.service.CustomQueryLocalService;
import com.medicaid.liferay.service.persistence.CustomQueryFinder;
import com.medicaid.liferay.service.persistence.CustomQueryPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the custom query local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.medicaid.liferay.service.impl.CustomQueryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.medicaid.liferay.service.impl.CustomQueryLocalServiceImpl
 * @generated
 */
public abstract class CustomQueryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, CustomQueryLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CustomQueryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.medicaid.liferay.service.CustomQueryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the custom query to the database. Also notifies the appropriate model listeners.
	 *
	 * @param customQuery the custom query
	 * @return the custom query that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CustomQuery addCustomQuery(CustomQuery customQuery) {
		customQuery.setNew(true);

		return customQueryPersistence.update(customQuery);
	}

	/**
	 * Creates a new custom query with the primary key. Does not add the custom query to the database.
	 *
	 * @param sqlKey the primary key for the new custom query
	 * @return the new custom query
	 */
	@Override
	@Transactional(enabled = false)
	public CustomQuery createCustomQuery(String sqlKey) {
		return customQueryPersistence.create(sqlKey);
	}

	/**
	 * Deletes the custom query with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sqlKey the primary key of the custom query
	 * @return the custom query that was removed
	 * @throws PortalException if a custom query with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CustomQuery deleteCustomQuery(String sqlKey) throws PortalException {
		return customQueryPersistence.remove(sqlKey);
	}

	/**
	 * Deletes the custom query from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customQuery the custom query
	 * @return the custom query that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CustomQuery deleteCustomQuery(CustomQuery customQuery) {
		return customQueryPersistence.remove(customQuery);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CustomQuery.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return customQueryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.liferay.model.impl.CustomQueryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return customQueryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.liferay.model.impl.CustomQueryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return customQueryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return customQueryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return customQueryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CustomQuery fetchCustomQuery(String sqlKey) {
		return customQueryPersistence.fetchByPrimaryKey(sqlKey);
	}

	/**
	 * Returns the custom query with the primary key.
	 *
	 * @param sqlKey the primary key of the custom query
	 * @return the custom query
	 * @throws PortalException if a custom query with the primary key could not be found
	 */
	@Override
	public CustomQuery getCustomQuery(String sqlKey) throws PortalException {
		return customQueryPersistence.findByPrimaryKey(sqlKey);
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return customQueryPersistence.create((String)primaryKeyObj);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return customQueryLocalService.deleteCustomQuery(
			(CustomQuery)persistedModel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return customQueryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the custom queries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.liferay.model.impl.CustomQueryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom queries
	 * @param end the upper bound of the range of custom queries (not inclusive)
	 * @return the range of custom queries
	 */
	@Override
	public List<CustomQuery> getCustomQueries(int start, int end) {
		return customQueryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of custom queries.
	 *
	 * @return the number of custom queries
	 */
	@Override
	public int getCustomQueriesCount() {
		return customQueryPersistence.countAll();
	}

	/**
	 * Updates the custom query in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param customQuery the custom query
	 * @return the custom query that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CustomQuery updateCustomQuery(CustomQuery customQuery) {
		return customQueryPersistence.update(customQuery);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CustomQueryLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		customQueryLocalService = (CustomQueryLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CustomQueryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CustomQuery.class;
	}

	protected String getModelClassName() {
		return CustomQuery.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = customQueryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	protected CustomQueryLocalService customQueryLocalService;

	@Reference
	protected CustomQueryPersistence customQueryPersistence;

	@Reference
	protected CustomQueryFinder customQueryFinder;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}