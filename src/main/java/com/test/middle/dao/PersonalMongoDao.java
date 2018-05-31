/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.dao;

import com.test.middle.model.PersonalModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author acruzb
 */
public interface PersonalMongoDao extends MongoRepository<PersonalModel, Object>{
    
    public PersonalModel findByNombre(String nombre);
    
}
