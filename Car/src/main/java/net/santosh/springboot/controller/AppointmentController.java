package net.santosh.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import net.santosh.springboot.model.*;
import net.santosh.springboot.service.*;
import io.swagger.annotations.Api;

@Api(value = "Swagger2DemoRestController")
@RestController

/***********************************************************
 * @author              R saisantosh kumar reddy
 * Description          It is a controller class that controls the data flow into model object 
 *                      and updates the view whenever data changes
 * Version              1.0
 * created date         24-03-2021
 ***********************************************************/
public class AppointmentController {

	@Autowired
	private IAppointmentService iappointmentservice;
	
	/*****************************************************
	 * Method              get all appointments
	 * Description         Displays all the appointments
	 * @GetMapping         used to get the appointments
	 * @Return             returns all the appointments of the user
	 * Created by:         R saisantosh kumar reddy
	 * created date        24-03-2021
	 *****************************************************/
	
	@GetMapping("/appointments")
	public ResponseEntity<List<Appointment>> getAllAppointments() {
		return ResponseEntity.ok().body(iappointmentservice.getAllAppointments());
	}
	
	@GetMapping("/appointments/{userId}")
	public ResponseEntity<List<Appointment>> getOpenAppointments(@PathVariable String userId) {
		return ResponseEntity.ok().body(iappointmentservice.getOpenAppointments(userId));
	}
	
	/*****************************************************
	 * Method              getappointmentbyid
	 * Description         Displays all the appointments by appointment id
	 * @GetMapping         used to get the appointments by appointment id
	 * @Return             returns all the appointments of the user by appointment id
	 * Created by:         R saisantosh kumar reddy
	 * created date        24-03-2021
	 *****************************************************/
	
	@GetMapping("/appointments/{id}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable long id) {
		return ResponseEntity.ok().body(iappointmentservice.getAppointment(id));
	}
	
	/*****************************************************
	 * Method              addappointment
	 * Description         Displays the newly added user appointment in database
	 * @PostMapping        used to add new appointment to database 
	 * @Return             returns newly added appointment details
	 * Created by:          R saisantosh kumar reddy
	 * created date        24-03-2021
	 *****************************************************/
	
	@PostMapping("/appointments")
	public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
		return ResponseEntity.ok().body(this.iappointmentservice.addAppointment(appointment));
	}

	/*****************************************************
	 * Method              updateappointment
	 * Description         Displays remaining appointments after deletion
	 * @PutMapping         used to update appointment by id
	 * @Return             appointments after updation
	 * Created by:         R saisantosh kumar reddy
	 * created date        24-03-2021
	 *****************************************************/

	@PutMapping("/appointments/{id}")
	public ResponseEntity<Appointment> updateAppointment(@PathVariable long id, @RequestBody Appointment appointment) {
		appointment.setAppointmentId(id);
		return ResponseEntity.ok().body(this.iappointmentservice.updateAppointment(appointment));
	}
	
	/*****************************************************
	 * Method              removeappointment
	 * Description         Displays remaining appointments after deletion
	 * @DeleteMapping      used to delete appointment by id
	 * @Return             remaining appointments after deletion
	 * Created by:         R saisantosh kumar reddy
	 * created date        24-03-2021
	 *****************************************************/

	@DeleteMapping("/appointments/{id}")
	public HttpStatus deleteProduct(@PathVariable long id) {
		this.iappointmentservice.removeAppointment(id);
		return HttpStatus.OK;
	}
}


