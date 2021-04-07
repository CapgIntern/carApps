package net.santosh.springboot.service;
import net.santosh.springboot.model.*;
import java.util.List;
/****************************************************************************
 * @author               Chitta Yaswanth sai*
 * Description           It is a payment service interface that describes the abstract methods
 *                       used in its service implementation class.
 * version               1.0
 * created date          24-03-2021
 *
 ****************************************************************************/

public interface IPaymentService {
	public Payment addPayment(Payment payment);

	public Payment removePayment(long id);

	public Payment updatePayment(long id, Payment payment);

	public Payment getPaymentDetails(long id);

	public List<Payment> getAllPaymentDetails();
}
