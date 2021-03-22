package net.santosh.springboot.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.santosh.springboot.exception.ResourceNotFoundException;
import net.santosh.springboot.model.Order;
import net.santosh.springboot.repository.IAppointmentRepository;
import net.santosh.springboot.repository.IOrderRepository;


@Service
@Transactional

public class IOrderServiceImpl implements IOrderService {
	@Autowired
	private IOrderRepository IOrderRepository;
   
	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order removeOrder(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order updateOrder(long id, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderDetails(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
