/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.entities.Productos;
import com.mycompany.proyectofinal1.entities.Tipodeproducto;
import com.mycompany.proyectofinal1.model.ProductosFacadeLocal;
import com.mycompany.proyectofinal1.model.TipodeproductoFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
//import org.primefaces.model.chart.PieChartModel;


/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Named(value = "controllerProducto")
@ViewScoped
public class ControllerProducto implements Serializable {
    
    /*PieChartModel torta;
    @EJB*/
    Productos prod = new Productos();
    @EJB
    ProductosFacadeLocal prodfl;
    Tipodeproducto TipPro = new Tipodeproducto();
    @EJB
    TipodeproductoFacadeLocal TipProfl;

    List<SelectItem> listatipoproducto;

    /**
     * Creates a new instance of ControllerProducto
     */
    public ControllerProducto() {
    }

    public Productos getProd() {
        return prod;
    }

    public void setProd(Productos prod) {
        this.prod = prod;
    }

    public ProductosFacadeLocal getProdfl() {
        return prodfl;
    }

    public void setProdfl(ProductosFacadeLocal prodfl) {
        this.prodfl = prodfl;
    }

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

    public void setListatipoproducto(List<SelectItem> listatipoproducto) {
        this.listatipoproducto = listatipoproducto;
    }

    public List<SelectItem> getListatipoproducto() {
        this.listatipoproducto = new ArrayList<>();
        try {
            for (Tipodeproducto TipPro : this.TipProfl.findAll()) {
                SelectItem item = new SelectItem(TipPro.getTipId(), TipPro.getTipNom());
                this.listatipoproducto.add(item);
            }
        } catch (Exception e) {
        }
        return listatipoproducto;
    }

    public void setListatipoproductos(List<SelectItem> listaproductos) {
        this.listatipoproducto = listaproductos;
    }

    public void crearTipPro() {
        try {
            this.prod.setProTip(TipPro);
            this.prodfl.create(prod);
            prod = new Productos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se registro correctamente", "MSG_ERROR"));
        }
    }

    public void eliminar(Productos productos) {
        try {
            this.prodfl.remove(productos);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }

    public List<Productos> listar() {
        try {
            return this.prodfl.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public void editarProducto(Productos productos) {
        try {
            this.prod = productos;
            this.TipPro.setTipId(prod.getProTip().getTipId());
            //this.TipProfl.edit(tipodeproducto);
            FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarProducto.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar() {
        try {
            this.prod.setProTip(TipPro);
            this.prodfl.edit(prod);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }

}
