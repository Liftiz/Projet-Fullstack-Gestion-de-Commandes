package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.JwtUtil;
import com.example.demo.service.UtilisateurService;

@CrossOrigin(origins = "http://localhost:3000") // Autorise le front React
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> body) {
        try {
            String email = body.get("email");
            String motDePasse = body.get("motDePasse");

            utilisateurService.enregistrer(email, motDePasse);
            return ResponseEntity.ok("Utilisateur enregistré");
        } catch (Exception e) {
            e.printStackTrace(); // ← pour voir dans la console
            return ResponseEntity.status(500).body("Erreur serveur : " + e.getMessage());
        }
    }

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        try {
            String email = body.get("email");
            String motDePasse = body.get("motDePasse");

            var utilisateurOpt = utilisateurService.trouverParEmail(email);
            if (utilisateurOpt.isPresent()) {
                var utilisateur = utilisateurOpt.get();
                boolean isValid = utilisateurService.verifierMotDePasse(motDePasse, utilisateur.getMotDePasse());
                if (isValid) {
                    String token = jwtUtil.generateToken(email); // ✅ JWT généré ici
                    return ResponseEntity.ok(Map.of("token", token));
                }
            }

            return ResponseEntity.status(401).body("Identifiants invalides");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erreur serveur : " + e.getMessage());
        }
    }

}
