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
	public List<Car> getCarsByLocation();
	@Query("select u from Car u where u.model = ?1" )
	public List<Car> getCarsByModel(String model);
	@Query("select u from Car u where u.brand = ?1" )
	public List<Car> getCarsByBrand(String brand);

}
