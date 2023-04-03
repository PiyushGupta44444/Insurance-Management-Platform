package com.insurancePolicy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurancePolicy.Model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
