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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByCliPerId", query = "SELECT c FROM Clientes c WHERE c.cliPerId = :cliPerId"),
    @NamedQuery(name = "Clientes.findByCliDirr", query = "SELECT c FROM Clientes c WHERE c.cliDirr = :cliDirr")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CliPerId")
    private Integer cliPerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CliDirr")
    private String cliDirr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venCliId", fetch = FetchType.LAZY)
    private List<Ventas> ventasList;
    @JoinColumn(name = "CliPerId", referencedColumnName = "PerId", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Personas personas;
    @JoinColumn(name = "CliEsId", referencedColumnName = "CliEsId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clientesestado cliEsId;
    @JoinColumn(name = "CilTipId", referencedColumnName = "TipCliId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipodeclientes cilTipId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codVenCl", fetch = FetchType.LAZY)
    private List<Codven> codvenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sopDoCl", fetch = FetchType.LAZY)
    private List<Soporte> soporteList;

    public Clientes() {
    }

    public Clientes(Integer cliPerId) {
        this.cliPerId = cliPerId;
    }

    public Clientes(Integer cliPerId, String cliDirr) {
        this.cliPerId = cliPerId;
        this.cliDirr = cliDirr;
    }

    public Integer getCliPerId() {
        return cliPerId;
    }

    public void setCliPerId(Integer cliPerId) {
        this.cliPerId = cliPerId;
    }

    public String getCliDirr() {
        return cliDirr;
    }

    public void setCliDirr(String cliDirr) {
        this.cliDirr = cliDirr;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public Clientesestado getCliEsId() {
        return cliEsId;
    }

    public void setCliEsId(Clientesestado cliEsId) {
        this.cliEsId = cliEsId;
    }

    public Tipodeclientes getCilTipId() {
        return cilTipId;
    }

    public void setCilTipId(Tipodeclientes cilTipId) {
        this.cilTipId = cilTipId;
    }

    @XmlTransient
    public List<Codven> getCodvenList() {
        return codvenList;
    }

    public void setCodvenList(List<Codven> codvenList) {
        this.codvenList = codvenList;
    }

    @XmlTransient
    public List<Soporte> getSoporteList() {
        return soporteList;
    }

    public void setSoporteList(List<Soporte> soporteList) {
        this.soporteList = soporteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliPerId != null ? cliPerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.cliPerId == null && other.cliPerId != null) || (this.cliPerId != null && !this.cliPerId.equals(other.cliPerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Clientes[ cliPerId=" + cliPerId + " ]";
    }
    
}
