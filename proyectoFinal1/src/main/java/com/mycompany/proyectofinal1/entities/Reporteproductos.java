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
import javax.persistence.metamodel.SingularAttribute;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Entity
@Table(name = "reporteproductos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporteproductos.findAll", query = "SELECT r FROM Reporteproductos r"),
    @NamedQuery(name = "Reporteproductos.findByReId", query = "SELECT r FROM Reporteproductos r WHERE r.reId = :reId"),
    @NamedQuery(name = "Reporteproductos.findByDesRePr", query = "SELECT r FROM Reporteproductos r WHERE r.desRePr = :desRePr"),
    @NamedQuery(name = "Reporteproductos.findByRepFech", query = "SELECT r FROM Reporteproductos r WHERE r.repFech = :repFech")})
public class Reporteproductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ReId")
    private Integer reId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DesRePr")
    private String desRePr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RepFech")
    @Temporal(TemporalType.TIMESTAMP)
    private Date repFech;
    @JoinColumn(name = "ReProId", referencedColumnName = "ProId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Productos reProId;

    public Reporteproductos() {
    }

    public Reporteproductos(Integer reId) {
        this.reId = reId;
    }

    public Reporteproductos(Integer reId, String desRePr, Date repFech) {
        this.reId = reId;
        this.desRePr = desRePr;
        this.repFech = repFech;
    }

    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public String getDesRePr() {
        return desRePr;
    }

    public void setDesRePr(String desRePr) {
        this.desRePr = desRePr;
    }

    public Date getRepFech() {
        return repFech;
    }

    public void setRepFech(Date repFech) {
        this.repFech = repFech;
    }

    public Productos getReProId() {
        return reProId;
    }

    public void setReProId(Productos reProId) {
        this.reProId = reProId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reId != null ? reId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reporteproductos)) {
            return false;
        }
        Reporteproductos other = (Reporteproductos) object;
        if ((this.reId == null && other.reId != null) || (this.reId != null && !this.reId.equals(other.reId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Reporteproductos[ reId=" + reId + " ]";
    }

    public void setReId(SingularAttribute<Reporteproductos, Integer> reId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
