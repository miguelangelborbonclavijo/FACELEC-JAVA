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
@Table(name = "tipodeclientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodeclientes.findAll", query = "SELECT t FROM Tipodeclientes t"),
    @NamedQuery(name = "Tipodeclientes.findByTipCliId", query = "SELECT t FROM Tipodeclientes t WHERE t.tipCliId = :tipCliId"),
    @NamedQuery(name = "Tipodeclientes.findByTipCli", query = "SELECT t FROM Tipodeclientes t WHERE t.tipCli = :tipCli")})
public class Tipodeclientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TipCliId")
    private Integer tipCliId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TipCli")
    private String tipCli;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cilTipId", fetch = FetchType.LAZY)
    private List<Clientes> clientesList;

    public Tipodeclientes() {
    }

    public Tipodeclientes(Integer tipCliId) {
        this.tipCliId = tipCliId;
    }

    public Tipodeclientes(Integer tipCliId, String tipCli) {
        this.tipCliId = tipCliId;
        this.tipCli = tipCli;
    }

    public Integer getTipCliId() {
        return tipCliId;
    }

    public void setTipCliId(Integer tipCliId) {
        this.tipCliId = tipCliId;
    }

    public String getTipCli() {
        return tipCli;
    }

    public void setTipCli(String tipCli) {
        this.tipCli = tipCli;
    }

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipCliId != null ? tipCliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodeclientes)) {
            return false;
        }
        Tipodeclientes other = (Tipodeclientes) object;
        if ((this.tipCliId == null && other.tipCliId != null) || (this.tipCliId != null && !this.tipCliId.equals(other.tipCliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Tipodeclientes[ tipCliId=" + tipCliId + " ]";
    }
    
}
