package net.santosh.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.santosh.springboot.model.*;
import net.santosh.springboot.service.*;


import io.swagger.annotations.Api;

@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/c1")
public class CustomerController {
	@Autowired
	private ICustomerService iService;
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "Welcome to CapG";
	}
	
	@PostMapping("/customeradd")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		return iService.addCustomer(customer);
	}
	
	@GetMapping("/customer/{userId}")
	public Customer getcustomer(@PathVariable String userId)
	{
			return iService.getCustomer(userId);
	}
	
	@GetMapping("/getAll")
	public List<Customer> getAllCustomers(){
		return iService.getAllCustomers();
	}
	
	@DeleteMapping("/delete/{userId}")
	public Optional<Customer> removeCustomer(@PathVariable String userId)
	{
		return iService.removeCustomer(userId);
	}
	@PostMapping("/cust/{userId}")
	public Customer updateCustomer(String userId, Customer customer)
	{
		return iService.updateCustomer(userId, customer);
	}
}
