package com.mycompany.proyectofinal1.entities;

import com.mycompany.proyectofinal1.entities.Clientesestado;
import com.mycompany.proyectofinal1.entities.Codven;
import com.mycompany.proyectofinal1.entities.Personas;
import com.mycompany.proyectofinal1.entities.Soporte;
import com.mycompany.proyectofinal1.entities.Tipodeclientes;
import com.mycompany.proyectofinal1.entities.Ventas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-12-14T19:37:29")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, Integer> cliPerId;
    public static volatile SingularAttribute<Clientes, Clientesestado> cliEsId;
    public static volatile ListAttribute<Clientes, Soporte> soporteList;
    public static volatile ListAttribute<Clientes, Codven> codvenList;
    public static volatile SingularAttribute<Clientes, String> cliDirr;
    public static volatile ListAttribute<Clientes, Ventas> ventasList;
    public static volatile SingularAttribute<Clientes, Personas> personas;
    public static volatile SingularAttribute<Clientes, Tipodeclientes> cilTipId;

}