/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Clientes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> implements ClientesFacadeLocal {

    @PersistenceContext(unitName = "Sistema_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }
    
}
