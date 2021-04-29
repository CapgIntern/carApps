package net.santosh.springboot.controller;

import java.util.List;
import java.util.Optional;

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

import io.swagger.annotations.Api;
import net.santosh.springboot.exception.UserModuleException;
import net.santosh.springboot.model.Customer;
import net.santosh.springboot.model.User;
import net.santosh.springboot.repository.IUserRepository;
import net.santosh.springboot.service.ICustomerService;
import net.santosh.springboot.service.IUserService;

/*********************
 * @author              G.Pavan
 * Description          It is a controller class that controls the data flow into model object 
 *                      and updates the view whenever data changes
 * Version              1.0
 * created date         24-03-2021
 *********************/

@Api(value = "Swagger2DemoRestController")
@RestController
public class UserController {

	@Autowired
	IUserRepository userrepo;
	
	@Autowired
	ICustomerService customerservice;

	@Autowired
	IUserService userservice;
	
	/*******************
	 * Method              defaultResponse
	 * Description         displays the website application name
	 * @GetMapping         It is used to handle GET type of request method.
	 * Created by:         G.Pavan
	 * created date        24-03-2021
	 *******************/

	@GetMapping("/")
	public String Welcomepage() {
		return "Welcome to Carapp";
	}
	
	/*******************
	 * Method              adduser
	 * Description         Displays the newly added user in database
	 * @PostMapping        used to add user to database 
	 * @Return             returns newly added user
	 * Created by:         G.Pavan
	 * created date        24-03-2021
	 *******************/
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		Optional<User> getuser=userrepo.findById(user.getUserId());
		try {
		if(getuser.isPresent()) {
			throw new UserModuleException("user already exists please login");
		}
		}
		catch(Exception e) {
			throw new UserModuleException("user already exists please login");
		}
		userrepo.save(user);
		Customer customer=new Customer();
		customer.setUserId(user.getUserId());
		customerservice.addCustomer(customer);
		return user;
	}
	
	
	
	/*******************
	 * Method              getusers
	 * Description         Displays all the users present in database
	 * @GetMapping        used to get all users database 
	 * @Return             returns all users
	 * Created by:         G.Pavan
	 * created date        24-03-2021
	 *******************/
	
	@GetMapping("/getallusers")
	public List<User> getUsers() {
		return userrepo.findAll();
	}

	/*******************
	 * Method              getuser
	 * Description         Displays user bases on userid
	 * @GetMapping         used to get user by userid 
	 * @Return             returns user by id
	 * Created by:         G.Pavan
	 * created date        24-03-2021
	 *******************/
	
	@GetMapping("/getuserbyid/{userId}")
	public Optional<User> getUser(@PathVariable("userId") String userId) {
		return userrepo.findById(userId);
	}
	
	/*******************
	 * Method              deleteuser
	 * Description         Displays as deleted after deleting a particular user by userid
	 * @DeleteMapping      used to delete user by userid 
	 * @Return             returns string as deleted
	 * Created by:         G.Pavan
	 * created date        24-03-2021
	 *******************/
	
	
	@DeleteMapping("user/{userId}")
	public String deleteUser(@PathVariable String userId) {
		User user = userrepo.getOne(userId);
		userrepo.delete(user);
		return "deleted";
	}
	
	/**************************
	 * Method                         loginUser
	 * Description                    It is used to login into online application
	 * @param user                    user reference variable
	 * @return                        return true if user details is correct or else false
	 * @throws UserModuleException    it is raises due to invalid user details
	 ***************************/
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> loginUser(@RequestBody User user) {
		return new ResponseEntity<Boolean>(userservice.signIn(user), HttpStatus.OK);
	}
	
	/***************************
	 * Method                        logoutUser
	 * Description                   It is used to logout from online application
	 * @param user                   user reference variable
	 * @return                       true if user details are correct
	 * @throws UserModuleException   It raises due to invalid user details
	  ***************************/

	@PostMapping("/logout")
	public ResponseEntity<Boolean> logoutUser(@RequestBody User user) {
		return new ResponseEntity<Boolean>(userservice.signOut(user), HttpStatus.OK);
	}
	
	/***************************
	 * Method                        updatePassword
	 * Description                   It is used to update the password
	 * @param user                   user reference variable
	 * @return                       It will update the password by checking with old password
	 * @throws UserModuleException   It raises due to invalid details
	 ***************************/
	
	@PutMapping("/updatepassword/{id}/{newpass}")
	public ResponseEntity<User> updateeoldPassword(@PathVariable("id") String id,
			 @PathVariable("newpass") String newpass) {
		return new ResponseEntity<User>(userservice.changePassword(id, newpass), HttpStatus.OK);
	}
}