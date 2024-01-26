/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Usuarios;
import com.mycompany.proyectofinal1.reports.Usu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface UsuariosFacadeLocal {

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();

    List<Usu> obtenerDatos();

    Usuarios IniciarSesion(Usuarios usuarios);
}
