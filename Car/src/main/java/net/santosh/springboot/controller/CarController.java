package net.santosh.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.santosh.springboot.model.Car;
import net.santosh.springboot.service.ICarServiceImpl;


@RestController
public class CarController {
	
	@Autowired
	ICarServiceImpl carService;
	
	@GetMapping("/cars")
	public List<Car> getAllCars(){
		return carService.getAllCars();
	}
	
	@GetMapping("/cars/{/carid}")
	public Car getCar(@PathVariable("carid") long id) {
		return carService.getCar(id);
	}
	
	@GetMapping("/cars/{/model}")
	public List<Car> getCarsByModel(@PathVariable("model") String model) {
		return (List<Car>) carService.getCarsByModel(model);
	}

	@GetMapping("/cars/{/brand}")
	public List<Car> getCarsByBrand(String brand) {
		return (List<Car>) carService.getCarsByBrand(brand);
	}
	
	@PostMapping("/addcar")
	public Car addCar(@RequestBody Car car) {
		return carService.addCar(car);
	}
	
	@PutMapping("/updatecar/{/carid}")
	public Car updateCar(@RequestBody Car car, @PathVariable long id) {
		return carService.updateCar(id, car);
	}
	
	@DeleteMapping("/cars/{/carid}")
	public Car removeCar(long id) {
		return carService.removeCar(id);
	}
}
