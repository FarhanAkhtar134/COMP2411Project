package com.comp2411.dbms.controller.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("patient",new Patient());
        model.addAttribute("pageTitle", "Add new User");

        return "patient-form";
    }

    @PostMapping("/patients/save")
    public String saveNewPatient(Patient patient, RedirectAttributes ra){
        service.save(patient);
        ra.addFlashAttribute("message","Patient Added Successfully");

        return"redirect:/patients";
    }

    @GetMapping("/patient/edit/{id}")
    public String showEditForm(@PathVariable("id") String patientID, Model model, RedirectAttributes ra) throws PatientNotFoundException {
        try{
            Patient patient = service.get(patientID);
            model.addAttribute("patient",patient);
            model.addAttribute("pageTitle", "Edit Patient (patientID: " + patientID + ")" );
            return "patient-form";
        }
        catch (PatientNotFoundException e){
            ra.addFlashAttribute("message","The usr ");

            return"redirect:/patients";
        }

    }
    @GetMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable("id") String patientID, RedirectAttributes ra) throws PatientNotFoundException {
        try{
            service.delete(patientID);
            ra.addFlashAttribute("message","Patient with ID " + patientID +" has been deleted successfully");

        }
        catch (PatientNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());

            return"redirect:/patients";
        }

    return"redirect:/patients";

    }








}
