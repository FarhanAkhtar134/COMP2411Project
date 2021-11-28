package com.comp2411.dbms.controller.doctor;

import com.comp2411.dbms.controller.patient.Patient;
import com.comp2411.dbms.controller.patient.PatientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService service;

    @GetMapping("/doctor")
    public String showPatientList(Model model) {

        List<Doctor> listDoctors = service.listAllDoctors();
        model.addAttribute("ListDoctor", listDoctors);


        return "doctor";


    }

    @GetMapping("/doctor/new")
    public String addNewDoctor(Model model){
        model.addAttribute("doctor",new Doctor());
        model.addAttribute("pageTitle", "Add new Doctor");

        return "doctor-form";
    }

    @PostMapping("/doctor/save")
    public String saveNewDoctor(Doctor doctor, RedirectAttributes ra){
        service.save(doctor);
        ra.addFlashAttribute("message","Doctor Added Successfully");

        return"redirect:/doctor";
    }


    @GetMapping("/doctor/edit/{id}")
    public String showEditForm(@PathVariable("id") Long doctorID, Model model, RedirectAttributes ra) throws PatientNotFoundException {
        try{
            Doctor doctor = service.get(doctorID);
            model.addAttribute("doctor",doctor);
            model.addAttribute("pageTitle", "Edit Doctor (doctorID: " + doctorID + ")" );
            return "doctor-form";
        }
        catch (PatientNotFoundException e){
            ra.addFlashAttribute("message","The usr ");

            return"redirect:/doctor";
        }

    }


    @GetMapping("/doctor/delete/{id}")
    public String deletePatient(@PathVariable("id") Long doctorID, RedirectAttributes ra) throws PatientNotFoundException {
        try{
            service.delete(doctorID);
            ra.addFlashAttribute("message","Doctor with ID " + doctorID +" has been deleted successfully");

        }
        catch (PatientNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());

            return"redirect:/doctor";
        }

        return"redirect:/doctor";

    }





}
