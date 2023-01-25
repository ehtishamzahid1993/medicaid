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
import com.liferay.portal.kernel.util.ProxyUtil;

import com.medicaid.app.model.Document;
import com.medicaid.app.model.DocumentModel;
import com.medicaid.app.model.DocumentSoap;

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
 * The base model implementation for the Document service. Represents a row in the &quot;Medicaid_Document&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DocumentModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DocumentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentImpl
 * @generated
 */
@JSON(strict = true)
public class DocumentModelImpl
	extends BaseModelImpl<Document> implements DocumentModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a document model instance should use the <code>Document</code> interface instead.
	 */
	public static final String TABLE_NAME = "Medicaid_Document";

	public static final Object[][] TABLE_COLUMNS = {
		{"documentId", Types.BIGINT}, {"docName", Types.VARCHAR},
		{"fileId", Types.BIGINT}, {"fileUrl", Types.VARCHAR},
		{"patientId", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"createdBy", Types.VARCHAR}, {"modifiedDate", Types.TIMESTAMP},
		{"modifiedBy", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("documentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("docName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileUrl", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("patientId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Medicaid_Document (documentId LONG not null primary key,docName VARCHAR(75) null,fileId LONG,fileUrl VARCHAR(75) null,patientId LONG,createDate DATE null,createdBy VARCHAR(75) null,modifiedDate DATE null,modifiedBy VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table Medicaid_Document";

	public static final String ORDER_BY_JPQL =
		" ORDER BY document.documentId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Medicaid_Document.documentId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long PATIENTID_COLUMN_BITMASK = 1L;

	public static final long DOCUMENTID_COLUMN_BITMASK = 2L;

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
	public static Document toModel(DocumentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Document model = new DocumentImpl();

		model.setDocumentId(soapModel.getDocumentId());
		model.setDocName(soapModel.getDocName());
		model.setFileId(soapModel.getFileId());
		model.setFileUrl(soapModel.getFileUrl());
		model.setPatientId(soapModel.getPatientId());
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
	public static List<Document> toModels(DocumentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Document> models = new ArrayList<Document>(soapModels.length);

		for (DocumentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public DocumentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _documentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDocumentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _documentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Document.class;
	}

	@Override
	public String getModelClassName() {
		return Document.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Document, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Document, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Document, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Document)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Document, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Document, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Document)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Document, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Document, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Document>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Document.class.getClassLoader(), Document.class,
			ModelWrapper.class);

		try {
			Constructor<Document> constructor =
				(Constructor<Document>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Document, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Document, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Document, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Document, Object>>();
		Map<String, BiConsumer<Document, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Document, ?>>();

		attributeGetterFunctions.put("documentId", Document::getDocumentId);
		attributeSetterBiConsumers.put(
			"documentId", (BiConsumer<Document, Long>)Document::setDocumentId);
		attributeGetterFunctions.put("docName", Document::getDocName);
		attributeSetterBiConsumers.put(
			"docName", (BiConsumer<Document, String>)Document::setDocName);
		attributeGetterFunctions.put("fileId", Document::getFileId);
		attributeSetterBiConsumers.put(
			"fileId", (BiConsumer<Document, Long>)Document::setFileId);
		attributeGetterFunctions.put("fileUrl", Document::getFileUrl);
		attributeSetterBiConsumers.put(
			"fileUrl", (BiConsumer<Document, String>)Document::setFileUrl);
		attributeGetterFunctions.put("patientId", Document::getPatientId);
		attributeSetterBiConsumers.put(
			"patientId", (BiConsumer<Document, Long>)Document::setPatientId);
		attributeGetterFunctions.put("createDate", Document::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Document, Date>)Document::setCreateDate);
		attributeGetterFunctions.put("createdBy", Document::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy", (BiConsumer<Document, String>)Document::setCreatedBy);
		attributeGetterFunctions.put("modifiedDate", Document::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Document, Date>)Document::setModifiedDate);
		attributeGetterFunctions.put("modifiedBy", Document::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<Document, String>)Document::setModifiedBy);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getDocumentId() {
		return _documentId;
	}

	@Override
	public void setDocumentId(long documentId) {
		_documentId = documentId;
	}

	@JSON
	@Override
	public String getDocName() {
		if (_docName == null) {
			return "";
		}
		else {
			return _docName;
		}
	}

	@Override
	public void setDocName(String docName) {
		_docName = docName;
	}

	@JSON
	@Override
	public long getFileId() {
		return _fileId;
	}

	@Override
	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	@JSON
	@Override
	public String getFileUrl() {
		if (_fileUrl == null) {
			return "";
		}
		else {
			return _fileUrl;
		}
	}

	@Override
	public void setFileUrl(String fileUrl) {
		_fileUrl = fileUrl;
	}

	@JSON
	@Override
	public long getPatientId() {
		return _patientId;
	}

	@Override
	public void setPatientId(long patientId) {
		_columnBitmask |= PATIENTID_COLUMN_BITMASK;

		if (!_setOriginalPatientId) {
			_setOriginalPatientId = true;

			_originalPatientId = _patientId;
		}

		_patientId = patientId;
	}

	public long getOriginalPatientId() {
		return _originalPatientId;
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
			0, Document.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Document toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Document>
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
		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setDocumentId(getDocumentId());
		documentImpl.setDocName(getDocName());
		documentImpl.setFileId(getFileId());
		documentImpl.setFileUrl(getFileUrl());
		documentImpl.setPatientId(getPatientId());
		documentImpl.setCreateDate(getCreateDate());
		documentImpl.setCreatedBy(getCreatedBy());
		documentImpl.setModifiedDate(getModifiedDate());
		documentImpl.setModifiedBy(getModifiedBy());

		documentImpl.resetOriginalValues();

		return documentImpl;
	}

	@Override
	public int compareTo(Document document) {
		long primaryKey = document.getPrimaryKey();

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

		if (!(obj instanceof Document)) {
			return false;
		}

		Document document = (Document)obj;

		long primaryKey = document.getPrimaryKey();

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
		DocumentModelImpl documentModelImpl = this;

		documentModelImpl._originalPatientId = documentModelImpl._patientId;

		documentModelImpl._setOriginalPatientId = false;

		documentModelImpl._setModifiedDate = false;

		documentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Document> toCacheModel() {
		DocumentCacheModel documentCacheModel = new DocumentCacheModel();

		documentCacheModel.documentId = getDocumentId();

		documentCacheModel.docName = getDocName();

		String docName = documentCacheModel.docName;

		if ((docName != null) && (docName.length() == 0)) {
			documentCacheModel.docName = null;
		}

		documentCacheModel.fileId = getFileId();

		documentCacheModel.fileUrl = getFileUrl();

		String fileUrl = documentCacheModel.fileUrl;

		if ((fileUrl != null) && (fileUrl.length() == 0)) {
			documentCacheModel.fileUrl = null;
		}

		documentCacheModel.patientId = getPatientId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			documentCacheModel.createDate = createDate.getTime();
		}
		else {
			documentCacheModel.createDate = Long.MIN_VALUE;
		}

		documentCacheModel.createdBy = getCreatedBy();

		String createdBy = documentCacheModel.createdBy;

		if ((createdBy != null) && (createdBy.length() == 0)) {
			documentCacheModel.createdBy = null;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			documentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			documentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		documentCacheModel.modifiedBy = getModifiedBy();

		String modifiedBy = documentCacheModel.modifiedBy;

		if ((modifiedBy != null) && (modifiedBy.length() == 0)) {
			documentCacheModel.modifiedBy = null;
		}

		return documentCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Document, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Document, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Document, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Document)this));
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
		Map<String, Function<Document, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Document, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Document, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Document)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Document>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _documentId;
	private String _docName;
	private long _fileId;
	private String _fileUrl;
	private long _patientId;
	private long _originalPatientId;
	private boolean _setOriginalPatientId;
	private Date _createDate;
	private String _createdBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _modifiedBy;
	private long _columnBitmask;
	private Document _escapedModel;

}