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

import com.medicaid.app.model.Note;
import com.medicaid.app.model.NoteModel;
import com.medicaid.app.model.NoteSoap;

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
 * The base model implementation for the Note service. Represents a row in the &quot;Medicaid_Note&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>NoteModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NoteImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NoteImpl
 * @generated
 */
@JSON(strict = true)
public class NoteModelImpl extends BaseModelImpl<Note> implements NoteModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a note model instance should use the <code>Note</code> interface instead.
	 */
	public static final String TABLE_NAME = "Medicaid_Note";

	public static final Object[][] TABLE_COLUMNS = {
		{"noteId", Types.BIGINT}, {"referralId", Types.BIGINT},
		{"commentDate", Types.TIMESTAMP}, {"comments", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"createdBy", Types.VARCHAR},
		{"modifiedDate", Types.TIMESTAMP}, {"modifiedBy", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("noteId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("referralId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commentDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("comments", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Medicaid_Note (noteId LONG not null primary key,referralId LONG,commentDate DATE null,comments VARCHAR(75) null,createDate DATE null,createdBy VARCHAR(75) null,modifiedDate DATE null,modifiedBy VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table Medicaid_Note";

	public static final String ORDER_BY_JPQL = " ORDER BY note.noteId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Medicaid_Note.noteId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long REFERRALID_COLUMN_BITMASK = 1L;

	public static final long NOTEID_COLUMN_BITMASK = 2L;

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
	public static Note toModel(NoteSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Note model = new NoteImpl();

		model.setNoteId(soapModel.getNoteId());
		model.setReferralId(soapModel.getReferralId());
		model.setCommentDate(soapModel.getCommentDate());
		model.setComments(soapModel.getComments());
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
	public static List<Note> toModels(NoteSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Note> models = new ArrayList<Note>(soapModels.length);

		for (NoteSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public NoteModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _noteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNoteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _noteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Note.class;
	}

	@Override
	public String getModelClassName() {
		return Note.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Note, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Note, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Note, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Note)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Note, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Note, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Note)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Note, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Note, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Note>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Note.class.getClassLoader(), Note.class, ModelWrapper.class);

		try {
			Constructor<Note> constructor =
				(Constructor<Note>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Note, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Note, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Note, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Note, Object>>();
		Map<String, BiConsumer<Note, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Note, ?>>();

		attributeGetterFunctions.put("noteId", Note::getNoteId);
		attributeSetterBiConsumers.put(
			"noteId", (BiConsumer<Note, Long>)Note::setNoteId);
		attributeGetterFunctions.put("referralId", Note::getReferralId);
		attributeSetterBiConsumers.put(
			"referralId", (BiConsumer<Note, Long>)Note::setReferralId);
		attributeGetterFunctions.put("commentDate", Note::getCommentDate);
		attributeSetterBiConsumers.put(
			"commentDate", (BiConsumer<Note, Date>)Note::setCommentDate);
		attributeGetterFunctions.put("comments", Note::getComments);
		attributeSetterBiConsumers.put(
			"comments", (BiConsumer<Note, String>)Note::setComments);
		attributeGetterFunctions.put("createDate", Note::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Note, Date>)Note::setCreateDate);
		attributeGetterFunctions.put("createdBy", Note::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy", (BiConsumer<Note, String>)Note::setCreatedBy);
		attributeGetterFunctions.put("modifiedDate", Note::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Note, Date>)Note::setModifiedDate);
		attributeGetterFunctions.put("modifiedBy", Note::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy", (BiConsumer<Note, String>)Note::setModifiedBy);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
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
	public Long getReferralId() {
		return _referralId;
	}

	@Override
	public void setReferralId(Long referralId) {
		_columnBitmask |= REFERRALID_COLUMN_BITMASK;

		if (!_setOriginalReferralId) {
			_setOriginalReferralId = true;

			_originalReferralId = _referralId;
		}

		_referralId = referralId;
	}

	public Long getOriginalReferralId() {
		return _originalReferralId;
	}

	@JSON
	@Override
	public Date getCommentDate() {
		return _commentDate;
	}

	@Override
	public void setCommentDate(Date commentDate) {
		_commentDate = commentDate;
	}

	@JSON
	@Override
	public String getComments() {
		if (_comments == null) {
			return "";
		}
		else {
			return _comments;
		}
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;
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
			0, Note.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Note toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Note>
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
		NoteImpl noteImpl = new NoteImpl();

		noteImpl.setNoteId(getNoteId());
		noteImpl.setReferralId(getReferralId());
		noteImpl.setCommentDate(getCommentDate());
		noteImpl.setComments(getComments());
		noteImpl.setCreateDate(getCreateDate());
		noteImpl.setCreatedBy(getCreatedBy());
		noteImpl.setModifiedDate(getModifiedDate());
		noteImpl.setModifiedBy(getModifiedBy());

		noteImpl.resetOriginalValues();

		return noteImpl;
	}

	@Override
	public int compareTo(Note note) {
		long primaryKey = note.getPrimaryKey();

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

		if (!(obj instanceof Note)) {
			return false;
		}

		Note note = (Note)obj;

		long primaryKey = note.getPrimaryKey();

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
		NoteModelImpl noteModelImpl = this;

		noteModelImpl._originalReferralId = noteModelImpl._referralId;

		noteModelImpl._setOriginalReferralId = false;

		noteModelImpl._setModifiedDate = false;

		noteModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Note> toCacheModel() {
		NoteCacheModel noteCacheModel = new NoteCacheModel();

		noteCacheModel.noteId = getNoteId();

		noteCacheModel.referralId = getReferralId();

		Date commentDate = getCommentDate();

		if (commentDate != null) {
			noteCacheModel.commentDate = commentDate.getTime();
		}
		else {
			noteCacheModel.commentDate = Long.MIN_VALUE;
		}

		noteCacheModel.comments = getComments();

		String comments = noteCacheModel.comments;

		if ((comments != null) && (comments.length() == 0)) {
			noteCacheModel.comments = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			noteCacheModel.createDate = createDate.getTime();
		}
		else {
			noteCacheModel.createDate = Long.MIN_VALUE;
		}

		noteCacheModel.createdBy = getCreatedBy();

		String createdBy = noteCacheModel.createdBy;

		if ((createdBy != null) && (createdBy.length() == 0)) {
			noteCacheModel.createdBy = null;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			noteCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			noteCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		noteCacheModel.modifiedBy = getModifiedBy();

		String modifiedBy = noteCacheModel.modifiedBy;

		if ((modifiedBy != null) && (modifiedBy.length() == 0)) {
			noteCacheModel.modifiedBy = null;
		}

		return noteCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Note, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Note, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Note, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Note)this));
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
		Map<String, Function<Note, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Note, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Note, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Note)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Note>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _noteId;
	private Long _referralId;
	private Long _originalReferralId;
	private boolean _setOriginalReferralId;
	private Date _commentDate;
	private String _comments;
	private Date _createDate;
	private String _createdBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _modifiedBy;
	private long _columnBitmask;
	private Note _escapedModel;

}