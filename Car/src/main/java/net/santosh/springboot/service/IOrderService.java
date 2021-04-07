package net.santosh.springboot.service;

import java.util.List;
import java.util.Optional;

import net.santosh.springboot.exception.OrderNotFoundException;
import net.santosh.springboot.model.Order;

/****************************************************************************
 * @author               Naga Raghuveer
 * Description           It is a car service interface that describes the abstract methods
 *                       used in its service implementation class.
 * version               1.0
 * created date          24-03-2021
 *
 ****************************************************************************/
public interface IOrderService {
	public Order addOrder(Order order);

	public Optional<Order> removeOrder(Long orderId);

	public Order getOrderDetails(Long orderId) throws OrderNotFoundException;

	public List<Order> getAllOrders();

	public Order updateOrder(long orderId, Order order) throws OrderNotFoundException;

}
