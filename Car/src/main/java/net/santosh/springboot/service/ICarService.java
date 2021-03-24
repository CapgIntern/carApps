package net.santosh.springboot.service;
import net.santosh.springboot.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;



public interface ICarService {
	public Car addCar(Car car);
	public Car removeCar(long id);
	public Car updateCar(long id, Car car);
	public Car getCar(long id);
	public List<Car> getAllCars();
//	public List<Car> getCarsByLocation();
	public List<Car> getCarsByModel(String model);
	public List<Car> getCarsByBrand(String brand);

}
