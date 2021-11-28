package com.comp2411.dbms.controller.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PatientController {
    @Autowired private PatientService service;

    @GetMapping("/patients")
    public String showPatientList(Model model){

        List<Patient> listPatients = service.listAllPatient();
        model.addAttribute("ListPatients",listPatients);


        return "patients";
    }

    @GetMapping("/patients/new")
    public String addNewPatient(Model model){
        model.addAttribute("newPatient",new Patient());

        return "patient-form";
    }


}
