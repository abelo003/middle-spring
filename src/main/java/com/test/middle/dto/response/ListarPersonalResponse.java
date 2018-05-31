/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.dto.response;

import com.test.middle.dto.ResponseDTO;
import com.test.middle.model.PersonalModel;
import com.test.middle.model.PersonalModelRelational;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acruzb
 */
public class ListarPersonalResponse extends ResponseDTO{
    
    private List<PersonalModel> lista;
    private List<PersonalModelRelational> listaPersonal;

    public ListarPersonalResponse() {
        super();
        lista = new ArrayList<>();
        listaPersonal = new ArrayList<>();
    }

    public List<PersonalModel> getLista() {
        return lista;
    }

    public void setLista(List<PersonalModel> lista) {
        this.lista = lista;
    }

    public Iterable<PersonalModelRelational> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(Iterable<PersonalModelRelational> listaPersonal) {
        for (PersonalModelRelational personalModelRelational : listaPersonal) {
            this.listaPersonal.add(personalModelRelational);
        }
    }
       
}
