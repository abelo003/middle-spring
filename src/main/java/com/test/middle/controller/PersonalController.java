/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.controller;

import com.test.middle.dto.request.AddPersonalRequest;
import com.test.middle.service.PersonalService;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acruzb
 */
@RequestMapping("personal")
@RestController
public class PersonalController {

    Logger LOGGER = Logger.getLogger(PersonalController.class);

    @Autowired
    private PersonalService personal;
    
    @RequestMapping(value = "registrar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> addPersonal(HttpServletRequest httpRequest, @RequestBody AddPersonalRequest request) {
        LOGGER.info("Llega peticion al servicio de agregar personal.");
        return (ResponseEntity<String>)personal.addPersonal(httpRequest, request);
    }
    
    @RequestMapping(value = "listar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    public ResponseEntity<String> listarPersonal() {
        LOGGER.info("Llega peticion al servicio de listar informacion.");
        return (ResponseEntity<String>) personal.listar();
    }
    
    @RequestMapping(value = "listar/all", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    public ResponseEntity<String> listarPersonales() {
        LOGGER.info("Llega peticion al servicio de listar informacion.");
        return (ResponseEntity<String>) personal.listarMySQL();
    }
    
    @RequestMapping(value = "bitacora", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    public ResponseEntity<String> listarBitacora() {
        LOGGER.info("Llega peticion al servicio de listar informacion.");
        return (ResponseEntity<String>) personal.listarRegistroBitacora();
    }
    
}
