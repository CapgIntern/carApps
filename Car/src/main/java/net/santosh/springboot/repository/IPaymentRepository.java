package net.santosh.springboot.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.santosh.springboot.model.*;

public interface IPaymentRepository extends JpaRepository<Payment, Long>{
	
}
