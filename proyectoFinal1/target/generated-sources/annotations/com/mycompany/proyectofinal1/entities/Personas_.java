package com.mycompany.proyectofinal1.entities;

import com.mycompany.proyectofinal1.entities.Clientes;
import com.mycompany.proyectofinal1.entities.Tipodedocumento;
import com.mycompany.proyectofinal1.entities.Tipodeusuario;
import com.mycompany.proyectofinal1.entities.Trabajadores;
import com.mycompany.proyectofinal1.entities.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-12-14T19:37:29")
@StaticMetamodel(Personas.class)
public class Personas_ { 

    public static volatile SingularAttribute<Personas, String> perApe2;
    public static volatile SingularAttribute<Personas, Integer> perId;
    public static volatile SingularAttribute<Personas, String> perApe1;
    public static volatile ListAttribute<Personas, Usuarios> usuariosList;
    public static volatile ListAttribute<Personas, Trabajadores> trabajadoresList;
    public static volatile SingularAttribute<Personas, String> perDirr;
    public static volatile SingularAttribute<Personas, Date> perFech;
    public static volatile SingularAttribute<Personas, String> perNom1;
    public static volatile SingularAttribute<Personas, Clientes> clientes;
    public static volatile SingularAttribute<Personas, String> perNom2;
    public static volatile SingularAttribute<Personas, Tipodeusuario> perTipUs;
    public static volatile SingularAttribute<Personas, Tipodedocumento> perTidId;

}