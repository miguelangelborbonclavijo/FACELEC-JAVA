/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import org.primefaces.model.chart.PieChartModel;
import com.mycompany.proyectofinal1.model.TipodeproductoFacadeLocal;
import com.mycompany.proyectofinal1.reports.TipPro;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Named(value = "graficaTipPro")
@ViewScoped
public class GraficaTipPro implements Serializable {

    PieChartModel torta;
    @EJB
    TipodeproductoFacadeLocal TipProfl;

    public GraficaTipPro() {
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
            for (TipPro tip : this.TipProfl.obtenerDatos()) {
                torta.set(tip.getNombreTipPro(), tip.getSumatori());
            }
            torta.setTitle("Grafia de Tipo de producto");
            torta.setLegendPosition("e");
            torta.setFill(true);
            torta.setShowDataLabels(true);
            torta.setDiameter(400);
        } catch (Exception e) {
        }
    }
}
