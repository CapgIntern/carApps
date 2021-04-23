package net.santosh.springboot.service;

import java.util.List;

import net.santosh.springboot.model.Address;

public interface IAddressService {
	
	public Address addAddress(Address address);

	public void removeAddress(long addressId);
	
	public List<Address> getAllAddress(String addressId);
	
	public Address updateAddress(Address address, long addressId);
}
