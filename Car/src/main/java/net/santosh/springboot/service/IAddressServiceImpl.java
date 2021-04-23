package net.santosh.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import net.santosh.springboot.exception.ModelAddException;
import net.santosh.springboot.exception.ModelEmptyListException;
import net.santosh.springboot.exception.ModelUpdateException;
import net.santosh.springboot.exception.ResourceNotFoundException;
import net.santosh.springboot.model.Address;
import net.santosh.springboot.model.Car;
import net.santosh.springboot.repository.IAddressRepository;

public class IAddressServiceImpl implements IAddressService{

	@Autowired
	private IAddressRepository iAddressRepository;
	
	@Override
	public Address addAddress(Address address) {
		try {
			return iAddressRepository.save(address);
		} catch (Exception e) {
			throw new ModelAddException("Can't add Address, please add the proper details");
		}
	}

	@Override
	public void removeAddress(long addressId) {
		Optional<Address> addressList = this.iAddressRepository.findById(addressId);

		if (addressList.isPresent()) {
			this.iAddressRepository.delete(addressList.get());
		} else {
			throw new ResourceNotFoundException("cannot find the address");
		}
	}

	@Override
	public List<Address> getAllAddress(String userId) {
		try {
			return (List<Address>) iAddressRepository.findByUserId(userId);
		} catch (Exception e) {
			throw new ModelEmptyListException("Error retriving address...please try again");
		}
	}

	@Override
	public Address updateAddress(Address address, long addressId) {
		try {
			Optional<Address> addresslist = this.iAddressRepository.findById(addressId);
			if (addresslist.isPresent()) {
				Address addressUpdate = addresslist.get();
				addressUpdate.setArea(address.getArea());
				addressUpdate.setCity(address.getCity());
				addressUpdate.setDoorNo(address.getDoorNo());
				addressUpdate.setPincode(address.getPincode());
				addressUpdate.setState(address.getState());
				addressUpdate.setStreet(address.getStreet());
				addressUpdate.setUserId(address.getUserId());
				iAddressRepository.save(addressUpdate);
				return addressUpdate;
			} else {
				throw new ResourceNotFoundException("Address not found");
			}
		} catch (Exception e) {
			throw new ModelUpdateException("Couldn't update the the address, please try again ");
		}
	}

	
}
