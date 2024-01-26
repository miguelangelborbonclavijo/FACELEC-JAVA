/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Personas;
import com.mycompany.proyectofinal1.reports.Per;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface PersonasFacadeLocal {

    //Métodos para realizar operaciones CRUD en la entidad Personas
    void create(Personas personas);

    void edit(Personas personas);

    void remove(Personas personas);

    Personas find(Object id);

    List<Personas> findAll();

    List<Personas> findRange(int[] range);

    int count();
    //creamos una lista de personas con el nombre de obtener datos
    //// Método personalizado para obtener datos específicos transformados desde Personas
    List<Per> obtenerDatos();
    
}
