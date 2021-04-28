package net.santosh.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.santosh.springboot.model.Address;
import net.santosh.springboot.model.Car;
import net.santosh.springboot.service.IAddressServiceImpl;

@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	IAddressServiceImpl iAddressService;

	@GetMapping("/addressbyuserid/{userId}")
	public ResponseEntity<List<Address>> getAddressByUserId(@PathVariable("userId") String userId) {
		return ResponseEntity.ok().body(iAddressService.getAllAddress(userId));
	}
	
	@PostMapping("/addaddress")
	public ResponseEntity<Address> addAddress(@RequestBody Address address) {
		return ResponseEntity.ok().body(this.iAddressService.addAddress(address));
	}
	
	@GetMapping("/addressbyid/{addressid}")
	public ResponseEntity<Address> getCar(@PathVariable("addressid") long id) {
		return ResponseEntity.ok().body(iAddressService.getAddress(id));
	}

	
	@PutMapping("/updateaddress/{addressid}")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable("addressid") long addressId) {
		return ResponseEntity.ok().body(this.iAddressService.updateAddress(address, addressId));
	}
	
	@DeleteMapping("/address/{addressid}")
	public HttpStatus removeAddress(@PathVariable("addressid") long addressId) {
		this.iAddressService.removeAddress(addressId);
		return HttpStatus.OK;
	}
}
