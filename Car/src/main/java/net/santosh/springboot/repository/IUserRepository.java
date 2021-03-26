package net.santosh.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.santosh.springboot.model.*;

public interface IUserRepository extends JpaRepository<User,String> {


}

