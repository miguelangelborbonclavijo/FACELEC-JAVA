/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.reports;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
public class Prove {
    
    private String nombreProve;
    private int idProve;

    public Prove(String nombreProve, int idProve) {
        this.nombreProve = nombreProve;
        this.idProve = idProve;
    }

    public String getNombreProve() {
        return nombreProve;
    }

    public void setNombreProve(String nombreProve) {
        this.nombreProve = nombreProve;
    }

    public int getIdProve() {
        return idProve;
    }

    public void setIdProve(int idProve) {
        this.idProve = idProve;
    }
    
}
