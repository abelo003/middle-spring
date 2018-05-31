/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.config;

import com.mongodb.MongoClientURI;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

/**
 *
 * @author acruzb
 */
@Configuration
public class MongoConfig {
    
    @Value("${spring.data.mongodb.uri}")
    public String url;
    
    @Bean
    public MongoClientURI mongoClient() {
        return new MongoClientURI(url);
    }
    
    @Bean
    public MongoDbFactory mongoDbFactory(MongoClientURI mongoClient) throws Exception {
        return new SimpleMongoDbFactory(mongoClient);
    }

    @Primary
    @Bean
    public MongoTemplate mongoTemplate(MongoClientURI mongoClient) throws UnknownHostException {
        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient);
        MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
        ((MappingMongoConverter) mongoTemplate.getConverter()).setTypeMapper(new DefaultMongoTypeMapper(null));
        return mongoTemplate;
    }
    
}
