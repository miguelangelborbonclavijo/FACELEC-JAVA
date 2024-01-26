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
@Table(name = "tipodedocumento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodedocumento.findAll", query = "SELECT t FROM Tipodedocumento t"),
    @NamedQuery(name = "Tipodedocumento.findByTipDocId", query = "SELECT t FROM Tipodedocumento t WHERE t.tipDocId = :tipDocId"),
    @NamedQuery(name = "Tipodedocumento.findByTipDoc", query = "SELECT t FROM Tipodedocumento t WHERE t.tipDoc = :tipDoc")})
public class Tipodedocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TipDocId")
    private Integer tipDocId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TipDoc")
    private String tipDoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perTidId", fetch = FetchType.LAZY)
    private List<Personas> personasList;

    public Tipodedocumento() {
    }

    public Tipodedocumento(Integer tipDocId) {
        this.tipDocId = tipDocId;
    }

    public Tipodedocumento(Integer tipDocId, String tipDoc) {
        this.tipDocId = tipDocId;
        this.tipDoc = tipDoc;
    }

    public Integer getTipDocId() {
        return tipDocId;
    }

    public void setTipDocId(Integer tipDocId) {
        this.tipDocId = tipDocId;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    @XmlTransient
    public List<Personas> getPersonasList() {
        return personasList;
    }

    public void setPersonasList(List<Personas> personasList) {
        this.personasList = personasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipDocId != null ? tipDocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodedocumento)) {
            return false;
        }
        Tipodedocumento other = (Tipodedocumento) object;
        if ((this.tipDocId == null && other.tipDocId != null) || (this.tipDocId != null && !this.tipDocId.equals(other.tipDocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Tipodedocumento[ tipDocId=" + tipDocId + " ]";
    }
    
}
