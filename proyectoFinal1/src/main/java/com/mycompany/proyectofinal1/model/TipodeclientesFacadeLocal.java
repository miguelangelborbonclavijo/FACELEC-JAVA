/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Tipodeclientes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface TipodeclientesFacadeLocal {

    void create(Tipodeclientes tipodeclientes);

    void edit(Tipodeclientes tipodeclientes);

    void remove(Tipodeclientes tipodeclientes);

    Tipodeclientes find(Object id);

    List<Tipodeclientes> findAll();

    List<Tipodeclientes> findRange(int[] range);

    int count();
    
}
