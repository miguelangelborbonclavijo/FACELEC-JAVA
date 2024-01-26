/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.entities.Clientes;
import com.mycompany.proyectofinal1.entities.Codven;
import com.mycompany.proyectofinal1.entities.Trabajadores;
import com.mycompany.proyectofinal1.model.ClientesFacadeLocal;
import com.mycompany.proyectofinal1.model.CodvenFacadeLocal;
import com.mycompany.proyectofinal1.model.TrabajadoresFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Named(value = "controllerCodVen")
@SessionScoped
public class ControllerCodVen implements Serializable {

    Codven codven = new Codven();
    @EJB
    CodvenFacadeLocal codvenfl;
    Trabajadores Tra = new Trabajadores();
    @EJB
    TrabajadoresFacadeLocal trafl;
    Clientes cli = new Clientes();
    @EJB
    ClientesFacadeLocal clifl;
    List<SelectItem> listatrabajadores;
    List<SelectItem> listaclientes;
    

    /**
     * Creates a new instance of ControllerCodVen
     */
    public ControllerCodVen() {
    }

    public Codven getCodven() {
        return codven;
    }

    public void setCodven(Codven codven) {
        this.codven = codven;
    }

    public CodvenFacadeLocal getCodvenfl() {
        return codvenfl;
    }

    public void setCodvenfl(CodvenFacadeLocal codvenfl) {
        this.codvenfl = codvenfl;
    }

    public List<Codven> getConVen() {
        try {
            return this.codvenfl.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public void eliminar(Codven codven) {
        try {
            this.codvenfl.remove(codven);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }

    public Trabajadores getTra() {
        return Tra;
    }

    public void setTra(Trabajadores Tra) {
        this.Tra = Tra;
    }

    public TrabajadoresFacadeLocal getTrafl() {
        return trafl;
    }

    public void setTrafl(TrabajadoresFacadeLocal trafl) {
        this.trafl = trafl;
    }

    public Clientes getCli() {
        return cli;
    }

    public void setCli(Clientes cli) {
        this.cli = cli;
    }

    public ClientesFacadeLocal getClifl() {
        return clifl;
    }

    public void setClifl(ClientesFacadeLocal clifl) {
        this.clifl = clifl;
    }

    public List<SelectItem> getListatrabajadores() {
        this.listatrabajadores = new ArrayList<>();
        
        try {
            for (Trabajadores tra : this.trafl.findAll()) {
                SelectItem item = new SelectItem(tra.getTraId());
                this.listatrabajadores.add(item);
            }
        } catch (Exception e) {
        }
        return listatrabajadores;
    }

    public void setListatrabajadores(List<SelectItem> listatrabajadores) {
        this.listatrabajadores = listatrabajadores;
    }

    public List<SelectItem> getListaclientes() {
        this.listaclientes = new ArrayList<>();
        try {
            for (Clientes cli : this.clifl.findAll()) {
                SelectItem item = new SelectItem(cli.getCliPerId());
                this.listaclientes.add(item);
            }
        } catch (Exception e) {
        }
        return listaclientes;
    }

    public void setListaclientes(List<SelectItem> listaclientes) {
        this.listaclientes = listaclientes;
    }

    public void crearCodVen() {
        try {
            this.codven.setCodTraId(Tra);
            this.codven.setCodVenCl(cli);
            this.codvenfl.create(codven);
            codven = new Codven();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se registro correctamente", "MSG_ERROR"));
        }
    }

    public void editarCodVen(Codven codven) {
        try {
            this.codven = codven;
            this.Tra.setTraId(codven.getCodTraId().getTraId());
            this.cli.setCliPerId(codven.getCodVenCl().getCliPerId());
            //this.TipProfl.edit(tipodeproducto);
            FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarCodVen.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerCodVen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar() {
        try {
            this.codven.setCodTraId(Tra);
            this.codven.setCodVenCl(cli);
            this.codvenfl.edit(codven);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }

}
