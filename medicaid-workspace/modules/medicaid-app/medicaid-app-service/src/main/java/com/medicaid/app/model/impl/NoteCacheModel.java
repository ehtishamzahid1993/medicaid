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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.medicaid.app.model.Note;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Note in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NoteCacheModel implements CacheModel<Note>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NoteCacheModel)) {
			return false;
		}

		NoteCacheModel noteCacheModel = (NoteCacheModel)obj;

		if (noteId == noteCacheModel.noteId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, noteId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{noteId=");
		sb.append(noteId);
		sb.append(", referralId=");
		sb.append(referralId);
		sb.append(", commentDate=");
		sb.append(commentDate);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Note toEntityModel() {
		NoteImpl noteImpl = new NoteImpl();

		noteImpl.setNoteId(noteId);
		noteImpl.setReferralId(referralId);

		if (commentDate == Long.MIN_VALUE) {
			noteImpl.setCommentDate(null);
		}
		else {
			noteImpl.setCommentDate(new Date(commentDate));
		}

		if (comments == null) {
			noteImpl.setComments("");
		}
		else {
			noteImpl.setComments(comments);
		}

		if (createDate == Long.MIN_VALUE) {
			noteImpl.setCreateDate(null);
		}
		else {
			noteImpl.setCreateDate(new Date(createDate));
		}

		if (createdBy == null) {
			noteImpl.setCreatedBy("");
		}
		else {
			noteImpl.setCreatedBy(createdBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			noteImpl.setModifiedDate(null);
		}
		else {
			noteImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (modifiedBy == null) {
			noteImpl.setModifiedBy("");
		}
		else {
			noteImpl.setModifiedBy(modifiedBy);
		}

		noteImpl.resetOriginalValues();

		return noteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		noteId = objectInput.readLong();

		referralId = objectInput.readLong();
		commentDate = objectInput.readLong();
		comments = objectInput.readUTF();
		createDate = objectInput.readLong();
		createdBy = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(noteId);

		objectOutput.writeLong(referralId);
		objectOutput.writeLong(commentDate);

		if (comments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeLong(createDate);

		if (createdBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		objectOutput.writeLong(modifiedDate);

		if (modifiedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modifiedBy);
		}
	}

	public long noteId;
	public long referralId;
	public long commentDate;
	public String comments;
	public long createDate;
	public String createdBy;
	public long modifiedDate;
	public String modifiedBy;

}