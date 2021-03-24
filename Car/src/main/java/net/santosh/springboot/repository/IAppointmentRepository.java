package net.santosh.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.santosh.springboot.model.Appointment;


public interface IAppointmentRepository extends JpaRepository<Appointment,Long>{
//	public Appointment addAppointment(Appointment appointment);
//	public Appointment removeAppointment(long id); 
//	public Appointment updateAppointment(long id, Appointment appointment);
//	public Appointment getAppointment(long id);
//	public List<Appointment> getAllAppointments(); 
//	public List<Appointment> getOpenAppointments();

}
