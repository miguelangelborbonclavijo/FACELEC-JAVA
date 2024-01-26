/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.entities.Personas;
import com.mycompany.proyectofinal1.entities.Tipodedocumento;
import com.mycompany.proyectofinal1.entities.Tipodeusuario;
import com.mycompany.proyectofinal1.model.PersonasFacadeLocal;
import com.mycompany.proyectofinal1.model.TipodedocumentoFacadeLocal;
import com.mycompany.proyectofinal1.model.TipodeusuarioFacadeLocal;
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
@Named(value = "controllerPersonas")
@SessionScoped
public class ControllerPersonas implements Serializable {

    Personas per = new Personas();
    @EJB
    PersonasFacadeLocal pfl;
    Tipodedocumento TipDoc = new Tipodedocumento();
    @EJB
    TipodedocumentoFacadeLocal tipdocfl;
    Tipodeusuario TipUsu = new Tipodeusuario();
    @EJB
    TipodeusuarioFacadeLocal TipUsfl;
    List<SelectItem> listatipodedocumento;
    List<SelectItem> listatipodeusuario;

    public ControllerPersonas() {
    }

    public Personas getPer() {
        return per;
    }

    public void setPer(Personas per) {
        this.per = per;
    }

    public PersonasFacadeLocal getPfl() {
        return pfl;
    }

    public void setPfl(PersonasFacadeLocal pfl) {
        this.pfl = pfl;
    }

    public Tipodedocumento getTipDoc() {
        return TipDoc;
    }

    public void setTipDoc(Tipodedocumento TipDoc) {
        this.TipDoc = TipDoc;
    }

    public TipodedocumentoFacadeLocal getTipdocfl() {
        return tipdocfl;
    }

    public void setTipdocfl(TipodedocumentoFacadeLocal tipdocfl) {
        this.tipdocfl = tipdocfl;
    }

    public Tipodeusuario getTipUsu() {
        return TipUsu;
    }

    public void setTipUsu(Tipodeusuario TipUsu) {
        this.TipUsu = TipUsu;
    }

    public TipodeusuarioFacadeLocal getTipUsfl() {
        return TipUsfl;
    }

    public void setTipUsfl(TipodeusuarioFacadeLocal TipUsfl) {
        this.TipUsfl = TipUsfl;
    }

    public List<SelectItem> getListatipodedocumento() {
        this.listatipodedocumento = new ArrayList<>();
        try {
            for (Tipodedocumento TipDoc : this.tipdocfl.findAll()) {
                SelectItem item = new SelectItem(TipDoc.getTipDocId(), TipDoc.getTipDoc());
                this.listatipodedocumento.add(item);
            }
        } catch (Exception e) {
        }
        return listatipodedocumento;
    }

    public void setListatipodedocumento(List<SelectItem> listatipodedocumento) {
        this.listatipodedocumento = listatipodedocumento;
    }

    public List<SelectItem> getListatipodeusuario() {
        this.listatipodeusuario = new ArrayList<>();
        try {
            for (Tipodeusuario TipUsu : this.TipUsfl.findAll()) {
                SelectItem item = new SelectItem(TipUsu.getTipId(), TipUsu.getTipUsu());
                this.listatipodeusuario.add(item);
            }
        } catch (Exception e) {
        }
        return listatipodeusuario;
    }

    public void setListatipodeusuario(List<SelectItem> listatipodeusuario) {
        this.listatipodeusuario = listatipodeusuario;
    }

    public void crearPersonas() {
        try {
            this.per.setPerTidId(TipDoc);
            this.per.setPerTipUs(TipUsu);
            this.pfl.create(per);
            per = new Personas();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se registro correctamente", "MSG_ERROR"));
        }
    }

    public List<Personas> listar() {
        try {
            return this.pfl.findAll();
        } catch (Exception e) {
            return null;
        }
    }
    
    public void editarPersonas(Personas personas) {
        try {
            this.per = personas;
            this.TipDoc.setTipDocId(per.getPerTidId().getTipDocId());
            this.TipUsu.setTipId(per.getPerTipUs().getTipId());
     
            //this.TipProfl.edit(tipodeproducto);
            FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarPersonas.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizar(){
        try{
            this.per.setPerTipUs(TipUsu);
            this.per.setPerTidId(TipDoc);
            this.pfl.edit(per);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        }catch(Exception e){
            
        }
    }
        public void eliminar(Personas personas) {
        try {
            this.pfl.remove(personas);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }
}
