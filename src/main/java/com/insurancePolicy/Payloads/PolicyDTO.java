package com.insurancePolicy.Payloads;

import java.util.Date;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PolicyDTO {

	 private Long id;
	
	 @NotBlank(message = "Policy number is mandatory")
	 private String policyNumber;
	 
	 @NotBlank(message = "Type is mandatory")
	 private String type;

	 @NotNull(message = "Start date is mandatory")
	 @FutureOrPresent(message = "Start date must be in the future or present")
	 private Date startDate;

	 @NotNull(message = "End date is mandatory")
	 @Future(message = "End date must be in the future")
     private Date endDate;

	 @NotNull(message = "Coverage amount is mandatory")
	 @DecimalMin(value = "0.00", message = "Coverage amount must be a positive number")
	 private double coverageAmount;
	 
	 @DecimalMin(value = "0.0", message = "Premium amount cannot be negative")
	 private Double premium;

     @NotNull(message = "Client ID is mandatory")
     private Long clientId;

     
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public Double getPremium() {
		return premium;
	}

	public void setPremium(Double premium) {
		this.premium = premium;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public PolicyDTO(Long id, String policyNumber, String type, Date startDate, Date endDate,double coverageAmount, Double premium, Long clientId) {
		super();
		this.id = id;
		this.policyNumber = policyNumber;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.coverageAmount = coverageAmount;
		this.premium = premium;
		this.clientId = clientId;
	}

	public PolicyDTO() {
		super();
	}
     
     
}
