/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author acruzb
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {
    
    private int codigoOperacion;
    private String descripcion;

    public ResponseDTO() {
    }

    public int getCodigoOperacion() {
        return codigoOperacion;
    }

    public void setCodigoOperacion(int codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
