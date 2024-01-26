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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Entity
@Table(name = "soporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soporte.findAll", query = "SELECT s FROM Soporte s"),
    @NamedQuery(name = "Soporte.findBySopoId", query = "SELECT s FROM Soporte s WHERE s.sopoId = :sopoId"),
    @NamedQuery(name = "Soporte.findBySopDesc", query = "SELECT s FROM Soporte s WHERE s.sopDesc = :sopDesc"),
    @NamedQuery(name = "Soporte.findBySopFe", query = "SELECT s FROM Soporte s WHERE s.sopFe = :sopFe")})
public class Soporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SopoId")
    private Integer sopoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "SopDesc")
    private String sopDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SopFe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sopFe;
    @JoinColumn(name = "SopTiS", referencedColumnName = "TisId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipodesoporte sopTiS;
    @JoinColumn(name = "SopTiCl", referencedColumnName = "TipId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipodeusuario sopTiCl;
    @JoinColumn(name = "SopDoCl", referencedColumnName = "CliPerId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clientes sopDoCl;
    @JoinColumn(name = "SopEstId", referencedColumnName = "EstId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estados sopEstId;

    public Soporte() {
    }

    public Soporte(Integer sopoId) {
        this.sopoId = sopoId;
    }

    public Soporte(Integer sopoId, String sopDesc, Date sopFe) {
        this.sopoId = sopoId;
        this.sopDesc = sopDesc;
        this.sopFe = sopFe;
    }

    public Integer getSopoId() {
        return sopoId;
    }

    public void setSopoId(Integer sopoId) {
        this.sopoId = sopoId;
    }

    public String getSopDesc() {
        return sopDesc;
    }

    public void setSopDesc(String sopDesc) {
        this.sopDesc = sopDesc;
    }

    public Date getSopFe() {
        return sopFe;
    }

    public void setSopFe(Date sopFe) {
        this.sopFe = sopFe;
    }

    public Tipodesoporte getSopTiS() {
        return sopTiS;
    }

    public void setSopTiS(Tipodesoporte sopTiS) {
        this.sopTiS = sopTiS;
    }

    public Tipodeusuario getSopTiCl() {
        return sopTiCl;
    }

    public void setSopTiCl(Tipodeusuario sopTiCl) {
        this.sopTiCl = sopTiCl;
    }

    public Clientes getSopDoCl() {
        return sopDoCl;
    }

    public void setSopDoCl(Clientes sopDoCl) {
        this.sopDoCl = sopDoCl;
    }

    public Estados getSopEstId() {
        return sopEstId;
    }

    public void setSopEstId(Estados sopEstId) {
        this.sopEstId = sopEstId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sopoId != null ? sopoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soporte)) {
            return false;
        }
        Soporte other = (Soporte) object;
        if ((this.sopoId == null && other.sopoId != null) || (this.sopoId != null && !this.sopoId.equals(other.sopoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Soporte[ sopoId=" + sopoId + " ]";
    }
    
}
