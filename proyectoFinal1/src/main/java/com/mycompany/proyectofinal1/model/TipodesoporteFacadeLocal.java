/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Tipodesoporte;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface TipodesoporteFacadeLocal {

    void create(Tipodesoporte tipodesoporte);

    void edit(Tipodesoporte tipodesoporte);

    void remove(Tipodesoporte tipodesoporte);

    Tipodesoporte find(Object id);

    List<Tipodesoporte> findAll();

    List<Tipodesoporte> findRange(int[] range);

    int count();
    
}
