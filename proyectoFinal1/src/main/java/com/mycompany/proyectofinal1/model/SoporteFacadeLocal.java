/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Soporte;
import com.mycompany.proyectofinal1.reports.Sop;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface SoporteFacadeLocal {

    void create(Soporte soporte);

    void edit(Soporte soporte);

    void remove(Soporte soporte);

    Soporte find(Object id);

    List<Soporte> findAll();

    List<Soporte> findRange(int[] range);

    int count();
    
    List<Sop> obtenerDatos();
}
