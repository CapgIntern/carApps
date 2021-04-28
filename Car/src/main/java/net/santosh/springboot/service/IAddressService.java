package net.santosh.springboot.service;

import java.util.List;

import net.santosh.springboot.model.Address;
import net.santosh.springboot.model.Car;

public interface IAddressService {
	
	public Address addAddress(Address address);

	public void removeAddress(long addressId);
	
	public List<Address> getAllAddress(String userId);
	
	public Address updateAddress(Address address, long addressId);
	
	public Address getAddress(long id);
}
