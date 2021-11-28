package com.comp2411.dbms.controller.precondition;


import com.comp2411.dbms.controller.patient.Patient;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@IdClass(PreconditionId.class)
@Table(name = "PRECONDITIONS")
public class Precondition {
    @Id
    @Column(name = "PRECONDITION")
    private String precondition;

    @Column (name = "PATIENT_HKID")
    private String patientID;


//    @ManyToOne
//    private Patient patient_ID;

}
