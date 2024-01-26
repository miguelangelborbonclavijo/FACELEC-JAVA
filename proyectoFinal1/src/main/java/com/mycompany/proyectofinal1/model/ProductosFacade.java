/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Productos;
import com.mycompany.proyectofinal1.reports.Prod;
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
public class ProductosFacade extends AbstractFacade<Productos> implements ProductosFacadeLocal {

    @PersistenceContext(unitName = "Sistema_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }

    @Override
    public List<Prod> obtenerDatos() {
        List<Productos> resullist;
        List<Prod> listProd = new ArrayList();
        String jpql = "SELECT pd FROM Productos pd";
        try {
            Query query = em.createQuery(jpql, Productos.class);
            resullist = query.getResultList();
            if (resullist.size() > 0) {
                for (Productos pd : resullist) {
                    listProd.add(new Prod(pd.getProDes(), pd.getProId()));
                }
            }
            return listProd;
        } catch (Exception e) {
        }
        return null;
    }
}
