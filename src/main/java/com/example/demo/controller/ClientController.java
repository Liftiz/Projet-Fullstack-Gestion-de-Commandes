// Déclaration du package : ce fichier appartient au dossier controller (logique de gestion des routes)
package com.example.demo.controller;

// Import des outils nécessaires pour gérer les requêtes HTTP
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;

// Indique que cette classe est un contrôleur REST capable de répondre à des requêtes HTTP (GET, POST, etc.)
@RestController

// Définit la racine des routes de cette classe : ici, toutes les routes commenceront par /clients
@RequestMapping("/clients")
public class ClientController {

    // Injection automatique du service ClientService par Spring
    @Autowired
    private ClientService clientService;

    // GET /clients → renvoie la liste de tous les clients enregistrés
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAll(); // Appelle le service pour récupérer les clients
    }

    // POST /clients → ajoute un nouveau client
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        // @RequestBody : Spring convertit automatiquement le JSON reçu en objet Client
        return clientService.create(client); // Appelle le service pour l’enregistrer
    }
}
