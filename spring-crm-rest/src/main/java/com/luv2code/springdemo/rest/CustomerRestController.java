package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	//autowire the service so it injects the service class (dependency injection)
	@Autowired
	private CustomerService customerService;

	// get all customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	// get customer by id
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if(customer==null) {
			throw new CustomerNotFoundException("Customer id not found: "+ customerId);
		}
		return customer;
	}
	
	// add a customer
	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer customer) {
		customer.setId(0); // setting the id to 0 because hibernate will auto generate the id
								// if id is null or 0
		customerService.saveCustomer(customer);
		return customer;
	}
	
	// update a customer
	@PutMapping("/customers/{customerId}")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		customerService.saveCustomer(customer);
		return customer;
	}
	
	// delete a customer
	@DeleteMapping("/customers/{customerId}")
	public int deleteCustomer(@PathVariable int customerId) {
		// first check if the customer exists
		Customer deleteCustomer = getCustomer(customerId);
		if(null==deleteCustomer) {
			throw new CustomerNotFoundException("No Customer with id: "+ customerId);
		}
		customerService.deleteCustomer(customerId);
		return customerId;
	}
}
