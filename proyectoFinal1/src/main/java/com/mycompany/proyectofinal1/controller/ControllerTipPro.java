package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.entities.Tipodeproducto;
import com.mycompany.proyectofinal1.model.TipodeproductoFacadeLocal;
//import com.mycompany.proyectofinal1.reports.TipPro;

import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
//import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Named(value = "controllerTipPro")
@SessionScoped
public class ControllerTipPro implements Serializable {

    /*PieChartModel torta;
    @EJB*/
    Tipodeproducto TipPro = new Tipodeproducto();
    @EJB
    TipodeproductoFacadeLocal TipProfl;

    public Tipodeproducto getTipPro() {
        return TipPro;
    }

    public void setTipPro(Tipodeproducto TipPro) {
        this.TipPro = TipPro;
    }

    public TipodeproductoFacadeLocal getTipProfl() {
        return TipProfl;
    }

    public void setTipProfl(TipodeproductoFacadeLocal TipProfl) {
        this.TipProfl = TipProfl;
    }

    /**
     * Creates a new instance of ControllerTipPro
     */
    public ControllerTipPro() {
    }

    /*public PieChartModel getTorta() {
        return torta;
    }

    public void setTorta(PieChartModel torta) {
        this.torta = torta;
    }*/

    /*public void graficar() {
        torta = new PieChartModel();
        try {
            for (TipPro tipro : this.TipProfl.obtenerDatos()) {
                torta.set(tipro.getNombreTipPro(), tipro.getSumatori());
            }
            torta.setTitle("Valor nomina mensual");
            torta.setLegendPosition("e");
            torta.setFill(true);
            torta.setShowDataLabels(true);
            torta.setDiameter(400);
        } catch (Exception e) {
        }
    }*/

    public List<Tipodeproducto> listar() {
        try {
            return this.TipProfl.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public void insertar() {
        try {
            this.TipProfl.create(TipPro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se inserto registro correctamente", "MSG_INFO"));
            TipPro = new Tipodeproducto();
        } catch (Exception e) {

        }
    }

    public void eliminar(Tipodeproducto TipPro) {
        try {
            this.TipProfl.remove(TipPro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }

    public void editar(Tipodeproducto tipodeproducto) {
        try {
            this.TipPro = tipodeproducto;
            //this.TipProfl.edit(tipodeproducto);
            FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarTipPro.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerTipPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar() {
        try {
            this.TipProfl.edit(TipPro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }
}
