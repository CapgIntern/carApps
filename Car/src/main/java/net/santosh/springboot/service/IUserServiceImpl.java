package net.santosh.springboot.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.santosh.springboot.exception.*;
import net.santosh.springboot.model.*;
import net.santosh.springboot.repository.*;

@Service
public class IUserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userrepo;

	@Override
	public Boolean signIn(User user) {

		Boolean status = false;
		Optional<User> resultUser = userrepo.findById(user.getUserId());
		if ((resultUser != null) && (resultUser.get().getPassword().equals(user.getPassword()))) {
			if (resultUser.get().getRole().equals(user.getRole())) {
				status = true;
			}
			else {
				throw new UserModuleException("role not found");
			}
		}
		else {
			throw new UserModuleException("invalid id,password");
		}
		return status;
	}

	public Boolean signOut(User user) {

		Boolean status = false;
		Optional<User> resultUser = userrepo.findById(user.getUserId());
		if ((resultUser != null) && (resultUser.get().getPassword().equals(user.getPassword()))) {
			if (resultUser.get().getRole().equals(user.getRole())) {
				status = true;
			}
			else {
				throw new UserModuleException("role not found");
			}
		}
		else {
			throw new UserModuleException("invalid id,password");
		}
		return status;
	}

	public User changePassword(String id, String oldpassword, String newpassword) {

		User changeUser = null;
		Optional<User> resultUser = userrepo.findById(id);
		if ((resultUser != null) && (resultUser.get().getPassword().equals(oldpassword))) {
			changeUser = new User(id, newpassword, resultUser.get().getRole());
			userrepo.save(changeUser);
		}
		else {
			throw new UserModuleException("password not matched");
		}
		return changeUser;
	}

	//getting all user record by using the method findaAll() of CrudRepository
	public List<User> getAllUser() {
		List<User> user = new ArrayList<User>();
		userrepo.findAll().forEach(user1 -> user.add(user1));
		return user;
	}

	// getting a specific record by using the method findById() of CrudRepository
	public User getUserById(String userId) {
		return userrepo.findById(userId).get();
	}

	// saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(User user) {
		userrepo.saveAndFlush(user);
	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(String userId) {
		userrepo.deleteById(userId);
	}

	// updating a record
	public void update(User user, String userId) {
		userrepo.save(user);
	}
}
