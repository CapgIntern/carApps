package net.santosh.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.santosh.springboot.exception.OrderNotFoundException;
import net.santosh.springboot.model.Order;
import net.santosh.springboot.service.IOrderService;
import net.santosh.springboot.service.IPaymentService;

@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/o1")
/***********************************************************
 * @author              V Raghuveer
 * Description          It is a controller class that controls the data flow into model object 
 *                      and updates the view whenever data changes
 * Version              1.0
 * created date         24-03-2021
 ***********************************************************/
public class OrderController {

	@Autowired
	private IOrderService iService;
	
	/*****************************************************
	 * Method              addOrder
	 * Description         Displays the newly added order details in database
	 * @PostMapping        used to add new order to database 
	 * @Return             returns newly added order details
	 * Created by:         V Raghuveer
	 * created date        24-03-2021
	 *****************************************************/
	@PostMapping("/order")
	public Order addOrder(@RequestBody Order order) {
		return iService.addOrder(order);
	}
	/*****************************************************
	 * Method              removeOrder
	 * Description         Displays remaining order after deletion
	 * @DeleteMapping      used to delete order by orderId
	 * @Return             returns deleted order
	 * Created by:         V Raghuveer
	 * created date        24-03-2021
	 *****************************************************/
	@DeleteMapping("/order/{orderId}")
	public Optional<Order> removeOrder(@PathVariable Long orderId) {
		return iService.removeOrder(orderId);
	}
	
	/*****************************************************
	 * Method              getorderbyid
	 * Description         Displays the order by userId
	 * @GetMapping         used to get the order details by orderId
	 * @Return             returns the order details by orderId
	 * Created by:         V Raghuveer
	 * created date        24-03-2021
	 *****************************************************/

	@GetMapping("/order/{orderId}")
	public Order getOrderDetails(@PathVariable Long orderId) throws OrderNotFoundException {
		return iService.getOrderDetails(orderId);
	}
	
	/*****************************************************
	 * Method              getAllOrders
	 * Description         Displays all the orders
	 * @GetMapping         used to get the orders
	 * @Return             returns all the orders
	 * Created by:         V Raghuveer
	 * created date        24-03-2021
	 *****************************************************/

	@GetMapping("/allOrders")
	public List<Order> getAllOrders() {
		return iService.getAllOrders();
	}
	
	/*****************************************************
	 * Method              updateOrder
	 * Description         Displays order details after updation
	 * @PostMapping         used to update order by id
	 * @Return             customer after orders
	 * Created by:         V Raghuveer
	 * created date        24-03-2021
	 *****************************************************/
	@PostMapping("/order/{orderId}")
	public Order updateOrder(@PathVariable long orderId, @RequestBody Order order) throws OrderNotFoundException {
		return iService.updateOrder(orderId, order);
	}
	
	@PutMapping("/addpaymentid/{orderid}/{paymentid}")
	public HttpStatus addOrderId(@PathVariable("orderid") long orderId, @PathVariable("paymentid") long paymentId) {
		this.iService.addPaymentId(orderId, paymentId);
		return HttpStatus.OK;
	}
}
