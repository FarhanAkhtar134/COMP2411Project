package com.comp2411.dbms.controller.admitted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdmittedService {
    @Autowired AdmittedRepository repo;
    public Long Admitted(){
        return repo.numberAdmitted();

    }
}
