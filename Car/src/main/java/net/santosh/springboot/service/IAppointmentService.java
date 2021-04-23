package net.santosh.springboot.service;

import java.util.List;

import net.santosh.springboot.model.Appointment;

/****************************************************************************
 * @author               R saisantosh kumar reddy
 * Description           It is a appointment service interface that describes the abstract methods
 *                       used in its service implementation class.
 * version               1.0
 * created date          24-03-2021
 *
 ****************************************************************************/

public interface IAppointmentService {

	public Appointment addAppointment(Appointment appointment);

	public void removeAppointment(long id);

	public Appointment getAppointment(long id);

	public List<Appointment> getAllAppointments();

	public List<Appointment> getOpenAppointments(String userId);

	public Appointment updateAppointment(Appointment appointment);
}

