package net.santosh.springboot.service;

import java.util.List;

import net.santosh.springboot.model.Car;



/****************************************************************************
 * @author               G Gagandeep reddy
 * Description           It is a car service interface that describes the abstract methods
 *                       used in its service implementation class.
 * version               1.0
 * created date          24-03-2021
 *
 ****************************************************************************/

public interface ICarService {

	public Car addCar(Car car);

	public void removeCar(long id);

	public Car updateCar(Car car, long id);

	public Car getCar(long id);

	public List<Car> getAllCars();
	
	public List<Car> getCarsByUserId(String userId);

	public List<Car> getCarsByModel(String model);

	public List<Car> getCarsByBrand(String brand);

	public Car transferUser(long id, String userId);
}
