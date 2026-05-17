package com.example.HotelManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelManagement.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
