package net.santosh.springboot.service;
import net.santosh.springboot.model.*;
import java.util.List;
import java.util.Optional;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);
	public Customer getCustomer(String userId);
	public List<Customer> getAllCustomers(); 
	public Optional<Customer> removeCustomer(String userId);
	public Customer updateCustomer(String userId, Customer customer);

}
