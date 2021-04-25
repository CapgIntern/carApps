package net.santosh.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.santosh.springboot.exception.ModelAddException;
import net.santosh.springboot.exception.ModelNotFoundException;
import net.santosh.springboot.exception.ModelUpdateException;
import net.santosh.springboot.exception.OrderNotFoundException;
import net.santosh.springboot.exception.ResourceNotFoundException;
import net.santosh.springboot.model.Appointment;
import net.santosh.springboot.model.Order;
import net.santosh.springboot.repository.IOrderRepository;
/****************************************************************************
 * @author               V Raghuveer
 * Description           It is a customer service implementation class that implements the methods
 *                       in its service interface.
 * version               1.0
 * created date          24-03-2021
 *
 ****************************************************************************/
@Service
@Transactional
public class IOrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository iOrderRepo;
	
	/************************************************************************************
	 * Method                     addOrder
	 * Description                It is used to add a new order in the database
	 
	 * @ModelAddException         It is raised due to invalid  details
	 * created by                 V Raghuveer
	 * created date               24-03-2021
	 ***********************************************************************************/
	@Override
	public Order addOrder(Order order){
		return iOrderRepo.save(order);
	}
	
	/************************************************************************************
	 * Method                     removeOrder
	 * Description                It is used to remove order in database
	 * @throws orderrNotFoundException 
	 * @orderNotFoundException It is raised when we try to delete order with 
	 *                            invalid  id 
	 * created by                 V Raghuveer
	 * created date               24-03-2021
	 ***********************************************************************************/
	
	@Override
	public Optional<Order> removeOrder(Long orderId) {
		// TODO Auto-generated method stub
		Optional<Order> order = iOrderRepo.findById(orderId);
		try {
			if (order != null) {
				iOrderRepo.deleteById(orderId);
				return order;
			} else {
				throw new OrderNotFoundException("Record not found with id : " + orderId);
			}

		} catch (Exception e) {
			throw new ModelNotFoundException("Couldnt find the order by id" + orderId);
		}

	}

	/************************************************************************************
	 * Method                     getOrder
	 * Description                It is used to get an existing order 
	 *                            in database
	 * @throws orderNotFoundException 
	 * @ModelNotFoundException      It is raised when we try to get order with 
	 *                            invalid  id 
	 * created by                 V Raghuveer
	 * created date               24-03-2021
	 ***********************************************************************************/
	@Override
	public Order getOrderDetails(Long orderId) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		Optional<Order> order = iOrderRepo.findById(orderId);
		if (order.isPresent()) {
			return order.get();
		} else {
			throw new OrderNotFoundException("Record not found with id : " + orderId);
		}
	}
	/************************************************************************************
	 * Method                     getAllorders
	 * Description                It is used to get all existing orders 
	 *                            in database
	 * 
	 * created by                 V Raghuveer
	 * created date               24-03-2021
	 ***********************************************************************************/
	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return iOrderRepo.findAll();
	}

	/************************************************************************************
	 * Method                     updateOrder
	 * Description                It is used to update an existing order details 
	 *                            in database
	 * @OrderNotFoundException      It is raised when we try to update order with 
	 *                            invalid  id 
	 * created by                 V Raghuveer
	 * created date               24-03-2021
	 ***********************************************************************************/
	@Override
	public Order updateOrder(long orderId, Order order) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		Optional<Order> order1 = iOrderRepo.findById(orderId);
		try {
			if (order1.isPresent()) {
				return iOrderRepo.save(order);
			} else {
				throw new OrderNotFoundException("Record not found with id : " + orderId);
			}
		} catch (Exception e1) {
			throw new OrderNotFoundException("Record not found with id : " + orderId);
		}

	}


}
