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
public class AppointmentController {
	
	@Autowired
	private IAppointmentService iappointmentservice;
	
	@GetMapping("/appointments")
	public ResponseEntity<List<Appointment>> getAllAppointments(){
		return ResponseEntity.ok().body(iappointmentservice.getAllAppointments());
	}
	
	@GetMapping("/appointments/{id}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable long id){
		return ResponseEntity.ok().body(iappointmentservice.getAppointment(id));
	}
	
	@PostMapping("/appointments")
	public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment){
		return ResponseEntity.ok().body(this.iappointmentservice.addAppointment(appointment));
	}
	
	@PutMapping("/appointments/{id}")
	public ResponseEntity<Appointment> addAppointment(@PathVariable long id, @RequestBody Appointment appointment){
		appointment.setAppointmentId(id);
		return ResponseEntity.ok().body(this.iappointmentservice.updateAppointment(appointment));
	}

	@DeleteMapping("/appointments/{id}")
	public HttpStatus deleteProduct(@PathVariable long id){
		this.iappointmentservice.removeAppointment(id);
		return HttpStatus.OK;
	}
}


