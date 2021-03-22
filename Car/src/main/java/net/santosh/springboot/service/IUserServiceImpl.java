package net.santosh.springboot.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.santosh.springboot.exception.ResourceNotFoundException;
import net.santosh.springboot.model.User;
import net.santosh.springboot.repository.IAppointmentRepository;
import net.santosh.springboot.repository.IUserRepository;


@Service
@Transactional

public class IUserServiceImpl implements IUserService{
	@Autowired
	private IUserRepository IUserRepository;

	@Override
	public User signIn(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User signOut(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User changePassword(long id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
