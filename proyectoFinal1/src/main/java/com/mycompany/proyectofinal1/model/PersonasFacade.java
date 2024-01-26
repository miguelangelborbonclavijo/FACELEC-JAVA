/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//ubicacion del archi en que paquete
package com.mycompany.proyectofinal1.model;
//se traen el archivo de entidades
import com.mycompany.proyectofinal1.entities.Personas;
//se traen el archivo de reporte de personas
import com.mycompany.proyectofinal1.reports.Per;
//es una de las estructuras de datos más utilizadas en Java. Permite modificar 
//y almacenar dinámicamente una colección de objetos.
import java.util.ArrayList;
//Se importa para poder hacer listas
import java.util.List;
//
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
// el enfoque stateless implica que una aplicación 
//o sistema no guarda ningún estado relacionado con las interacciones de los usuarios. 
@Stateless
// creamos unaclase puclica en la cual creamos una subclase abstracta 
//de Personas imp´lementado la interfaz del archivo PersonasFacadeLocal 
public class PersonasFacade extends AbstractFacade<Personas> implements PersonasFacadeLocal {

    @PersistenceContext(unitName = "Sistema_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonasFacade() {
        super(Personas.class);
    }

    //debe anular un método de una superclase. 
    @Override
    //Crea una lista del archivo Per.java con acceso publico llamando al metodo de obtener datos
    public List<Per> obtenerDatos() {
        //crea ubna lista con el chivo de entidades de persoans y le asigana el nombre de resullits
        List<Personas> resullist;
        //lo que hace aca es que todos los datos que estan en esta lista los almacena similar a un Array
        List<Per> listPer = new ArrayList();
        //hacemos la consulta jpql donde llamos todos los datos de una tabla de la base de datos
        String jpql = "SELECT p FROM Personas p";
        //creamos el inico del bloque de excepticion con el try
        try {
            //hacemos la peticion de datos con un query 
            //em.createQuery devuelve un objeto Query, que puede después interrogarse para obtener 
            //los resultados de la consulta.
            // llamos a la consulta jpql y a la case de Personas
            Query query = em.createQuery(jpql, Personas.class);
            //llamomos a la lista de Persoans por parte de la entidad y le desimos que sea igual a 
            //los resultado de la lista de peticiones con el query
            resullist = query.getResultList();
            // con una condicional le decimos que si resullist cuanta con mas un elemento en el Array
            if (resullist.size() > 0) {
                //el fin objetivo de este ciclo es que reuna todos los datos reunido en resullist para que al final los retorne 
                for (Personas p : resullist) {
                    listPer.add(new Per(p.getPerNom1(), p.getPerId()));
                }
            }
            //lo que le decimos que que retorne el valor almacenado en listPer
            return listPer;
            //Es como el else (se ejecuta al dispara una excepcion en el bloque try
        } catch (Exception e) {
        }
        return null;

    }
}
