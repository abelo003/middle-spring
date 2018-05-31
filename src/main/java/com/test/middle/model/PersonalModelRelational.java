/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author acruzb
 */
@Entity
public class PersonalModelRelational implements Serializable {
    
    @JsonIgnore
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String descripcion;
    private Date fechaAlta;
    private String extraData;

    public PersonalModelRelational() {
    }

    public PersonalModelRelational(Integer id, String nombre, String descripcion, Date fechaAlta, String extraData) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaAlta = fechaAlta;
        this.extraData = extraData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }
    
    
}
