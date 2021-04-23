//package net.santosh.springboot;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import net.santosh.springboot.exception.CustomerNotFoundException;
//import net.santosh.springboot.model.Address;
//import net.santosh.springboot.model.Customer;
//import net.santosh.springboot.repository.ICustomerRepository;
//import net.santosh.springboot.service.ICustomerServiceImpl;
//
///**********************************************************************************
// * @author                 G.sai nikesh
// * Description             It is a service implementation test class that defines the methods
// *                         to test the service.
// * Version                 1.0
// * created date            24-03-2021
// *
// ****************************************************************************************/
//@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
//public class CustomerModuleTest {
//
//	@InjectMocks
//	ICustomerServiceImpl iCustomerImpl;
//
//	@Mock
//	ICustomerRepository iCustomerRepository;
//	/************************************************************************************
//	 * Method                     addcustomerTest
//	 * Description                It is used to test addcustomer method 
//	 * created by                 G sai nikesh
//	 * created date               24-03-2021
//	 ***********************************************************************************/
//	@Test
//	public void addCustomerTest() {
//		LocalDate dob_1 = LocalDate.of(2000, 05, 03);
//		Address address = new Address("YV", "Kadapa", "Kadapa", "AP", 516001);
//		Customer customer_1 = new Customer("123", "Nikesh", "sainikesh94@gmail.com", "9494420652", dob_1, address);
//		when(iCustomerRepository.save(customer_1)).thenReturn(customer_1);
//		Customer customer_values = iCustomerImpl.addCustomer(customer_1);
//		assertEquals("123", customer_values.getUserId());
//		assertEquals("Nikesh", customer_values.getName());
//		assertEquals("sainikesh94@gmail.com", customer_values.getEmail());
//	}
//	/************************************************************************************
//	 * Method                     removecustomerTest
//	 * Description                It is used to test removecustomer method 
//	 * created by                 G sai nikesh
//	 * created date               24-03-2021
//	 ***********************************************************************************/
//	@Test
//	public void removeCustomerTest() {
//		verify(iCustomerRepository, never()).delete(any(Customer.class));
//	}
//
//	/************************************************************************************
//	 * Method                     getcustomerTest
//	 * Description                It is used to test getcustomer method 
//	 * created by                 G sai nikesh
//	 * created date               24-03-2021
//	 ***********************************************************************************/
//	@Test
//	public void getCustomerTest() throws CustomerNotFoundException {
//		LocalDate dob_1 = LocalDate.of(2000, 05, 03);
//		Address address = new Address("YV", "Kadapa", "Kadapa", "AP", 516001);
//		Optional<Customer> customer_1 = Optional
//				.of(new Customer("123", "Nikesh", "sainikesh94@gmail.com", "9494420652", dob_1, address));
//		when(iCustomerRepository.findById("123")).thenReturn(customer_1);
//		Customer customer_values = iCustomerImpl.getCustomer("123");
//		assertEquals("123", customer_values.getUserId());
//		assertEquals("Nikesh", customer_values.getName());
//		assertEquals("sainikesh94@gmail.com", customer_values.getEmail());
//	}
//
//	/************************************************************************************
//	 * Method                     gettallcustomerTest
//	 * Description                It is used to test getallcustomers method 
//	 * created by                 G sai nikesh
//	 * created date               24-03-2021
//	 ***********************************************************************************/
//	@Test
//	public void getAllCustomersTest() {
//		List<Customer> customer_list = new ArrayList<Customer>();
//		LocalDate dob_1 = LocalDate.of(2000, 05, 03);
//		Address address = new Address("YV", "Kadapa", "Kadapa", "AP", 516001);
//		Customer customer_1 = new Customer("123", "Nikesh", "sainikesh94@gmail.com", "9494420652", dob_1, address);
//		LocalDate dob_2 = LocalDate.of(2000, 9, 03);
//		Customer customer_2 = new Customer("125", "Sai", "sai74@gmail.com", "7589512689", dob_2, address);
//		customer_list.add(customer_2);
//		customer_list.add(customer_1);
//		when(iCustomerRepository.findAll()).thenReturn(customer_list);
//		List<Customer> check_customer_list = iCustomerImpl.getAllCustomers();
//		assertEquals(2, check_customer_list.size());
//	}
//
//	/************************************************************************************
//	 * Method                     updateCustomerTest
//	 * Description                It is used to test updateAppointment method 
//	 * created by                 G Sai Nikesh
//	 * created date               24-03-2021
//	 ***********************************************************************************/
//	@Test
//	public void updateCustomerTest() throws CustomerNotFoundException {
//		LocalDate dob_1 = LocalDate.of(2000, 05, 03);
//		Address address = new Address("YV", "Kadapa", "Kadapa", "AP", 516001);
//		Optional<Customer> customer_1 = Optional
//				.of(new Customer("123", "Sai", "sainikesh94@gmail.com", "9494420652", dob_1, address));
//
//		Address new_address = new Address("BKM", "Kadapa", "Kadapa", "AP", 516002);
//		Customer new_customer_1 = new Customer("123", "Sai Nikesh", "sainikesh94@gmail.com", "9494420652", dob_1,
//				new_address);
//		when(iCustomerRepository.findById("123")).thenReturn(customer_1);
//		iCustomerImpl.updateCustomer("123", new_customer_1);
//		assertEquals("Sai Nikesh", new_customer_1.getName());
//	}
//}
