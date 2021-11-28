package com.comp2411.dbms.controller.precondition;


import lombok.Data;

import java.io.Serializable;

@Data
public class PreconditionId implements Serializable {
    private String patientID;
    private String precondition;

}
