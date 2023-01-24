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

package com.medicaid.app.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.medicaid.app.model.Note;
import com.medicaid.app.service.base.NoteServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the note remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.medicaid.app.service.NoteService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NoteServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=medicaid",
		"json.web.service.context.path=Note"
	},
	service = AopService.class
)
public class NoteServiceImpl extends NoteServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.medicaid.app.service.NoteServiceUtil</code> to access the note remote service.
	 */
	
	public Note addNote(String comments) {
		Note note=noteLocalService.createNote(CounterLocalServiceUtil.increment(Note.class.getCanonicalName()));
		note.setCommentDate(new Date());
		note.setComments(comments);
		note.setReferralId(1L);
		noteLocalService.updateNote(note);
		return note;
		
	}
}