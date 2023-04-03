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
import com.insurancePolicy.Model.Client;
import com.insurancePolicy.Payloads.ApiResponse;
import com.insurancePolicy.Service.ClientService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clients")
@SecurityRequirement(name = "Insurance-docs")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	// Fetch all clients
	@GetMapping
	public ResponseEntity<List<Client>> getAllClients(){
	 List<Client> clients = this.clientService.getAllClients();
	 return ResponseEntity.ok(clients);
	}
	
	// Fetch a specific client by ID
	@GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id) throws ResourceNotFoundException{
		 Client client = this.clientService.getClientById(id);
		 return ResponseEntity.ok(client);
    }
	
	// Create a new client
	@PostMapping
	public ResponseEntity<Client> createClient(@Valid @RequestBody Client client){
		 Client createdClient = this.clientService.createClient(client);
		 return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
	}
	
	// Update a client's information
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") Long id,@Valid @RequestBody Client clientDetails) throws ResourceNotFoundException{
		 Client updatedClient = this.clientService.updateClient(id, clientDetails);
		 return ResponseEntity.ok(updatedClient);
	}
	
	// Delete a client
	@DeleteMapping("/{id}")
	 public ResponseEntity<ApiResponse> deleteClient(@PathVariable("id") Long id) throws ResourceNotFoundException {
		this.clientService.deleteClient(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Client is Deleted Successfully", true),HttpStatus.OK);
	}
}
