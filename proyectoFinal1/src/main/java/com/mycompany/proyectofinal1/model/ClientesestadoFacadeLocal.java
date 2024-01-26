/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Clientesestado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface ClientesestadoFacadeLocal {

    void create(Clientesestado clientesestado);

    void edit(Clientesestado clientesestado);

    void remove(Clientesestado clientesestado);

    Clientesestado find(Object id);

    List<Clientesestado> findAll();

    List<Clientesestado> findRange(int[] range);

    int count();
    
}
