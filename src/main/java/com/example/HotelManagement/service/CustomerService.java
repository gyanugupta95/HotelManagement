package com.example.HotelManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelManagement.DTO.CustomerDTO;
import com.example.HotelManagement.entity.Customer;
import com.example.HotelManagement.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer saveCustomer(CustomerDTO dto) {

		Customer customer = new Customer();
		customer.setFirstName(dto.getFirstName());
		customer.setLastName(dto.getLastName());
		customer.setEmail(dto.getEmail());
		customer.setPhoneNumber(dto.getPhoneNumber());

		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	public Customer getByIdCustomers(Long customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}
}
