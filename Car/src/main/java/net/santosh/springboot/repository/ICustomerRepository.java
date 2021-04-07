
package net.santosh.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.santosh.springboot.model.Customer;

/***************************************************************
 * @author              G.Sai Nikesh
 * Description          It is a test repository interface that extends JPA repository 
 *                      that contains inbuilt methods for various CRUD operations
 * Version              1.0
 * created date         24-03-2021
 *
 ****************************************************************/

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {

	Optional<Customer> findById(String userId);
}
