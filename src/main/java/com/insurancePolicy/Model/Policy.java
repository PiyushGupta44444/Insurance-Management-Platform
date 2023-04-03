package com.insurancePolicy.Model;

import java.util.Date;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "policies")
public class Policy {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 @NotBlank(message = "Policy number is mandatory")
	 private String policyNumber;

	 @NotBlank(message = "Type is mandatory")
	 private String type;
	 
	 @NotNull(message = "Coverage amount is mandatory")
	 @DecimalMin(value = "0.0", inclusive = false, message = "Coverage amount must be greater than 0.0")
	 private double coverageAmount;

	 @NotNull(message = "Premium is mandatory")
	 @DecimalMin(value = "0.0", inclusive = false, message = "Premium must be greater than 0.0")
	 private double premium;
	 
	 @NotNull(message = "Start date is mandatory")
	 @FutureOrPresent(message = "Start date must be in the future or present")
	 private Date startDate;
	 
	 @NotNull(message = "End date is mandatory")
	 @Future(message = "End date must be in the future")
	 private Date endDate;
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "client_id", nullable = false)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 @JsonIgnore
	 private Client client;

	public Policy() {
		super();
	}

	public Policy(Long id,String policyNumber,String type,double coverageAmount,double premium,Date startDate,Date endDate,Client client) {
		super();
		this.id = id;
		this.policyNumber = policyNumber;
		this.type = type;
		this.coverageAmount = coverageAmount;
		this.premium = premium;
		this.startDate = startDate;
		this.endDate = endDate;
		this.client = client;
	}

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

	public double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
