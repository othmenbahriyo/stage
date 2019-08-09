/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stage.ete.controller;

import com.stage.ete.model.persone;
import com.stage.ete.repository.PersoneRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@RestController
@Transactional
@RequestMapping("/api")
@CrossOrigin(origins = "localhost:3000", maxAge = 3600)
public class UtilisateurController {

    @Autowired
    PersoneRepository pr;

    // Get All Utilisateurs
@GetMapping("/utilisateur")
public List<persone> getUtilisateurs() {
    return (List<persone>) pr.findAll();
}
// Create a new Utilisateur
@PostMapping("/utilisateurs")
public persone createUtilisateur(@Valid @RequestBody persone utilisateur) {
    return pr.save(utilisateur);
}

// Get a Single Utilisateur
@GetMapping("/utilisateurs/{id}")
public persone getUtilisateurById(@PathVariable(value = "id") Long utilisateurId) {
    return pr.findById(utilisateurId)
            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur"));
}
    // Update a Utilisateur
@PutMapping("/utilisateur/{id}")
public persone updateUtilisateur(@PathVariable(value = "id") Long utilisateurId,
                                        @Valid @RequestBody persone utilisateurDetails) {

    persone utilisateur = pr.findById(utilisateurId)
            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur"));

    utilisateur.setNom(utilisateurDetails.getNom());
    utilisateur.setPrenom(utilisateurDetails.getPrenom());
    
    utilisateur.setCin(utilisateurDetails.getCin());
   
    persone updatedUtilisateur = pr.save(utilisateur);
    return updatedUtilisateur;
}
// Delete a Utilisateur
@DeleteMapping("/utilisateurs/{id}")
public ResponseEntity<?> deleteUtilisateur(@PathVariable(value = "id") Long utilisateurId) {
    persone utilisateur = pr.findById(utilisateurId)
            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur"));

    pr.delete(utilisateur);

    return ResponseEntity.ok().build();
}
}
