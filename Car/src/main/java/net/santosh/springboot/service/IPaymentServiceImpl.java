package net.santosh.springboot.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.santosh.springboot.exception.*;
import net.santosh.springboot.model.*;

import net.santosh.springboot.repository.*;


@Service
@Transactional
public class IPaymentServiceImpl implements IPaymentService {

	@Autowired
 	private IPaymentRepository PaymentRepository;

	@Override
	public Payment addPayment(Payment payment) {
		// TODO Auto-generated method stub
		return PaymentRepository.save(payment);
	}

	
	
	@Override
	public Payment updatePayment(long id, Payment payment) {
		// TODO Auto-generated method stub
		return PaymentRepository.save(payment);

	}


	@Override
	public List<Payment> getAllPaymentDetails() {
		// TODO Auto-generated method stub
		return (List<Payment>) PaymentRepository.findAll();
	}

	@Override
	public void removePayment(long id) {
		// TODO Auto-generated method stub
		 Optional<Payment> paymentDb = this.PaymentRepository.findById(id);
			
			if(paymentDb.isPresent()) {
				this.PaymentRepository.delete(paymentDb.get());
			}else {
				throw new ResourceNotFoundException("Record not found with id : " + id);
			}
		
	}

	@Override
	public Payment getPaymentDetails(long id) {
		// TODO Auto-generated method stub
		 Optional<Payment> appointmentDb = this.PaymentRepository.findById(id);
			
			if(appointmentDb.isPresent()) {
				return appointmentDb.get();
			}else {
				throw new ResourceNotFoundException("Record not found with id : " + id);
			}

	}
	

}
