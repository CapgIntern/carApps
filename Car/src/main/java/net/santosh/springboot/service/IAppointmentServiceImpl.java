package net.santosh.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.santosh.springboot.exception.ModelAddException;
import net.santosh.springboot.exception.ModelEmptyListException;
import net.santosh.springboot.exception.ModelNotFoundException;
import net.santosh.springboot.exception.ModelUpdateException;
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
		
		try {
		return IAppointmentRepository.save(appointment);
		} catch (Exception e) {
			throw new ModelAddException("Can't add the model Appointment, please add the proper details");
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAppointment(long id) {
           Optional<Appointment> appointmentDb = this.IAppointmentRepository.findById(id);
		
		if(appointmentDb.isPresent()) {
			this.IAppointmentRepository.delete(appointmentDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}
	}

	
	@Override
	public Appointment updateAppointment(Appointment appointment) {
       Optional<Appointment> appointmentDb = this.IAppointmentRepository.findById(appointment.getAppointmentId());
		try {
		if(appointmentDb.isPresent()) {
			Appointment appointmentUpdate = appointmentDb.get();
			appointmentUpdate.setAppointmentId(appointment.getAppointmentId());
			appointmentUpdate.setLocation(appointment.getLocation());
			appointmentUpdate.setPreferredDate(appointment.getPreferredDate());
			appointmentUpdate.setPreferredTime(appointment.getPreferredTime());
			appointmentUpdate.setCustomer(appointment.getCustomer());
			appointmentUpdate.setPayment(appointment.getPayment());
			
			
			
			IAppointmentRepository.save(appointmentUpdate);
			return appointmentUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + appointment.getAppointmentId());
		}
		}catch(Exception e){
			throw new ModelUpdateException("couldnt update the appointment details,please try again " );
		}
		
		
	}

	@Override
	public Appointment getAppointment(long id) {
       Optional<Appointment> appointmentDb = this.IAppointmentRepository.findById(id);
		try {
		if(appointmentDb.isPresent()) {
			return appointmentDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}
		}
		catch(Exception e) {
			throw new ModelNotFoundException("Couldnt find the appointment by id"+ id );
		}
	}

	
	@Override
	public List<Appointment> getAllAppointments() {
		try {
		return this.IAppointmentRepository.findAll();
		}catch(Exception e) {
			throw new ModelEmptyListException("error retriving appointments...please try again" );
			
		}
	}

	@Override
	public List<Appointment> getOpenAppointments() {
		 
		return this.IAppointmentRepository.findAll();
	}

}
