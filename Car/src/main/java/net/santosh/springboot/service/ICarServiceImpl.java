package net.santosh.springboot.service;
import java.util.List;

import org.springframework.beans.BeanUtils;
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
		ICarRepository.save(car);
		return car;
	}

	@Override
	public Car removeCar(long id) {
		Car return_value = ICarRepository.getCar(id);
		ICarRepository.deleteById(id);
		return return_value;
	}

	@Override
	public Car updateCar(long id, Car car) {
		Car replace = getCar(id);
		BeanUtils.copyProperties(replace, car);
		return car;
	}

	@Override
	public Car getCar(long id) {
		return ICarRepository.getCar(id);
	}

	@Override
	public List<Car> getAllCars() {
		return (List<Car>) ICarRepository.findAll();
	}

//	@Override
//	public List<Car> getCarsByLocation() {
//		return null;
//	}

	@Override
	public List<Car> getCarsByModel(String model) {
		return (List<Car>) ICarRepository.getCarsByModel(model);
	}

	@Override
	public List<Car> getCarsByBrand(String brand) {
		return (List<Car>) ICarRepository.getCarsByBrand(brand);
	}

}
