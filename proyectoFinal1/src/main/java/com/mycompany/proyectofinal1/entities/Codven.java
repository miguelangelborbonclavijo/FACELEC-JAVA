/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Entity
@Table(name = "codven")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Codven.findAll", query = "SELECT c FROM Codven c"),
    @NamedQuery(name = "Codven.findByCodVenId", query = "SELECT c FROM Codven c WHERE c.codVenId = :codVenId"),
    @NamedQuery(name = "Codven.findByCodFec", query = "SELECT c FROM Codven c WHERE c.codFec = :codFec")})
public class Codven implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodVenId")
    private Integer codVenId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date codFec;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facVenId", fetch = FetchType.LAZY)
    private List<Facturacion> facturacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venCodId", fetch = FetchType.LAZY)
    private List<Ventas> ventasList;
    @JoinColumn(name = "CodTraId", referencedColumnName = "TraId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Trabajadores codTraId;
    @JoinColumn(name = "CodVenCl", referencedColumnName = "CliPerId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clientes codVenCl;

    public Codven() {
    }

    public Codven(Integer codVenId) {
        this.codVenId = codVenId;
    }

    public Codven(Integer codVenId, Date codFec) {
        this.codVenId = codVenId;
        this.codFec = codFec;
    }

    public Integer getCodVenId() {
        return codVenId;
    }

    public void setCodVenId(Integer codVenId) {
        this.codVenId = codVenId;
    }

    public Date getCodFec() {
        return codFec;
    }

    public void setCodFec(Date codFec) {
        this.codFec = codFec;
    }

    @XmlTransient
    public List<Facturacion> getFacturacionList() {
        return facturacionList;
    }

    public void setFacturacionList(List<Facturacion> facturacionList) {
        this.facturacionList = facturacionList;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    public Trabajadores getCodTraId() {
        return codTraId;
    }

    public void setCodTraId(Trabajadores codTraId) {
        this.codTraId = codTraId;
    }

    public Clientes getCodVenCl() {
        return codVenCl;
    }

    public void setCodVenCl(Clientes codVenCl) {
        this.codVenCl = codVenCl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVenId != null ? codVenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codven)) {
            return false;
        }
        Codven other = (Codven) object;
        if ((this.codVenId == null && other.codVenId != null) || (this.codVenId != null && !this.codVenId.equals(other.codVenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Codven[ codVenId=" + codVenId + " ]";
    }
    
}
