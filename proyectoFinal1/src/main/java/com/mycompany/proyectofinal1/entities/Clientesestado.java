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
@Table(name = "clientesestado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientesestado.findAll", query = "SELECT c FROM Clientesestado c"),
    @NamedQuery(name = "Clientesestado.findByCliEsId", query = "SELECT c FROM Clientesestado c WHERE c.cliEsId = :cliEsId"),
    @NamedQuery(name = "Clientesestado.findByCliTipEs", query = "SELECT c FROM Clientesestado c WHERE c.cliTipEs = :cliTipEs")})
public class Clientesestado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CliEsId")
    private Integer cliEsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CliTipEs")
    private String cliTipEs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliEsId", fetch = FetchType.LAZY)
    private List<Clientes> clientesList;

    public Clientesestado() {
    }

    public Clientesestado(Integer cliEsId) {
        this.cliEsId = cliEsId;
    }

    public Clientesestado(Integer cliEsId, String cliTipEs) {
        this.cliEsId = cliEsId;
        this.cliTipEs = cliTipEs;
    }

    public Integer getCliEsId() {
        return cliEsId;
    }

    public void setCliEsId(Integer cliEsId) {
        this.cliEsId = cliEsId;
    }

    public String getCliTipEs() {
        return cliTipEs;
    }

    public void setCliTipEs(String cliTipEs) {
        this.cliTipEs = cliTipEs;
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
        hash += (cliEsId != null ? cliEsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientesestado)) {
            return false;
        }
        Clientesestado other = (Clientesestado) object;
        if ((this.cliEsId == null && other.cliEsId != null) || (this.cliEsId != null && !this.cliEsId.equals(other.cliEsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Clientesestado[ cliEsId=" + cliEsId + " ]";
    }
    
}
