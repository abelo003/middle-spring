/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.dto.request;

import com.test.middle.annotations.NotNullOrEmptyField;
import com.test.middle.dto.RequestDTO;
import com.test.middle.annotations.ValidationLength;
import java.io.IOException;
import java.util.Date;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author acruzb
 */

public class AddPersonalRequest extends RequestDTO{
    
    @ValidationLength(longitudMaxima = 19)
    private String nombre;
    @ValidationLength(longitudMaxima = 250)
    private String descripcion;
    @NotNullOrEmptyField
    private Date fechaAlta;

    public AddPersonalRequest() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    @Override
    public String toString(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        }catch (IOException e) {}
        return null;
    }
    
}
