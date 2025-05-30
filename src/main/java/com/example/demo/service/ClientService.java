// Ce fichier appartient au package "service" : il contient la logique métier pour les clients
package com.example.demo.service;

// Import des classes nécessaires
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;

// Annotation @Service → indique à Spring que cette classe est un service métier
@Service
public class ClientService {

    // Injection automatique du ClientRepository (accès aux données)
    @Autowired
    private ClientRepository clientRepository;

    // Méthode pour récupérer tous les clients enregistrés
    public List<Client> getAll() {
        return clientRepository.findAll(); // méthode générée automatiquement par JpaRepository
    }

    // Méthode pour ajouter un nouveau client dans la base
    public Client create(Client client) {
        return clientRepository.save(client); // enregistre ou met à jour un client
    }

    // Méthode pour récupérer un client spécifique par son identifiant
    public Client findById(Long id) {
        // findById renvoie un Optional<Client> → on utilise orElse(null) pour éviter une exception
        return clientRepository.findById(id).orElse(null);
    }
}
