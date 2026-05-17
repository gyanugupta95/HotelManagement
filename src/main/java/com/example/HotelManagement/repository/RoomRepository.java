package com.example.HotelManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelManagement.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
