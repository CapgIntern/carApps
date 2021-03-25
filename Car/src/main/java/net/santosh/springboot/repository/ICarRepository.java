package net.santosh.springboot.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.santosh.springboot.model.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long>{

	List<Car> findAll();
	List<Car> findByModel(String model);
	List<Car> findByBrand(String brand);
}