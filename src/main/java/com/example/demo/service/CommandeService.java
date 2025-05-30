// Ce fichier appartient au package "service", où l’on centralise la logique métier
package com.example.demo.service;

// Importation des bibliothèques nécessaires
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Client;
import com.example.demo.model.Commande;
import com.example.demo.model.Produit;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.CommandeRepository;
import com.example.demo.repository.ProduitRepository;

// Annotation @Service : indique que cette classe contient de la logique métier (service injectable)
@Service
public class CommandeService {

    // Injection des 3 repositories nécessaires pour créer une commande
    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProduitRepository produitRepository;

    // Méthode pour récupérer toutes les commandes (GET)
    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }

    // Méthode pour créer une commande (POST)
    // On reçoit : un ID de client + une liste d'IDs de produits
    public Commande create(Long clientId, List<Long> produitIds) {
        // On récupère le client depuis la base grâce à son ID
        Client client = clientRepository.findById(clientId).orElse(null);

        // On récupère tous les produits correspondants aux IDs reçus
        List<Produit> produits = produitRepository.findAllById(produitIds);

        // On crée une nouvelle commande avec :
        // - la date du jour
        // - le client récupéré
        // - la liste des produits associés
        Commande commande = new Commande(LocalDate.now(), client, produits);

        // On sauvegarde la commande dans la base et on la retourne
        return commandeRepository.save(commande);
    }
}

