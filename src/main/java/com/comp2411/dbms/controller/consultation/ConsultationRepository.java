package com.comp2411.dbms.controller.consultation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConsultationRepository extends CrudRepository<Consultation, Long> {


    @Query("SELECT COUNT(u) FROM Consultation u")
    long numberofConsultations();



}
