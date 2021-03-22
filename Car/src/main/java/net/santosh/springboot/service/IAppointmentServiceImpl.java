package net.santosh.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.santosh.springboot.exception.ResourceNotFoundException;
import net.santosh.springboot.model.Appointment;
import net.santosh.springboot.repository.IAppointmentRepository;

@Service
@Transactional
public class IAppointmentServiceImpl  implements IAppointmentService {
	
	@Autowired
	private IAppointmentRepository IAppointmentRepository;

	@Override
	public Appointment addAppointment(Appointment appointment) {
		return IAppointmentRepository.save(appointment);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Appointment removeAppointment(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment updateAppointment(long id, Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment getAppointment(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> getOpenAppointments() {
		// TODO Auto-generated method stub
		return null;
	}

}
