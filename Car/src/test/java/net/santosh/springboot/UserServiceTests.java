package net.santosh.springboot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import net.santosh.springboot.model.User;
import net.santosh.springboot.repository.IUserRepository;
import net.santosh.springboot.service.IUserServiceImpl;

/****************************
 * @author                 G.Pavan
 * Description             It is a service implementation test class that defines the methods
 *                         to test the service.
 * Version                 1.0
 * created date            24-03-2021
 *
 ******************************/

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {
	@InjectMocks
	IUserServiceImpl iUserService;

	@Mock
	IUserRepository iUserRepository;

	/****************************
	 * Method changepasswordtest1 Description It is used to test changepassword
	 * method created by G.Pavan created date 24-03-2021
	 *****************************/

	@Test
	public void changePasswordTest1() {
		User updatedUser = new User("103", "prem", "analyst");
		Optional<User> checkUser = Optional.of(new User("103", "pavan", "analyst"));

		when(iUserRepository.findById("103")).thenReturn(checkUser);

		iUserService.changePassword("103", "pavan", "prem");

		assertEquals("prem", updatedUser.getPassword());
	}
	
	/****************************
	 * Method                     changepasswordtest2
	 * Description                It is used to test changepassword method 
	 * created by                 G.Pavan
	 * created date               24-03-2021
	 *****************************/

	@Test
	public void changePasswordTest2() {
		User updatedUser = new User("105", "raadha", "senioranalyst");
		Optional<User> checkUser = Optional.of(new User("105", "krishna", "senioranalyst"));

		when(iUserRepository.findById("105")).thenReturn(checkUser);

		iUserService.changePassword("105", "krishna", "raadha");

		assertEquals("raadha", updatedUser.getPassword());
	}

	/****************************
	 * Method                     changepasswordtest3
	 * Description                It is used to test changepassword  method 
	 * created by                 G.Pavan
	 * created date               24-03-2021
	 *****************************/

	@Test
	public void changePasswordTest3() {
		User updatedUser = new User("102", "gagan", "analyst");
		Optional<User> checkUser = Optional.of(new User("102", "santosh", "analyst"));

		when(iUserRepository.findById("102")).thenReturn(checkUser);

		iUserService.changePassword("102", "santosh", "gagan");

		assertEquals("gagan", updatedUser.getPassword());
	}

	/****************************
	 * Method                     signintest1
	 * Description                It is used to test signin  method 
	 * created by                 G.Pavan
	 * created date               24-03-2021
	 *****************************/

	@Test
	public void signInTest1() {
		User user = new User("103", "prem", "analyst");
		Optional<User> checkUser = Optional.of(new User("103", "prem", "analyst"));

		when(iUserRepository.findById("103")).thenReturn(checkUser);

		assertEquals(true, iUserService.signIn(user));
	}
	
	/****************************
	 * Method                     signintest2
	 * Description                It is used to test signin  method 
	 * created by                 G.Pavan
	 * created date               24-03-2021
	 *****************************/

	@Test
	public void signInTest2() {
		User user = new User("104", "pavan", "senioranalyst");
		Optional<User> checkUser = Optional.of(new User("104", "pavan", "senioranalyst"));

		when(iUserRepository.findById("104")).thenReturn(checkUser);

		assertEquals(true, iUserService.signIn(user));
	}

	/****************************
	 * Method                     signintest3
	 * Description                It is used to test signin  method 
	 * created by                 G.Pavan
	 * created date               24-03-2021
	 *****************************/

	@Test
	public void signInTest3() {
		User user = new User("102", "krishna", "analyst");
		Optional<User> checkUser = Optional.of(new User("102", "krishna", "analyst"));

		when(iUserRepository.findById("102")).thenReturn(checkUser);

		assertEquals(true, iUserService.signIn(user));
	}
	
	/****************************
	 * Method                     signouttest1
	 * Description                It is used to test signout  method 
	 * created by                 G.Pavan
	 * created date               24-03-2021
	 *****************************/

	@Test
	public void signOutTest1() {
		User user = new User("102", "krishna", "analyst");
		Optional<User> checkUser = Optional.of(new User("102", "krishna", "analyst"));

		when(iUserRepository.findById("102")).thenReturn(checkUser);

		assertEquals(true, iUserService.signIn(user));
	}

	/****************************
	 * Method                     signouttest2
	 * Description                It is used to test signout  method 
	 * created by                 G.Pavan
	 * created date               24-03-2021
	 *****************************/

	@Test
	public void signOutTest2() {
		User user = new User("104", "pavan", "senioranalyst");
		Optional<User> checkUser = Optional.of(new User("104", "pavan", "senioranalyst"));

		when(iUserRepository.findById("104")).thenReturn(checkUser);

		assertEquals(true, iUserService.signIn(user));
	}

	/****************************
	 * Method                     signouttest3
	 * Description                It is used to test signout  method 
	 * created by                 G.Pavan
	 * created date               24-03-2021
	 *****************************/

	@Test
	public void signOutTest3() {
		User user = new User("103", "prem", "analyst");
		Optional<User> checkUser = Optional.of(new User("103", "prem", "analyst"));

		when(iUserRepository.findById("103")).thenReturn(checkUser);

		assertEquals(true, iUserService.signIn(user));
	}

}