package com.comp2411.dbms.controller.room;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoomStatusRepository extends CrudRepository<Room, Long> {

    @Query("SELECT COUNT(u) FROM Room u WHERE u.roomStatus = 1")
    Long numberOfRoomAvailable();


}
