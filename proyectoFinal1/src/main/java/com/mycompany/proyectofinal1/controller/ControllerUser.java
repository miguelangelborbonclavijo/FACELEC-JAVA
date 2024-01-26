package com.mycompany.proyectofinal1.controller;

import com.mycompany.proyectofinal1.entities.Personas;
import com.mycompany.proyectofinal1.entities.Tipodedocumento;
import com.mycompany.proyectofinal1.entities.Tipodeusuario;
import com.mycompany.proyectofinal1.entities.Usuarios;
import com.mycompany.proyectofinal1.model.PersonasFacadeLocal;
import com.mycompany.proyectofinal1.model.TipodedocumentoFacadeLocal;
import com.mycompany.proyectofinal1.model.TipodeusuarioFacadeLocal;
import com.mycompany.proyectofinal1.model.UsuariosFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Named(value = "controllerUser")
@SessionScoped
public class ControllerUser implements Serializable {

    Usuarios usuarios = new Usuarios();
    @EJB
    UsuariosFacadeLocal ufl;
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

    /**
     * Creates a new instance of ControllerUser
     */
    public ControllerUser() {

    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public UsuariosFacadeLocal getUfl() {
        return ufl;
    }

    public void setUfl(UsuariosFacadeLocal ufl) {
        this.ufl = ufl;
    }

    public void validarUsuario() {
        usuarios.setUsuario(per);
        String redir = "";
        try {
            usuarios = ufl.IniciarSesion(usuarios);
            if (usuarios != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarios.getNombre());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("tipo_usuario", usuarios.getTipoUsuario().getTipUsu());
                redir = "principal.xhtml";
                FacesContext.getCurrentInstance().getExternalContext().redirect(redir);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Usuario y/o contraseña invalido", "MSG_ERROR"));
                redir = "index.xhtml";
            }
        } catch (Exception e) {

        }
        usuarios = new Usuarios();
    }
    public List<Personas> listar() {
        try {
            return this.pfl.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public void eliminar(Personas personas) {
        try {
            this.pfl.remove(personas);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
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

    public List<SelectItem> getListatipodeusuario() {
        this.listatipodeusuario = new ArrayList<>();
        try {
            for (Tipodeusuario TipUsu : this.TipUsfl.findAll()) {
                SelectItem item = new SelectItem(TipUsu.getTipId(),TipUsu.getTipUsu());
                this.listatipodeusuario.add(item);
            }
        } catch (Exception e) {

        }

        return listatipodeusuario;
    }

    public List<SelectItem> getListatipodedocumento() {
        this.listatipodedocumento = new ArrayList<>();
        try {
            for (Tipodedocumento TipDoc : this.tipdocfl.findAll()) {
                SelectItem item = new SelectItem(TipDoc.getTipDocId(),TipDoc.getTipDoc());
                this.listatipodedocumento.add(item);
            }
        } catch (Exception e) {

        }
        return listatipodedocumento;
    }

    public void setListatipodedocumento(List<SelectItem> listatipodedocumento) {
        this.listatipodedocumento = listatipodedocumento;
    }


    public void crearPersona() {
        try {
            this.per.setPerTidId(TipDoc);
            this.per.setPerTipUs(TipUsu);
            this.pfl.create(per);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se inserto registro correctamente", "MSG_INFO"));
        } catch (Exception e) {

        }
    }

    public Personas getPerso() {
        return per;
    }

    public void setPerso(Personas perso) {
        this.per = perso;
    }
    
}
