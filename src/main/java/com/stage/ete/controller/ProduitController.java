/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stage.ete.controller;

import com.stage.ete.model.produit;
import com.stage.ete.repository.produitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.function.Supplier;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@RestController
@Transactional
@RequestMapping("/api")
@CrossOrigin(origins = "localhost:3000", maxAge = 3600)


/**
 *
 * @author bahri
 */
public class ProduitController {
   @Autowired
   produitRepository pr;
   // Get All Utilisateurs
@GetMapping("/utilisateur")
public List<produit> getUtilisateurs() {
    return (List<produit>) pr.findAll();
}
// Create a new Utilisateur
@PostMapping("/produit")
public produit createproduit(@Valid @RequestBody produit prd) {
    return pr.save(prd);
}
// Get a Single Utilisateur
@GetMapping("/produit/{id}")
public produit getUtilisateurById(@PathVariable(value = "id") Long utilisateurId) {
    return pr.findById(utilisateurId)
            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur"));
}
// Update a Utilisateur
@PutMapping("/produit/{id}")
public produit updateProduit(@PathVariable(value = "id") Long utilisateurId,
                                        @Valid @RequestBody produit prd) throws Throwable {

    produit prod = pr.findById(utilisateurId)
            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur"));

    prod.setId(prd.getId());
    prod.setQuantite(prd.getQuantite());
    prod.setPrix(prd.getPrix());
    produit updatedProduit = pr.save(prod);
    return updatedProduit;
}
// Delete a Utilisateur
@DeleteMapping("/produit/{id}")
public ResponseEntity<?> deleteUtilisateur(@PathVariable(value = "id") Long utilisateurId) {
    produit prd = pr.findById(utilisateurId)
            .orElseThrow(() -> new ResourceNotFoundException("produit"));

    pr.delete(prd);

    return ResponseEntity.ok().build();
}
}
