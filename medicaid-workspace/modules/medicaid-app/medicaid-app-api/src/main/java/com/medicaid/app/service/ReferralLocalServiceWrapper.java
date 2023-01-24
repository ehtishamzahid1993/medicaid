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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReferralLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReferralLocalService
 * @generated
 */
public class ReferralLocalServiceWrapper
	implements ReferralLocalService, ServiceWrapper<ReferralLocalService> {

	public ReferralLocalServiceWrapper(
		ReferralLocalService referralLocalService) {

		_referralLocalService = referralLocalService;
	}

	/**
	 * Adds the referral to the database. Also notifies the appropriate model listeners.
	 *
	 * @param referral the referral
	 * @return the referral that was added
	 */
	@Override
	public com.medicaid.app.model.Referral addReferral(
		com.medicaid.app.model.Referral referral) {

		return _referralLocalService.addReferral(referral);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _referralLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new referral with the primary key. Does not add the referral to the database.
	 *
	 * @param referralId the primary key for the new referral
	 * @return the new referral
	 */
	@Override
	public com.medicaid.app.model.Referral createReferral(long referralId) {
		return _referralLocalService.createReferral(referralId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _referralLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the referral with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param referralId the primary key of the referral
	 * @return the referral that was removed
	 * @throws PortalException if a referral with the primary key could not be found
	 */
	@Override
	public com.medicaid.app.model.Referral deleteReferral(long referralId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _referralLocalService.deleteReferral(referralId);
	}

	/**
	 * Deletes the referral from the database. Also notifies the appropriate model listeners.
	 *
	 * @param referral the referral
	 * @return the referral that was removed
	 */
	@Override
	public com.medicaid.app.model.Referral deleteReferral(
		com.medicaid.app.model.Referral referral) {

		return _referralLocalService.deleteReferral(referral);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _referralLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _referralLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _referralLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _referralLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _referralLocalService.dynamicQueryCount(dynamicQuery);
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _referralLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.medicaid.app.model.Referral fetchReferral(long referralId) {
		return _referralLocalService.fetchReferral(referralId);
	}

	@Override
	public java.util.List<com.medicaid.app.model.Referral> findByStatus(
		String status) {

		return _referralLocalService.findByStatus(status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _referralLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _referralLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _referralLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _referralLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the referral with the primary key.
	 *
	 * @param referralId the primary key of the referral
	 * @return the referral
	 * @throws PortalException if a referral with the primary key could not be found
	 */
	@Override
	public com.medicaid.app.model.Referral getReferral(long referralId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _referralLocalService.getReferral(referralId);
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
	@Override
	public java.util.List<com.medicaid.app.model.Referral> getReferrals(
		int start, int end) {

		return _referralLocalService.getReferrals(start, end);
	}

	/**
	 * Returns the number of referrals.
	 *
	 * @return the number of referrals
	 */
	@Override
	public int getReferralsCount() {
		return _referralLocalService.getReferralsCount();
	}

	/**
	 * Updates the referral in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param referral the referral
	 * @return the referral that was updated
	 */
	@Override
	public com.medicaid.app.model.Referral updateReferral(
		com.medicaid.app.model.Referral referral) {

		return _referralLocalService.updateReferral(referral);
	}

	@Override
	public ReferralLocalService getWrappedService() {
		return _referralLocalService;
	}

	@Override
	public void setWrappedService(ReferralLocalService referralLocalService) {
		_referralLocalService = referralLocalService;
	}

	private ReferralLocalService _referralLocalService;

}