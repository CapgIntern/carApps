package net.santosh.springboot.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.santosh.springboot.model.*;


public interface ICarRepository extends JpaRepository<Car, Long>{
	
	List<Car> findAll();
	List<Car> findByModel(String model);
	List<Car> findByBrand(String brand);

}
