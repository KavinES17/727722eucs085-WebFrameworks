package com.example.day10cw1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.day10cw1.model.Door;

import jakarta.transaction.Transactional;

public interface DoorRepo extends JpaRepository<Door,Integer>{
    @Query("select d from Door d where d.color=?1")
    List<Door> findByColor(String color);

    @Modifying
    @Transactional
    @Query(value="update Door d set d.color=?1 where d.doorId=?2")
    void updateColorById(String color,int id);

    @Query("select d from Door d where d.doorType=?1")
    List<Door> findByDoorType(String doorType);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM Door WHERE door_id=?1", nativeQuery = true)
    void deleteDoorByDoorId(int doorId);

}
