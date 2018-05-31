/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.dto.response;

import com.test.middle.dto.ResponseDTO;
import com.test.middle.model.BitacoraModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acruzb
 */
public class BitacoraResponse extends ResponseDTO{
    
    private List<BitacoraModel> lista;

    public BitacoraResponse() {
        lista = new ArrayList<>();
    }

    public List<BitacoraModel> getLista() {
        return lista;
    }

    public void setLista(Iterable<BitacoraModel> lista) {
        for (BitacoraModel next : lista) {
            this.lista.add(next);
        }
    }
        
}
