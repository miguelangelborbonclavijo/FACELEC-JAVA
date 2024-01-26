/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Cartrab;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface CartrabFacadeLocal {

    void create(Cartrab cartrab);

    void edit(Cartrab cartrab);

    void remove(Cartrab cartrab);

    Cartrab find(Object id);

    List<Cartrab> findAll();

    List<Cartrab> findRange(int[] range);

    int count();
    
}
