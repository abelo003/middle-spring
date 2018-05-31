/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.dao;

import com.test.middle.model.BitacoraModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author acruzb
 */

public interface BitacoraRepository extends CrudRepository<BitacoraModel, Object>{
    
}
