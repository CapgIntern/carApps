package net.santosh.springboot.service;

import java.util.List;

import net.santosh.springboot.model.*;

public interface IAppointmentService {

	public Appointment addAppointment(Appointment appointment);
	public void removeAppointment(long id); 
	
	public Appointment getAppointment(long id);
	public List<Appointment> getAllAppointments(); 
	public List<Appointment> getOpenAppointments();
	public Appointment updateAppointment(Appointment appointment);
}

