package net.santosh.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.santosh.springboot.exception.CustomerNotFoundException;
import net.santosh.springboot.exception.ModelAddException;
import net.santosh.springboot.exception.ModelNotFoundException;
import net.santosh.springboot.model.Customer;
import net.santosh.springboot.repository.ICustomerRepository;
/****************************************************************************
 * @author               G.Sai Nikesh
 * Description           It is a customer service implementation class that implements the methods
 *                       in its service interface.
 * version               1.0
 * created date          24-03-2021
 *
 ****************************************************************************/



@Service
@Transactional
public class ICustomerServiceImpl implements ICustomerService {

	private static final String userIdnotFound = "UserId is Invalid";
	@Autowired
	private ICustomerRepository ICustomerRepository;
	
	/************************************************************************************
	 * Method                     addCustomer
	 * Description                It is used to add a new customer in the database
	 
	 * @ModelAddException         It is raised due to invalid  details
	 * created by                 G.Sai Nikesh
	 * created date               24-03-2021
	 ***********************************************************************************/

	@Override
	public Customer addCustomer(Customer customer) throws ModelAddException {
		// TODO Auto-generated method stub
		Optional<Customer> result = ICustomerRepository.findById(customer.getUserId());
		try {
			if (result.isPresent()) {
				throw new ModelAddException("Invalid Details");
			}
		} catch (Exception e2) {
			throw new ModelAddException("UserId is already Exists");
		}
		return ICustomerRepository.save(customer);
	}

	/************************************************************************************
	 * Method                     getCustomer
	 * Description                It is used to get an existing customer 
	 *                            in database
	 * @ModelNotFoundException      It is raised when we try to get customer with 
	 *                            invalid  id 
	 * created by                 G.Sai Nikesh
	 * created date               24-03-2021
	 ***********************************************************************************/
	@Override
	public Customer getCustomer(String userId) {
		// TODO Auto-generated method stub
		Optional<Customer> result = ICustomerRepository.findById(userId);
		try {
			if (result.isPresent()) {
				return result.get();
			} else {
				throw new CustomerNotFoundException("Record not found with id : " + userId);
			}
		} catch (Exception e) {
			throw new ModelNotFoundException("Couldnt find the customer by id" + userId);
		}
	}
	
	/************************************************************************************
	 * Method                     getAllCustomers
	 * Description                It is used to get all existing customers 
	 *                            in database
	 * @ModelEmptyListException   It is raised when we try to get appointments when
	 *                            there are no actual appointments.
	 * created by                 G.Sai Nikesh
	 * created date               24-03-2021
	 ***********************************************************************************/
	
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return ICustomerRepository.findAll();
	}

	/************************************************************************************
	 * Method                     removeCustomer
	 * Description                It is used to remove customer in database
	 * @CustomerNotFoundException It is raised when we try to delete customer with 
	 *                            invalid  id 
	 * created by                 G.Sai Nikesh
	 * created date               24-03-2021
	 ***********************************************************************************/
	
	@Override
	public Optional<Customer> removeCustomer(String userId) {
		// TODO Auto-generated method stub
		Optional<Customer> customer = ICustomerRepository.findById(userId);
		try {
			if (customer != null) {
				ICustomerRepository.deleteById(userId);
				return customer;
			} else {
				throw new CustomerNotFoundException("Record not found with id : " + userId);
			}
		} catch (Exception e) {
			throw new ModelNotFoundException("Couldnt find the customers by id" + userId);
		}

	}
	

	/************************************************************************************
	 * Method                     updateCustomer
	 * Description                It is used to update an existing customer details 
	 *                            in database
	 * @CustomerNotFoundException      It is raised when we try to update appointment with 
	 *                            invalid  id 
	 * created by                 G.Sai Nikesh
	 * created date               24-03-2021
	 ***********************************************************************************/
	
	@Override
	public Customer updateCustomer(String userId, Customer customer) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> customer1 = ICustomerRepository.findById(userId);
		try {
			if (customer1.isPresent()) {
				return ICustomerRepository.save(customer);
			} else {
				throw new CustomerNotFoundException(userIdnotFound);
			}
		} catch (Exception e1) {
			throw new CustomerNotFoundException("Record not found with id : " + userId);

		}
	}

}
