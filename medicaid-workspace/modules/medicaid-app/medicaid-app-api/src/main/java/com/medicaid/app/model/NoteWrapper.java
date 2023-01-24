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

package com.medicaid.app.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Note}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Note
 * @generated
 */
public class NoteWrapper
	extends BaseModelWrapper<Note> implements ModelWrapper<Note>, Note {

	public NoteWrapper(Note note) {
		super(note);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("noteId", getNoteId());
		attributes.put("referralId", getReferralId());
		attributes.put("commentDate", getCommentDate());
		attributes.put("comments", getComments());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long noteId = (Long)attributes.get("noteId");

		if (noteId != null) {
			setNoteId(noteId);
		}

		Long referralId = (Long)attributes.get("referralId");

		if (referralId != null) {
			setReferralId(referralId);
		}

		Date commentDate = (Date)attributes.get("commentDate");

		if (commentDate != null) {
			setCommentDate(commentDate);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	/**
	 * Returns the comment date of this note.
	 *
	 * @return the comment date of this note
	 */
	@Override
	public Date getCommentDate() {
		return model.getCommentDate();
	}

	/**
	 * Returns the comments of this note.
	 *
	 * @return the comments of this note
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the create date of this note.
	 *
	 * @return the create date of this note
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this note.
	 *
	 * @return the created by of this note
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the modified by of this note.
	 *
	 * @return the modified by of this note
	 */
	@Override
	public String getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this note.
	 *
	 * @return the modified date of this note
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the note ID of this note.
	 *
	 * @return the note ID of this note
	 */
	@Override
	public long getNoteId() {
		return model.getNoteId();
	}

	/**
	 * Returns the primary key of this note.
	 *
	 * @return the primary key of this note
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the referral ID of this note.
	 *
	 * @return the referral ID of this note
	 */
	@Override
	public Long getReferralId() {
		return model.getReferralId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the comment date of this note.
	 *
	 * @param commentDate the comment date of this note
	 */
	@Override
	public void setCommentDate(Date commentDate) {
		model.setCommentDate(commentDate);
	}

	/**
	 * Sets the comments of this note.
	 *
	 * @param comments the comments of this note
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the create date of this note.
	 *
	 * @param createDate the create date of this note
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this note.
	 *
	 * @param createdBy the created by of this note
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the modified by of this note.
	 *
	 * @param modifiedBy the modified by of this note
	 */
	@Override
	public void setModifiedBy(String modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this note.
	 *
	 * @param modifiedDate the modified date of this note
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the note ID of this note.
	 *
	 * @param noteId the note ID of this note
	 */
	@Override
	public void setNoteId(long noteId) {
		model.setNoteId(noteId);
	}

	/**
	 * Sets the primary key of this note.
	 *
	 * @param primaryKey the primary key of this note
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the referral ID of this note.
	 *
	 * @param referralId the referral ID of this note
	 */
	@Override
	public void setReferralId(Long referralId) {
		model.setReferralId(referralId);
	}

	@Override
	protected NoteWrapper wrap(Note note) {
		return new NoteWrapper(note);
	}

}