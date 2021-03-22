package net.santosh.springboot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
		List<Car> car_list = new ArrayList<Car>();
		LocalDate reg_date_1 = LocalDate.of(2007,12,03);
		Car car_values_1 = new Car(123L, "Tata", "Nano", "Basic", reg_date_1, "Andhra Pradesh");
		LocalDate reg_date_2 = LocalDate.of(2010,10,11);
		Car car_values_2 = new Car(8900L, "Mahindra", "XUV", "500", reg_date_2, "Telangana");
		LocalDate reg_date_3 = LocalDate.of(2015,12,28);
		Car car_values_3 = new Car(232L, "Toyata", "Innova", "Crysta", reg_date_3, "Andhra Pradesh");
		
		car_list.add(car_values_1);
		car_list.add(car_values_2);
		car_list.add(car_values_3);
		
		when(iCarRepository.getAllCars()).thenReturn(car_list);
		
		List<Car> check_car_list = iCarServiceImpl.getAllCars();
		
		assertEquals(3, check_car_list.size());
		verify(iCarRepository, times(1)).getAllCars();
		
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
	public void getCarsByModelTest() {
		List<Car> car_list = new ArrayList<Car>();
		LocalDate reg_date_1 = LocalDate.of(2007,12,03);
		Car car_values_1 = new Car(123L, "Tata", "Nano", "Basic", reg_date_1, "Andhra Pradesh");
		LocalDate reg_date_2 = LocalDate.of(2010,10,11);
		Car car_values_2 = new Car(456L, "Tata", "Nano", "High", reg_date_2, "Telangana");
		LocalDate reg_date_3 = LocalDate.of(2015,12,28);
		Car car_values_3 = new Car(789L, "Tata", "Harrier", "High", reg_date_3, "Tamil Nadu");
		
		car_list.add(car_values_1);
		car_list.add(car_values_2);
		car_list.add(car_values_3);
		
		when(iCarRepository.getCarsByModel("Nano")).thenReturn(car_list);
		
		List<Car> check_car_list = iCarServiceImpl.getCarsByModel("Nano");
		
		assertEquals(2, check_car_list.size());
		verify(iCarRepository, times(1)).getCarsByModel("Nano");
	}
	
	@Test
	public void getCarsByBrandTest() {
		List<Car> car_list = new ArrayList<Car>();
		LocalDate reg_date_1 = LocalDate.of(2007,12,03);
		Car car_values_1 = new Car(123L, "Tata", "Nano", "Basic", reg_date_1, "Andhra Pradesh");
		LocalDate reg_date_2 = LocalDate.of(2010,10,11);
		Car car_values_2 = new Car(456L, "Tata", "Nano", "High", reg_date_2, "Telangana");
		LocalDate reg_date_3 = LocalDate.of(2015,12,28);
		Car car_values_3 = new Car(789L, "Tata", "Harrier", "High", reg_date_3, "Tamil Nadu");
		
		car_list.add(car_values_1);
		car_list.add(car_values_2);
		car_list.add(car_values_3);
		
		when(iCarRepository.getCarsByBrand("Tata")).thenReturn(car_list);
		
		List<Car> check_car_list = iCarServiceImpl.getCarsByBrand("Tata");
		
		assertEquals(3, check_car_list.size());
		verify(iCarRepository, times(1)).getCarsByBrand("Tata");
	}
}
