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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Entity
@Table(name = "trabajadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajadores.findAll", query = "SELECT t FROM Trabajadores t"),
    @NamedQuery(name = "Trabajadores.findByTraId", query = "SELECT t FROM Trabajadores t WHERE t.traId = :traId"),
    @NamedQuery(name = "Trabajadores.findByTraHor", query = "SELECT t FROM Trabajadores t WHERE t.traHor = :traHor"),
    @NamedQuery(name = "Trabajadores.findByTraSalario", query = "SELECT t FROM Trabajadores t WHERE t.traSalario = :traSalario")})
public class Trabajadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TraId")
    private Integer traId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TraHor")
    private int traHor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TraSalario")
    private int traSalario;
    @JoinColumn(name = "TraPerId", referencedColumnName = "PerId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Personas traPerId;
    @JoinColumn(name = "TraCarId", referencedColumnName = "CarTraId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cartrab traCarId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comTraId", fetch = FetchType.LAZY)
    private List<Compras> comprasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venTraId", fetch = FetchType.LAZY)
    private List<Ventas> ventasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTraId", fetch = FetchType.LAZY)
    private List<Codven> codvenList;

    public Trabajadores() {
    }

    public Trabajadores(Integer traId) {
        this.traId = traId;
    }

    public Trabajadores(Integer traId, int traHor, int traSalario) {
        this.traId = traId;
        this.traHor = traHor;
        this.traSalario = traSalario;
    }

    public Integer getTraId() {
        return traId;
    }

    public void setTraId(Integer traId) {
        this.traId = traId;
    }

    public int getTraHor() {
        return traHor;
    }

    public void setTraHor(int traHor) {
        this.traHor = traHor;
    }

    public int getTraSalario() {
        return traSalario;
    }

    public void setTraSalario(int traSalario) {
        this.traSalario = traSalario;
    }

    public Personas getTraPerId() {
        return traPerId;
    }

    public void setTraPerId(Personas traPerId) {
        this.traPerId = traPerId;
    }

    public Cartrab getTraCarId() {
        return traCarId;
    }

    public void setTraCarId(Cartrab traCarId) {
        this.traCarId = traCarId;
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

    @XmlTransient
    public List<Codven> getCodvenList() {
        return codvenList;
    }

    public void setCodvenList(List<Codven> codvenList) {
        this.codvenList = codvenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traId != null ? traId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajadores)) {
            return false;
        }
        Trabajadores other = (Trabajadores) object;
        if ((this.traId == null && other.traId != null) || (this.traId != null && !this.traId.equals(other.traId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Trabajadores[ traId=" + traId + " ]";
    }
    
}
