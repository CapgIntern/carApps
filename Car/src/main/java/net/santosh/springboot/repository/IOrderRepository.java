package net.santosh.springboot.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.santosh.springboot.model.*;

public interface IOrderRepository extends JpaRepository<Order, Long>{
	public Order addOrder(Order order);
	public Order removeOrder(long id);
	public Order  updateOrder(long id, Order order);
	public Order  getOrderDetails(long id);
	public List<Order> getAllOrders(); 

}
