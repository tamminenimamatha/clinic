package com.petzey.clinic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petzey.clinic.entities.ClinicDetails;
import com.petzey.clinic.exceptions.ClinicDetailsAlreadyExistsException;
import com.petzey.clinic.exceptions.clinicDetailsNotFoundException;
import com.petzey.clinic.repository.ClinicDetailsRepository;
import com.petzey.clinic.service.ClinicDetailsService;

@Service
public class ClinicDetailsServiceImpl implements ClinicDetailsService {
	
	@Autowired
	private ClinicDetailsRepository clinicRepo;
	
	@Override
	public List<ClinicDetails> getAllClinics() throws clinicDetailsNotFoundException {
	     List<ClinicDetails> clinicDetails = clinicRepo.findAll();
	     if (clinicDetails.isEmpty()) {
	    	 throw new clinicDetailsNotFoundException("clinic details not exist..add the details");
	     }
		return clinicDetails;
	}

	@Override
	public ClinicDetails AddClinics(ClinicDetails clinicDetails) throws ClinicDetailsAlreadyExistsException {
		ClinicDetails details= null;
		if(clinicRepo.existsById(clinicDetails.getClinicId())) {
			throw new ClinicDetailsAlreadyExistsException("clinic details are already exists..");
		}
		else {
			details=clinicRepo.save(clinicDetails);
		}
		return details;
	}

	@Override
	public ClinicDetails editClinics(ClinicDetails clinicDetails) throws clinicDetailsNotFoundException {
		ClinicDetails details = null;
		if(clinicRepo.equals(details)) {
			throw  new clinicDetailsNotFoundException("clinic ndetails are not found by this id");
		}
		else {
		    clinicRepo.save(clinicDetails);
		}
		
		return details;
	}

	@Override
	public String deleteClinics(long clinicId) throws clinicDetailsNotFoundException {
		String details = null;
		if(clinicRepo.equals(details)) {
			throw new clinicDetailsNotFoundException("clinic details are  not found");
		}
		else {
			clinicRepo.deleteById(clinicId);
			details = "deleted successfully";
		}
		return null;
	}

}
