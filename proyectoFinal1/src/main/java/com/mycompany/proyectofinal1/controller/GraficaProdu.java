/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.model.ProductosFacadeLocal;
import com.mycompany.proyectofinal1.reports.Prod;
import com.mycompany.proyectofinal1.reports.Sop;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Named(value = "graficaProdu")
@ViewScoped
public class GraficaProdu implements Serializable {

    PieChartModel torta;
    @EJB
    ProductosFacadeLocal produfl;
   
    public GraficaProdu()  {
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
            for (Prod produ : this.produfl.obtenerDatos()) {
                torta.set(produ.getNombrePro(), produ.getIdPro());
            }
            torta.setTitle("Grafica de Producto");
            torta.setLegendPosition("e");
            torta.setFill(true);
            torta.setShowDataLabels(true);
            torta.setDiameter(400);
        } catch (Exception e) {
        }
    }

}
