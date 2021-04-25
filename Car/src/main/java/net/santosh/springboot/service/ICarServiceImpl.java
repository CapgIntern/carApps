package net.santosh.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.santosh.springboot.exception.ModelAddException;
import net.santosh.springboot.exception.ModelEmptyListException;
import net.santosh.springboot.exception.ModelNotFoundException;
import net.santosh.springboot.exception.ModelUpdateException;
import net.santosh.springboot.exception.ResourceNotFoundException;
import net.santosh.springboot.model.Car;
import net.santosh.springboot.repository.ICarRepository;

/**************************
 * @author               G Gagandeep Reddy
 * Description           It is a Car service implementation class that defines the methods
 *                       in its service interface.
 * version               1.0
 * created date          24-03-2021
 *
 **************************/
@Service
@Transactional
public class ICarServiceImpl implements ICarService {

	@Autowired
	private ICarRepository ICarRepository;

	/****************************
	 * Method                     addCar
	 * Description                It is used to add a new car in the database
	 
	 * @ModelAddException         It is raised due to invalid car details
	 * created by                 G Gagandeep Reddy
	 * created date               24-03-2021
	 *****************************/
	@Override
	public Car addCar(Car car) {
		try {
			return ICarRepository.save(car);
		} catch (Exception e) {
			throw new ModelAddException("Can't add the model Car, please add the proper details");
		}
	}

	/****************************
	 * Method                     removeCar
	 * Description                It is used to remove car from database
	 * @ResourceNotFoundException It is raised when we try to delete car with 
	 *                            invalid  id 
	 * created by                 G Gagandeep Reddy
	 * created date               24-03-2021
	 *****************************/
	@Override
	public void removeCar(long id) {
		Optional<Car> carList = this.ICarRepository.findById(id);

		if (carList.isPresent()) {
			this.ICarRepository.delete(carList.get());
		} else {
			throw new ResourceNotFoundException("Car not found with ID :" + id);
		}
	}

	/****************************
	 * Method                     updateCar
	 * Description                It is used to update an existing car 
	 *                            in database
	 * @ModelUpdateException      It is raised when we try to update car with 
	 *                            invalid  id or values
	 * created by                 G Gagandeep Reddy
	 * created date               24-03-2021
	 *****************************/
	@Override
	public Car updateCar(Car car, long id) {

		try {
			Optional<Car> carList = this.ICarRepository.findById(id);
			if (carList.isPresent()) {
				Car carUpdate = carList.get();
				carUpdate.setBrand(car.getBrand());
				carUpdate.setModel(car.getModel());
				carUpdate.setVariant(car.getVariant());
				carUpdate.setRegistrationYear(car.getRegistrationYear());
				carUpdate.setRegistrationState(car.getRegistrationState());

				ICarRepository.save(carUpdate);
				return carUpdate;
			} else {
				throw new ResourceNotFoundException("Car not found with ID :" + id);
			}
		} catch (Exception e) {
			throw new ModelUpdateException("Couldn't update the car details, please try again ");
		}

	}

	/****************************
	 * Method                     getCar
	 * Description                It is used to get an existing car 
	 *                            in database
	 * @ModelNotFoundException    It is raised when we try to get car with 
	 *                            invalid  id 
	 * created by                 G Gagandeep Reddy
	 * created date               24-03-2021
	 *****************************/
	@Override
	public Car getCar(long id) {
		Optional<Car> carList = this.ICarRepository.findById(id);
		try {
			if (carList.isPresent()) {
				return carList.get();
			} else {
				throw new ResourceNotFoundException("Car not found with ID :" + id);
			}
		} catch (Exception e) {
			throw new ModelNotFoundException("Couldn't find the car by id" + id);
		}
	}

	/****************************
	 * Method                     getAllCars
	 * Description                It is used to get all existing cars 
	 *                            in database
	 * @ModelEmptyListException   It is raised when we try to get cars when
	 *                            there are no actual cars.
	 * created by                 G Gagandeep Reddy
	 * created date               24-03-2021
	 *****************************/
	@Override
	public List<Car> getAllCars() {
		try {
			return (List<Car>) ICarRepository.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ModelEmptyListException("Error retriving cars...please try again");
		}
	}
	
	@Override
	public List<Car> getCarsByUserId(String userId){
		try {
			return (List<Car>) ICarRepository.findByUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ModelEmptyListException("Error retriving cars...please try again");
		}
	}

	/****************************
	 * Method                     getCarsByModel
	 * Description                It is used to get all existing cars 
	 *                            in database of same model
	 * @ModelEmptyListException   It is raised when we try to get cars when
	 *                            there are no actual cars by model name.
	 * created by                 G Gagandeep Reddy
	 * created date               24-03-2021
	 *****************************/
	@Override
	public List<Car> getCarsByModel(String model) {
		try {
			return (List<Car>) ICarRepository.findByModel(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ModelEmptyListException("Error retriving cars...please try again");
		}
	}

	/****************************
	 * Method                     getCarsByBrand
	 * Description                It is used to get all existing cars 
	 *                            in database of same brand
	 * @ModelEmptyListException   It is raised when we try to get cars when
	 *                            there are no actual cars by brand name.
	 * created by                 G Gagandeep Reddy
	 * created date               24-03-2021
	 *****************************/
	@Override
	public List<Car> getCarsByBrand(String brand) {
		try {
			return (List<Car>) ICarRepository.findByBrand(brand);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ModelEmptyListException("Error retriving cars...please try again");
		}
	}

	@Override
	public Car transferUser(long id, String userId) {
		try {
			Optional<Car> carList = this.ICarRepository.findById(id);
			if (carList.isPresent()) {
				Car carUpdate = carList.get();
				carUpdate.setUserId(userId);

				ICarRepository.save(carUpdate);
				return carUpdate;
			} else {
				throw new ResourceNotFoundException("Car not found with ID :" + id);
			}
		} catch (Exception e) {
			throw new ModelUpdateException("Couldn't update the car details, please try again ");
		}
	}

}