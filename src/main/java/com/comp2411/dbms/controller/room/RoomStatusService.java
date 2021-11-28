package com.comp2411.dbms.controller.room;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomStatusService {
    @Autowired RoomStatusRepository repo;

    public Long numberofRoomsAvailable(){
        return repo.numberOfRoomAvailable();
    }


}
