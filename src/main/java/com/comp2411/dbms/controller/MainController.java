package com.comp2411.dbms.controller;

import com.comp2411.dbms.controller.admitted.AdmittedRepository;
import com.comp2411.dbms.controller.consultation.consultationService;
import com.comp2411.dbms.controller.patient.PatientService;
import com.comp2411.dbms.controller.room.RoomStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private consultationService consultationService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private RoomStatusRepository roomStatusRepository;
    @Autowired
    private AdmittedRepository admittedRepository;
    @GetMapping("")
    public String showDashBoard(Model model){
        Long numberOfConsultations = consultationService.getALlConsultations();
        Long numberOfPatients = patientService.numberofPatients();
        Long numberOfRoomsAvailable = roomStatusRepository.numberOfRoomAvailable();
        Long numberAdmitted = admittedRepository.numberAdmitted();

        model.addAttribute("NumberOfConsultations",numberOfConsultations);
        model.addAttribute("NumberOfPatients",numberOfPatients);
        model.addAttribute("NumberOfRoomAvailabe",numberOfRoomsAvailable);
        model.addAttribute("NumberAdmitted",numberAdmitted);

        return "dashboard";
    }


    @GetMapping("/dashboard")
    public String backtoDashboardBoard(Model model){

        Long numberOfConsultations = consultationService.getALlConsultations();
        Long numberOfPatients = patientService.numberofPatients();
        Long numberOfRoomsAvailable = roomStatusRepository.numberOfRoomAvailable();
        Long numberAdmitted = admittedRepository.numberAdmitted();
        System.out.println(numberOfRoomsAvailable);
        model.addAttribute("NumberOfConsultations",numberOfConsultations);
        model.addAttribute("NumberOfPatients",numberOfPatients);
        model.addAttribute("NumberOfRoomAvailabe",numberOfRoomsAvailable);
        model.addAttribute("NumberAdmitted",numberAdmitted);

        return "dashboard";
    }
}
