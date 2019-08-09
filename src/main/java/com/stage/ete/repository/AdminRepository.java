/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stage.ete.repository;

import com.stage.ete.model.admin;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author bahri
 */
public interface AdminRepository  extends CrudRepository<admin,Long> {
    
}
