/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.reports;


public class TipPro {

    private String nombreTipPro;
    private int sumatori;

    public TipPro(String nombreTipPro, int sumatori) {
        this.nombreTipPro = nombreTipPro;
        this.sumatori = sumatori;
    }

    public String getNombreTipPro() {
        return nombreTipPro;
    }

    public void setNombreTipPro(String nombreTipPro) {
        this.nombreTipPro = nombreTipPro;
    }

    public int getSumatori() {
        return sumatori;
    }

    public void setSumatori(int sumatori) {
        this.sumatori = sumatori;
    }


}
