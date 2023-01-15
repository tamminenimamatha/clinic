package com.petzey.clinic.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ClinicDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long clinicId;
	private String clinicName;
	private String clinicInfo;
	private long contactNumber;
	private String contactPerson;
	private String workingDays;
	private String time;
	private String description;
	private boolean status;
	

}
