package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.entities.Personas;
import com.mycompany.proyectofinal1.entities.Tipodeusuario;
import com.mycompany.proyectofinal1.entities.Usuarios;
import com.mycompany.proyectofinal1.model.PersonasFacadeLocal;
import com.mycompany.proyectofinal1.model.TipodeusuarioFacadeLocal;
import com.mycompany.proyectofinal1.model.UsuariosFacadeLocal;
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
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
//import org.apache.commons.codec.net.;

import java.net.InetAddress;
/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Named(value = "controllerUsuarios")
@SessionScoped
public class ControllerUsuarios implements Serializable {

    Usuarios usu = new Usuarios();
    @EJB
    UsuariosFacadeLocal usufl;
    Personas per = new Personas();
    @EJB
    PersonasFacadeLocal perfl;
    Tipodeusuario TipUsu = new Tipodeusuario();
    @EJB
    TipodeusuarioFacadeLocal TipUsufl;
    List<SelectItem> listapersonas;
    List<SelectItem> listatipousuarios;

    /**
     * Creates a new instance of ControllerUsuarios
     */
    public ControllerUsuarios() {
    }

    public Usuarios getUsu() {
        return usu;
    }

    public void setUsu(Usuarios usu) {
        this.usu = usu;
    }

    public UsuariosFacadeLocal getUsufl() {
        return usufl;
    }

    public void setUsufl(UsuariosFacadeLocal usufl) {
        this.usufl = usufl;
    }

    public List<Usuarios> listar() {
        try {
            return this.usufl.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public void eliminar(Usuarios usuarios) {
        try {
            this.usufl.remove(usuarios);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }

    public Personas getPer() {
        return per;
    }

    public void setPer(Personas per) {
        this.per = per;
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

    public List<SelectItem> getListatipousuarios() {
        this.listatipousuarios = new ArrayList<>();
        try {
            for (Tipodeusuario TipUsu : this.TipUsufl.findAll()) {
                SelectItem item = new SelectItem(TipUsu.getTipId(), TipUsu.getTipUsu());
                this.listatipousuarios.add(item);
            }
        } catch (Exception e) {
        }
        return listatipousuarios;
    }

    public void setListatipousuarios(List<SelectItem> listatipousuarios) {
        this.listatipousuarios = listatipousuarios;
    }

    public void crearClientes() {
        try {
            this.usu.setUsuario(per);
            this.usu.setTipoUsuario(TipUsu);
            this.usufl.create(usu);
            usu = new Usuarios();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se registro correctamente", "MSG_ERROR"));
        }
    }

    public PersonasFacadeLocal getPerfl() {
        return perfl;
    }

    public void setPerfl(PersonasFacadeLocal perfl) {
        this.perfl = perfl;
    }

    public void editarPersonas(Usuarios usuarios) {
        try {
            this.usu = usuarios;
            this.per.setPerId(usu.getUsuId());
            this.TipUsu.setTipId(usu.getTipoUsuario().getTipId());
            //this.TipProfl.edit(tipodeproducto);
            FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarUsuarios.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerTipPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar() {
        try {
            this.usufl.edit(usu);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }
    
    String servidor = "es.pool.ntp.org";

    public String conexion() {
        try {
            String formattedTime;
            // Obtenemos la información de tiempo del servidor NTP
            try ( // Creamos un cliente NTP
                    NTPUDPClient timeClient = new NTPUDPClient()) {
                // Obtenemos la información de tiempo del servidor NTP
                InetAddress inetAddress = InetAddress.getByName(servidor);
                TimeInfo timeInfo = timeClient.getTime(inetAddress);
                // Obtenemos la hora del servidor y la imprimimos
                long serverTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
                // Convertimos la hora del servidor a una representación legible
                formattedTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(serverTime));
                System.out.println("Hora formateada: " + formattedTime);
                // Cerramos el cliente NTP
            }
            
            return formattedTime;
        } catch (Exception e) {
            System.err.println(e);
            return "";
        }
    }
}
