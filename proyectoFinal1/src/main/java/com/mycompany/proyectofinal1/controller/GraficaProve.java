/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.model.ProveedoresFacadeLocal;
import com.mycompany.proyectofinal1.reports.Prove;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Named(value = "graficaProve")
@ViewScoped
public class GraficaProve implements Serializable {

    PieChartModel torta;
    @EJB
    ProveedoresFacadeLocal provefl;
    
    public GraficaProve() {
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
            for (Prove prov : this.provefl.obtenerDatos()) {
                torta.set(prov.getNombreProve(), prov.getIdProve());
            }
            torta.setTitle("Grafica de Provedores");
            torta.setLegendPosition("e");
            torta.setFill(true);
            torta.setShowDataLabels(true);
            torta.setDiameter(400);
        } catch (Exception e) {
        }
    }
    
}
