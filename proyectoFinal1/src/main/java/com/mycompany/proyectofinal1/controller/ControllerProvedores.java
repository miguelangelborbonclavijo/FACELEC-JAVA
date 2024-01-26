/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.entities.Proveedores;
import com.mycompany.proyectofinal1.model.ProveedoresFacadeLocal;
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

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Named(value = "controllerProvedores")
@SessionScoped
public class ControllerProvedores implements Serializable {

    Proveedores pro = new Proveedores();
    @EJB
    ProveedoresFacadeLocal profl;

    /**
     * Creates a new instance of ControllerProvedores
     */
    public ControllerProvedores() {
    }

    public Proveedores getPro() {
        return pro;
    }

    public void setPro(Proveedores pro) {
        this.pro = pro;
    }

    public ProveedoresFacadeLocal getProfl() {
        return profl;
    }

    public void setProfl(ProveedoresFacadeLocal profl) {
        this.profl = profl;
    }

    public List<Proveedores> listar() {
        try {
            return this.profl.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public void insertar() {
        try {
            this.profl.create(pro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se inserto registro correctamente", "MSG_INFO"));
            pro = new Proveedores();
        } catch (Exception e) {

        }
    }

    public void eliminar(Proveedores proveedores) {
        try {
            this.profl.remove(proveedores);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }
        public void editarProducto(Proveedores proveedores) {
        try {
            this.pro = proveedores;
            //this.TipProfl.edit(tipodeproducto);
            FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarProvedores.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizar(){
        try{
            this.profl.edit(pro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        }catch(Exception e){
            
        }
    }
}
