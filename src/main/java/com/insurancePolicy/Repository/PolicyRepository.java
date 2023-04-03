package com.insurancePolicy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurancePolicy.Model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long>{

}
