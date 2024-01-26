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
@Table(name = "ventasacan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventasacan.findAll", query = "SELECT v FROM Ventasacan v"),
    @NamedQuery(name = "Ventasacan.findByVeAnId", query = "SELECT v FROM Ventasacan v WHERE v.veAnId = :veAnId"),
    @NamedQuery(name = "Ventasacan.findByVeAnTip", query = "SELECT v FROM Ventasacan v WHERE v.veAnTip = :veAnTip")})
public class Ventasacan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VeAnId")
    private Integer veAnId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "VeAnTip")
    private String veAnTip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comEs", fetch = FetchType.LAZY)
    private List<Compras> comprasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venAcId", fetch = FetchType.LAZY)
    private List<Ventas> ventasList;

    public Ventasacan() {
    }

    public Ventasacan(Integer veAnId) {
        this.veAnId = veAnId;
    }

    public Ventasacan(Integer veAnId, String veAnTip) {
        this.veAnId = veAnId;
        this.veAnTip = veAnTip;
    }

    public Integer getVeAnId() {
        return veAnId;
    }

    public void setVeAnId(Integer veAnId) {
        this.veAnId = veAnId;
    }

    public String getVeAnTip() {
        return veAnTip;
    }

    public void setVeAnTip(String veAnTip) {
        this.veAnTip = veAnTip;
    }

    @XmlTransient
    public List<Compras> getComprasList() {
        return comprasList;
    }

    public void setComprasList(List<Compras> comprasList) {
        this.comprasList = comprasList;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (veAnId != null ? veAnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventasacan)) {
            return false;
        }
        Ventasacan other = (Ventasacan) object;
        if ((this.veAnId == null && other.veAnId != null) || (this.veAnId != null && !this.veAnId.equals(other.veAnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Ventasacan[ veAnId=" + veAnId + " ]";
    }
    
}
