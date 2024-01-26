/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.entities.Compras;
import com.mycompany.proyectofinal1.entities.Productos;
import com.mycompany.proyectofinal1.entities.Proveedores;
import com.mycompany.proyectofinal1.entities.Trabajadores;
import com.mycompany.proyectofinal1.entities.Ventasacan;
import com.mycompany.proyectofinal1.model.ComprasFacadeLocal;
import com.mycompany.proyectofinal1.model.ProductosFacadeLocal;
import com.mycompany.proyectofinal1.model.ProveedoresFacadeLocal;
import com.mycompany.proyectofinal1.model.TrabajadoresFacadeLocal;
import com.mycompany.proyectofinal1.model.VentasacanFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Named(value = "controllerCompra")
@SessionScoped
public class ControllerCompra implements Serializable {

    Compras com = new Compras();
    @EJB
    ComprasFacadeLocal cfl;
    Productos prod = new Productos();
    @EJB
    ProductosFacadeLocal prodfl;
    Proveedores prov = new Proveedores();
    @EJB
    ProveedoresFacadeLocal provfl;
    Trabajadores tra = new Trabajadores();
    @EJB
    TrabajadoresFacadeLocal trafl;
    Ventasacan vencan = new Ventasacan();
    @EJB
    VentasacanFacadeLocal vencanfl;
    List<SelectItem> listaproductos;
    List<SelectItem> listaproveedores;
    List<SelectItem> listatrabajadores;
    List<SelectItem> listaventasacan;

    public ControllerCompra() {
    }

    public Compras getCom() {
        return com;
    }

    public void setCom(Compras com) {
        this.com = com;
    }

    public ComprasFacadeLocal getCfl() {
        return cfl;
    }

    public void setCfl(ComprasFacadeLocal cfl) {
        this.cfl = cfl;
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

    public Proveedores getProv() {
        return prov;
    }

    public void setProv(Proveedores prov) {
        this.prov = prov;
    }

    public ProveedoresFacadeLocal getProvfl() {
        return provfl;
    }

    public void setProvfl(ProveedoresFacadeLocal provfl) {
        this.provfl = provfl;
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

    public Ventasacan getVencan() {
        return vencan;
    }

    public void setVencan(Ventasacan vencan) {
        this.vencan = vencan;
    }

    public VentasacanFacadeLocal getVencanfl() {
        return vencanfl;
    }

    public void setVencanfl(VentasacanFacadeLocal vencanfl) {
        this.vencanfl = vencanfl;
    }

    public List<SelectItem> getListaproductos() {
        this.listaproductos = new ArrayList<>();
        try {
            for (Productos prod : this.prodfl.findAll()) {
                SelectItem item = new SelectItem(prod.getProId(),prod.getProDes());
                this.listaproductos.add(item);
            }
        } catch (Exception e) {
        }
        return listaproductos;
    }

    public void setListaproductos(List<SelectItem> listaproductos) {
        this.listaproductos = listaproductos;
    }

    public List<SelectItem> getListaproveedores() {
        this.listaproveedores = new ArrayList<>();
        try {
            for (Proveedores prov : this.provfl.findAll()) {
                SelectItem item = new SelectItem(prov.getPrId(), prov.getPrNomPr());
                this.listaproveedores.add(item);
            }
        } catch (Exception e) {
        }
        return listaproveedores;
    }

    public void setListaproveedores(List<SelectItem> listaproveedores) {
        this.listaproveedores = listaproveedores;
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

    public List<SelectItem> getListaventasacan() {
        this.listaventasacan = new ArrayList<>();
        try {
            for (Ventasacan vencan : this.vencanfl.findAll()) {
                SelectItem item = new SelectItem(vencan.getVeAnId(), vencan.getVeAnTip());
                this.listaventasacan.add(item);
            }
        } catch (Exception e) {
        }
        return listaventasacan;
    }

    public void setListaventasacan(List<SelectItem> listaventasacan) {
        this.listaventasacan = listaventasacan;
    }

    public List<Compras> listar() {
        try {
            return this.cfl.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public void eliminar(Compras compras) {
        try {
            this.cfl.remove(compras);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }
    public void crearCompra() {
        try {
            this.com.setComPrId(prod);
            this.com.setComPvId(prov);
            this.com.setComTraId(tra);
            this.com.setComEs(vencan);
            this.cfl.create(com);
            com = new Compras();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se registro correctamente", "MSG_ERROR"));
        }
    }
        public void editarCompras(Compras compras) {
        try {
            this.com = compras;
            this.prod.setProId(com.getComPrId().getProId());
            this.prov.setPrId(com.getComPvId().getPrId());
            this.tra.setTraId(com.getComTraId().getTraId());
            this.vencan.setVeAnId(com.getComEs().getVeAnId());
            //this.TipProfl.edit(tipodeproducto);
            FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarCompra.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizar(){
        try{
            this.com.setComPrId(prod);
            this.com.setComPvId(prov);
            this.com.setComTraId(tra);
            this.com.setComEs(vencan);
            this.cfl.edit(com);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        }catch(Exception e){
            
        }
    }
}
