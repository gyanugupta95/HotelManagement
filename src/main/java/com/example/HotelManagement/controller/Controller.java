package com.example.HotelManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	@Autowired
	private RoomService roomService;

	@PostMapping("/createCustomer")
	public Customer saveCustomer(@RequestBody CustomerDTO dto) {
		return customerService.saveCustomer(dto);
	}

	@GetMapping("/getCustomers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/getByIdCustomers/{customerId}")
	public Customer getByIdCustomer(@PathVariable Long customerId) {
		return customerService.getByIdCustomers(customerId);
	}

	@GetMapping("/delete/{customerId}")
	public String customerDelete(@PathVariable Long customerId) {
		customerService.customerDelete(customerId);
		return "Deleted Successfully";
	}

	@PostMapping("/updateCustomer/{customerId}")
	public Customer updateRoom(@PathVariable Long customerId, @RequestBody CustomerDTO dto) {
		return customerService.updateCustomer(customerId, dto);
	}

	@PostMapping("/createRoom")
	public Room saveRoom(@RequestBody RoomDTO rdto) {
		return roomService.saveRoom(rdto);
	}

	@GetMapping("getRoom")
	public List<Room> getAllRooms() {
		return roomService.getAllRooms();
	}

	@GetMapping("/getByIdRoom/{roomId}")
	public Customer getByIdRooms(@PathVariable Long roomId) {
		return customerService.getByIdCustomers(roomId);
	}

}
