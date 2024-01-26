/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Soporte;
import com.mycompany.proyectofinal1.reports.Sop;
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
public class SoporteFacade extends AbstractFacade<Soporte> implements SoporteFacadeLocal {

    @PersistenceContext(unitName = "Sistema_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SoporteFacade() {
        super(Soporte.class);
    }

    @Override
    public List<Sop> obtenerDatos() {
        List<Soporte> resullist;
        List<Sop> listSop = new ArrayList();
        String jpql = "SELECT s FROM Soporte s";
        try {
            Query query = em.createQuery(jpql, Soporte.class);
            resullist = query.getResultList();
            if (resullist.size() > 0) {
                for (Soporte s : resullist) {
                    listSop.add(new Sop( s.getSopDesc(), s.getSopoId()));
                }
            }
            return listSop;
        } catch (Exception e) {
        }
        return null;
    }

}
