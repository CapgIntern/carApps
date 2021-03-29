package net.santosh.springboot.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.santosh.springboot.exception.ModelAddException;
import net.santosh.springboot.exception.ModelEmptyListException;
import net.santosh.springboot.exception.ModelNotFoundException;
import net.santosh.springboot.exception.ModelUpdateException;
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
		try {
			return ICarRepository.save(car);
		} catch (Exception e) {
			throw new ModelAddException("Can't add the model Car, please add the proper details");
		}
	}

	@Override
	public void removeCar(long id) {
		Optional<Car> carList = this.ICarRepository.findById(id);
		
		if(carList.isPresent()) {
			this.ICarRepository.delete(carList.get());
		}
		else {
			throw new ResourceNotFoundException("Record not found with ID :" + id);
		}
	}

	@Override
	public Car updateCar(Car car, long id) {
		Optional<Car> carList = this.ICarRepository.findById(id);
		try {
			if(carList.isPresent()) {
				Car carUpdate = carList.get();
				carUpdate.setBrand(car.getBrand());
				carUpdate.setModel(car.getModel());
				carUpdate.setVariant(car.getVariant());
				carUpdate.setRegistrationYear(car.getRegistrationYear());
				carUpdate.setRegistrationState(car.getRegistrationState());
				
				ICarRepository.save(carUpdate);
				return carUpdate;
				}
			else {
				throw new ResourceNotFoundException("Record not found with ID :" + id);
			}
		}
		catch(Exception e){
			throw new ModelUpdateException("couldnt update the appointment details,please try again " );
		}
		
		
	}

	@Override
	public Car getCar(long id) {
		Optional<Car> carList = this.ICarRepository.findById(id);
		try {
			if(carList.isPresent()) {
				return carList.get();
			}
			else {
				throw new ResourceNotFoundException("Record not found with ID :" + id);
			}
		}
		catch(Exception e) {
			throw new ModelNotFoundException("Couldnt find the appointment by id"+ id );
		}
	}

	@Override
	public List<Car> getAllCars() {
		try {
			return (List<Car>) ICarRepository.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ModelEmptyListException("error retriving appointments...please try again" );
		}
	}



	@Override
	public List<Car> getCarsByModel(String model) {
		try {
			return (List<Car>) ICarRepository.findByModel(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ModelEmptyListException("error retriving appointments...please try again" );
		}
	}

	@Override
	public List<Car> getCarsByBrand(String brand) {
		try {
			return (List<Car>) ICarRepository.findByBrand(brand);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ModelEmptyListException("error retriving appointments...please try again" );
		}
	}

//	@Override
//	public List<Car> getCarsByLocation() {
//		return null;
//	}
}
