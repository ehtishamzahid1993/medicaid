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

package com.medicaid.app.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
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

import com.medicaid.app.model.Facility;
import com.medicaid.app.service.FacilityLocalService;
import com.medicaid.app.service.persistence.FacilityAdminPersistence;
import com.medicaid.app.service.persistence.FacilityPersistence;
import com.medicaid.app.service.persistence.NotePersistence;
import com.medicaid.app.service.persistence.PatientPersistence;
import com.medicaid.app.service.persistence.ReferralPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the facility local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.medicaid.app.service.impl.FacilityLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.medicaid.app.service.impl.FacilityLocalServiceImpl
 * @generated
 */
public abstract class FacilityLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, FacilityLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>FacilityLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.medicaid.app.service.FacilityLocalServiceUtil</code>.
	 */

	/**
	 * Adds the facility to the database. Also notifies the appropriate model listeners.
	 *
	 * @param facility the facility
	 * @return the facility that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Facility addFacility(Facility facility) {
		facility.setNew(true);

		return facilityPersistence.update(facility);
	}

	/**
	 * Creates a new facility with the primary key. Does not add the facility to the database.
	 *
	 * @param facilityId the primary key for the new facility
	 * @return the new facility
	 */
	@Override
	@Transactional(enabled = false)
	public Facility createFacility(long facilityId) {
		return facilityPersistence.create(facilityId);
	}

	/**
	 * Deletes the facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility that was removed
	 * @throws PortalException if a facility with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Facility deleteFacility(long facilityId) throws PortalException {
		return facilityPersistence.remove(facilityId);
	}

	/**
	 * Deletes the facility from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facility the facility
	 * @return the facility that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Facility deleteFacility(Facility facility) {
		return facilityPersistence.remove(facility);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Facility.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return facilityPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.app.model.impl.FacilityModelImpl</code>.
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

		return facilityPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.app.model.impl.FacilityModelImpl</code>.
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

		return facilityPersistence.findWithDynamicQuery(
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
		return facilityPersistence.countWithDynamicQuery(dynamicQuery);
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

		return facilityPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Facility fetchFacility(long facilityId) {
		return facilityPersistence.fetchByPrimaryKey(facilityId);
	}

	/**
	 * Returns the facility with the primary key.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility
	 * @throws PortalException if a facility with the primary key could not be found
	 */
	@Override
	public Facility getFacility(long facilityId) throws PortalException {
		return facilityPersistence.findByPrimaryKey(facilityId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(facilityLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Facility.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("facilityId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			facilityLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Facility.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("facilityId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(facilityLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Facility.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("facilityId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return facilityPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return facilityLocalService.deleteFacility((Facility)persistedModel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return facilityPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.app.model.impl.FacilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @return the range of facilities
	 */
	@Override
	public List<Facility> getFacilities(int start, int end) {
		return facilityPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of facilities.
	 *
	 * @return the number of facilities
	 */
	@Override
	public int getFacilitiesCount() {
		return facilityPersistence.countAll();
	}

	/**
	 * Updates the facility in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param facility the facility
	 * @return the facility that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Facility updateFacility(Facility facility) {
		return facilityPersistence.update(facility);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			FacilityLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		facilityLocalService = (FacilityLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return FacilityLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Facility.class;
	}

	protected String getModelClassName() {
		return Facility.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = facilityPersistence.getDataSource();

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

	protected FacilityLocalService facilityLocalService;

	@Reference
	protected FacilityPersistence facilityPersistence;

	@Reference
	protected FacilityAdminPersistence facilityAdminPersistence;

	@Reference
	protected NotePersistence notePersistence;

	@Reference
	protected PatientPersistence patientPersistence;

	@Reference
	protected ReferralPersistence referralPersistence;

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