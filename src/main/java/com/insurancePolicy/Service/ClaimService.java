package com.insurancePolicy.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insurancePolicy.Exception.ResourceNotFoundException;
import com.insurancePolicy.Model.Claim;
import com.insurancePolicy.Model.Policy;
import com.insurancePolicy.Payloads.ClaimDTO;
import com.insurancePolicy.Repository.ClaimRepository;
import com.insurancePolicy.Repository.PolicyRepository;

@Service
@Transactional
public class ClaimService {

	 @Autowired
	 private ClaimRepository claimRepository;
	 
	 @Autowired
	 private PolicyRepository policyRepository;
	 
	 //get all claims
	 public List<Claim> getAllClaims() {
	       return this.claimRepository.findAll();
	 }
	 
	 //get claim by id
	 public Claim getClaimById(Long id) {
		 return this.claimRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Claim", "id", id));
	 }
	 
	 //create claim
	 public Claim createClaim(ClaimDTO claimDTO) {
		 
		 Policy policy =this.policyRepository.findById(claimDTO.getPolicyId())
				 .orElseThrow(() -> new ResourceNotFoundException("Policy", "id", claimDTO.getPolicyId()));
		 Claim claim = new Claim();
		 claim.setClaimNumber(claimDTO.getClaimNumber());
		 claim.setDescription(claimDTO.getDescription());
	     claim.setClaimDate(claimDTO.getClaimDate());
	     claim.setClaimStatus(claimDTO.getClaimStatus());
		 claim.setPolicy(policy);
	     return this.claimRepository.save(claim);
	 }
	 
	 //update claim
	 public Claim updateClaim(Long id, ClaimDTO claimDTO) {
		 Policy policy = this.policyRepository.findById(claimDTO.getPolicyId())
		            .orElseThrow(() -> new ResourceNotFoundException("Policy", "id", claimDTO.getPolicyId()));
		 Optional<Claim> optionalClaim = this.claimRepository.findById(id);
		 if (optionalClaim.isEmpty()) {
	            throw new ResourceNotFoundException("Claim", "id", id);
	        }
		 Claim existingClaim = optionalClaim.get();
		 existingClaim.setClaimNumber(claimDTO.getClaimNumber());
		 existingClaim.setDescription(claimDTO.getDescription());
		 existingClaim.setClaimDate(claimDTO.getClaimDate());
	     existingClaim.setClaimStatus(claimDTO.getClaimStatus());
		 existingClaim.setPolicy(policy);
		 return this.claimRepository.save(existingClaim);
	 }
	 
	 //delete claim
	 public void deleteClaim(Long id) {
		 Optional<Claim> optionalClaim = this.claimRepository.findById(id);
	        if (optionalClaim.isEmpty()) {
	            throw new ResourceNotFoundException("Claim", "id", id);
	        }
	        this.claimRepository.deleteById(id);
	 }
}
