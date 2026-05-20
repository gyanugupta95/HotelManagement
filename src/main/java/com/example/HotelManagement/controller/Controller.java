package com.example.HotelManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDTO dto) {
		 customerService.saveCustomer(dto);
		  return new ResponseEntity<>(
				  customerService.saveCustomer(dto),
		            HttpStatus.CREATED
		    );
	}

	@GetMapping("/getCustomers")
	public ResponseEntity<?> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		if (customers.isEmpty()) {
			return new ResponseEntity<>("No Customers Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@GetMapping("/getByIdCustomers/{customerId}")
	public ResponseEntity<?> getByIdCustomer(@PathVariable Long customerId) {
		Customer customer = customerService.getByIdCustomers(customerId);
		if (customer != null) {
			return new ResponseEntity<>(customer, HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Customer Not Found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/delete/{customerId}")
	public ResponseEntity<String> customerDelete(@PathVariable Long customerId) {
		customerService.customerDelete(customerId);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}

	@PostMapping("/updateCustomer/{customerId}")
	public ResponseEntity<Customer> updateRoom(@PathVariable Long customerId, @RequestBody CustomerDTO dto) {
		Customer updatedCustomer = customerService.updateCustomer(customerId, dto);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}

	@PostMapping("/createRoom")
	public ResponseEntity<Room> saveRoom(@RequestBody RoomDTO rdto) {
		Room room = roomService.saveRoom(rdto);
		return new ResponseEntity<>(room, HttpStatus.CREATED);

	}

	@GetMapping("/getRoom")
	public ResponseEntity<?> getAllRooms() {
		List<Room> rooms = roomService.getAllRooms();
		if (rooms.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Rooms Found");
		}
		return ResponseEntity.ok(rooms);
	}

	@GetMapping("/getByIdRoom/{roomId}")
	public ResponseEntity<?> getByIdRooms(@PathVariable Long roomId) {
		Room room = roomService.getByIdRooms(roomId);
		if (room != null) {
			return ResponseEntity.ok(room);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room Not Found");
		}
	}

}
