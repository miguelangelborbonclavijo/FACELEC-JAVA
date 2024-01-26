/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.entities.Productos;
import com.mycompany.proyectofinal1.entities.Reporteproductos;
import com.mycompany.proyectofinal1.model.ProductosFacadeLocal;
import com.mycompany.proyectofinal1.model.ReporteproductosFacadeLocal;
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
@Named(value = "controllerRepProd")
@SessionScoped
public class ControllerRepProd implements Serializable {

    Reporteproductos repPro = new Reporteproductos();
    @EJB
    ReporteproductosFacadeLocal repProfl;
    Productos pro = new Productos();
    @EJB
    ProductosFacadeLocal profl;
    List<SelectItem> listaproductos;

    /**
     * Creates a new instance of ControllerRepProd
     */
    public ControllerRepProd() {
    }

    public Reporteproductos getRepPro() {
        return repPro;
    }

    public void setRepPro(Reporteproductos repPro) {
        this.repPro = repPro;
    }

    public ReporteproductosFacadeLocal getRepProfl() {
        return repProfl;
    }

    public void setRepProfl(ReporteproductosFacadeLocal repProfl) {
        this.repProfl = repProfl;
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

    public void crearRepPro() {
        try {
            this.repPro.setReProId(pro);
            this.repProfl.create(repPro);
            repPro = new Reporteproductos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se registro correctamente", "MSG_ERROR"));
        }
    }

    public void eliminar(Reporteproductos reporteproductos) {
        try {
            this.repProfl.remove(reporteproductos);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }
        public List<Reporteproductos> listar() {
        try {
            return this.repProfl.findAll();
        } catch (Exception e) {
            return null;
        }
    }
    public void editarRepPro(Reporteproductos reporteproductos) {
        try {
            this.repPro = reporteproductos;
            this.pro.setProId(repPro.getReProId().getProId());
            //this.TipProfl.edit(tipodeproducto);
            FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarRepPro.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizar(){
        try{
            this.repPro.setReProId(pro);
            this.repProfl.edit(repPro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        }catch(Exception e){
            
        }
    }
}
