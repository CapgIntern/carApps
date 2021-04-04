package net.santosh.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.santosh.springboot.model.*;

/***************************************************************
 * @author              R Gagandeep Reddy
 * Description          It is a Car repository interface that extends JPA repository 
 *                      that contains inbuilt methods for various CRUD operations
 * Version              1.0
 * created date         24-03-2021
 *
 ****************************************************************/
public interface ICarRepository extends JpaRepository<Car, Long> {

	public List<Car> findAll();

	public List<Car> findByModel(String model);

	public List<Car> findByBrand(String brand);

}
