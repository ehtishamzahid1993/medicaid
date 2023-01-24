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

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.medicaid.app.model.FacilityAdmin;
import com.medicaid.app.model.FacilityAdminModel;
import com.medicaid.app.model.FacilityAdminSoap;

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
 * The base model implementation for the FacilityAdmin service. Represents a row in the &quot;Medicaid_FacilityAdmin&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FacilityAdminModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FacilityAdminImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacilityAdminImpl
 * @generated
 */
@JSON(strict = true)
public class FacilityAdminModelImpl
	extends BaseModelImpl<FacilityAdmin> implements FacilityAdminModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a facility admin model instance should use the <code>FacilityAdmin</code> interface instead.
	 */
	public static final String TABLE_NAME = "Medicaid_FacilityAdmin";

	public static final Object[][] TABLE_COLUMNS = {
		{"userName", Types.VARCHAR}, {"email", Types.VARCHAR},
		{"firstName", Types.VARCHAR}, {"lastName", Types.VARCHAR},
		{"phoneNumber", Types.BIGINT}, {"title", Types.VARCHAR},
		{"facilityIds", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"createdBy", Types.VARCHAR}, {"modifiedDate", Types.TIMESTAMP},
		{"modifiedBy", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("phoneNumber", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("facilityIds", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Medicaid_FacilityAdmin (userName VARCHAR(75) not null primary key,email VARCHAR(75) null,firstName VARCHAR(75) null,lastName VARCHAR(75) null,phoneNumber LONG,title VARCHAR(75) null,facilityIds VARCHAR(75) null,createDate DATE null,createdBy VARCHAR(75) null,modifiedDate DATE null,modifiedBy VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table Medicaid_FacilityAdmin";

	public static final String ORDER_BY_JPQL =
		" ORDER BY facilityAdmin.userName ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Medicaid_FacilityAdmin.userName ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

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
	public static FacilityAdmin toModel(FacilityAdminSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		FacilityAdmin model = new FacilityAdminImpl();

		model.setUserName(soapModel.getUserName());
		model.setEmail(soapModel.getEmail());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());
		model.setPhoneNumber(soapModel.getPhoneNumber());
		model.setTitle(soapModel.getTitle());
		model.setFacilityIds(soapModel.getFacilityIds());
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
	public static List<FacilityAdmin> toModels(FacilityAdminSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<FacilityAdmin> models = new ArrayList<FacilityAdmin>(
			soapModels.length);

		for (FacilityAdminSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public FacilityAdminModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _userName;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setUserName(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userName;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return FacilityAdmin.class;
	}

	@Override
	public String getModelClassName() {
		return FacilityAdmin.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<FacilityAdmin, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<FacilityAdmin, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FacilityAdmin, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((FacilityAdmin)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<FacilityAdmin, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<FacilityAdmin, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(FacilityAdmin)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<FacilityAdmin, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<FacilityAdmin, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, FacilityAdmin>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			FacilityAdmin.class.getClassLoader(), FacilityAdmin.class,
			ModelWrapper.class);

		try {
			Constructor<FacilityAdmin> constructor =
				(Constructor<FacilityAdmin>)proxyClass.getConstructor(
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

	private static final Map<String, Function<FacilityAdmin, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<FacilityAdmin, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<FacilityAdmin, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<FacilityAdmin, Object>>();
		Map<String, BiConsumer<FacilityAdmin, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<FacilityAdmin, ?>>();

		attributeGetterFunctions.put("userName", FacilityAdmin::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<FacilityAdmin, String>)FacilityAdmin::setUserName);
		attributeGetterFunctions.put("email", FacilityAdmin::getEmail);
		attributeSetterBiConsumers.put(
			"email",
			(BiConsumer<FacilityAdmin, String>)FacilityAdmin::setEmail);
		attributeGetterFunctions.put("firstName", FacilityAdmin::getFirstName);
		attributeSetterBiConsumers.put(
			"firstName",
			(BiConsumer<FacilityAdmin, String>)FacilityAdmin::setFirstName);
		attributeGetterFunctions.put("lastName", FacilityAdmin::getLastName);
		attributeSetterBiConsumers.put(
			"lastName",
			(BiConsumer<FacilityAdmin, String>)FacilityAdmin::setLastName);
		attributeGetterFunctions.put(
			"phoneNumber", FacilityAdmin::getPhoneNumber);
		attributeSetterBiConsumers.put(
			"phoneNumber",
			(BiConsumer<FacilityAdmin, Long>)FacilityAdmin::setPhoneNumber);
		attributeGetterFunctions.put("title", FacilityAdmin::getTitle);
		attributeSetterBiConsumers.put(
			"title",
			(BiConsumer<FacilityAdmin, String>)FacilityAdmin::setTitle);
		attributeGetterFunctions.put(
			"facilityIds", FacilityAdmin::getFacilityIds);
		attributeSetterBiConsumers.put(
			"facilityIds",
			(BiConsumer<FacilityAdmin, String>)FacilityAdmin::setFacilityIds);
		attributeGetterFunctions.put(
			"createDate", FacilityAdmin::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<FacilityAdmin, Date>)FacilityAdmin::setCreateDate);
		attributeGetterFunctions.put("createdBy", FacilityAdmin::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<FacilityAdmin, String>)FacilityAdmin::setCreatedBy);
		attributeGetterFunctions.put(
			"modifiedDate", FacilityAdmin::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<FacilityAdmin, Date>)FacilityAdmin::setModifiedDate);
		attributeGetterFunctions.put(
			"modifiedBy", FacilityAdmin::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<FacilityAdmin, String>)FacilityAdmin::setModifiedBy);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return "";
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return "";
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@JSON
	@Override
	public long getPhoneNumber() {
		return _phoneNumber;
	}

	@Override
	public void setPhoneNumber(long phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@JSON
	@Override
	public String getFacilityIds() {
		if (_facilityIds == null) {
			return "";
		}
		else {
			return _facilityIds;
		}
	}

	@Override
	public void setFacilityIds(String facilityIds) {
		_facilityIds = facilityIds;
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

	@Override
	public FacilityAdmin toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, FacilityAdmin>
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
		FacilityAdminImpl facilityAdminImpl = new FacilityAdminImpl();

		facilityAdminImpl.setUserName(getUserName());
		facilityAdminImpl.setEmail(getEmail());
		facilityAdminImpl.setFirstName(getFirstName());
		facilityAdminImpl.setLastName(getLastName());
		facilityAdminImpl.setPhoneNumber(getPhoneNumber());
		facilityAdminImpl.setTitle(getTitle());
		facilityAdminImpl.setFacilityIds(getFacilityIds());
		facilityAdminImpl.setCreateDate(getCreateDate());
		facilityAdminImpl.setCreatedBy(getCreatedBy());
		facilityAdminImpl.setModifiedDate(getModifiedDate());
		facilityAdminImpl.setModifiedBy(getModifiedBy());

		facilityAdminImpl.resetOriginalValues();

		return facilityAdminImpl;
	}

	@Override
	public int compareTo(FacilityAdmin facilityAdmin) {
		String primaryKey = facilityAdmin.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FacilityAdmin)) {
			return false;
		}

		FacilityAdmin facilityAdmin = (FacilityAdmin)obj;

		String primaryKey = facilityAdmin.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
		FacilityAdminModelImpl facilityAdminModelImpl = this;

		facilityAdminModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<FacilityAdmin> toCacheModel() {
		FacilityAdminCacheModel facilityAdminCacheModel =
			new FacilityAdminCacheModel();

		facilityAdminCacheModel.userName = getUserName();

		String userName = facilityAdminCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			facilityAdminCacheModel.userName = null;
		}

		facilityAdminCacheModel.email = getEmail();

		String email = facilityAdminCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			facilityAdminCacheModel.email = null;
		}

		facilityAdminCacheModel.firstName = getFirstName();

		String firstName = facilityAdminCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			facilityAdminCacheModel.firstName = null;
		}

		facilityAdminCacheModel.lastName = getLastName();

		String lastName = facilityAdminCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			facilityAdminCacheModel.lastName = null;
		}

		facilityAdminCacheModel.phoneNumber = getPhoneNumber();

		facilityAdminCacheModel.title = getTitle();

		String title = facilityAdminCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			facilityAdminCacheModel.title = null;
		}

		facilityAdminCacheModel.facilityIds = getFacilityIds();

		String facilityIds = facilityAdminCacheModel.facilityIds;

		if ((facilityIds != null) && (facilityIds.length() == 0)) {
			facilityAdminCacheModel.facilityIds = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			facilityAdminCacheModel.createDate = createDate.getTime();
		}
		else {
			facilityAdminCacheModel.createDate = Long.MIN_VALUE;
		}

		facilityAdminCacheModel.createdBy = getCreatedBy();

		String createdBy = facilityAdminCacheModel.createdBy;

		if ((createdBy != null) && (createdBy.length() == 0)) {
			facilityAdminCacheModel.createdBy = null;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			facilityAdminCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			facilityAdminCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		facilityAdminCacheModel.modifiedBy = getModifiedBy();

		String modifiedBy = facilityAdminCacheModel.modifiedBy;

		if ((modifiedBy != null) && (modifiedBy.length() == 0)) {
			facilityAdminCacheModel.modifiedBy = null;
		}

		return facilityAdminCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<FacilityAdmin, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<FacilityAdmin, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FacilityAdmin, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((FacilityAdmin)this));
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
		Map<String, Function<FacilityAdmin, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<FacilityAdmin, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FacilityAdmin, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((FacilityAdmin)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, FacilityAdmin>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _userName;
	private String _email;
	private String _firstName;
	private String _lastName;
	private long _phoneNumber;
	private String _title;
	private String _facilityIds;
	private Date _createDate;
	private String _createdBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _modifiedBy;
	private FacilityAdmin _escapedModel;

}