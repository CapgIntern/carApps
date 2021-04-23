package net.santosh.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.santosh.springboot.model.Address;
import net.santosh.springboot.model.Card;

public interface ICardRepository extends JpaRepository<Card, Long> {

	List<Card> findByUserId(String userId);
	
}
