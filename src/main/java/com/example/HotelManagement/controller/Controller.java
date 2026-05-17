package com.example.HotelManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelManagement.DTO.CustomerDTO;
import com.example.HotelManagement.DTO.RoomDTO;
import com.example.HotelManagement.entity.Customer;
import com.example.HotelManagement.entity.Room;
import com.example.HotelManagement.service.CustomerService;
import com.example.HotelManagement.service.RoomService;

@RestController
public class Controller {
	@GetMapping("/home")
	public String test() {
		return "Welcome to The India";
	}

	@Autowired
	private CustomerService customerService;
	private RoomService roomService;

	@PostMapping("/createCustomer")
	public Customer saveCustomer(@RequestBody CustomerDTO dto) {
		return customerService.saveCustomer(dto);
	}

	@GetMapping("/getCustomers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@PostMapping("/createRoom")
	public Room saveRoom(@RequestBody RoomDTO dto) {
		return roomService.saveRoom(dto);
	}

	@GetMapping("getRoom")
	public List<Room> getAllRooms() {
		return roomService.getAllRooms();
	}

}
