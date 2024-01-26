/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.model.UsuariosFacadeLocal;
import com.mycompany.proyectofinal1.reports.Usu;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Named(value = "graficaUsu")
@ViewScoped
public class GraficaUsu implements Serializable {

    PieChartModel torta;
    @EJB
    UsuariosFacadeLocal usufl;

    public GraficaUsu() {
    }

    public PieChartModel getTorta() {
        return torta;
    }

    public void setTorta(PieChartModel torta) {
        this.torta = torta;
    }

    public void graficar() {
        torta = new PieChartModel();
        try {
            for (Usu usu : this.usufl.obtenerDatos()) {
                torta.set(usu.getNombreUsu(), usu.getIdUsu());
            }
            torta.setTitle("Grafica de usuarios");
            torta.setLegendPosition("e");
            torta.setFill(true);
            torta.setShowDataLabels(true);
            torta.setDiameter(400);
        } catch (Exception e) {
        }
    }

}
