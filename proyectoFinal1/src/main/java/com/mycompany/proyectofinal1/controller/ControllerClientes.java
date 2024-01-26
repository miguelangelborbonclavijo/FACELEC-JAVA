package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.entities.Clientes;
import com.mycompany.proyectofinal1.entities.Clientesestado;
import com.mycompany.proyectofinal1.entities.Tipodeclientes;
import com.mycompany.proyectofinal1.model.ClientesFacadeLocal;
import com.mycompany.proyectofinal1.model.ClientesestadoFacadeLocal;
import com.mycompany.proyectofinal1.model.TipodeclientesFacadeLocal;
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
@Named(value = "controllerClientes")
@SessionScoped
public class ControllerClientes implements Serializable {

    Clientes cli = new Clientes();
    @EJB
    ClientesFacadeLocal clifl;
    Clientesestado cliest = new Clientesestado();
    @EJB
    ClientesestadoFacadeLocal cliestfl;
    Tipodeclientes TipCli = new Tipodeclientes();
    @EJB
    TipodeclientesFacadeLocal tipclifl;
    List<SelectItem> listaclientesestado;
    List<SelectItem> listatipoclientes;

   

    /**
     * Creates a new instance of ControllerClientes
     */
    public ControllerClientes() {
    }
    
    public Clientes getCli() {
        return cli;
    }

    public void setCli(Clientes cli) {
        this.cli = cli;
    }

    public ClientesFacadeLocal getClilf() {
        return clifl;
    }

    public void setClilf(ClientesFacadeLocal clilf) {
        this.clifl = clilf;
    }

    /**
     *
     * @return
     */
    public List<Clientes> listar() {
        try {
            return this.clifl.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    
    
    public void eliminar(Clientes clientes) {
        try {
            this.clifl.remove(clientes);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }

    public ClientesFacadeLocal getClifl() {
        return clifl;
    }

    public void setClifl(ClientesFacadeLocal clifl) {
        this.clifl = clifl;
    }

    public Clientesestado getCliest() {
        return cliest;
    }

    public void setCliest(Clientesestado cliest) {
        this.cliest = cliest;
    }

    public ClientesestadoFacadeLocal getCliestfl() {
        return cliestfl;
    }

    public void setCliestfl(ClientesestadoFacadeLocal cliestfl) {
        this.cliestfl = cliestfl;
    }

    public Tipodeclientes getTipCli() {
        return TipCli;
    }

    public void setTipCli(Tipodeclientes TipCli) {
        this.TipCli = TipCli;
    }

    public TipodeclientesFacadeLocal getTipclifl() {
        return tipclifl;
    }

    public void setTipclifl(TipodeclientesFacadeLocal tipclifl) {
        this.tipclifl = tipclifl;
    }

    public List<SelectItem> getListaclientesestado() {
        this.listaclientesestado = new ArrayList<>();
        try {
            for (Clientesestado cliest : this.cliestfl.findAll()) {
                SelectItem item = new SelectItem(cliest.getCliEsId(),cliest.getCliTipEs());
                this.listaclientesestado.add(item);
            }
        } catch (Exception e) {
        }
        return listaclientesestado;
    }

    public void setListaclientesestado(List<SelectItem> listaclientesestado) {
        this.listaclientesestado = listaclientesestado;
    }


    public List<SelectItem> getListatipoclientes() {
        this.listatipoclientes = new ArrayList<>();
        try {
            for (Tipodeclientes TipCli : this.tipclifl.findAll()) {
                SelectItem item = new SelectItem(TipCli.getTipCliId(),TipCli.getTipCli());
                this.listatipoclientes.add(item);
            }
        } catch (Exception e) {
        }
        return listatipoclientes;
    }

    public void setListatipoclientes(List<SelectItem> listatipoclientes) {
        this.listatipoclientes = listatipoclientes;
    }
    public void crearClientes() {
        try {
            this.cli.setCilTipId(TipCli);
            this.cli.setCliEsId(cliest);
            this.clifl.create(cli);
            cli = new Clientes();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se registro correctamente", "MSG_ERROR"));
        }
    }
        public void editarPersonas(Clientes clientes) {
        try {
            this.cli = clientes;
            this.TipCli.setTipCliId(cli.getCilTipId().getTipCliId());
            this.cliest.setCliEsId(cli.getCliEsId().getCliEsId());
            //this.TipProfl.edit(tipodeproducto);
            FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarClientes.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerTipPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizar(){
        try{
            this.clifl.edit(cli);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        }catch(Exception e){
            
        }
    }
}
