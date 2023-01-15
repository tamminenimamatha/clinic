package com.petzey.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petzey.clinic.entities.ClinicDetails;
import com.petzey.clinic.exceptions.ClinicDetailsAlreadyExistsException;
import com.petzey.clinic.exceptions.clinicDetailsNotFoundException;
import com.petzey.clinic.service.ClinicDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/clinic")
public class ClinicDetailsController {
	
	@Autowired
	private ClinicDetailsService service;
	
	@GetMapping("/clinic")
	@Operation(summary = "to get list of clinic details")
	public ResponseEntity<?> get(){
		ResponseEntity<?> response =null;
		try {
			response = new ResponseEntity<>(service.getAllClinics(), HttpStatus.OK);
		} catch(clinicDetailsNotFoundException e) {
		response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	return response;
	}
	@PostMapping("/clinicdetails/add")
	@Operation(summary = "to save the clinic details")
	public ResponseEntity<?>post(@RequestBody ClinicDetails clinicDetails){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.AddClinics(clinicDetails), HttpStatus.CREATED);
		}
		catch(ClinicDetailsAlreadyExistsException e) {
			response = new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return response;
	}
	@PutMapping("/clinics/update")
	@Operation(summary = "to update the clinic details")
	public ResponseEntity<?> editClinics(@RequestBody ClinicDetails clinicDetails){
		ResponseEntity<?> response =null;
		try {
			response = new ResponseEntity<>(service.editClinics(clinicDetails), HttpStatus.OK);
		}
		catch(clinicDetailsNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
	}
	@DeleteMapping("/clinicd/delete")
	@Operation(summary = "to delete te clinic details")
	public  ResponseEntity<?> deleteclinics(@RequestBody long clinicId){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.deleteClinics(clinicId), HttpStatus.OK);
		}catch(clinicDetailsNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
	}


}
