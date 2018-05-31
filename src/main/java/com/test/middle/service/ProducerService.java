/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.service;

import com.test.middle.model.BitacoraModel;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author acruzb
 */
@Component
public class ProducerService {

    private final Logger LOGGER = Logger.getLogger(ProducerService.class);
    
    @Autowired
    private AmqpTemplate amqpTemplate;
    private final String exchange = "jsa.direct";
    private final String routingKey = "jsa.routingkey";

    public ProducerService() {
    }

    public void produceMsg(BitacoraModel msg) {
        amqpTemplate.convertAndSend(exchange, routingKey, msg);
        LOGGER.info("Se agrega el mensaje al broker.");
    }

}
