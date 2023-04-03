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
import com.insurancePolicy.Model.Policy;
import com.insurancePolicy.Payloads.ApiResponse;
import com.insurancePolicy.Payloads.PolicyDTO;
import com.insurancePolicy.Service.PolicyService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policies")
@SecurityRequirement(name = "Insurance-docs")
public class PolicyController {

	@Autowired
	private PolicyService policyService;
	
	// Fetch all insurance policies
	@GetMapping
	public ResponseEntity<List<Policy>> getAllPolicies(){
		List<Policy> policies = this.policyService.getAllPolicies();
		return new ResponseEntity<>(policies, HttpStatus.OK);
	}
	
	// Fetch a specific insurance policy by ID
    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable("id") Long id) throws ResourceNotFoundException{
        Policy policy = this.policyService.getPolicyById(id);
        return new ResponseEntity<>(policy, HttpStatus.OK);
    }
    
    // Create a new insurance policy
    @PostMapping
    public ResponseEntity<Policy> createPolicy(@Valid @RequestBody PolicyDTO policy) throws ResourceNotFoundException{
    	Policy createdPolicy = this.policyService.createPolicy(policy);
    	 return new ResponseEntity<>(createdPolicy, HttpStatus.CREATED);
    }
    
    // Update an insurance policy
    @PutMapping("/{id}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable("id") Long id, @Valid @RequestBody PolicyDTO policy) throws ResourceNotFoundException{
    	Policy updatedPolicy = this.policyService.updatePolicy(id, policy);
    	 return new ResponseEntity<>(updatedPolicy, HttpStatus.OK);
    }
    
    // Delete an insurance policy
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePolicy(@PathVariable("id") Long id) throws ResourceNotFoundException{
    	this.policyService.deletePolicy(id);
    	return new ResponseEntity<ApiResponse>(new ApiResponse("Policy Deleted Succesfully",true),HttpStatus.OK);
    }
    
    

}
