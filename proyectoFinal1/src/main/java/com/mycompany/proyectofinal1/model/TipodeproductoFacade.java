/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Tipodeproducto;
import com.mycompany.proyectofinal1.reports.TipPro;
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
public class TipodeproductoFacade extends AbstractFacade<Tipodeproducto> implements TipodeproductoFacadeLocal {

    @PersistenceContext(unitName = "Sistema_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipodeproductoFacade() {
        super(Tipodeproducto.class);
    }

    @Override
    public List<TipPro> obtenerDatos() {
        List<Tipodeproducto> resullist;
        List<TipPro> listTipPro = new ArrayList();
        String jpql = "SELECT t FROM Tipodeproducto t";
        try {
            Query query = em.createQuery(jpql, Tipodeproducto.class);
            resullist = query.getResultList();
            if (resullist.size() > 0) {
                for (Tipodeproducto t : resullist) {
                    listTipPro.add(new TipPro(t.getTipNom(),t.getTipId()));
                }
            }
            return listTipPro;
        } catch (Exception e) {
        }
        return null;
    }
}
