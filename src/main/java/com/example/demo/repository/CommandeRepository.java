// Ce fichier appartient au package repository, qui regroupe toutes les interfaces d'accès aux données
package com.example.demo.repository;

// Import de JpaRepository, l'interface qui fournit toutes les méthodes CRUD de base
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Commande;

// Déclaration de l'interface CommandeRepository
// Elle étend JpaRepository pour l'entité Commande avec une clé primaire de type Long

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    // Ici, aucune méthode n’est nécessaire à écrire manuellement.
    // Grâce à JpaRepository, on a déjà accès à :

    // 🔹 findAll() → Liste toutes les commandes
    // 🔹 findById(Long id) → Trouve une commande par son ID
    // 🔹 save(Commande commande) → Ajoute ou met à jour une commande
    // 🔹 deleteById(Long id) → Supprime une commande par son ID

    // ✅ Tu peux aussi ajouter tes propres méthodes ici plus tard,
    // comme : List<Commande> findByClientId(Long clientId);
}
