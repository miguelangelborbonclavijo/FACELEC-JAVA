/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.entities.Clientes;
import com.mycompany.proyectofinal1.entities.Estados;
import com.mycompany.proyectofinal1.entities.Soporte;
import com.mycompany.proyectofinal1.entities.Tipodesoporte;
import com.mycompany.proyectofinal1.entities.Tipodeusuario;
import com.mycompany.proyectofinal1.model.ClientesFacadeLocal;
import com.mycompany.proyectofinal1.model.EstadosFacadeLocal;
import com.mycompany.proyectofinal1.model.SoporteFacadeLocal;
import com.mycompany.proyectofinal1.model.TipodesoporteFacadeLocal;
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
@Named(value = "controllerSoporte")
@SessionScoped
public class ControllerSoporte implements Serializable {

    Soporte sop = new Soporte();
    @EJB
    SoporteFacadeLocal sopfl;
    Tipodesoporte TipSop = new Tipodesoporte();
    @EJB
    TipodesoporteFacadeLocal TipSopfl;
    Tipodeusuario TipUsu = new Tipodeusuario();
    @EJB
    TipodeusuarioFacadeLocal TipUsufl;
    Clientes cli = new Clientes();
    @EJB
    ClientesFacadeLocal clifl;
    Estados EstSop = new Estados();
    @EJB
    EstadosFacadeLocal EstSopfl;
    List<SelectItem> listatiposoporte;
    List<SelectItem> listatipousuario;
    List<SelectItem> listaclientes;
    List<SelectItem> listaestados;

    /**
     * Creates a new instance of ControllerSoporte
     */
    public ControllerSoporte() {
    }

    public Soporte getSop() {
        return sop;
    }

    public void setSop(Soporte sop) {
        this.sop = sop;
    }

    public SoporteFacadeLocal getSopfl() {
        return sopfl;
    }

    public void setSopfl(SoporteFacadeLocal sopfl) {
        this.sopfl = sopfl;
    }

    public List<Soporte> listar() {
        try {
            return this.sopfl.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public void insertar() {
        try {
            this.sopfl.create(sop);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se inserto registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }

    public void eliminar(Soporte soporte) {
        try {
            this.sopfl.remove(soporte);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }

    public Tipodesoporte getTipSop() {
        return TipSop;
    }

    public void setTipSop(Tipodesoporte TipSop) {
        this.TipSop = TipSop;
    }

    public TipodesoporteFacadeLocal getTipSopfl() {
        return TipSopfl;
    }

    public void setTipSopfl(TipodesoporteFacadeLocal TipSopfl) {
        this.TipSopfl = TipSopfl;
    }

    public Tipodeusuario getTipUsu() {
        return TipUsu;
    }

    public void setTipUsu(Tipodeusuario TipUsu) {
        this.TipUsu = TipUsu;
    }

    public TipodeusuarioFacadeLocal getTipUsufl() {
        return TipUsufl;
    }

    public void setTipUsufl(TipodeusuarioFacadeLocal TipUsufl) {
        this.TipUsufl = TipUsufl;
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

    public Estados getEstSop() {
        return EstSop;
    }

    public void setEstSop(Estados EstSop) {
        this.EstSop = EstSop;
    }

    public EstadosFacadeLocal getEstSopfl() {
        return EstSopfl;
    }

    public void setEstSopfl(EstadosFacadeLocal EstSopfl) {
        this.EstSopfl = EstSopfl;
    }

    public List<SelectItem> getListatiposoporte() {
        this.listatiposoporte= new ArrayList<>();
        try {
            for (Tipodesoporte TipSop : this.TipSopfl.findAll()) {
                SelectItem item = new SelectItem(TipSop.getTisId(),TipSop.getTisSopr());
                this.listatiposoporte.add(item);
            }
        } catch (Exception e) {
        }
        return listatiposoporte;
    }

    public void setListatiposoporte(List<SelectItem> listatiposoporte) {
        this.listatiposoporte = listatiposoporte;
    }

    public List<SelectItem> getListatipousuario() {
        this.listatipousuario= new ArrayList<>();
        try {
            for (Tipodeusuario TipUsu : this.TipUsufl.findAll()) {
                SelectItem item = new SelectItem(TipUsu.getTipId(),TipUsu.getTipUsu());
                this.listatipousuario.add(item);
            }
        } catch (Exception e) {
        }
        return listatipousuario;
    }

    public void setListatipousuario(List<SelectItem> listatipousuario) {
        this.listatipousuario = listatipousuario;
    }

    public List<SelectItem> getListaclientes() {
        this.listaclientes= new ArrayList<>();
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

    public List<SelectItem> getListaestados() {
        this.listaestados= new ArrayList<>();
        try {
            for (Estados EstSop : this.EstSopfl.findAll()) {
                SelectItem item = new SelectItem(EstSop.getEstId(),EstSop.getEstNom());
                this.listaestados.add(item);
            }
        } catch (Exception e) {
        }
        return listaestados;
    }

    public void setListaestados(List<SelectItem> listaestados) {
        this.listaestados = listaestados;
    }
    public void crearSoporte() {
        try {
            this.sop.setSopTiS(TipSop);
            this.sop.setSopTiCl(TipUsu);
            this.sop.setSopDoCl(cli);
            this.sop.setSopEstId(EstSop);
            this.sopfl.create(sop);
            sop = new Soporte();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se registro correctamente", "MSG_ERROR"));
        }
    }
        public void editarSoporte(Soporte soporte) {
        try {
            this.sop = soporte;
            this.TipSop.setTisId(sop.getSopTiS().getTisId());
            this.TipUsu.setTipId(sop.getSopTiCl().getTipId());
            this.cli.setCliPerId(sop.getSopDoCl().getCliPerId());
            this.EstSop.setEstId(sop.getSopEstId().getEstId());
            //this.TipProfl.edit(tipodeproducto);
            FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarSoporte.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerSoporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizar(){
        try{
            this.sop.setSopTiS(TipSop);
            this.sop.setSopTiCl(TipUsu);
            this.sop.setSopDoCl(cli);
            this.sop.setSopEstId(EstSop);
            this.sopfl.edit(sop);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        }catch(Exception e){
            
        }
    }
}
