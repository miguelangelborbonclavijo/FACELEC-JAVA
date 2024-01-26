/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.entities.Clientes;
import com.mycompany.proyectofinal1.entities.Codven;
import com.mycompany.proyectofinal1.entities.Productos;
import com.mycompany.proyectofinal1.entities.Trabajadores;
import com.mycompany.proyectofinal1.entities.Ventas;
import com.mycompany.proyectofinal1.entities.Ventasacan;
import com.mycompany.proyectofinal1.model.ClientesFacadeLocal;
import com.mycompany.proyectofinal1.model.CodvenFacadeLocal;
import com.mycompany.proyectofinal1.model.ProductosFacadeLocal;
import com.mycompany.proyectofinal1.model.TrabajadoresFacadeLocal;
import com.mycompany.proyectofinal1.model.VentasFacadeLocal;
import com.mycompany.proyectofinal1.model.VentasacanFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
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
@Named(value = "controllerVentas")
@SessionScoped
public class ControllerVentas implements Serializable {

    Ventas ven = new Ventas();
    @EJB
    VentasFacadeLocal vfl;
    Trabajadores tra = new Trabajadores();
    @EJB
    TrabajadoresFacadeLocal trafl;
    Clientes cli = new Clientes();
    @EJB
    ClientesFacadeLocal clifl;
    Ventasacan venact = new Ventasacan();
    @EJB
    VentasacanFacadeLocal venactfl;
    Codven codven = new Codven();
    @EJB
    CodvenFacadeLocal codvenfl;
    Productos pro = new Productos();
    @EJB
    ProductosFacadeLocal profl;
    List<SelectItem> listatrabajadores;
    List<SelectItem> listaclientes;
    List<SelectItem> listaventasacan;
    List<SelectItem> listacodven;
    List<SelectItem> listaproductos;

    /**
     * Creates a new instance of ControllerVentas
     */
    public ControllerVentas() {
    }

    public Ventas getVen() {
        return ven;
    }

    public void setVen(Ventas ven) {
        this.ven = ven;
    }

    public VentasFacadeLocal getVfl() {
        return vfl;
    }

    public void setVfl(VentasFacadeLocal vfl) {
        this.vfl = vfl;
    }

    public List<Ventas> listar() {
        try {
            return this.vfl.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public void eliminar(Ventas ventas) {
        try {
            this.vfl.remove(ventas);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }

    public Trabajadores getTra() {
        return tra;
    }

    public void setTra(Trabajadores tra) {
        this.tra = tra;
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

    public Ventasacan getVenact() {
        return venact;
    }

    public void setVenact(Ventasacan venact) {
        this.venact = venact;
    }

    public VentasacanFacadeLocal getVenactfl() {
        return venactfl;
    }

    public void setVenactfl(VentasacanFacadeLocal venactfl) {
        this.venactfl = venactfl;
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

    public Productos getPro() {
        return pro;
    }

    public void setPro(Productos pro) {
        this.pro = pro;
    }

    public ProductosFacadeLocal getProfl() {
        return profl;
    }

    public void setProfl(ProductosFacadeLocal profl) {
        this.profl = profl;
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

    public List<SelectItem> getListaventasacan() {
        this.listaventasacan = new ArrayList<>();
        try {
            for (Ventasacan venact : this.venactfl.findAll()) {
                SelectItem item = new SelectItem(venact.getVeAnId(), venact.getVeAnTip());
                this.listaventasacan.add(item);
            }
        } catch (Exception e) {
        }
        return listaventasacan;
    }

    public void setListaventasacan(List<SelectItem> listaventasacan) {
        this.listaventasacan = listaventasacan;
    }

    public List<SelectItem> getListacodven() {
        this.listacodven = new ArrayList<>();
        try {
            for (Codven codven : this.codvenfl.findAll()) {
                SelectItem item = new SelectItem(codven.getCodVenId());
                this.listacodven.add(item);
            }
        } catch (Exception e) {
        }
        return listacodven;
    }

    public void setListacodven(List<SelectItem> listacodven) {
        this.listacodven = listacodven;
    }

    public List<SelectItem> getListaproductos() {
        this.listaproductos = new ArrayList<>();
        try {
            for (Productos pro : this.profl.findAll()) {
                SelectItem item = new SelectItem(pro.getProId(), pro.getProDes());
                this.listaproductos.add(item);
            }
        } catch (Exception e) {
        }
        return listaproductos;
    }

    public void setListaproductos(List<SelectItem> listaproductos) {
        this.listaproductos = listaproductos;
    }

    public void crearCodVen() {
        try {
            this.ven.setVenTraId(tra);
            this.ven.setVenCliId(cli);
            this.ven.setVenAcId(venact);
            this.ven.setVenCodId(codven);
            this.ven.setVenProId(pro);
            this.vfl.create(ven);
            ven = new Ventas();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se registro correctamente", "MSG_ERROR"));
        }
    }

    public void editarVentas(Ventas ventas) {
        try {
            this.ven = ventas;
            this.tra.setTraId(ven.getVenTraId().getTraId());
            this.cli.setCliPerId(ven.getVenCliId().getCliPerId());
            this.venact.setVeAnId(ven.getVenAcId().getVeAnId());
            this.pro.setProId(ven.getVenProId().getProId());
            //this.TipProfl.edit(tipodeproducto);
            FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarVentas.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerTipPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void actualizar() {
        try {
            this.ven.setVenTraId(tra);
            this.ven.setVenCliId(cli);
            this.ven.setVenAcId(venact);
            this.ven.setVenProId(pro);
            this.vfl.edit(ven);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }
}
