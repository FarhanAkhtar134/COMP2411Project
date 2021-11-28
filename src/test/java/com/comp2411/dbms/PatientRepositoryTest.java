package com.comp2411.dbms;

import com.comp2411.dbms.controller.patient.Patient;
import com.comp2411.dbms.controller.patient.PatientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Collections;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

@Rollback(false)
public class PatientRepositoryTest {
@Autowired PatientRepository repo;

    @Test
    public void testAddNewPatient(){
        Patient newPatient = new Patient();
        newPatient.setPatientID("M1234567");
        newPatient.setFirstName("Ahmed");
        newPatient.setLastName("Masud");
        newPatient.setWeight(72);
        newPatient.setHeight(180);
        newPatient.setAddress("Homantin Kwong Street");
        newPatient.setPhoneNumber("98563218");
        newPatient.setDateOfBirth("98/11/03");

        Patient savedPatient = repo.save(newPatient);

        Assertions.assertNotNull(savedPatient);
        Assertions.assertNotNull(savedPatient.getPatientID());

    }



    @Test
    public void testListAllPatients(){
       Iterable <Patient> patients= repo.findAll();
       Assertions.assertNotNull(patients);

       for (Patient patient : patients){
           System.out.println(patient);
       }

    }

    @Test
    public void editPatient(){
        String testPatientID = "M1234567";
       Optional<Patient> editedPatent =  repo.findById(testPatientID);
       Patient patient = editedPatent.get();
        System.out.println(patient);
       patient.setPhoneNumber("12385279");
       repo.save(patient);

        Patient updatedPatient = repo.findById(testPatientID).get();

        System.out.println(updatedPatient);

        Assertions.assertEquals("12385279",updatedPatient.getPhoneNumber());


    }



}
