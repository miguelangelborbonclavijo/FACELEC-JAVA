/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Tipodeusuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface TipodeusuarioFacadeLocal {

    void create(Tipodeusuario tipodeusuario);

    void edit(Tipodeusuario tipodeusuario);

    void remove(Tipodeusuario tipodeusuario);

    Tipodeusuario find(Object id);

    List<Tipodeusuario> findAll();

    List<Tipodeusuario> findRange(int[] range);

    int count();
    
}
