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
@Table(name = "proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p"),
    @NamedQuery(name = "Proveedores.findByPrId", query = "SELECT p FROM Proveedores p WHERE p.prId = :prId"),
    @NamedQuery(name = "Proveedores.findByPrNomPr", query = "SELECT p FROM Proveedores p WHERE p.prNomPr = :prNomPr"),
    @NamedQuery(name = "Proveedores.findByPrDirr", query = "SELECT p FROM Proveedores p WHERE p.prDirr = :prDirr"),
    @NamedQuery(name = "Proveedores.findByPrCel", query = "SELECT p FROM Proveedores p WHERE p.prCel = :prCel")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrId")
    private Integer prId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PrNomPr")
    private String prNomPr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PrDirr")
    private String prDirr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrCel")
    private long prCel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comPvId", fetch = FetchType.LAZY)
    private List<Compras> comprasList;

    public Proveedores() {
    }

    public Proveedores(Integer prId) {
        this.prId = prId;
    }

    public Proveedores(Integer prId, String prNomPr, String prDirr, long prCel) {
        this.prId = prId;
        this.prNomPr = prNomPr;
        this.prDirr = prDirr;
        this.prCel = prCel;
    }

    public Integer getPrId() {
        return prId;
    }

    public void setPrId(Integer prId) {
        this.prId = prId;
    }

    public String getPrNomPr() {
        return prNomPr;
    }

    public void setPrNomPr(String prNomPr) {
        this.prNomPr = prNomPr;
    }

    public String getPrDirr() {
        return prDirr;
    }

    public void setPrDirr(String prDirr) {
        this.prDirr = prDirr;
    }

    public long getPrCel() {
        return prCel;
    }

    public void setPrCel(long prCel) {
        this.prCel = prCel;
    }

    @XmlTransient
    public List<Compras> getComprasList() {
        return comprasList;
    }

    public void setComprasList(List<Compras> comprasList) {
        this.comprasList = comprasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prId != null ? prId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.prId == null && other.prId != null) || (this.prId != null && !this.prId.equals(other.prId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Proveedores[ prId=" + prId + " ]";
    }
    
}
