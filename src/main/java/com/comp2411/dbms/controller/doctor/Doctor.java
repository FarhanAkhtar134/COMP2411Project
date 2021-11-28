package com.comp2411.dbms.controller.doctor;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DOCTOR")
@Data
public class Doctor {
    @Id
    @Column(name = "Doctor_id")
    private Long doctorId;
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    @Column(name = "Address")
    private String address;
}