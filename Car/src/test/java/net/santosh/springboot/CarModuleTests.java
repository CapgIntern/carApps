package net.santosh.springboot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import net.santosh.springboot.model.Car;
import net.santosh.springboot.repository.ICarRepository;
import net.santosh.springboot.service.ICarServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class CarModuleTests {
	
	@InjectMocks
	ICarServiceImpl iCarServiceImpl;
	
	@Mock
	ICarRepository iCarRepository;
	
	@Test
	public void getAllCarsTest() {
		assertNotNull(iCarServiceImpl.getAllCars());
	}
	
	@Test
	public void getCarTest() {
		Car car_values = iCarServiceImpl.getCar(123);
		assertEquals("Tata",car_values.getBrand());
		assertEquals("Nano",car_values.getModel());
		assertEquals("Basic",car_values.getVariant());
		assertEquals("Andhra Pradesh",car_values.getRegistrationState());
	}
}
