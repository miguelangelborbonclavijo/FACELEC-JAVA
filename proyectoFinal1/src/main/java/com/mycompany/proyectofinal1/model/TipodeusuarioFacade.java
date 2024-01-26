/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Tipodeusuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Stateless
public class TipodeusuarioFacade extends AbstractFacade<Tipodeusuario> implements TipodeusuarioFacadeLocal {

    @PersistenceContext(unitName = "Sistema_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipodeusuarioFacade() {
        super(Tipodeusuario.class);
    }
    
}
