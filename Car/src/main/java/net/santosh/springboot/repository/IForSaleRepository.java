package net.santosh.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.santosh.springboot.model.Car;
import net.santosh.springboot.model.ForSale;

@Repository
public interface IForSaleRepository extends JpaRepository<ForSale, Long> {

	List<ForSale> findAll();
	Optional<ForSale> findByCarId(long carId);
	
}
