/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Proveedores;
import com.mycompany.proyectofinal1.reports.Prove;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface ProveedoresFacadeLocal {

    void create(Proveedores proveedores);

    void edit(Proveedores proveedores);

    void remove(Proveedores proveedores);

    Proveedores find(Object id);

    List<Proveedores> findAll();

    List<Proveedores> findRange(int[] range);

    int count();
    
    List<Prove> obtenerDatos();
}
