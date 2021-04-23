package net.santosh.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.santosh.springboot.model.Appointment;
/***************************************************************
 * @author              R Saisantosh kumar reddy
 * Description          It is a test repository interface that extends JPA repository 
 *                      that contains inbuilt methods for various CRUD operations
 * Version              1.0
 * created date         24-03-2021
 *
 ****************************************************************/
@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

	List<Appointment> findByUserId(String userId);
	Object findByAppointmentId(int i);
}
