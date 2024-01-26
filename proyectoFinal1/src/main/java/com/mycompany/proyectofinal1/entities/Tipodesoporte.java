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
@Table(name = "tipodesoporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodesoporte.findAll", query = "SELECT t FROM Tipodesoporte t"),
    @NamedQuery(name = "Tipodesoporte.findByTisId", query = "SELECT t FROM Tipodesoporte t WHERE t.tisId = :tisId"),
    @NamedQuery(name = "Tipodesoporte.findByTisSopr", query = "SELECT t FROM Tipodesoporte t WHERE t.tisSopr = :tisSopr")})
public class Tipodesoporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TisId")
    private Integer tisId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TisSopr")
    private String tisSopr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sopTiS", fetch = FetchType.LAZY)
    private List<Soporte> soporteList;

    public Tipodesoporte() {
    }

    public Tipodesoporte(Integer tisId) {
        this.tisId = tisId;
    }

    public Tipodesoporte(Integer tisId, String tisSopr) {
        this.tisId = tisId;
        this.tisSopr = tisSopr;
    }

    public Integer getTisId() {
        return tisId;
    }

    public void setTisId(Integer tisId) {
        this.tisId = tisId;
    }

    public String getTisSopr() {
        return tisSopr;
    }

    public void setTisSopr(String tisSopr) {
        this.tisSopr = tisSopr;
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
        hash += (tisId != null ? tisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodesoporte)) {
            return false;
        }
        Tipodesoporte other = (Tipodesoporte) object;
        if ((this.tisId == null && other.tisId != null) || (this.tisId != null && !this.tisId.equals(other.tisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Tipodesoporte[ tisId=" + tisId + " ]";
    }
    
}
