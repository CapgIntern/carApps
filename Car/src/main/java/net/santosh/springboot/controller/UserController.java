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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.santosh.springboot.model.*;
import net.santosh.springboot.repository.*;
import net.santosh.springboot.service.*;

import io.swagger.annotations.Api;
@Api(value = "Swagger2DemoRestController")
@RestController
public class UserController {

	@Autowired
	IUserRepository userrepo;

	
	@Autowired
	IUserService userservice;

	@RequestMapping("/")
	public String Welcomepage() {
		return "Welcome to Carapp";
	}

	@PostMapping("/login")
	public ResponseEntity<Boolean> loginUser(@RequestBody User user) {
		return new ResponseEntity<Boolean>(userservice.signIn(user), HttpStatus.OK);
	}

	@PostMapping("/logout")
	public ResponseEntity<Boolean> logoutUser(@RequestBody User user) {
		return new ResponseEntity<Boolean>(userservice.signOut(user), HttpStatus.OK);
	}

	@PutMapping("/changepassword/{userid}/{oldpass}/{newpass}")
	public ResponseEntity<User> updateoldPassword(@PathVariable("id") String id,
			@PathVariable("oldpass") String oldpass, @PathVariable("newpass") String newpass) {
		return new ResponseEntity<User>(userservice.changePassword(id, oldpass, newpass), HttpStatus.OK);
	}

//creating a get mapping that retrieves all the user detail from the database
	@RequestMapping(value = "/User", method = RequestMethod.GET)
	@GetMapping("/User")
	private List<User> getAllUser() {
		return userservice.getAllUser();
	}

	// creating a get mapping that retrieves the detail of a specific user
	@RequestMapping(value = "/User/{userId}", method = RequestMethod.GET)

	@GetMapping("/User/{serId}")
	private User getBooks(@PathVariable("userId") String userId) {
		return userservice.getUserById(userId);
	}

	// creating a delete mapping that deletes a specified user
	@RequestMapping(value = "/User/{userId}", method = RequestMethod.DELETE)
	@DeleteMapping("/User/{userId}")
	private void deleteBook(@PathVariable("userId") String userId) {
		userservice.delete(userId);
	}

	// creating post mapping that post the user detail in the database
	@RequestMapping(value = "/User", method = RequestMethod.POST)
	@PostMapping("/User")
	private String saveUser(@RequestBody User user) {
		userservice.saveOrUpdate(user);
		return user.getUserId();
	}

	// creating put mapping that updates the user 
	@RequestMapping(value = "/User", method = RequestMethod.PUT)
	@PutMapping("/User")
	private User update(@RequestBody User user) {
		userservice.saveOrUpdate(user);
		return user;
	}
}

