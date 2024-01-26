/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.reports;


public class Sop {
    
    private String nombreSop;
    private int idSop;

    public Sop(String nombreSop, int idSop) {
        this.nombreSop = nombreSop;
        this.idSop = idSop;
    }

    public String getNombreSop() {
        return nombreSop;
    }

    public void setNombreSop(String nombreSop) {
        this.nombreSop = nombreSop;
    }

    public int getIdSop() {
        return idSop;
    }

    public void setIdSop(int idSop) {
        this.idSop = idSop;
    }
}
