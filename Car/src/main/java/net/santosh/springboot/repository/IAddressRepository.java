package net.santosh.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.santosh.springboot.model.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {
	
	List<Address> findByUserId(String userId);

}
