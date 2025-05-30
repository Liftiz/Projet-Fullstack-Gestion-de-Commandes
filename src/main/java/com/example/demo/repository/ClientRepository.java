// Ce fichier fait partie du package "repository", qui contient les interfaces d'accès aux données
package com.example.demo.repository;

// Import de JpaRepository, une interface fournie par Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Client;

// Déclaration de l'interface ClientRepository
// Elle hérite de JpaRepository pour bénéficier automatiquement des opérations CRUD

public interface ClientRepository extends JpaRepository<Client, Long> {
    // On précise :
    // - Le type de l'entité : Client
    // - Le type de sa clé primaire : Long

    // Grâce à ça, pas besoin d’écrire de code !
    // Spring Boot génère automatiquement :
    // - findAll() → liste tous les clients
    // - findById(id) → trouve un client par son ID
    // - save(client) → ajoute ou modifie un client
    // - deleteById(id) → supprime un client
}
