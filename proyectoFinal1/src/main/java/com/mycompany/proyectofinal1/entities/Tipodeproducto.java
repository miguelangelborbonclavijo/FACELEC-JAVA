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
@Table(name = "tipodeproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodeproducto.findAll", query = "SELECT t FROM Tipodeproducto t"),
    @NamedQuery(name = "Tipodeproducto.findByTipId", query = "SELECT t FROM Tipodeproducto t WHERE t.tipId = :tipId"),
    @NamedQuery(name = "Tipodeproducto.findByTipNom", query = "SELECT t FROM Tipodeproducto t WHERE t.tipNom = :tipNom")})
public class Tipodeproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TipId")
    private Integer tipId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TipNom")
    private String tipNom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proTip", fetch = FetchType.LAZY)
    private List<Productos> productosList;

    public Tipodeproducto() {
    }

    public Tipodeproducto(Integer tipId) {
        this.tipId = tipId;
    }

    public Tipodeproducto(Integer tipId, String tipNom) {
        this.tipId = tipId;
        this.tipNom = tipNom;
    }

    public Integer getTipId() {
        return tipId;
    }

    public void setTipId(Integer tipId) {
        this.tipId = tipId;
    }

    public String getTipNom() {
        return tipNom;
    }

    public void setTipNom(String tipNom) {
        this.tipNom = tipNom;
    }

    @XmlTransient
    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipId != null ? tipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodeproducto)) {
            return false;
        }
        Tipodeproducto other = (Tipodeproducto) object;
        if ((this.tipId == null && other.tipId != null) || (this.tipId != null && !this.tipId.equals(other.tipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Tipodeproducto[ tipId=" + tipId + " ]";
    }
    
}
