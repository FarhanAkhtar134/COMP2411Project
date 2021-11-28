package com.comp2411.dbms.controller.patient;


import com.comp2411.dbms.controller.consultation.Consultation;
import com.comp2411.dbms.controller.precondition.Precondition;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="PATIENT")
@Data
public class Patient {
    @Id
    @Column(name = "PATIENT_HKID")
    private String patientID;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "WEIGHT")
    private Integer weight;
    @Column(name = "HEIGHT")
    private Integer height;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;

    @OneToMany(mappedBy = "patient_ID")
    private Set<Precondition> preconditions;


    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Consultation> consultations;



}
