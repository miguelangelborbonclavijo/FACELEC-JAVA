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
@Table(name = "compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findByComId", query = "SELECT c FROM Compras c WHERE c.comId = :comId"),
    @NamedQuery(name = "Compras.findByComFec", query = "SELECT c FROM Compras c WHERE c.comFec = :comFec"),
    @NamedQuery(name = "Compras.findByComCan", query = "SELECT c FROM Compras c WHERE c.comCan = :comCan")})
public class Compras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ComId")
    private Integer comId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ComFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date comFec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ComCan")
    private int comCan;
    @JoinColumn(name = "ComPrId", referencedColumnName = "ProId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Productos comPrId;
    @JoinColumn(name = "ComPvId", referencedColumnName = "PrId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Proveedores comPvId;
    @JoinColumn(name = "ComTraId", referencedColumnName = "TraId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Trabajadores comTraId;
    @JoinColumn(name = "ComEs", referencedColumnName = "VeAnId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ventasacan comEs;

    public Compras() {
    }

    public Compras(Integer comId) {
        this.comId = comId;
    }

    public Compras(Integer comId, Date comFec, int comCan) {
        this.comId = comId;
        this.comFec = comFec;
        this.comCan = comCan;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Date getComFec() {
        return comFec;
    }

    public void setComFec(Date comFec) {
        this.comFec = comFec;
    }

    public int getComCan() {
        return comCan;
    }

    public void setComCan(int comCan) {
        this.comCan = comCan;
    }

    public Productos getComPrId() {
        return comPrId;
    }

    public void setComPrId(Productos comPrId) {
        this.comPrId = comPrId;
    }

    public Proveedores getComPvId() {
        return comPvId;
    }

    public void setComPvId(Proveedores comPvId) {
        this.comPvId = comPvId;
    }

    public Trabajadores getComTraId() {
        return comTraId;
    }

    public void setComTraId(Trabajadores comTraId) {
        this.comTraId = comTraId;
    }

    public Ventasacan getComEs() {
        return comEs;
    }

    public void setComEs(Ventasacan comEs) {
        this.comEs = comEs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comId != null ? comId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.comId == null && other.comId != null) || (this.comId != null && !this.comId.equals(other.comId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Compras[ comId=" + comId + " ]";
    }
    
}
