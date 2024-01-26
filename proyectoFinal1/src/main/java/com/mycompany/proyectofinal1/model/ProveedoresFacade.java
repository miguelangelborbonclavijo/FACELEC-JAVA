/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Proveedores;
import com.mycompany.proyectofinal1.reports.Prove;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Stateless
public class ProveedoresFacade extends AbstractFacade<Proveedores> implements ProveedoresFacadeLocal {

    @PersistenceContext(unitName = "Sistema_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedoresFacade() {
        super(Proveedores.class);
    }

    @Override
    public List<Prove> obtenerDatos() {
        List<Proveedores> resullist;
        List<Prove> listProve = new ArrayList();
        String jpql = "SELECT pv FROM Proveedores pv";
        try {
            Query query = em.createQuery(jpql, Proveedores.class);
            resullist = query.getResultList();
            if (resullist.size() > 0) {
                for (Proveedores pv : resullist) {
                    listProve.add(new Prove(pv.getPrNomPr(), pv.getPrId()));
                }
            }
            return listProve;
        } catch (Exception e) {
        }
        return null;
    }
    
}
