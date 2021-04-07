package net.santosh.springboot.service;

import java.util.List;
import java.util.Optional;

import net.santosh.springboot.exception.CustomerNotFoundException;
import net.santosh.springboot.exception.ModelAddException;
import net.santosh.springboot.model.Customer;

/****************************************************************************
 * @author               G Sai nikesh
 * Description           It is a customer service interface that describes the abstract methods
 *                       used in its service implementation class.
 * version               1.0
 * created date          24-03-2021
 *
 ****************************************************************************/
public interface ICustomerService {
	public Customer addCustomer(Customer customer) throws ModelAddException;

	public Customer getCustomer(String userId);

	public List<Customer> getAllCustomers();

	public Optional<Customer> removeCustomer(String userId);

	public Customer updateCustomer(String userId, Customer customer) throws CustomerNotFoundException;

}