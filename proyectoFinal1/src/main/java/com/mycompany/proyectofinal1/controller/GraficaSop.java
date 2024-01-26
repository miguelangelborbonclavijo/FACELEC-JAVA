/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.model.SoporteFacadeLocal;
import com.mycompany.proyectofinal1.reports.Sop;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Named(value = "graficaSop")
@ViewScoped
public class GraficaSop implements Serializable {

    PieChartModel torta;
    @EJB
    SoporteFacadeLocal sopfl;
    /**
     * Creates a new instance of GraficaSop
     */
    public GraficaSop() {
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
            for (Sop sop : this.sopfl.obtenerDatos()) {
                torta.set(sop.getNombreSop(), sop.getIdSop());
            }
            torta.setTitle("Grafica de Soporte");
            torta.setLegendPosition("e");
            torta.setFill(true);
            torta.setShowDataLabels(true);
            torta.setDiameter(400);
        } catch (Exception e) {
        }
    }
    
}
