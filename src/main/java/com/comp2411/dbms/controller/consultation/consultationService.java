package com.comp2411.dbms.controller.consultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class consultationService {
    @Autowired ConsultationRepository repo;

    public Long getALlConsultations(){
      return  repo.numberofConsultations();

    }



}
