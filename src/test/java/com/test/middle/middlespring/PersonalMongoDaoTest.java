/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.middlespring;

import com.test.middle.MiddleSpringApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author acruzb
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(MiddleSpringApplication.class)
//@WebAppConfiguration
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
//@SpringApplicationConfiguration(classes = MiddleSpringApplication.class)
public class PersonalMongoDaoTest {
    
    @Test
    public void test(){
        System.out.println("Yes");
    }
    
}
