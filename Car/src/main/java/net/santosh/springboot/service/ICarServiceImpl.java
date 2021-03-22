package net.santosh.springboot.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.santosh.springboot.exception.ResourceNotFoundException;
import net.santosh.springboot.model.Car;
import net.santosh.springboot.repository.IAppointmentRepository;
import net.santosh.springboot.repository.ICarRepository;

@Service
@Transactional
public class ICarServiceImpl implements ICarService{
	
	@Autowired
	private ICarRepository ICarRepository;

	@Override
	public Car addCar(Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car removeCar(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car updateCar(long id, Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car getCar(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getCarsByLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getCarsByModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getCarsByBrand() {
		// TODO Auto-generated method stub
		return null;
	}

}
