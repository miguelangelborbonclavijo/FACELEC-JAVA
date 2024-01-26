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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
//Indica que esta clase es una entidad JPA (Java Persistence API).
@Entity
// Especifica el nombre de la tabla en la base de datos a la que está mapeada esta entidad.
@Table(name = "personas")
//Anotación utilizada para la serialización XML.
@XmlRootElement
//Contiene consultas nombradas que se pueden utilizar para realizar operaciones en la base de datos.
@NamedQueries({
    @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p"),
    @NamedQuery(name = "Personas.findByPerId", query = "SELECT p FROM Personas p WHERE p.perId = :perId"),
    @NamedQuery(name = "Personas.findByPerNom1", query = "SELECT p FROM Personas p WHERE p.perNom1 = :perNom1"),
    @NamedQuery(name = "Personas.findByPerNom2", query = "SELECT p FROM Personas p WHERE p.perNom2 = :perNom2"),
    @NamedQuery(name = "Personas.findByPerApe1", query = "SELECT p FROM Personas p WHERE p.perApe1 = :perApe1"),
    @NamedQuery(name = "Personas.findByPerApe2", query = "SELECT p FROM Personas p WHERE p.perApe2 = :perApe2"),
    @NamedQuery(name = "Personas.findByPerDirr", query = "SELECT p FROM Personas p WHERE p.perDirr = :perDirr"),
    @NamedQuery(name = "Personas.findByPerFech", query = "SELECT p FROM Personas p WHERE p.perFech = :perFech")})
public class Personas implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void setPersonas(Personas perso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // Indica que este atributo es la clave primaria de la entidad.
    @Id
    //Especifica que el atributo es básico y no puede ser nulo
    @Basic(optional = false)
    //Indica que el atributo no puede ser nulo en la base de datos.
    @NotNull
    //Especifica el nombre de la columna en la base de datos.
    @Column(name = "PerId")
    private Integer perId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PerNom1")
    private String perNom1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PerNom2")
    private String perNom2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PerApe1")
    private String perApe1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PerApe2")
    private String perApe2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "PerDirr")
    private String perDirr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PerFech")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFech;
    //Indica una relación uno a muchos con otras entidades.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traPerId", fetch = FetchType.LAZY)
    private List<Trabajadores> trabajadoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Usuarios> usuariosList;
    //Especifica la columna de unión para la relación.
    @JoinColumn(name = "PerTipUs", referencedColumnName = "TipId")
    //Indica una relación muchos a uno con otra entidad.
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipodeusuario perTipUs;
    @JoinColumn(name = "PerTidId", referencedColumnName = "TipDocId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipodedocumento perTidId;
    // Indica una relación uno a uno con otra entidad.
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personas", fetch = FetchType.LAZY)
    private Clientes clientes;

    //Constructores: En programación orientada a objetos, un constructor es un método especial que se llama automáticamente 
    //cuando se crea una instancia (objeto) de una clase. Su propósito principal es inicializar los atributos del objeto.
    public Personas() {
    }
    //Constructor vacio
    
    public Personas(Integer perId) {
        this.perId = perId;
        //this: La palabra clave this se utiliza para referirse a la instancia actual de la clase. En los constructores con varios 
        //parámetros, this se utiliza para distinguir los nombres de los parámetros de los nombres de los atributos de la clase. 
        //(Por ejemplo, this.perId = perId; significa que el atributo perId de la instancia actual se inicializa con el valor del 
        //parámetro perId.
    }
    // Este constructor toma un parámetro perId, que se utiliza para inicializar el atributo perId de la instancia de Personas.
    //Se usa cuando solo se conoce el ID y se quiere crear una instancia con este valor.
    
    public Personas(Integer perId, String perNom1, String perNom2, String perApe1, String perApe2, String perDirr, Date perFech) {
        this.perId = perId;
        this.perNom1 = perNom1;
        this.perNom2 = perNom2;
        this.perApe1 = perApe1;
        this.perApe2 = perApe2;
        this.perDirr = perDirr;
        this.perFech = perFech;
    }
    // Este constructor toma varios parámetros, que se utilizan para inicializar varios atributos de la instancia de Personas. 
    //Se utiliza cuando se conocen todos o la mayoría de los valores necesarios para crear una instancia completa.
    
    //creacion de getter and setter
    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerNom1() {
        return perNom1;
    }

    public void setPerNom1(String perNom1) {
        this.perNom1 = perNom1;
    }

    public String getPerNom2() {
        return perNom2;
    }

    public void setPerNom2(String perNom2) {
        this.perNom2 = perNom2;
    }

    public String getPerApe1() {
        return perApe1;
    }

    public void setPerApe1(String perApe1) {
        this.perApe1 = perApe1;
    }

    public String getPerApe2() {
        return perApe2;
    }

    public void setPerApe2(String perApe2) {
        this.perApe2 = perApe2;
    }

    public String getPerDirr() {
        return perDirr;
    }

    public void setPerDirr(String perDirr) {
        this.perDirr = perDirr;
    }

    public Date getPerFech() {
        return perFech;
    }

    public void setPerFech(Date perFech) {
        this.perFech = perFech;
    }

    @XmlTransient
    public List<Trabajadores> getTrabajadoresList() {
        return trabajadoresList;
    }

    public void setTrabajadoresList(List<Trabajadores> trabajadoresList) {
        this.trabajadoresList = trabajadoresList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
        //El metodo devuelve la lsita de los usuarios
    }
    //Es un metodo publico con un nombre de gerUsuariosList() que devuelve una lista de objetos de Usuarios
    
    //Creacion ge getter and setter
    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Tipodeusuario getPerTipUs() {
        return perTipUs;
    }

    public void setPerTipUs(Tipodeusuario perTipUs) {
        this.perTipUs = perTipUs;
    }

    public Tipodedocumento getPerTidId() {
        return perTidId;
    }

    public void setPerTidId(Tipodedocumento perTidId) {
        this.perTidId = perTidId;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    @Override
    //Métodos estándar de Java para operaciones de comparación y representación de cadenas (hashCode(), equals(), toString()).
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    //Esta anotación indica que el método que sigue a continuación está destinado
    //a anular un método en la clase padre (en este caso, la clase Object).
    public boolean equals(Object object) {
        //Este es el método equals. Recibe un objeto como parámetro y devuelve un valor booleano 
        //(true si los objetos son iguales, false de lo contrario)
        if (!(object instanceof Personas)) {
            return false;
        }
        //Este bloque if comprueba si el objeto pasado como parámetro es una instancia de la clase Personas. 
        //Si no es así, se devuelve false, indicando que los objetos no son iguales. 
        Personas other = (Personas) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        //Este bloque if compara los identificadores (perId) de la instancia actual y la 
        //instancia proporcionada como parámetro. Si los identificadores son diferentes, 
        //se devuelve false. La comparación tiene en cuenta si uno o ambos identificadores son null.
        return true;
        //Si el método ha llegado hasta este punto, significa que los objetos son 
        //iguales en función de la comparación de identificadores, y se devuelve true.
    }

    @Override
    //sta anotación indica que el método que sigue a continuación está anulando el método toString heredado de la clase Object.
    public String toString() {
        //Este es el método toString. Devuelve una cadena que representa el objeto. 
        //Es común sobrescribir este método para proporcionar una representación de cadena más significativa del objeto.
        return "com.mycompany.proyectofinal1.entities.Personas[ perId=" + perId + " ]";
        //Este es el valor de retorno del método toString. La cadena resultante incluye el nombre de la clase 
        //(com.mycompany.proyectofinal1.entities.Personas) y el valor del atributo perId. Esto se hace para 
        //proporcionar una representación de cadena que identifique de manera única la instancia de la clase.
    }

    public void getPerTidId(Tipodedocumento TipDoc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void getPerTipUs(Tipodeusuario TipUsu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
