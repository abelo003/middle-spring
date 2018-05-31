/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 *
 * @author acruzb
 */
@RedisHash("bitacora")
public class BitacoraModel implements Serializable{
    
    @Id
    private String id;
    private String evento;
    private String hora;

    public BitacoraModel() {
    }

    public BitacoraModel(String evento, String hora) {
        this.evento = evento;
        this.hora = hora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
