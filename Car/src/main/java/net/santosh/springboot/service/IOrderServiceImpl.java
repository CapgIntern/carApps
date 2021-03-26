package net.santosh.springboot.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.santosh.springboot.model.*;
import net.santosh.springboot.repository.*;

@Service
@Transactional
public class IOrderServiceImpl implements IOrderService{
	
	@Autowired
	private IOrderRepository iOrderRepo;

	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return iOrderRepo.saveAndFlush(order);
	}

	@Override
	public Optional<Order> removeOrder(Long orderId) {
		// TODO Auto-generated method stub
		Optional<Order> order=iOrderRepo.findById(orderId);
		if(order!=null)
			iOrderRepo.deleteById(orderId);
		return order;
	}

	@Override
	public Order getOrderDetails(Long orderId) {
		// TODO Auto-generated method stub
		Optional<Order> order=iOrderRepo.findById(orderId);
		return order.get();
		
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return iOrderRepo.findAll();
	}
	@Override
	public Order updateOrder(long orderId, Order order) {
		// TODO Auto-generated method stub
		Order order1=getOrderDetails(orderId);
		BeanUtils.copyProperties( order1, order);
		return order;
		
	}

	
}
