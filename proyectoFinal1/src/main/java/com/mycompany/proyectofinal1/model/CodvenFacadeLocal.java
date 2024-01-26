/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Codven;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface CodvenFacadeLocal {

    void create(Codven codven);

    void edit(Codven codven);

    void remove(Codven codven);

    Codven find(Object id);

    List<Codven> findAll();

    List<Codven> findRange(int[] range);

    int count();
    
}
