package net.santosh.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.santosh.springboot.exception.ModelAddException;
import net.santosh.springboot.exception.ModelDeleteException;
import net.santosh.springboot.exception.ModelEmptyListException;
import net.santosh.springboot.exception.ModelNotFoundException;
import net.santosh.springboot.exception.ModelUpdateException;
import net.santosh.springboot.exception.ResourceNotFoundException;
import net.santosh.springboot.model.Payment;
import net.santosh.springboot.repository.IPaymentRepository;
@Service("paymentser")
@Transactional
/****************************************************************************
 * @author               CHITTA YASWANTH SAI
 * Description           It is a payment service implementation class that defines the methods
 *                       in its service interface.
 * version               1.0
 * created date          24-03-2021
 *
 ****************************************************************************/
public class IPaymentServiceImpl implements IPaymentService {

	@Autowired
	IPaymentRepository paymentRepository;
	/************************************************************************************
	 * Method                     addPayment
	 * Description                It is used to add a new payment in the database
	 
	 * @ModelAddException         It is raised due to invalid user details
	 * created by                 CHITTA YASWANTH SAI
	 * created date               24-03-2021
	 ***********************************************************************************/

	@Transactional
	public Payment addPayment(Payment payment) {
		try {
			return paymentRepository.save(payment);
			} catch (Exception e) {
				throw new ModelAddException("Can't add the model Payment, please add the proper details");
			}

	}
	
	/************************************************************************************
	 * Method                     removePayment
	 * Description                It is used to remove payment in database
	 * @ResourceNotFoundException It is raised when we try to delete payment with 
	 *                            invalid  id 
	 * created by                 CHITTA YASWANTH SAI
	 * created date               24-03-2021
	 ***********************************************************************************/
	@Override
	@Transactional
	public Payment removePayment(long id) {
		Optional<Payment> payment = paymentRepository.findById(id);
		if (payment.isEmpty()) {
			throw new ModelDeleteException("paymentId does not exist to delete");
		} else {
			paymentRepository.delete(payment.get());
			return payment.get();
		}
	}
	
	/************************************************************************************
	 * Method                     updatePayment
	 * Description                It is used to update an existing payment 
	 *                            in database
	 * @ModelUpdateException      It is raised when we try to update payment with 
	 *                            invalid  id 
	 * created by                 CHITTA YASWANTH SAI
	 * created date               24-03-2021
	 ***********************************************************************************/

	@Transactional
	public Payment updatePayment(long id, Payment payment) {
		Optional<Payment> payment1 = paymentRepository.findById(id);
		if (payment1.isEmpty()) {
			throw new ModelUpdateException("PaymentId not found");
		} else
			paymentRepository.save(payment);
		return payment;

	}
	
	/************************************************************************************
	 * Method                     getPayment
	 * Description                It is used to get an existing payment 
	 *                            in database
	 * @ModelNotFoundException      It is raised when we try to get payment with 
	 *                            invalid  id 
	 * created by                 CHITTA YASWANTH SAI
	 * created date               24-03-2021
	 ***********************************************************************************/

	@Transactional
	public Payment getPaymentDetails(long id) {
		// TODO Auto-generated method stub
		Optional<Payment> payment = paymentRepository.findById(id);
		try {
			if(payment.isPresent()) {
				return payment.get();
			}else {
				throw new ResourceNotFoundException("Record not found with id : " + id);
			}
			}
			catch(Exception e) {
				throw new ModelNotFoundException("Couldnt find the payment by id"+ id );
			}
	}
	
	/************************************************************************************
	 * Method                     getAllpayments
	 * Description                It is used to get all existing payments 
	 *                            in database
	 * @ModelEmptyListException   It is raised when we try to get payments when
	 *                            there are no actual payments.
	 * created by                 CHITTA YASWANTH SAI
	 * created date               24-03-2021
	 ***********************************************************************************/

	@Transactional
	public List<Payment> getAllPaymentDetails() {
		// TODO Auto-generated method stub
		try {
			return this.paymentRepository.findAll();
			}catch(Exception e) {
				throw new ModelEmptyListException("error retriving payments...please try again" );
				
			}

	}

	

	
}

