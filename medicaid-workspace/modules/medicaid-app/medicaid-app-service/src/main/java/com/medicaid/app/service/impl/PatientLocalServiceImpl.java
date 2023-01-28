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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.medicaid.app.model.Facility;
import com.medicaid.app.model.Patient;
import com.medicaid.app.service.base.PatientLocalServiceBaseImpl;
import com.medicaid.app.util.FormattingUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the patient local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.medicaid.app.service.PatientLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.medicaid.app.model.Patient",
	service = AopService.class
)
public class PatientLocalServiceImpl extends PatientLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.medicaid.app.service.PatientLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.medicaid.app.service.PatientLocalServiceUtil</code>.
	 */
	
static Log log = LogFactoryUtil.getLog(Patient.class);
	
	public List<Patient> findByEmailAddress(String emailAddress){
		try {
			return patientPersistence.findByEmailAddress(emailAddress);
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		return null;
	}
	
	public List<Patient> findByFirstName(String firstName){
		try {
			return patientPersistence.findByFirstName(firstName);
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		return null;
	}
	
	public List<Patient> findByLastName(String lastName){
		try {
			return patientPersistence.findByLastName(lastName);
		} catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		}
		return null;
	}
	
	
	
	
	
	public HashMap<Long, Patient> getPatientMap(){
		HashMap<Long, Patient> patientsMap=new HashMap<Long, Patient>();
		try {
			List<Patient> patients=patientLocalService.getPatients(-1, -1);
			for (Patient patient : patients) {
				patientsMap.put(patient.getPatientId(), patient);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return patientsMap;
	}
	
}