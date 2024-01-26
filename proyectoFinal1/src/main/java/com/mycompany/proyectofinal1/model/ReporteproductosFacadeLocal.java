/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Reporteproductos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface ReporteproductosFacadeLocal {

    void create(Reporteproductos reporteproductos);

    void edit(Reporteproductos reporteproductos);

    void remove(Reporteproductos reporteproductos);

    Reporteproductos find(Object id);

    List<Reporteproductos> findAll();

    List<Reporteproductos> findRange(int[] range);

    int count();
    
}
