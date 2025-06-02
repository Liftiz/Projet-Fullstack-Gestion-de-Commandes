package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Utilisateur;
import com.example.demo.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Utilisateur enregistrer(String email, String motDePasse) {
        String motDePasseCrypte = passwordEncoder.encode(motDePasse);
        Utilisateur utilisateur = new Utilisateur(email, motDePasseCrypte);
        return utilisateurRepository.save(utilisateur);
    }

    public Optional<Utilisateur> trouverParEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    public boolean verifierIdentifiants(String email, String motDePasse) {
        Optional<Utilisateur> utilisateurOpt = trouverParEmail(email);
        if (utilisateurOpt.isPresent()) {
            Utilisateur utilisateur = utilisateurOpt.get();
            return verifierMotDePasse(motDePasse, utilisateur.getMotDePasse());
        }
        return false;
    }


    public boolean verifierMotDePasse(String rawPassword, String encodedPassword) {
    System.out.println("Comparaison : " + rawPassword + " vs " + encodedPassword);
    return passwordEncoder.matches(rawPassword, encodedPassword);
    }


}
