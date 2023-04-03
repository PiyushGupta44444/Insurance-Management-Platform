package com.insurancePolicy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurancePolicy.Exception.ResourceNotFoundException;
import com.insurancePolicy.Model.Claim;
import com.insurancePolicy.Payloads.ApiResponse;
import com.insurancePolicy.Payloads.ClaimDTO;
import com.insurancePolicy.Service.ClaimService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/claims")
@SecurityRequirement(name = "Insurance-docs")
public class ClaimController {

	@Autowired
	private ClaimService claimService;
	
	// Fetch all claims
	@GetMapping
	public ResponseEntity<List<Claim>> getAllClaims(){
		List<Claim> claims = this.claimService.getAllClaims();
		return ResponseEntity.ok(claims);
	}
	
	// Fetch a specific claim by ID
	@GetMapping("/{id}")
	public ResponseEntity<Claim> getClaimById(@PathVariable("id") Long id) throws ResourceNotFoundException{
		  Claim claim = this.claimService.getClaimById(id);
		  return ResponseEntity.ok(claim);
	}
	
	// Create a new claim
	@PostMapping
	 public ResponseEntity<Claim> createClaim(@Valid @RequestBody ClaimDTO claim){
		Claim savedClaim = this.claimService.createClaim(claim);
		return new ResponseEntity<>(savedClaim,HttpStatus.CREATED);
	}
	
	// Update a claim's information
	@PutMapping("/{id}")
	public ResponseEntity<Claim> updateClaim(@PathVariable("id") Long id, @Valid @RequestBody ClaimDTO claim) throws ResourceNotFoundException{
		Claim updatedClaim = this.claimService.updateClaim(id, claim);
		 return ResponseEntity.ok().body(updatedClaim);
	}
	
	// Delete a claim
	@DeleteMapping("/{id}")
	 public ResponseEntity<ApiResponse> deleteClaim(@PathVariable("id") Long id) throws ResourceNotFoundException {
        this.claimService.deleteClaim(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Claim Deleted Successfully",true),HttpStatus.OK);
    }

}
