// Indique que ce fichier fait partie du package "controller"
package com.example.demo.controller;

// Importation des classes nécessaires pour gérer les requêtes HTTP et les listes
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Commande;
import com.example.demo.service.CommandeService;

// Annotation Spring qui transforme cette classe en contrôleur REST
@RestController

// Toutes les routes de ce contrôleur commenceront par /commandes
@RequestMapping("/commandes")
public class CommandeController {

    // Injection automatique du service CommandeService par Spring
    @Autowired
    private CommandeService commandeService;

    // Route GET /commandes
    // Retourne toutes les commandes enregistrées
    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.getAll(); // Appelle le service pour obtenir la liste
    }

    // Route POST /commandes
    // Permet de créer une commande avec :
    // - un identifiant de client passé en paramètre de requête (?clientId=1)
    // - une liste d'identifiants de produits passée dans le corps de la requête
    @PostMapping
    public Commande createCommande(
            @RequestParam Long clientId,         // Requête GET : paramètre ?clientId=1
            @RequestBody List<Long> produitIds   // Corps de la requête : [1, 2, 3]
    ) {
        // Appelle le service pour créer une commande avec les données fournies
        return commandeService.create(clientId, produitIds);
    }
}
