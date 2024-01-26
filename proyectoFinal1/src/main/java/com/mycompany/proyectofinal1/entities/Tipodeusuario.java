/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Entity
@Table(name = "tipodeusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodeusuario.findAll", query = "SELECT t FROM Tipodeusuario t"),
    @NamedQuery(name = "Tipodeusuario.findByTipId", query = "SELECT t FROM Tipodeusuario t WHERE t.tipId = :tipId"),
    @NamedQuery(name = "Tipodeusuario.findByTipUsu", query = "SELECT t FROM Tipodeusuario t WHERE t.tipUsu = :tipUsu")})
public class Tipodeusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TipId")
    private Integer tipId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TipUsu")
    private String tipUsu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUsuario", fetch = FetchType.LAZY)
    private List<Usuarios> usuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perTipUs", fetch = FetchType.LAZY)
    private List<Personas> personasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sopTiCl", fetch = FetchType.LAZY)
    private List<Soporte> soporteList;

    public Tipodeusuario() {
    }

    public Tipodeusuario(Integer tipId) {
        this.tipId = tipId;
    }

    public Tipodeusuario(Integer tipId, String tipUsu) {
        this.tipId = tipId;
        this.tipUsu = tipUsu;
    }

    public Integer getTipId() {
        return tipId;
    }

    public void setTipId(Integer tipId) {
        this.tipId = tipId;
    }

    public String getTipUsu() {
        return tipUsu;
    }

    public void setTipUsu(String tipUsu) {
        this.tipUsu = tipUsu;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @XmlTransient
    public List<Personas> getPersonasList() {
        return personasList;
    }

    public void setPersonasList(List<Personas> personasList) {
        this.personasList = personasList;
    }

    @XmlTransient
    public List<Soporte> getSoporteList() {
        return soporteList;
    }

    public void setSoporteList(List<Soporte> soporteList) {
        this.soporteList = soporteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipId != null ? tipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodeusuario)) {
            return false;
        }
        Tipodeusuario other = (Tipodeusuario) object;
        if ((this.tipId == null && other.tipId != null) || (this.tipId != null && !this.tipId.equals(other.tipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Tipodeusuario[ tipId=" + tipId + " ]";
    }
    
}
