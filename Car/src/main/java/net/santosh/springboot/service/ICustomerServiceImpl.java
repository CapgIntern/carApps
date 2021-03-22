package net.santosh.springboot.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.santosh.springboot.exception.ResourceNotFoundException;
import net.santosh.springboot.model.Customer;
import net.santosh.springboot.repository.IAppointmentRepository;
import net.santosh.springboot.repository.ICustomerRepository;

@Service
@Transactional
public class ICustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerRepository ICustomerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer removeCustomer(long custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(long custId, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomer(long custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomersByLocation() {
		// TODO Auto-generated method stub
		return null;
	}

}
