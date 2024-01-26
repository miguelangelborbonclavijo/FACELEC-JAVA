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
@Table(name = "estados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estados.findAll", query = "SELECT e FROM Estados e"),
    @NamedQuery(name = "Estados.findByEstId", query = "SELECT e FROM Estados e WHERE e.estId = :estId"),
    @NamedQuery(name = "Estados.findByEstNom", query = "SELECT e FROM Estados e WHERE e.estNom = :estNom")})
public class Estados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EstId")
    private Integer estId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EstNom")
    private String estNom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sopEstId", fetch = FetchType.LAZY)
    private List<Soporte> soporteList;

    public Estados() {
    }

    public Estados(Integer estId) {
        this.estId = estId;
    }

    public Estados(Integer estId, String estNom) {
        this.estId = estId;
        this.estNom = estNom;
    }

    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public String getEstNom() {
        return estNom;
    }

    public void setEstNom(String estNom) {
        this.estNom = estNom;
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
        hash += (estId != null ? estId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estados)) {
            return false;
        }
        Estados other = (Estados) object;
        if ((this.estId == null && other.estId != null) || (this.estId != null && !this.estId.equals(other.estId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Estados[ estId=" + estId + " ]";
    }
    
}
