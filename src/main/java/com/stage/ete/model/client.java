/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

@Table(name = "client")
@EntityListeners(AuditingEntityListener.class)
public class client extends persone {
     
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cc;

    public client(Long cc) {
        this.cc = cc;
    }

    public client(Long cc, Long cin, String nom, String prenom) {
        super(cin, nom, prenom);
        this.cc = cc;
    }

    public Long getCc() {
        return cc;
    }

    public void setCc(Long cc) {
        this.cc = cc;
    }
       
 
    
}
