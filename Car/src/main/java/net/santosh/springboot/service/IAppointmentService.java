package net.santosh.springboot.service;

import java.util.List;

import net.santosh.springboot.model.*;

public interface IAppointmentService {

	public Appointment addAppointment(Appointment appointment);
	public Appointment removeAppointment(long id); 
	public Appointment updateAppointment(long id, Appointment appointment);
	public Appointment getAppointment(long id);
	public List<Appointment> getAllAppointments(); 
	public List<Appointment> getOpenAppointments();
}
