package net.santosh.springboot.service;
import net.santosh.springboot.model.*;
import java.util.List;


public interface IOrderService {
	public Order addOrder(Order order);
	public Order removeOrder(long id);
	public Order  updateOrder(long id, Order order);
	public Order  getOrderDetails(long id);
	public List<Order> getAllOrders(); 

}