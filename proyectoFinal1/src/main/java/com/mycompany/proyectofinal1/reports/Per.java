/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.reports;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
public class Per {
    //creamos dos variables que solo son visibles dentro de la clase, de texo y entero
    private String nombrePer;
    private int idPer;
    //con esas dos variables de Tipo entero creamos un constructor
    //El constructor es para inicializar el objeto y establecer sus propiedades y valores
    public Per(String nombrePer, int idPer) {
        this.nombrePer = nombrePer;
        this.idPer = idPer;
    }
    //Despues de esto creamos los getters y setters
    //nos permiten leer y escribir (respectivamente) los valores de nuestras variables privadas 
    //desde fuera de la clase donde fueron creadas. Con los Getters obtenemos los datos de las 
    //variables y con los Setter asignamos o cambiamos su valor.
    public String getNombrePer() {
        return nombrePer;
    }

    public void setNombrePer(String nombrePer) {
        this.nombrePer = nombrePer;
    }

    public int getIdPer() {
        return idPer;
    }

    public void setIdPer(int idPer) {
        this.idPer = idPer;
    }
}
