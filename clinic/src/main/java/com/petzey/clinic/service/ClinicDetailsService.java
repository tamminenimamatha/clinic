package com.petzey.clinic.service;

import java.util.List;

import com.petzey.clinic.entities.ClinicDetails;
import com.petzey.clinic.exceptions.ClinicDetailsAlreadyExistsException;
import com.petzey.clinic.exceptions.clinicDetailsNotFoundException;

public interface ClinicDetailsService {

	public List<ClinicDetails> getAllClinics() throws clinicDetailsNotFoundException;
	
	public ClinicDetails AddClinics(ClinicDetails clinicDetails) throws ClinicDetailsAlreadyExistsException;
	
	public ClinicDetails editClinics(ClinicDetails clinicDetails) throws clinicDetailsNotFoundException;
	
	public String deleteClinics(long id) throws clinicDetailsNotFoundException;
}