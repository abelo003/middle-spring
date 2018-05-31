/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.service;

import com.test.middle.dto.ResponseDTO;
import com.test.middle.dto.response.BitacoraResponse;
import com.test.middle.model.BitacoraModel;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @RabbitListener(queues="jsa.queue")
    public void consumerBitacora(BitacoraModel msg){
        LOGGER.info("Se consume el mensaje del broker: " + msg);
    }

}
