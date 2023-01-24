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

package com.medicaid.app.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Referral. This utility wraps
 * <code>com.medicaid.app.service.impl.ReferralLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ReferralLocalService
 * @generated
 */
public class ReferralLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.medicaid.app.service.impl.ReferralLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the referral to the database. Also notifies the appropriate model listeners.
	 *
	 * @param referral the referral
	 * @return the referral that was added
	 */
	public static com.medicaid.app.model.Referral addReferral(
		com.medicaid.app.model.Referral referral) {

		return getService().addReferral(referral);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new referral with the primary key. Does not add the referral to the database.
	 *
	 * @param referralId the primary key for the new referral
	 * @return the new referral
	 */
	public static com.medicaid.app.model.Referral createReferral(
		long referralId) {

		return getService().createReferral(referralId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the referral with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param referralId the primary key of the referral
	 * @return the referral that was removed
	 * @throws PortalException if a referral with the primary key could not be found
	 */
	public static com.medicaid.app.model.Referral deleteReferral(
			long referralId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteReferral(referralId);
	}

	/**
	 * Deletes the referral from the database. Also notifies the appropriate model listeners.
	 *
	 * @param referral the referral
	 * @return the referral that was removed
	 */
	public static com.medicaid.app.model.Referral deleteReferral(
		com.medicaid.app.model.Referral referral) {

		return getService().deleteReferral(referral);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.app.model.impl.ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.app.model.impl.ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.medicaid.app.model.Referral fetchReferral(
		long referralId) {

		return getService().fetchReferral(referralId);
	}

	public static java.util.List<com.medicaid.app.model.Referral> findByStatus(
		String status) {

		return getService().findByStatus(status);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the referral with the primary key.
	 *
	 * @param referralId the primary key of the referral
	 * @return the referral
	 * @throws PortalException if a referral with the primary key could not be found
	 */
	public static com.medicaid.app.model.Referral getReferral(long referralId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getReferral(referralId);
	}

	/**
	 * Returns a range of all the referrals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.medicaid.app.model.impl.ReferralModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of referrals
	 * @param end the upper bound of the range of referrals (not inclusive)
	 * @return the range of referrals
	 */
	public static java.util.List<com.medicaid.app.model.Referral> getReferrals(
		int start, int end) {

		return getService().getReferrals(start, end);
	}

	/**
	 * Returns the number of referrals.
	 *
	 * @return the number of referrals
	 */
	public static int getReferralsCount() {
		return getService().getReferralsCount();
	}

	/**
	 * Updates the referral in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param referral the referral
	 * @return the referral that was updated
	 */
	public static com.medicaid.app.model.Referral updateReferral(
		com.medicaid.app.model.Referral referral) {

		return getService().updateReferral(referral);
	}

	public static ReferralLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ReferralLocalService, ReferralLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ReferralLocalService.class);

		ServiceTracker<ReferralLocalService, ReferralLocalService>
			serviceTracker =
				new ServiceTracker<ReferralLocalService, ReferralLocalService>(
					bundle.getBundleContext(), ReferralLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}