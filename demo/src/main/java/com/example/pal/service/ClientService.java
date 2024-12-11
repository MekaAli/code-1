package com.example.pal.service;

import com.example.pal.model.Client;
import com.example.pal.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Get all clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Get a client by id
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    // Save or update a client
    public Client saveOrUpdateClient(Client client) {
        return clientRepository.save(client);
    }

    // Delete a client
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    // Additional business logic related to Client (e.g., validating client data)
    public void validateClient(Client client) {
        // Add any validation or business rules here
    }
}
