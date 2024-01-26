package com.mycompany.proyectofinal1.entities;

import com.mycompany.proyectofinal1.entities.Personas;
import com.mycompany.proyectofinal1.entities.Soporte;
import com.mycompany.proyectofinal1.entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-12-14T19:37:28")
@StaticMetamodel(Tipodeusuario.class)
public class Tipodeusuario_ { 

    public static volatile ListAttribute<Tipodeusuario, Usuarios> usuariosList;
    public static volatile SingularAttribute<Tipodeusuario, Integer> tipId;
    public static volatile SingularAttribute<Tipodeusuario, String> tipUsu;
    public static volatile ListAttribute<Tipodeusuario, Soporte> soporteList;
    public static volatile ListAttribute<Tipodeusuario, Personas> personasList;

}