package com.mycompany.proyectofinal1.entities;

import com.mycompany.proyectofinal1.entities.Personas;
import com.mycompany.proyectofinal1.entities.Tipodeusuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-12-14T19:37:29")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, Integer> usuId;
    public static volatile SingularAttribute<Usuarios, String> contrasena;
    public static volatile SingularAttribute<Usuarios, Tipodeusuario> tipoUsuario;
    public static volatile SingularAttribute<Usuarios, Personas> usuario;
    public static volatile SingularAttribute<Usuarios, String> nombre;

}