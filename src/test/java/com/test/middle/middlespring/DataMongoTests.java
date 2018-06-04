/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.middlespring;

import com.test.middle.dto.request.AddPersonalRequest;
import com.test.middle.model.PersonalModel;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author acruzb
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataMongoTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test(){
        AddPersonalRequest p = new AddPersonalRequest();
        p.setDescripcion("Heyyyyy");
        
        List<PersonalModel> lista = mongoTemplate.findAll(PersonalModel.class);
        lista.forEach((object) -> {
            System.out.println(object);
        });
    }
    
}
