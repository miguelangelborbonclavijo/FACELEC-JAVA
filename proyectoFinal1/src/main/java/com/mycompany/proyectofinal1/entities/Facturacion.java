/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Entity
@Table(name = "facturacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturacion.findAll", query = "SELECT f FROM Facturacion f"),
    @NamedQuery(name = "Facturacion.findByFacId", query = "SELECT f FROM Facturacion f WHERE f.facId = :facId"),
    @NamedQuery(name = "Facturacion.findByFacCaj", query = "SELECT f FROM Facturacion f WHERE f.facCaj = :facCaj"),
    @NamedQuery(name = "Facturacion.findByFacValTo", query = "SELECT f FROM Facturacion f WHERE f.facValTo = :facValTo"),
    @NamedQuery(name = "Facturacion.findByFacValRe", query = "SELECT f FROM Facturacion f WHERE f.facValRe = :facValRe"),
    @NamedQuery(name = "Facturacion.findByFacCamb", query = "SELECT f FROM Facturacion f WHERE f.facCamb = :facCamb")})
public class Facturacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FacId")
    private Integer facId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FacCaj")
    private int facCaj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FacValTo")
    private int facValTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FacValRe")
    private int facValRe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FacCamb")
    private int facCamb;
    @JoinColumn(name = "FacVenId", referencedColumnName = "CodVenId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Codven facVenId;

    public Facturacion() {
    }

    public Facturacion(Integer facId) {
        this.facId = facId;
    }

    public Facturacion(Integer facId, int facCaj, int facValTo, int facValRe, int facCamb) {
        this.facId = facId;
        this.facCaj = facCaj;
        this.facValTo = facValTo;
        this.facValRe = facValRe;
        this.facCamb = facCamb;
    }

    public Integer getFacId() {
        return facId;
    }

    public void setFacId(Integer facId) {
        this.facId = facId;
    }

    public int getFacCaj() {
        return facCaj;
    }

    public void setFacCaj(int facCaj) {
        this.facCaj = facCaj;
    }

    public int getFacValTo() {
        return facValTo;
    }

    public void setFacValTo(int facValTo) {
        this.facValTo = facValTo;
    }

    public int getFacValRe() {
        return facValRe;
    }

    public void setFacValRe(int facValRe) {
        this.facValRe = facValRe;
    }

    public int getFacCamb() {
        return facCamb;
    }

    public void setFacCamb(int facCamb) {
        this.facCamb = facCamb;
    }

    public Codven getFacVenId() {
        return facVenId;
    }

    public void setFacVenId(Codven facVenId) {
        this.facVenId = facVenId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facId != null ? facId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturacion)) {
            return false;
        }
        Facturacion other = (Facturacion) object;
        if ((this.facId == null && other.facId != null) || (this.facId != null && !this.facId.equals(other.facId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Facturacion[ facId=" + facId + " ]";
    }
    
}
