package net.santosh.springboot.service;
import java.util.List;

import net.santosh.springboot.model.*;
public interface IUserService {

	public Boolean signIn(User user);

	public Boolean signOut(User user);

	public User changePassword(String id, String oldpassword, String newpassword);

	public List<User> getAllUser();

	public User getUserById(String userId);

	public void delete(String userId);

	public void saveOrUpdate(User user);
}

