/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v"),
    @NamedQuery(name = "Ventas.findByVenId", query = "SELECT v FROM Ventas v WHERE v.venId = :venId"),
    @NamedQuery(name = "Ventas.findByVenCan", query = "SELECT v FROM Ventas v WHERE v.venCan = :venCan"),
    @NamedQuery(name = "Ventas.findByVenFech", query = "SELECT v FROM Ventas v WHERE v.venFech = :venFech"),
    @NamedQuery(name = "Ventas.findByVenTot", query = "SELECT v FROM Ventas v WHERE v.venTot = :venTot")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VenId")
    private Integer venId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VenCan")
    private int venCan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VenFech")
    @Temporal(TemporalType.TIMESTAMP)
    private Date venFech;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VenTot")
    private int venTot;
    @JoinColumn(name = "VenTraId", referencedColumnName = "TraId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Trabajadores venTraId;
    @JoinColumn(name = "VenCliId", referencedColumnName = "CliPerId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clientes venCliId;
    @JoinColumn(name = "VenAcId", referencedColumnName = "VeAnId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ventasacan venAcId;
    @JoinColumn(name = "VenCodId", referencedColumnName = "CodVenId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Codven venCodId;
    @JoinColumn(name = "VenProId", referencedColumnName = "ProId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Productos venProId;

    public Ventas() {
    }

    public Ventas(Integer venId) {
        this.venId = venId;
    }

    public Ventas(Integer venId, int venCan, Date venFech, int venTot) {
        this.venId = venId;
        this.venCan = venCan;
        this.venFech = venFech;
        this.venTot = venTot;
    }

    public Integer getVenId() {
        return venId;
    }

    public void setVenId(Integer venId) {
        this.venId = venId;
    }

    public int getVenCan() {
        return venCan;
    }

    public void setVenCan(int venCan) {
        this.venCan = venCan;
    }

    public Date getVenFech() {
        return venFech;
    }

    public void setVenFech(Date venFech) {
        this.venFech = venFech;
    }

    public int getVenTot() {
        return venTot;
    }

    public void setVenTot(int venTot) {
        this.venTot = venTot;
    }

    public Trabajadores getVenTraId() {
        return venTraId;
    }

    public void setVenTraId(Trabajadores venTraId) {
        this.venTraId = venTraId;
    }

    public Clientes getVenCliId() {
        return venCliId;
    }

    public void setVenCliId(Clientes venCliId) {
        this.venCliId = venCliId;
    }

    public Ventasacan getVenAcId() {
        return venAcId;
    }

    public void setVenAcId(Ventasacan venAcId) {
        this.venAcId = venAcId;
    }

    public Codven getVenCodId() {
        return venCodId;
    }

    public void setVenCodId(Codven venCodId) {
        this.venCodId = venCodId;
    }

    public Productos getVenProId() {
        return venProId;
    }

    public void setVenProId(Productos venProId) {
        this.venProId = venProId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (venId != null ? venId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.venId == null && other.venId != null) || (this.venId != null && !this.venId.equals(other.venId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Ventas[ venId=" + venId + " ]";
    }
    
}
