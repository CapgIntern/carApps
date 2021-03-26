package net.santosh.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.santosh.springboot.model.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment,Long>{
	

}
