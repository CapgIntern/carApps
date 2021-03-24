package net.santosh.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.santosh.springboot.model.*;

public interface IUserRepository extends JpaRepository<User,String> {
//	public User signIn(User user);
//	public User signOut(User user);
//	public User changePassword(long id, User user);

}

