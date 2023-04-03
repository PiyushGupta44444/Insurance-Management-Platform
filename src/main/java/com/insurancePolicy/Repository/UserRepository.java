package com.insurancePolicy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurancePolicy.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
