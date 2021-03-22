package net.santosh.springboot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

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
		LocalDate reg_date = LocalDate.of(2007,12,03);
		when(iCarRepository.getCar(123)).thenReturn(new Car(123L, "Tata", "Nano", "Basic", reg_date, "Andhra Pradesh"));
		
		Car car_values = iCarServiceImpl.getCar(123);
		
		assertEquals("Tata",car_values.getBrand());
		assertEquals("Nano",car_values.getModel());
		assertEquals("Basic",car_values.getVariant());
		assertEquals(reg_date,car_values.getRegistrationYear());
		assertEquals("Andhra Pradesh",car_values.getRegistrationState());
	
	}
	
	@Test
	public void addCarTest() {
		LocalDate reg_date = LocalDate.of(2007,12,03);
		Car car_values = new Car(123L, "Tata", "Nano", "Basic", reg_date, "Andhra Pradesh");
		
		iCarServiceImpl.addCar(car_values);
		verify(iCarRepository,times(1)).addCar(car_values);
		
	}
	
	@Test
	public void  removeCarTest() {
		LocalDate reg_date = LocalDate.of(2007,12,03);
		Car car_values = new Car(123L, "Tata", "Nano", "Basic", reg_date, "Andhra Pradesh");
		iCarServiceImpl.addCar(car_values);
		
		iCarServiceImpl.removeCar(123);
		verify(iCarRepository,times(1)).removeCar(123);
	}
	
	@Test
	public void updateCarTest() {
		LocalDate reg_date = LocalDate.of(2007,12,03);
		Car car_values = new Car(123L, "Tata", "Nano", "Basic", reg_date, "Andhra Pradesh");
		iCarServiceImpl.addCar(car_values);
		
		LocalDate new_reg_date = LocalDate.of(2010,10,11);
		Car new_car_values = new Car(8900L, "Mahindra", "XUV", "500", new_reg_date, "Telangana");
		
		iCarServiceImpl.updateCar(123,new_car_values);
		
		assertEquals("Mahindra",car_values.getBrand());
		assertEquals("XUV",car_values.getModel());
		assertEquals("500",car_values.getVariant());
		assertEquals(new_reg_date,car_values.getRegistrationYear());
		assertEquals("Telangana",car_values.getRegistrationState());
	}
	
	@Test
	public void getCarsByLocationTest() {
		
	}
	
	@Test
	public void getCarsByModelTest() {
		
	}
	
	@Test
	public void getCarsByBrandTest() {
		
	}
}
