package com.mycompany.proyectofinal1.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByUsuId", query = "SELECT u FROM Usuarios u WHERE u.usuId = :usuId"),
    @NamedQuery(name = "Usuarios.findByContrasena", query = "SELECT u FROM Usuarios u WHERE u.contrasena = :contrasena"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    public static Object getUsername() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static Object getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UsuId")
    private Integer usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "tipo_usuario", referencedColumnName = "TipId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipodeusuario tipoUsuario;
    @JoinColumn(name = "usuario", referencedColumnName = "PerId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Personas usuario;

    public Usuarios() {
    }

    public Usuarios(Integer usuId) {
        this.usuId = usuId;
    }

    public Usuarios(Integer usuId, String contrasena, String nombre) {
        this.usuId = usuId;
        this.contrasena = contrasena;
        this.nombre = nombre;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipodeusuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Tipodeusuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Personas getUsuario() {
        return usuario;
    }

    public void setUsuario(Personas usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectofinal1.entities.Usuarios[ usuId=" + usuId + " ]";
    }
    
}
