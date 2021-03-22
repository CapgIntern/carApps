package net.santosh.springboot.service;
import net.santosh.springboot.model.*;
public interface IUserService {
	public User signIn(User user);
	public User signOut(User user);
	public User changePassword(long id, User user);

}
