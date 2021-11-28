package com.comp2411.dbms.controller.admitted;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdmittedRepository extends CrudRepository<Admitted, Long> {


    @Query("SELECT COUNT(u) FROM Admitted u")
    long numberAdmitted();
}
