package net.santosh.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.santosh.springboot.model.*;
import net.santosh.springboot.repository.*;
import net.santosh.springboot.service.*;

import io.swagger.annotations.Api;

@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/o1")
public class OrderController {
	
	@Autowired
	private IOrderService iService;
	
	@PostMapping("/order")
	public Order addOrder(@RequestBody Order order) {
		return iService.addOrder(order);
	}
	@DeleteMapping("/order/{orderId}")
	public Optional<Order> removeOrder(@PathVariable Long orderId){
		return iService.removeOrder(orderId);
	}
	
	@GetMapping("/order/{orderId}")
	public Order getOrderDetails(@PathVariable Long orderId) {
		return iService.getOrderDetails(orderId);
	}
	
	@GetMapping("/allOrders")
	public List<Order> getAllOrders(){
		return iService.getAllOrders();
	}
	
	@PostMapping("/order/{orderId}")
	public Order updateOrder(@PathVariable long orderId, @RequestBody Order order) {
		return iService.updateOrder(orderId, order);
	}
}
