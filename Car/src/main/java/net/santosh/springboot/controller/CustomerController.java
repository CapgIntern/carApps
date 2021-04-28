package net.santosh.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.santosh.springboot.exception.CustomerNotFoundException;
import net.santosh.springboot.exception.ModelAddException;
import net.santosh.springboot.model.Customer;
import net.santosh.springboot.service.ICustomerService;

@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/c1")
/***********************************************************
 * @author              G Sai Nikesh
 * Description          It is a controller class that controls the data flow into model object 
 *                      and updates the view whenever data changes
 * Version              1.0
 * created date         24-03-2021
 ***********************************************************/
public class CustomerController {
	@Autowired
	private ICustomerService iService;
	/*****************************************************
	 * Method              addCustomer
	 * Description         Displays the newly added customer details in database
	 * @PostMapping        used to add new customer to database 
	 * @Return             returns newly added customer details
	 * Created by:         G Sai Nikesh
	 * created date        24-03-2021
	 *****************************************************/

	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) throws ModelAddException {
		return iService.addCustomer(customer);
	}

	/*****************************************************
	 * Method              getcustomerbyid
	 * Description         Displays the customer by userId
	 * @GetMapping         used to get the customer details by userId
	 * @Return             returns the customer details by userId
	 * Created by:         G Sai Nikesh
	 * created date        24-03-2021
	 *****************************************************/

	@GetMapping("/customer/{userId}")
	public Customer getcustomer(@PathVariable String userId) throws CustomerNotFoundException {
		return iService.getCustomer(userId);
	}

	/*****************************************************
	 * Method              getAllCustomers
	 * Description         Displays all the customers
	 * @GetMapping         used to get the customers
	 * @Return             returns all the customers
	 * Created by:         G Sai Nikesh
	 * created date        24-03-2021
	 *****************************************************/
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return iService.getAllCustomers();
	}

	/*****************************************************
	 * Method              removeCustomer
	 * Description         Displays remaining Customers after deletion
	 * @DeleteMapping      used to delete customer by id
	 * @Return             returns deleted customer
	 * Created by:         G Sai Nikesh
	 * created date        24-03-2021
	 *****************************************************/

	@DeleteMapping("/deletecustomer/{userId}")
	public Optional<Customer> removeCustomer(@PathVariable String userId) throws CustomerNotFoundException {
		return iService.removeCustomer(userId);
	}

	/*****************************************************
	 * Method              updatecustomer
	 * Description         Displays customer details after updation
	 * @PostMapping         used to update custmomer by id
	 * @Return             customer after updation
	 * Created by:         G Sai Nikesh
	 * created date        24-03-2021
	 *****************************************************/

	@PutMapping("/updatecustomer/{userId}")
	public Customer updateCustomer(@PathVariable String userId, @RequestBody Customer customer)
			throws CustomerNotFoundException {
		return iService.updateCustomer(userId, customer);
	}
}
