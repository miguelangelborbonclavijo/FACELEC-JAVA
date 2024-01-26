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
@Table(name = "cartrab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartrab.findAll", query = "SELECT c FROM Cartrab c"),
    @NamedQuery(name = "Cartrab.findByCarTraId", query = "SELECT c FROM Cartrab c WHERE c.carTraId = :carTraId"),
    @NamedQuery(name = "Cartrab.findByTipCarTr", query = "SELECT c FROM Cartrab c WHERE c.tipCarTr = :tipCarTr")})
public class Cartrab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CarTraId")
    private Integer carTraId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TipCarTr")
    private String tipCarTr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traCarId", fetch = FetchType.LAZY)
    private List<Trabajadores> trabajadoresList;

    public Cartrab() {
    }

    public Cartrab(Integer carTraId) {
        this.carTraId = carTraId;
    }

    public Cartrab(Integer carTraId, String tipCarTr) {
        this.carTraId = carTraId;
        this.tipCarTr = tipCarTr;
    }

    public Integer getCarTraId() {
        return carTraId;
    }

    public void setCarTraId(Integer carTraId) {
        this.carTraId = carTraId;
    }

    public String getTipCarTr() {
        return tipCarTr;
    }

    public void setTipCarTr(String tipCarTr) {
        this.tipCarTr = tipCarTr;
    }

    @XmlTransient
    public List<Trabajadores> getTrabajadoresList() {
        return trabajadoresList;
    }

    public void setTrabajadoresList(List<Trabajadores> trabajadoresList) {
        this.trabajadoresList = trabajadoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carTraId != null ? carTraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartrab)) {
            return false;
        }
        Cartrab other = (Cartrab) object;
        if ((this.carTraId == null && other.carTraId != null) || (this.carTraId != null && !this.carTraId.equals(other.carTraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Cartrab[ carTraId=" + carTraId + " ]";
    }
    
}
