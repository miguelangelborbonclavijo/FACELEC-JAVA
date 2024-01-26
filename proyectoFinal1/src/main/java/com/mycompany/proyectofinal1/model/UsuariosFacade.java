/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.model;

import com.mycompany.proyectofinal1.entities.Usuarios;
import com.mycompany.proyectofinal1.reports.Usu;
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
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "Sistema_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    @Override
    public Usuarios IniciarSesion(Usuarios usuarios) {
        try {
            Query query = em.createQuery("Select u from Usuarios u where u.usuario=:usuario and u.contrasena=:contrasena");
            query.setParameter("usuario", usuarios.getUsuario());
            query.setParameter("contrasena", usuarios.getContrasena());
            List<Usuarios> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuarios = lista.get(0);
            } else {

            }
        } catch (Exception e) {
            return null;
        }
        return usuarios;
    }

    @Override
    public List<Usu> obtenerDatos() {
        List<Usuarios> resullist;
        List<Usu> listUsu = new ArrayList();
        String jpql = "SELECT u FROM Usuarios u";
        try {
            Query query = em.createQuery(jpql, Usuarios.class);
            resullist = query.getResultList();
            if (resullist.size() > 0) {
                for (Usuarios u : resullist) {
                    listUsu.add(new Usu( u.getNombre(), u.getUsuId()));
                }
            }
            return listUsu;
        } catch (Exception e) {
        }
        return null;
    }

}
