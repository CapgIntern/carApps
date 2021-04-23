//package net.santosh.springboot;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.times;
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
//
//import net.santosh.springboot.model.Card;
//import net.santosh.springboot.model.Payment;
//import net.santosh.springboot.repository.IPaymentRepository;
//import net.santosh.springboot.service.IPaymentServiceImpl;
//
///**********
// * @author                 CHITTA YASWANTH SAI
// * Description             It is a service implementation test class that defines the methods
// *                         to test the service.
// * Version                 1.0
// * created date            24-03-2021
// *
// **********/
//
//@RunWith(MockitoJUnitRunner.class)
//public class PaymentServiceTest {
//
//	@InjectMocks
//	IPaymentServiceImpl iPaymentServiceImpl;
//
//	@Mock
//	IPaymentRepository iPaymentRepository;
//	
//	/**********
//	 * Method                     addPaymentTest
//	 * Description                It is used to test addPayment method 
//	 * created by                 CHITTA YASWANTH SAI
//	 * created date               24-03-2021
//	 ***********/
//
//	@Test
//	public void addPaymentTest() {
//		LocalDate expiryDate = LocalDate.parse("2025-07-01");
//		Card card = new Card(3, "pavan", "124", expiryDate, 709);
//		Payment payment = new Payment(3, "debit", "paid", card);
//		when(iPaymentRepository.save(payment)).thenReturn(payment);
//
//		Payment values = iPaymentServiceImpl.addPayment(payment);
//
//		assertEquals(payment.toString(), values.toString());
//
//	}
//
//	/**********
//	 * Method                     removepaymentTest
//	 * Description                It is used to test removePayment method 
//	 * created by                 CHITTA YASWANTH SAI
//	 * created date               24-03-2021
//	 ***********/
//
//
//	@Test
//	public void removePaymentTest() {
//		verify(iPaymentRepository, never()).delete(any(Payment.class));
//	}
//
//	/**********
//	 * Method                     getPaymentTest
//	 * Description                It is used to test getPayments method 
//	 * created by                 CHITTA YASWANTH SAI
//	 * created date               24-03-2021
//	 ***********/
//
//	@Test
//	public void getPaymentDetailsTest() {
//		LocalDate expiryDate = LocalDate.parse("2025-07-01");
//		Card card = new Card(3, "pavan", "124", expiryDate, 709);
//		Payment payment = new Payment(3, "debit", "paid", card);
//
//		when(iPaymentRepository.findById(3L)).thenReturn(Optional.of(payment));
//
//		iPaymentServiceImpl.getPaymentDetails(3L);
//
//		assertEquals("debit", payment.getType());
//		assertEquals("paid", payment.getStatus());
//		assertEquals(card, payment.getCard());
//	}
//	
//	/**********
//	 * Method                     updatePaymentTest
//	 * Description                It is used to test updatePayment method 
//	 * created by                 CHITTA YASWANTH SAI
//	 * created date               24-03-2021
//	 ***********/
//
//	@Test
//	public void updatePaymentTest() {
//		LocalDate expiryDate = LocalDate.parse("2025-07-01");
//		Card card = new Card(3, "pavan", "124", expiryDate, 709);
//		Payment payment = new Payment(3, "debit", "paid", card);
//
//		LocalDate newExpiryDate = LocalDate.parse("2024-10-11");
//		Card newCard = new Card(7, "sairam", "124", newExpiryDate, 556);
//		Payment newPayment = new Payment(6, "debit", "paid", newCard);
//
//		when(iPaymentRepository.findById(3L)).thenReturn(Optional.of(payment));
//
//		iPaymentServiceImpl.updatePayment(3L, payment);
//
//		assertEquals("debit", newPayment.getType());
//		assertEquals("paid", newPayment.getStatus());
//		assertEquals(newCard, newPayment.getCard());
//
//	}
//	
//	/**********
//	 * Method                     getAllPaymentsTest
//	 * Description                It is used to test getAllPayments method 
//	 * created by                 CHITTA YASWANTH SAI
//	 * created date               24-03-2021
//	 ***********/
//
//
//	@Test
//	public void getAllPaymentDetailsTest() {
//		List<Payment> payment_list = new ArrayList<Payment>();
//		LocalDate expiryDate1 = LocalDate.parse("2025-07-01");
//		Card card1 = new Card(8, "raghu", "124", expiryDate1, 234);
//		Payment payment1 = new Payment(8, "debit", "paid", card1);
//
//		LocalDate expiryDate2 = LocalDate.parse("2025-07-01");
//		Card card2 = new Card(3, "pavan", "124", expiryDate2, 709);
//		Payment payment2 = new Payment(3, "debit", "paid", card2);
//
//		LocalDate expiryDate3 = LocalDate.parse("2024-10-11");
//		Card card3 = new Card(7, "sairam", "124", expiryDate3, 556);
//		Payment payment3 = new Payment(6, "debit", "paid", card3);
//
//		payment_list.add(payment1);
//		payment_list.add(payment2);
//		payment_list.add(payment3);
//
//		when(iPaymentRepository.findAll()).thenReturn(payment_list);
//
//		List<Payment> check_payment_list = iPaymentServiceImpl.getAllPaymentDetails();
//
//		assertEquals(3, check_payment_list.size());
//		verify(iPaymentRepository, times(1)).findAll();
//	}
//}