/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Tipodeproducto;
import com.mycompany.proyectofinal1.reports.TipPro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Local
public interface TipodeproductoFacadeLocal {

    void create(Tipodeproducto tipodeproducto);

    void edit(Tipodeproducto tipodeproducto);

    void remove(Tipodeproducto tipodeproducto);

    Tipodeproducto find(Object id);

    List<Tipodeproducto> findAll();

    List<Tipodeproducto> findRange(int[] range);

    int count();
    
    List<TipPro> obtenerDatos();
}
