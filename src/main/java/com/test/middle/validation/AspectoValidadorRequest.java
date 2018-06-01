/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.validation;

import com.test.middle.dto.RequestDTO;
import com.test.middle.dto.ResponseDTO;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author acruzb
 */
@Aspect
@Component("protoype")
public class AspectoValidadorRequest {
    
    

    private final Logger LOGGER = Logger.getLogger(this.getClass());
    private final String HEADER_DATA_NAME = "extra-data";

    @Around("@annotation(ValiationRequest)")
    public ResponseEntity<?> validacionRequestDTO(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("Entra al around.");
        ResponseEntity responseEntity = null;
        HttpServletRequest servletRequest = null;
        RequestDTO requestDTO = null;
        for (Object object : joinPoint.getArgs()) {
            if (object instanceof HttpServletRequest) {
                servletRequest = (HttpServletRequest) object;
            } else if (object instanceof RequestDTO) {
                requestDTO = (RequestDTO) object;
            }
        }
        
        try {
            Object[] args = {null, requestDTO};
            String extraData = getExtraData(servletRequest);
            if (null != extraData && null != requestDTO) {
                requestDTO.setExtraData(extraData);
                LOGGER.info("Se agrega la infomacion complementaria al request.");
                responseEntity = (ResponseEntity) joinPoint.proceed(args);
            }
            else{
                throw new Exception("No hay extraData");
            }
        } catch (Exception e) {
            ResponseDTO response = new ResponseDTO();
            response.setCodigoOperacion(-1);
            response.setDescripcion("Falta informacion.");
            responseEntity = new ResponseEntity(response, HttpStatus.OK);
        }
        return ((ResponseEntity<?>) responseEntity);
    }
    
    private String getExtraData(HttpServletRequest servletRequest) {
        Enumeration headerNames = servletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            if (key.equals(HEADER_DATA_NAME)) {
                return servletRequest.getHeader(key);
            }
        }
        return null;
    }

}
