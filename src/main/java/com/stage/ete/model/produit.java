
package com.stage.ete.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author bahri
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")

@Table(name = "produit")
@EntityListeners(AuditingEntityListener.class)
public class produit {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
       @NotBlank
       private String quantite;
       @NotBlank
       private String prix;

    public produit() {
    }

    public produit(Long id, String quantite, String prix) {
        this.id = id;
        this.quantite = quantite;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public String getQuantite() {
        return quantite;
    }

    public String getPrix() {
        return prix;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
      
   
    
}
