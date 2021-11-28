package com.comp2411.dbms.controller.patient;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


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




}
