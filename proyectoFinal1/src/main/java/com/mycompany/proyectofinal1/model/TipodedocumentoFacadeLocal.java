/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Tipodedocumento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface TipodedocumentoFacadeLocal {

    void create(Tipodedocumento tipodedocumento);

    void edit(Tipodedocumento tipodedocumento);

    void remove(Tipodedocumento tipodedocumento);

    Tipodedocumento find(Object id);

    List<Tipodedocumento> findAll();

    List<Tipodedocumento> findRange(int[] range);

    int count();
    
}
