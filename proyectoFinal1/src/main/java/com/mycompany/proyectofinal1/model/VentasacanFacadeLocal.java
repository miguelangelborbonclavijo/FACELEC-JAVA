/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Ventasacan;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface VentasacanFacadeLocal {

    void create(Ventasacan ventasacan);

    void edit(Ventasacan ventasacan);

    void remove(Ventasacan ventasacan);

    Ventasacan find(Object id);

    List<Ventasacan> findAll();

    List<Ventasacan> findRange(int[] range);

    int count();
    
}
