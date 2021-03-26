package net.santosh.springboot.controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.santosh.springboot.model.*;
import net.santosh.springboot.service.*;
import io.swagger.annotations.Api;

@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/c1")
public class PaymentController {
	@Autowired
	IPaymentService iService;
	
	@GetMapping("/payment")
	public String welcome()
	{
		return "PAYMENT";
	}
	@PostMapping("/add")
	public Payment addPayment(@RequestBody Payment payment)
	{
		return iService.addPayment(payment);
	}

	@GetMapping("/getall")
	public List<Payment> getAllPayments(){
		return iService.getAllPaymentDetails();
	}

	@PostMapping("/cus/{userId}")
	public Payment updatePayment(long userId, Payment payment)
	{
		return iService.updatePayment(userId, payment);
	}
	@DeleteMapping("/delete/{id}")
	public HttpStatus deletePayment(@PathVariable long id){
		this.iService.removePayment(id);
		return HttpStatus.OK;
	}
	@GetMapping("/payment/{id}")
	public ResponseEntity<Payment> getPayment(@PathVariable long id){
		return ResponseEntity.ok().body(iService.getPaymentDetails(id));
	}


}

