//package net.santosh.springboot;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
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
//import net.santosh.springboot.model.Appointment;
//
//import net.santosh.springboot.repository.IAppointmentRepository;
//import net.santosh.springboot.service.IAppointmentServiceImpl;
///**********************************************************************************
// * @author                 R saisantosh kumar reddy
// * Description             It is a service implementation test class that defines the methods
// *                         to test the service.
// * Version                 1.0
// * created date            24-03-2021
// *
// ****************************************************************************************/
//@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
//public class IAppointmentServiceTest {
//
//	@InjectMocks
//	IAppointmentServiceImpl iAppointmentServiceImpl;
//
//	@Mock
//	IAppointmentRepository iAppointmentRepository;
//	/************************************************************************************
//	 * Method                     addAppointmentTest
//	 * Description                It is used to test addAppointment method 
//	 * created by                 R saisantosh kumar reddy
//	 * created date               24-03-2021
//	 ***********************************************************************************/
//	
//	@Test
//	public void addAppointmentTest() {
//		LocalDate preferredDate = LocalDate.of(2007, 12, 03);
//		LocalTime preferredTime = LocalTime.of(8, 9);
//		Appointment appointment = new Appointment(1, "kavoor", "Open", preferredDate, preferredTime);
//		when(iAppointmentRepository.save(appointment)).thenReturn(appointment);
//
//		Appointment appointment_values = iAppointmentServiceImpl.addAppointment(appointment);
//		assertEquals(1, appointment_values.getAppointmentId());
//		assertEquals("kavoor", appointment_values.getLocation());
//		assertEquals("Open", appointment_values.getInspectionType());
//		assertEquals(preferredDate, appointment_values.getPreferredDate());
//		assertEquals(preferredTime, appointment_values.getPreferredTime());
//
//	}
//	/************************************************************************************
//	 * Method                     removeAppointmentTest
//	 * Description                It is used to test removeAppointment method 
//	 * created by                 R saisantosh kumar reddy
//	 * created date               24-03-2021
//	 ***********************************************************************************/
//	
//	@Test
//	public void removeAppointmenTest() {
//		verify(iAppointmentRepository, never()).delete(any(Appointment.class));
//
//	}
//	/************************************************************************************
//	 * Method                     getAppointmentTest
//	 * Description                It is used to test getAppointment method 
//	 * created by                 R saisantosh kumar reddy
//	 * created date               24-03-2021
//	 ***********************************************************************************/
//	@Test
//	public void getAppointmentTest() {
//		LocalDate preferredDate = LocalDate.of(2007, 12, 03);
//		LocalTime preferredTime = LocalTime.of(8, 9);
//		Optional<Appointment> appointmentList = Optional
//				.of(new Appointment(1, "kavoor", "Open", preferredDate, preferredTime));
//		when(iAppointmentRepository.findById(1L)).thenReturn(appointmentList);
//
//		Appointment appointment_values = iAppointmentServiceImpl.getAppointment(1);
//
//		assertEquals(1, appointment_values.getAppointmentId());
//		assertEquals("kavoor", appointment_values.getLocation());
//		assertEquals("Open", appointment_values.getInspectionType());
//		assertEquals(preferredDate, appointment_values.getPreferredDate());
//		assertEquals(preferredTime, appointment_values.getPreferredTime());
//
//	}
//	
//	/************************************************************************************
//	 * Method                     getAllAppointmentTest
//	 * Description                It is used to test getAllAppointments method 
//	 * created by                 R saisantosh kumar reddy
//	 * created date               24-03-2021
//	 ***********************************************************************************/
//	
//	@Test
//	public void getAllAppointmentsTest() {
//		List<Appointment> appointment_list = new ArrayList<Appointment>();
//		LocalDate preferredDate_1 = LocalDate.of(2007, 12, 03);
//		LocalTime preferredTime_1 = LocalTime.of(8, 9);
//		Appointment appointment_values_1 = new Appointment(1, "kavoor", "Open", preferredDate_1, preferredTime_1);
//		LocalDate preferredDate_2 = LocalDate.of(2007, 12, 03);
//		LocalTime preferredTime_2 = LocalTime.of(8, 9);
//		Appointment appointment_values_2 = new Appointment(2, "chennai", "Open", preferredDate_2, preferredTime_2);
//		LocalDate preferredDate_3 = LocalDate.of(2007, 12, 03);
//		LocalTime preferredTime_3 = LocalTime.of(8, 9);
//		Appointment appointment_values_3 = new Appointment(3, "mumbai", "Open", preferredDate_3, preferredTime_3);
//
//		appointment_list.add(appointment_values_1);
//		appointment_list.add(appointment_values_2);
//		appointment_list.add(appointment_values_3);
//
//		when(iAppointmentRepository.findAll()).thenReturn(appointment_list);
//
//		List<Appointment> check_appointment_list = iAppointmentServiceImpl.getAllAppointments();
//
//		assertEquals(3, check_appointment_list.size());
//		verify(iAppointmentRepository, times(1)).findAll();
//
//	}
//	
//	/************************************************************************************
//	 * Method                     updateAppointmentTest
//	 * Description                It is used to test updateAppointment method 
//	 * created by                 R saisantosh kumar reddy
//	 * created date               24-03-2021
//	 ***********************************************************************************/
//	
//	@Test
//	public void updateAppointmentTest() {
//		LocalDate preferredDate = LocalDate.of(2007, 12, 03);
//		LocalTime preferredTime = LocalTime.of(8, 9);
//		Optional<Appointment> appointment_values = Optional
//				.of(new Appointment(1, "kavoor", "Open", preferredDate, preferredTime));
//
//		LocalDate preferredDate_2 = LocalDate.of(2007, 12, 03);
//		LocalTime preferredTime_2 = LocalTime.of(8, 9);
//		Appointment new_appointment_values = new Appointment(3, "mumbai", "Open", preferredDate_2, preferredTime_2);
//
//		when(iAppointmentRepository.findById(3L)).thenReturn(appointment_values);
//
//		iAppointmentServiceImpl.updateAppointment(new_appointment_values);
//
//		assertEquals(3, new_appointment_values.getAppointmentId());
//		assertEquals("mumbai", new_appointment_values.getLocation());
//		assertEquals("Open", new_appointment_values.getInspectionType());
//		assertEquals(preferredDate_2, new_appointment_values.getPreferredDate());
//		assertEquals(preferredTime_2, new_appointment_values.getPreferredTime());
//	}
//
//}
