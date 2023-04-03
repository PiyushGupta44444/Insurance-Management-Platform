package com.insurancePolicy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurancePolicy.Model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
