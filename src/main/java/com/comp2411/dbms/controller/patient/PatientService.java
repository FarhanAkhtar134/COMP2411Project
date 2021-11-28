package com.comp2411.dbms.controller.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repo;

    public List<Patient> listAllPatient() {

        return (List<Patient>) repo.findAll();
    }


    public void save(Patient patient) {
        repo.save(patient);
    }

    public Patient get(String patientID) throws PatientNotFoundException {
        Optional<Patient> result = repo.findById(patientID);
        if (result.isPresent()) {
            return result.get();
        }
        throw new PatientNotFoundException("Could not find patient with ID " + patientID);


    }

    public void delete(String patientID) throws PatientNotFoundException {
       Long count = repo.countPatientByPatientID(patientID);
       if (count == null || count == 0 ){
           throw new PatientNotFoundException("Could not find any patient with ID "+ patientID);

       }
        repo.deleteById(patientID);

    }


    public Long numberofPatients(){
        return repo.numberofPatients();
    }
}
