package com.petzey.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petzey.clinic.entities.ClinicDetails;
@Repository
public interface ClinicDetailsRepository extends JpaRepository<ClinicDetails,Long> {

}
