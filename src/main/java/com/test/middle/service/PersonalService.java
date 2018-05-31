/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.service;

import com.test.middle.dao.BitacoraRepository;
import com.test.middle.dao.PersonalMongoDao;
import com.test.middle.dao.PersonalSQLRepository;
import com.test.middle.dto.ResponseDTO;
import com.test.middle.dto.request.AddPersonalRequest;
import com.test.middle.dto.response.AddPersonalResponse;
import com.test.middle.dto.response.BitacoraResponse;
import com.test.middle.dto.response.ListarPersonalResponse;
import com.test.middle.model.BitacoraModel;
import com.test.middle.model.PersonalModel;
import com.test.middle.model.PersonalModelRelational;
import com.test.middle.validation.ValiationRequest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author acruzb
 */
@Service
public class PersonalService {
    
    private final Logger LOGGER = Logger.getLogger(PersonalService.class);
    private final SimpleDateFormat dateFormat;
    
    @Autowired
    private PersonalMongoDao personalDao;
    @Autowired
    private PersonalSQLRepository personalRepository;
    @Autowired
    private BitacoraRepository bitacoraRepository;
    @Autowired
    private ProducerService producer;

    public PersonalService() {
        dateFormat = new SimpleDateFormat("hh:mm:ss");
    }
    
    @ValiationRequest
    public ResponseEntity<?> addPersonal(HttpServletRequest httpRequest, AddPersonalRequest request){
        LOGGER.info("Se iniciar el proceso para agregar el personal: " + request);
        AddPersonalResponse response = new AddPersonalResponse();
        
        PersonalModel personal= new PersonalModel();
        personal.setNombre(request.getNombre());
        personal.setDescripcion(request.getDescripcion());
        personal.setFechaAlta(request.getFechaAlta());
        personal.setExtraData(request.getExtraData());
        try{
            LOGGER.info("Se guarda en mongo");
            personalDao.save(personal);
            PersonalModelRelational personal2 = new PersonalModelRelational();
            personal2.setNombre(request.getNombre());
            personal2.setDescripcion(request.getDescripcion());
            personal2.setFechaAlta(new Date(request.getFechaAlta().getTime()));
            personal2.setExtraData(request.getExtraData());
            LOGGER.info("Se guarda en MySQL");
            personalRepository.save(personal2);
            BitacoraModel bitacora1 = new BitacoraModel("Se agrega registro a mongo", dateFormat.format(new java.util.Date()));
            BitacoraModel bitacora2 = new BitacoraModel("Se agrega registro a MySQL", dateFormat.format(new java.util.Date()));
            bitacoraRepository.save(bitacora1);
            bitacoraRepository.save(bitacora2);
            producer.produceMsg(bitacora1);
            doSuccessResponse(response);
        }
        catch(Exception e){
            doDefaulErrorResponse(response);
            LOGGER.info("No se pudo guardar la informacion.");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    public ResponseEntity<?> listar(){
        ListarPersonalResponse response = new ListarPersonalResponse();
        try{
            response.setLista(personalDao.findAll());
            doSuccessResponse(response);
        }catch(Exception e){
            doDefaulErrorResponse(response);
            LOGGER.info("No se encontro la informacion.");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    public ResponseEntity<?> listarMySQL(){
        ListarPersonalResponse response = new ListarPersonalResponse();
        try{
            response.setListaPersonal(personalRepository.findAll());
            doSuccessResponse(response);
        }catch(Exception e){
            doDefaulErrorResponse(response);
            LOGGER.info("No se encontro la informacion.");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    public ResponseEntity<?> listarRegistroBitacora(){
        BitacoraResponse response = new BitacoraResponse();
        try{
            response.setLista(bitacoraRepository.findAll());
            doSuccessResponse(response);
        }catch(Exception e){
            doDefaulErrorResponse(response);
            LOGGER.info("No se encontro la informacion.", e);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    private void doSuccessResponse(ResponseDTO response){
        response.setCodigoOperacion(0);
        response.setDescripcion("Operacion exitosa.");
    }
    
    private void doDefaulErrorResponse(ResponseDTO response){
        response.setCodigoOperacion(-1);
        response.setDescripcion("No se pudo realizar la operacion.");
    }
    
}
