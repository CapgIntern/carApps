package net.santosh.springboot.service;
import net.santosh.springboot.model.*;
import java.util.List;

import java.util.*;




public interface IOrderService {
	public Order addOrder(Order order);
	public Optional<Order> removeOrder(Long orderId);
	public Order getOrderDetails(Long orderId);
	public List<Order> getAllOrders();
	public Order updateOrder(long orderId, Order order);
	
	
}
