package net.santosh.springboot.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.santosh.springboot.model.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long>{
	

	@Query("delete from Car c where c.id = :id")
	public Car removeCar(@Param("id") long id);
	
	@Query("select c from Car c where c.id = :id")
	public Car getCar(@Param("id") long id);
	
	@Query("select c from Car c")
	public List<Car> getAllCars();
	
	@Query("select c from Car c where c.model = :model")
	public List<Car> getCarsByModel(@Param("model") String model);
	
	@Query("select c from Car c where c.brand = :brand")
	public List<Car> getCarsByBrand(@Param("brand") String brand);
}
