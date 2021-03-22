package net.santosh.springboot.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.santosh.springboot.exception.ResourceNotFoundException;
import net.santosh.springboot.model.Payment;
import net.santosh.springboot.repository.IAppointmentRepository;
import net.santosh.springboot.repository.IPaymentRepository;

@Service
@Transactional
public class IPaymentServiceImpl implements IPaymentService {
	
	@Autowired
	private IPaymentRepository IPaymentRepository;

	@Override
	public Payment addPayment(Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment removePayment(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment updatePayment(long id, Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment getPaymentDetails(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
