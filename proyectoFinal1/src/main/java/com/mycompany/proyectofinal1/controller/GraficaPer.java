/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
//importaciones
//1 importamos la ubiicacion dell archivo en que carpeta es ta se genera cuando creamos el archivo por primera vez
package com.mycompany.proyectofinal1.controller;
//importamos el archivo PersonasFacadeLocal
//que es Facade: es un patronde diseño que nos da una interfaz 
//simplificada a una biblioteca, un framework o cualquier grupo complejo de clases
import com.mycompany.proyectofinal1.model.PersonasFacadeLocal;
//Llamomos al archivo de Per.java
import com.mycompany.proyectofinal1.reports.Per;
//la serualizacion de un objeto su fin es generar una secuencia
//de byte lista para su almacenamiento o trasmision
//con una deserializacion se puede vovel al estado origina del objeto
import java.io.Serializable;
//es dotar al programador de un modelo que le permita abstraerse de los problemas generales de una aplicación
import javax.ejb.EJB;
//lo que hacemos es inyectar un interfaz y asignadole un nombra a 
//nuestro parametro
import javax.inject.Named;
//
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
//Anotación que indica el nombre del bean gestionado en el ámbito de JSF.
@Named(value = "graficaPer")

//Anotación que define el ámbito del bean como "view scoped", lo que significa que 
//el bean vive mientras la vista asociada esté activa.
@ViewScoped


//Creo una clase publica que se implemente Serializable que lo que hace es convertir
//en una secuencia de bytes y luego reconstruido como un objeto nuevo.
public class GraficaPer implements Serializable {

    //llamos el PersonasFacadeLocal y el peicherModel asignadole un nombre
    //torta: Objeto del tipo PieChartModel de PrimeFaces utilizado para representar la gráfica de torta.
    PieChartModel torta;
    @EJB
    //perfl: Objeto de la interfaz PersonasFacadeLocal, que se utiliza para interactuar con el EJB que maneja la entidad "Personas".
    PersonasFacadeLocal perfl;

    public GraficaPer() {
    }

    //De hay creamos los getter and Setter de la importacion de archivo de Torta
    public PieChartModel getTorta() {
        return torta;
    }

    public void setTorta(PieChartModel torta) {
        this.torta = torta;
    }
    //creamos un metodo publico que no retorna nada que se llama Graficar
    public void graficar() {
        //Creamos un objeto torta del archivo PieChartModel
        torta = new PieChartModel();
        //bloque en donde puede ocurrir una excepcion
        try {
            //con el for  hace una acción hasta que se cumpla una condición previamente definida
            //llamamos al archovo Per y le asignamos el nomnbre de per y con this nos referimos al objeto de 
            //perfl(personas facede local) y llamamos el metodo de la lista de obtener datos
            for (Per per : this.perfl.obtenerDatos()) {
                //Utiliza el método obtenerDatos() del objeto perfl para obtener datos de la entidad Per.
                //llamos al bojeto de torta con un metodo publico set lo que quiere hacer aca es que los datos que 
                //muestre sea los siguiernte uno te tipo texto y otro de tipo numerico
                //Agrega datos al modelo de la gráfica de torta usando el método set()
                torta.set(per.getNombrePer(),per.getIdPer());
            }
            //Establece algunas propiedades de la gráfica, como el título, la posición de la leyenda,
            //si se debe rellenar, mostrar etiquetas de datos y el diámetro.
            torta.setTitle("Grafica de Personas");
            torta.setLegendPosition("e");
            torta.setFill(true);
            torta.setShowDataLabels(true);
            torta.setDiameter(400);
            //Es como el else (se ejecuta al dispara una excepcion en el bloque try
        } catch (Exception e) {
        }
    }

}
