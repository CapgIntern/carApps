package net.santosh.springboot.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.santosh.springboot.model.*;
import net.santosh.springboot.repository.*;


@Service
@Transactional
public class ICustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerRepository ICustomerRepository;
	

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return ICustomerRepository.saveAndFlush(customer);
		
	}


	@Override
	public Customer getCustomer(String userId) {
		// TODO Auto-generated method stub
		Optional<Customer> result = ICustomerRepository.findById(userId);
		return result.get();
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return ICustomerRepository.findAll();
	}


	@Override
	public Optional<Customer> removeCustomer(String userId) {
		// TODO Auto-generated method stub
		Optional<Customer> customer=ICustomerRepository.findById(userId);
		if(customer != null) 
			ICustomerRepository.deleteById(userId);
		return customer;
		
	}
	@Override
	public Customer updateCustomer(String userId, Customer customer) {
		// TODO Auto-generated method stub
		Customer replace = getCustomer(userId);
		BeanUtils.copyProperties(replace, customer);
		return customer;
		
	}
	

}
