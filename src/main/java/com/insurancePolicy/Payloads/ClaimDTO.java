package com.insurancePolicy.Payloads;

import java.util.Date;

import com.insurancePolicy.Model.ClaimStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;



public class ClaimDTO {

	
	 @NotBlank(message = "Claim number is mandatory")
	 private String claimNumber;

	 @NotBlank(message = "Description is mandatory")
	 private String description;

	 @NotNull(message = "Claim date is mandatory")
	 @PastOrPresent(message = "Claim date must be in the past or present")
	 private Date claimDate;

	 @NotNull(message = "Claim status is mandatory")
	 private ClaimStatus claimStatus;

	 @NotNull(message = "Policy ID is mandatory")
	 private Long policyId;

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	public ClaimStatus getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(ClaimStatus claimStatus) {
		this.claimStatus = claimStatus;
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public ClaimDTO() {
		super();
	}

	public ClaimDTO(String claimNumber,String description,Date claimDate,ClaimStatus claimStatus,Long policyId) {
		super();
		this.claimNumber = claimNumber;
		this.description = description;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
		this.policyId = policyId;
	}
	 
	 
}
