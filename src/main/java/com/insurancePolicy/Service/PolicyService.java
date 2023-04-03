package com.insurancePolicy.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurancePolicy.Exception.ResourceNotFoundException;
import com.insurancePolicy.Model.Client;
import com.insurancePolicy.Model.Policy;
import com.insurancePolicy.Payloads.PolicyDTO;
import com.insurancePolicy.Repository.ClientRepository;
import com.insurancePolicy.Repository.PolicyRepository;

@Service
public class PolicyService {

	@Autowired
	private PolicyRepository policyRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	//get all policies
	public List<Policy> getAllPolicies() {
	      return this.policyRepository.findAll();
	  }
	
	//get policy by id
	public Policy getPolicyById(Long id) {
		return this.policyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Policy", "id", id));
	}
	
	//create policy
	public Policy createPolicy(PolicyDTO policyDTO) {
        Client client = this.clientRepository.findById(policyDTO.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", policyDTO.getClientId()));
        Policy policy = new Policy();
        policy.setPolicyNumber(policyDTO.getPolicyNumber());
        policy.setCoverageAmount(policyDTO.getCoverageAmount());
        policy.setPremium(policyDTO.getPremium());
        policy.setType(policyDTO.getType());
        policy.setStartDate(policyDTO.getStartDate());
        policy.setEndDate(policyDTO.getEndDate());
        policy.setClient(client);
        return this.policyRepository.save(policy);
	}
	
	// update policy
	public Policy updatePolicy(Long id,PolicyDTO policyDTO) {
		Policy existingPolicy = this.policyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Policy", "id", id));
		existingPolicy.setCoverageAmount(policyDTO.getCoverageAmount());
		existingPolicy.setPolicyNumber(policyDTO.getPolicyNumber());
		existingPolicy.setPremium(policyDTO.getPremium());
		existingPolicy.setEndDate(policyDTO.getEndDate());
		existingPolicy.setStartDate(policyDTO.getStartDate());
		existingPolicy.setType(policyDTO.getType());
		existingPolicy.setClient(this.clientRepository.findById(policyDTO.getClientId())
				.orElseThrow(() -> new ResourceNotFoundException("Client", "id", policyDTO.getClientId())));
		return this.policyRepository.save(existingPolicy);
	}
	
	
	//delete policy
	  public void deletePolicy(Long id) {
		  Policy policy = this.policyRepository.findById(id)
				  .orElseThrow(() -> new ResourceNotFoundException("Policy", "id", id));
		  this.policyRepository.delete(policy);
	  }
	
	
}
