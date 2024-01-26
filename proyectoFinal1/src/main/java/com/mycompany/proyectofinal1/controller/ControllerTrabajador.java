/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.entities.Cartrab;
import com.mycompany.proyectofinal1.entities.Personas;
import com.mycompany.proyectofinal1.entities.Trabajadores;
import com.mycompany.proyectofinal1.model.CartrabFacadeLocal;
import com.mycompany.proyectofinal1.model.PersonasFacadeLocal;
import com.mycompany.proyectofinal1.model.TrabajadoresFacadeLocal;
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
@Named(value = "controllerTrabajador")
@SessionScoped
public class ControllerTrabajador implements Serializable {

    Trabajadores tra = new Trabajadores();
    @EJB
    TrabajadoresFacadeLocal trafl;
    Personas per = new Personas();
    @EJB
    PersonasFacadeLocal perfl;
    Cartrab cartra = new Cartrab();
    @EJB
    CartrabFacadeLocal cartrabfl;
    List<SelectItem> listapersonas;
    List<SelectItem> listacartrab;

    /**
     * Creates a new instance of ControllerTrabajador
     */
    public ControllerTrabajador() {
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

    public List<Trabajadores> listar() {
        try {
            return this.trafl.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public Personas getPer() {
        return per;
    }

    public void setPer(Personas per) {
        this.per = per;
    }

    public PersonasFacadeLocal getPerfl() {
        return perfl;
    }

    public void setPerfl(PersonasFacadeLocal perfl) {
        this.perfl = perfl;
    }

    public List<SelectItem> getListapersonas() {
        this.listapersonas = new ArrayList<>();
        try {
            for (Personas per : this.perfl.findAll()) {
                SelectItem item = new SelectItem(per.getPerId());
                this.listapersonas.add(item);
            }
        } catch (Exception e) {
        }
        return listapersonas;
    }

    public void setListapersonas(List<SelectItem> listapersonas) {
        this.listapersonas = listapersonas;
    }

    public Cartrab getCartra() {
        return cartra;
    }

    public void setCartra(Cartrab cartra) {
        this.cartra = cartra;
    }

    public CartrabFacadeLocal getCartrabfl() {
        return cartrabfl;
    }

    public void setCartrabfl(CartrabFacadeLocal cartrabfl) {
        this.cartrabfl = cartrabfl;
    }

    public List<SelectItem> getListacartrab() {
        this.listacartrab = new ArrayList<>();
        try {
            for (Cartrab cartrab : this.cartrabfl.findAll()) {
                SelectItem item = new SelectItem(cartrab.getCarTraId(),cartrab.getTipCarTr());
                this.listacartrab.add(item);
            }
        } catch (Exception e) {
        }
        return listacartrab;
    }

    public void setListacartrab(List<SelectItem> listacartrab) {
        this.listacartrab = listacartrab;
    }

    public void eliminar(Trabajadores trabajadores) {
        try {
            this.trafl.remove(trabajadores);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }

    public void crearTrabajadores() {
        try {
            this.tra.setTraPerId(per);
            this.tra.setTraCarId(cartra);
            this.trafl.create(tra);
            tra = new Trabajadores();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se registro correctamente", "MSG_ERROR"));
        }
    }

    public void editarPersonas(Trabajadores trabajadores) {
        try {
            this.tra = trabajadores;
            this.per.setPerId(tra.getTraPerId().getPerId());
            this.cartra.setCarTraId(tra.getTraCarId().getCarTraId());
            //this.TipProfl.edit(tipodeproducto);
            FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarTrabajadores.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerTipPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar() {
        try {
            this.tra.setTraPerId(per);
            this.tra.setTraCarId(cartra);
            this.trafl.edit(tra);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }
}
