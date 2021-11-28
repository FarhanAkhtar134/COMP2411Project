package com.comp2411.dbms.controller.room;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "ROOM_STATUS")
public class Room {
    @Id
    @Column(name = "ROOM_NUMBER")
    private Long roomNumber;
    @Column(name = "ROOM_STATUS")
    private Long roomStatus;

}
