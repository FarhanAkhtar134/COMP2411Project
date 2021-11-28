package com.comp2411.dbms.controller.consultation;

import com.comp2411.dbms.controller.patient.Patient;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "CONSULTATION")
public class Consultation {
    @Id
    @Column(name="CONSULTATION_ID")
    private Long consultationID;
    @Column(name="DOCTOR_ID")
    private Long doctorID;
    @Column(name="CONSULTATION_DATE")
    private Date consultationDate;
    @Column(name = "CONSULTATION_FEE")
    private Long consultationFee;


//    @ManyToOne
//    private Patient patient;


}
