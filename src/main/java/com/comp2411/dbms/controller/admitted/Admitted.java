package com.comp2411.dbms.controller.admitted;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "ADMITTED")
public class Admitted {
    @Id
    @Column(name = "CONSULTATION_ID")
    private Long consultationID;
    @Column(name = "DATE_OF_ADMISSION")
    private Date dateOfAdmission;
    @Column(name = "DATE_OF_DISCHARGE")
    private Date dateOfDischarge;
    @Column(name="ROOM_NUMBER")
    private Long roomNumber;

}
