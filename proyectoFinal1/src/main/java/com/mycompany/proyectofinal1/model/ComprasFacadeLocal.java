/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Compras;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface ComprasFacadeLocal {

    void create(Compras compras);

    void edit(Compras compras);

    void remove(Compras compras);

    Compras find(Object id);

    List<Compras> findAll();

    List<Compras> findRange(int[] range);

    int count();
    
}
