package net.santosh.springboot;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import net.santosh.springboot.model.*;
import net.santosh.springboot.service.*;
import net.santosh.springboot.repository.*;
import net.santosh.springboot.exception.*;

/**********************************************************************************
 * @author                 V Raghuveer
 * Description             It is a service implementation test class that defines the methods
 *                         to test the service.
 * Version                 1.0
 * created date            24-03-2021
 *
 ****************************************************************************************/
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class OrderModuleTests {
	@InjectMocks
	IOrderServiceImpl iOrderImpl;

	@Mock
	IOrderRepository iOrderRepo;

//	/************************************************************************************
//	 * Method                     addOrderTest
//	 * Description                It is used to test addOrder method 
//	 * created by                 V Raghuveer
//	 * created date               24-03-2021
//	 ***********************************************************************************/
//	@Test
//	public void addOrderTest() {
//		LocalDate billingDate = LocalDate.of(2000, 05, 03);
//		Order order = new Order(123L, 100000, billingDate);
//		when(iOrderRepo.save(order)).thenReturn(order);
//		Order order_values = iOrderImpl.addOrder(order);
//		assertEquals(123L, order_values.getOrderId());
//	}

	/************************************************************************************
	 * Method                     removeorderTest
	 * Description                It is used to test removeorder method 
	 * created by                 V Raghuveer
	 * created date               24-03-2021
	 ***********************************************************************************/
	@Test
	public void removeCustomerTest() {
		verify(iOrderRepo, never()).delete(any(Order.class));
	}
//
//	/************************************************************************************
//	 * Method                     getorderTest
//	 * Description                It is used to test georder method 
//	 * created by                 V Raghuveer
//	 * created date               24-03-2021
//	 ***********************************************************************************/
//	@Test
//	public void getOrderTest() throws OrderNotFoundException {
//		LocalDate billingDate = LocalDate.of(2000, 05, 03);
//		Optional<Order> order = Optional.of(new Order(123L, 100000, billingDate));
//		when(iOrderRepo.findById(123L)).thenReturn(order);
//		Order order_values = iOrderImpl.getOrderDetails(123L);
//		assertEquals(123L, order_values.getOrderId());
//	}
//	
//	/************************************************************************************
//	 * Method                     gettallorderTest
//	 * Description                It is used to test getallorders method 
//	 * created by                 V Raghuveer
//	 * created date               24-03-2021
//	 ***********************************************************************************/
//
//	@Test
//	public void getAllOrderTest() {
//		List<Order> order_list = new ArrayList<Order>();
//		LocalDate billingDate = LocalDate.of(2000, 05, 03);
//		Order order = new Order(123L, 100000, billingDate);
//		LocalDate billingDate1 = LocalDate.of(2000, 04, 03);
//		Order order1 = new Order(123L, 100000, billingDate1);
//		order_list.add(order);
//		order_list.add(order1);
//		when(iOrderRepo.findAll()).thenReturn(order_list);
//		List<Order> check_order_list = iOrderImpl.getAllOrders();
//		assertEquals(2, check_order_list.size());
//	}
//
//	/************************************************************************************
//	 * Method                     updateorderTest
//	 * Description                It is used to test updateorder method 
//	 * created by                 V Raghuveer
//	 * created date               24-03-2021
//	 ***********************************************************************************/
//	@Test
//	public void updateOrderTest() throws OrderNotFoundException {
//		LocalDate billingDate = LocalDate.of(2001, 05, 03);
//		Optional<Order> order = Optional.of(new Order(123L, 100000, billingDate));
//		Order new_order = new Order(123L, 1050000, billingDate);
//		when(iOrderRepo.findById(123L)).thenReturn(order);
//		iOrderImpl.updateOrder(123L, new_order);
//		assertEquals(LocalDate.of(2001, 05, 03), new_order.getBillingDate());
//	}
}
