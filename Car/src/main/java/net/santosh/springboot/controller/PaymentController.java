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
import net.santosh.springboot.model.Payment;
import net.santosh.springboot.service.IPaymentService;

@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/")
/***********************************************************
 * @author              CHITTA YASWANTH SAI
 * Description          It is a controller class that controls the data flow into model object 
 *                      and updates the view whenever data changes
 * Version              1.0
 * created date         24-03-2021
 ***********************************************************/
public class PaymentController {

	@Autowired

	private IPaymentService paymentService;

	/*****************************************************
	 * Method              addPayment
	 * Description         Displays the newly added user payment in database
	 * @PostMapping        used to add new payment to database 
	 * @Return             returns newly added payment details
	 * Created by:          CHITTA YASWANTH SAI
	 * created date        24-03-2021
	 *****************************************************/
	@PostMapping("/addPayment")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
		Payment resultpayment = paymentService.addPayment(payment);
		return new ResponseEntity<Payment>(resultpayment, HttpStatus.OK);
	}

	/*****************************************************
	 * Method              removePayment
	 * Description         Displays remaining payments after deletion
	 * @DeleteMapping      used to delete payment by id
	 * @Return             remaining payments after deletion
	 * Created by:         CHITTA YASWANTH SAI
	 * created date        24-03-2021
	 *****************************************************/
	@DeleteMapping("/removePayment/{id}")
	public Payment removePayment(@PathVariable long id) {
		return paymentService.removePayment(id);
	}

	/*****************************************************
	 * Method              updatePayment
	 * Description         Displays remaining payments after deletion
	 * @PutMapping         used to update payment by id
	 * @Return             payments after updation
	 * Created by:         CHITTA YASWANTH SAI
	 * created date        24-03-2021
	 *****************************************************/

	@PutMapping("/updatePayment")
	public ResponseEntity<Payment> updatePayment(@RequestBody long id, Payment payment) {

		Payment resultPayment = paymentService.updatePayment(id, payment);
		return new ResponseEntity<Payment>(resultPayment, HttpStatus.OK);
	}

	/*****************************************************
	 * Method              getPaymentbyid
	 * Description         Displays all the payments by payment id
	 * @GetMapping         used to get the payments by appointment id
	 * @Return             returns all the payments of the user by payment id
	 * Created by:         CHITTA YASWANTH SAI
	 * created date        24-03-2021
	 *****************************************************/

	@GetMapping("/getPaymentDetails/{id}")
	public ResponseEntity<Payment> GetPaymentDetails(@PathVariable long id) {
		Payment resultPayment = paymentService.getPaymentDetails(id);
		return new ResponseEntity<Payment>(resultPayment, HttpStatus.OK);
	}

	/*****************************************************
	 * Method              get all payments
	 * Description         Displays all the payments
	 * @GetMapping         used to get the payments
	 * @Return             returns all the payments of the user
	 * Created by:         CHITTA YASWANTH SAI
	 * created date        24-03-2021
	 *****************************************************/

	@GetMapping("/getAllPaymentDetails")
	public ResponseEntity<List<Payment>> getAllPayment() {
		List<Payment> resultPayment = paymentService.getAllPaymentDetails();
		return new ResponseEntity<List<Payment>>(resultPayment, HttpStatus.OK);
	}

}
