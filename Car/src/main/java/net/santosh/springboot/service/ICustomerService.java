package net.santosh.springboot.service;
import net.santosh.springboot.model.*;
import java.util.List;


public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public Customer removeCustomer(long custId);
	public Customer updateCustomer(long custId, Customer customer);
	public Customer getCustomer(long custId);
	public List<Customer> getAllCustomers(); 
	public List<Customer> getCustomersByLocation();
}
