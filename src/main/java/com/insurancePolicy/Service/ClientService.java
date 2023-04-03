package com.insurancePolicy.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurancePolicy.Exception.ResourceNotFoundException;
import com.insurancePolicy.Model.Client;
import com.insurancePolicy.Repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	//get all clients
	public List<Client> getAllClients(){
		return this.clientRepository.findAll();
	}
	
	//get client by id
	public Client getClientById(Long id) {	
		return this.clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client","id",id));
	}
	
	//create client
    public Client createClient(Client client) {
	    return this.clientRepository.save(client);
	}
	
    //update client
    public Client updateClient(Long id, Client clientDetails) {
    	Client client = getClientById(id);
        client.setName(clientDetails.getName());
        client.setDateOfBirth(clientDetails.getDateOfBirth());
        client.setAddress(clientDetails.getAddress());
        client.setEmail(clientDetails.getEmail());
        return this.clientRepository.save(client);
	}
    
    //delete client
    public void deleteClient(Long id) {
        Client client = getClientById(id);
        this.clientRepository.delete(client);
    }
}
