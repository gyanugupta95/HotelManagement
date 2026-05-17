package com.example.HotelManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelManagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
