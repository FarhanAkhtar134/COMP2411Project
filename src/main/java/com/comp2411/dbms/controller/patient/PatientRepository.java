package com.comp2411.dbms.controller.patient;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, String> {



     public Long countPatientByPatientID(String Id);

     @Query("SELECT COUNT(u) FROM Patient u")
     long numberofPatients();



}
