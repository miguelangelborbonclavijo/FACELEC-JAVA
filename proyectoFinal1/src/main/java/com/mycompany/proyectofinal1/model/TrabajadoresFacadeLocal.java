/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Trabajadores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface TrabajadoresFacadeLocal {

    void create(Trabajadores trabajadores);

    void edit(Trabajadores trabajadores);

    void remove(Trabajadores trabajadores);

    Trabajadores find(Object id);

    List<Trabajadores> findAll();

    List<Trabajadores> findRange(int[] range);

    int count();
    
}
