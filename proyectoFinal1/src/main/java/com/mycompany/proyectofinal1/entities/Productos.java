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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByProId", query = "SELECT p FROM Productos p WHERE p.proId = :proId"),
    @NamedQuery(name = "Productos.findByProDes", query = "SELECT p FROM Productos p WHERE p.proDes = :proDes"),
    @NamedQuery(name = "Productos.findByProPreCo", query = "SELECT p FROM Productos p WHERE p.proPreCo = :proPreCo"),
    @NamedQuery(name = "Productos.findByProPreVe", query = "SELECT p FROM Productos p WHERE p.proPreVe = :proPreVe")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProId")
    private Integer proId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ProDes")
    private String proDes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProPreCo")
    private int proPreCo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProPreVe")
    private int proPreVe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reProId", fetch = FetchType.LAZY)
    private List<Reporteproductos> reporteproductosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comPrId", fetch = FetchType.LAZY)
    private List<Compras> comprasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venProId", fetch = FetchType.LAZY)
    private List<Ventas> ventasList;
    @JoinColumn(name = "ProTip", referencedColumnName = "TipId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipodeproducto proTip;

    public Productos() {
    }

    public Productos(Integer proId) {
        this.proId = proId;
    }

    public Productos(Integer proId, String proDes, int proPreCo, int proPreVe) {
        this.proId = proId;
        this.proDes = proDes;
        this.proPreCo = proPreCo;
        this.proPreVe = proPreVe;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProDes() {
        return proDes;
    }

    public void setProDes(String proDes) {
        this.proDes = proDes;
    }

    public int getProPreCo() {
        return proPreCo;
    }

    public void setProPreCo(int proPreCo) {
        this.proPreCo = proPreCo;
    }

    public int getProPreVe() {
        return proPreVe;
    }

    public void setProPreVe(int proPreVe) {
        this.proPreVe = proPreVe;
    }

    @XmlTransient
    public List<Reporteproductos> getReporteproductosList() {
        return reporteproductosList;
    }

    public void setReporteproductosList(List<Reporteproductos> reporteproductosList) {
        this.reporteproductosList = reporteproductosList;
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

    public Tipodeproducto getProTip() {
        return proTip;
    }

    public void setProTip(Tipodeproducto proTip) {
        this.proTip = proTip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Productos[ proId=" + proId + " ]";
    }
    
}
