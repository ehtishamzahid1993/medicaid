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

package com.medicaid.app.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.medicaid.app.model.Referral;
import com.medicaid.app.model.ReferralModel;
import com.medicaid.app.model.ReferralSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Referral service. Represents a row in the &quot;Medicaid_Referral&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ReferralModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ReferralImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReferralImpl
 * @generated
 */
@JSON(strict = true)
public class ReferralModelImpl
	extends BaseModelImpl<Referral> implements ReferralModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a referral model instance should use the <code>Referral</code> interface instead.
	 */
	public static final String TABLE_NAME = "Medicaid_Referral";

	public static final Object[][] TABLE_COLUMNS = {
		{"referralId", Types.BIGINT}, {"dateReferred", Types.TIMESTAMP},
		{"submitDate", Types.TIMESTAMP}, {"approvedDate", Types.TIMESTAMP},
		{"pendingDate", Types.TIMESTAMP}, {"status", Types.VARCHAR},
		{"cocEmailSent", Types.VARCHAR}, {"resLiability", Types.VARCHAR},
		{"emailSentDueDate", Types.TIMESTAMP}, {"facilityAdmin", Types.VARCHAR},
		{"facilities", Types.VARCHAR}, {"patientId", Types.BIGINT},
		{"noteId", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"createdBy", Types.VARCHAR}, {"modifiedDate", Types.TIMESTAMP},
		{"modifiedBy", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("referralId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dateReferred", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("submitDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("approvedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("pendingDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cocEmailSent", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("resLiability", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("emailSentDueDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("facilityAdmin", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("facilities", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("patientId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("noteId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Medicaid_Referral (referralId LONG not null primary key,dateReferred DATE null,submitDate DATE null,approvedDate DATE null,pendingDate DATE null,status VARCHAR(75) null,cocEmailSent VARCHAR(75) null,resLiability VARCHAR(75) null,emailSentDueDate DATE null,facilityAdmin VARCHAR(75) null,facilities VARCHAR(75) null,patientId LONG,noteId LONG,createDate DATE null,createdBy VARCHAR(75) null,modifiedDate DATE null,modifiedBy VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table Medicaid_Referral";

	public static final String ORDER_BY_JPQL =
		" ORDER BY referral.referralId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Medicaid_Referral.referralId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long STATUS_COLUMN_BITMASK = 1L;

	public static final long REFERRALID_COLUMN_BITMASK = 2L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Referral toModel(ReferralSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Referral model = new ReferralImpl();

		model.setReferralId(soapModel.getReferralId());
		model.setDateReferred(soapModel.getDateReferred());
		model.setSubmitDate(soapModel.getSubmitDate());
		model.setApprovedDate(soapModel.getApprovedDate());
		model.setPendingDate(soapModel.getPendingDate());
		model.setStatus(soapModel.getStatus());
		model.setCocEmailSent(soapModel.getCocEmailSent());
		model.setResLiability(soapModel.getResLiability());
		model.setEmailSentDueDate(soapModel.getEmailSentDueDate());
		model.setFacilityAdmin(soapModel.getFacilityAdmin());
		model.setFacilities(soapModel.getFacilities());
		model.setPatientId(soapModel.getPatientId());
		model.setNoteId(soapModel.getNoteId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setModifiedBy(soapModel.getModifiedBy());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Referral> toModels(ReferralSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Referral> models = new ArrayList<Referral>(soapModels.length);

		for (ReferralSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ReferralModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _referralId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setReferralId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _referralId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Referral.class;
	}

	@Override
	public String getModelClassName() {
		return Referral.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Referral, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Referral, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Referral, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Referral)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Referral, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Referral, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Referral)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Referral, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Referral, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Referral>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Referral.class.getClassLoader(), Referral.class,
			ModelWrapper.class);

		try {
			Constructor<Referral> constructor =
				(Constructor<Referral>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Referral, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Referral, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Referral, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Referral, Object>>();
		Map<String, BiConsumer<Referral, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Referral, ?>>();

		attributeGetterFunctions.put("referralId", Referral::getReferralId);
		attributeSetterBiConsumers.put(
			"referralId", (BiConsumer<Referral, Long>)Referral::setReferralId);
		attributeGetterFunctions.put("dateReferred", Referral::getDateReferred);
		attributeSetterBiConsumers.put(
			"dateReferred",
			(BiConsumer<Referral, Date>)Referral::setDateReferred);
		attributeGetterFunctions.put("submitDate", Referral::getSubmitDate);
		attributeSetterBiConsumers.put(
			"submitDate", (BiConsumer<Referral, Date>)Referral::setSubmitDate);
		attributeGetterFunctions.put("approvedDate", Referral::getApprovedDate);
		attributeSetterBiConsumers.put(
			"approvedDate",
			(BiConsumer<Referral, Date>)Referral::setApprovedDate);
		attributeGetterFunctions.put("pendingDate", Referral::getPendingDate);
		attributeSetterBiConsumers.put(
			"pendingDate",
			(BiConsumer<Referral, Date>)Referral::setPendingDate);
		attributeGetterFunctions.put("status", Referral::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<Referral, String>)Referral::setStatus);
		attributeGetterFunctions.put("cocEmailSent", Referral::getCocEmailSent);
		attributeSetterBiConsumers.put(
			"cocEmailSent",
			(BiConsumer<Referral, String>)Referral::setCocEmailSent);
		attributeGetterFunctions.put("resLiability", Referral::getResLiability);
		attributeSetterBiConsumers.put(
			"resLiability",
			(BiConsumer<Referral, String>)Referral::setResLiability);
		attributeGetterFunctions.put(
			"emailSentDueDate", Referral::getEmailSentDueDate);
		attributeSetterBiConsumers.put(
			"emailSentDueDate",
			(BiConsumer<Referral, Date>)Referral::setEmailSentDueDate);
		attributeGetterFunctions.put(
			"facilityAdmin", Referral::getFacilityAdmin);
		attributeSetterBiConsumers.put(
			"facilityAdmin",
			(BiConsumer<Referral, String>)Referral::setFacilityAdmin);
		attributeGetterFunctions.put("facilities", Referral::getFacilities);
		attributeSetterBiConsumers.put(
			"facilities",
			(BiConsumer<Referral, String>)Referral::setFacilities);
		attributeGetterFunctions.put("patientId", Referral::getPatientId);
		attributeSetterBiConsumers.put(
			"patientId", (BiConsumer<Referral, Long>)Referral::setPatientId);
		attributeGetterFunctions.put("noteId", Referral::getNoteId);
		attributeSetterBiConsumers.put(
			"noteId", (BiConsumer<Referral, Long>)Referral::setNoteId);
		attributeGetterFunctions.put("createDate", Referral::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Referral, Date>)Referral::setCreateDate);
		attributeGetterFunctions.put("createdBy", Referral::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy", (BiConsumer<Referral, String>)Referral::setCreatedBy);
		attributeGetterFunctions.put("modifiedDate", Referral::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Referral, Date>)Referral::setModifiedDate);
		attributeGetterFunctions.put("modifiedBy", Referral::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<Referral, String>)Referral::setModifiedBy);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getReferralId() {
		return _referralId;
	}

	@Override
	public void setReferralId(long referralId) {
		_referralId = referralId;
	}

	@JSON
	@Override
	public Date getDateReferred() {
		return _dateReferred;
	}

	@Override
	public void setDateReferred(Date dateReferred) {
		_dateReferred = dateReferred;
	}

	@JSON
	@Override
	public Date getSubmitDate() {
		return _submitDate;
	}

	@Override
	public void setSubmitDate(Date submitDate) {
		_submitDate = submitDate;
	}

	@JSON
	@Override
	public Date getApprovedDate() {
		return _approvedDate;
	}

	@Override
	public void setApprovedDate(Date approvedDate) {
		_approvedDate = approvedDate;
	}

	@JSON
	@Override
	public Date getPendingDate() {
		return _pendingDate;
	}

	@Override
	public void setPendingDate(Date pendingDate) {
		_pendingDate = pendingDate;
	}

	@JSON
	@Override
	public String getStatus() {
		if (_status == null) {
			return "";
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (_originalStatus == null) {
			_originalStatus = _status;
		}

		_status = status;
	}

	public String getOriginalStatus() {
		return GetterUtil.getString(_originalStatus);
	}

	@JSON
	@Override
	public String getCocEmailSent() {
		if (_cocEmailSent == null) {
			return "";
		}
		else {
			return _cocEmailSent;
		}
	}

	@Override
	public void setCocEmailSent(String cocEmailSent) {
		_cocEmailSent = cocEmailSent;
	}

	@JSON
	@Override
	public String getResLiability() {
		if (_resLiability == null) {
			return "";
		}
		else {
			return _resLiability;
		}
	}

	@Override
	public void setResLiability(String resLiability) {
		_resLiability = resLiability;
	}

	@JSON
	@Override
	public Date getEmailSentDueDate() {
		return _emailSentDueDate;
	}

	@Override
	public void setEmailSentDueDate(Date emailSentDueDate) {
		_emailSentDueDate = emailSentDueDate;
	}

	@JSON
	@Override
	public String getFacilityAdmin() {
		if (_facilityAdmin == null) {
			return "";
		}
		else {
			return _facilityAdmin;
		}
	}

	@Override
	public void setFacilityAdmin(String facilityAdmin) {
		_facilityAdmin = facilityAdmin;
	}

	@JSON
	@Override
	public String getFacilities() {
		if (_facilities == null) {
			return "";
		}
		else {
			return _facilities;
		}
	}

	@Override
	public void setFacilities(String facilities) {
		_facilities = facilities;
	}

	@JSON
	@Override
	public long getPatientId() {
		return _patientId;
	}

	@Override
	public void setPatientId(long patientId) {
		_patientId = patientId;
	}

	@JSON
	@Override
	public long getNoteId() {
		return _noteId;
	}

	@Override
	public void setNoteId(long noteId) {
		_noteId = noteId;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public String getCreatedBy() {
		if (_createdBy == null) {
			return "";
		}
		else {
			return _createdBy;
		}
	}

	@Override
	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getModifiedBy() {
		if (_modifiedBy == null) {
			return "";
		}
		else {
			return _modifiedBy;
		}
	}

	@Override
	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Referral.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Referral toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Referral>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ReferralImpl referralImpl = new ReferralImpl();

		referralImpl.setReferralId(getReferralId());
		referralImpl.setDateReferred(getDateReferred());
		referralImpl.setSubmitDate(getSubmitDate());
		referralImpl.setApprovedDate(getApprovedDate());
		referralImpl.setPendingDate(getPendingDate());
		referralImpl.setStatus(getStatus());
		referralImpl.setCocEmailSent(getCocEmailSent());
		referralImpl.setResLiability(getResLiability());
		referralImpl.setEmailSentDueDate(getEmailSentDueDate());
		referralImpl.setFacilityAdmin(getFacilityAdmin());
		referralImpl.setFacilities(getFacilities());
		referralImpl.setPatientId(getPatientId());
		referralImpl.setNoteId(getNoteId());
		referralImpl.setCreateDate(getCreateDate());
		referralImpl.setCreatedBy(getCreatedBy());
		referralImpl.setModifiedDate(getModifiedDate());
		referralImpl.setModifiedBy(getModifiedBy());

		referralImpl.resetOriginalValues();

		return referralImpl;
	}

	@Override
	public int compareTo(Referral referral) {
		long primaryKey = referral.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Referral)) {
			return false;
		}

		Referral referral = (Referral)obj;

		long primaryKey = referral.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		ReferralModelImpl referralModelImpl = this;

		referralModelImpl._originalStatus = referralModelImpl._status;

		referralModelImpl._setModifiedDate = false;

		referralModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Referral> toCacheModel() {
		ReferralCacheModel referralCacheModel = new ReferralCacheModel();

		referralCacheModel.referralId = getReferralId();

		Date dateReferred = getDateReferred();

		if (dateReferred != null) {
			referralCacheModel.dateReferred = dateReferred.getTime();
		}
		else {
			referralCacheModel.dateReferred = Long.MIN_VALUE;
		}

		Date submitDate = getSubmitDate();

		if (submitDate != null) {
			referralCacheModel.submitDate = submitDate.getTime();
		}
		else {
			referralCacheModel.submitDate = Long.MIN_VALUE;
		}

		Date approvedDate = getApprovedDate();

		if (approvedDate != null) {
			referralCacheModel.approvedDate = approvedDate.getTime();
		}
		else {
			referralCacheModel.approvedDate = Long.MIN_VALUE;
		}

		Date pendingDate = getPendingDate();

		if (pendingDate != null) {
			referralCacheModel.pendingDate = pendingDate.getTime();
		}
		else {
			referralCacheModel.pendingDate = Long.MIN_VALUE;
		}

		referralCacheModel.status = getStatus();

		String status = referralCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			referralCacheModel.status = null;
		}

		referralCacheModel.cocEmailSent = getCocEmailSent();

		String cocEmailSent = referralCacheModel.cocEmailSent;

		if ((cocEmailSent != null) && (cocEmailSent.length() == 0)) {
			referralCacheModel.cocEmailSent = null;
		}

		referralCacheModel.resLiability = getResLiability();

		String resLiability = referralCacheModel.resLiability;

		if ((resLiability != null) && (resLiability.length() == 0)) {
			referralCacheModel.resLiability = null;
		}

		Date emailSentDueDate = getEmailSentDueDate();

		if (emailSentDueDate != null) {
			referralCacheModel.emailSentDueDate = emailSentDueDate.getTime();
		}
		else {
			referralCacheModel.emailSentDueDate = Long.MIN_VALUE;
		}

		referralCacheModel.facilityAdmin = getFacilityAdmin();

		String facilityAdmin = referralCacheModel.facilityAdmin;

		if ((facilityAdmin != null) && (facilityAdmin.length() == 0)) {
			referralCacheModel.facilityAdmin = null;
		}

		referralCacheModel.facilities = getFacilities();

		String facilities = referralCacheModel.facilities;

		if ((facilities != null) && (facilities.length() == 0)) {
			referralCacheModel.facilities = null;
		}

		referralCacheModel.patientId = getPatientId();

		referralCacheModel.noteId = getNoteId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			referralCacheModel.createDate = createDate.getTime();
		}
		else {
			referralCacheModel.createDate = Long.MIN_VALUE;
		}

		referralCacheModel.createdBy = getCreatedBy();

		String createdBy = referralCacheModel.createdBy;

		if ((createdBy != null) && (createdBy.length() == 0)) {
			referralCacheModel.createdBy = null;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			referralCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			referralCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		referralCacheModel.modifiedBy = getModifiedBy();

		String modifiedBy = referralCacheModel.modifiedBy;

		if ((modifiedBy != null) && (modifiedBy.length() == 0)) {
			referralCacheModel.modifiedBy = null;
		}

		return referralCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Referral, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Referral, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Referral, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Referral)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Referral, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Referral, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Referral, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Referral)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Referral>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _referralId;
	private Date _dateReferred;
	private Date _submitDate;
	private Date _approvedDate;
	private Date _pendingDate;
	private String _status;
	private String _originalStatus;
	private String _cocEmailSent;
	private String _resLiability;
	private Date _emailSentDueDate;
	private String _facilityAdmin;
	private String _facilities;
	private long _patientId;
	private long _noteId;
	private Date _createDate;
	private String _createdBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _modifiedBy;
	private long _columnBitmask;
	private Referral _escapedModel;

}