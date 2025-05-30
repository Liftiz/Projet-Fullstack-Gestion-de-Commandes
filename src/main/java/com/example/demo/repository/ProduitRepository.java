// Déclare que cette interface fait partie du package "repository"
package com.example.demo.repository;

// Import de l’interface JpaRepository fournie par Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Produit;

// Cette interface hérite de JpaRepository pour manipuler l'entité Produit
// JpaRepository<Produit, Long> signifie :
// - Le type de l'entité manipulée est Produit
// - La clé primaire (id) de Produit est de type Long

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    // Aucun code à écrire ici ! Spring génère automatiquement :
    // - findAll()
    // - findById()
    // - save()
    // - deleteById()
    // et plein d'autres méthodes utiles !
}
