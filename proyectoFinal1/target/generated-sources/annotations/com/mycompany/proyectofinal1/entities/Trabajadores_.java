package com.mycompany.proyectofinal1.entities;

import com.mycompany.proyectofinal1.entities.Cartrab;
import com.mycompany.proyectofinal1.entities.Codven;
import com.mycompany.proyectofinal1.entities.Compras;
import com.mycompany.proyectofinal1.entities.Personas;
import com.mycompany.proyectofinal1.entities.Ventas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-12-14T19:37:29")
@StaticMetamodel(Trabajadores.class)
public class Trabajadores_ { 

    public static volatile ListAttribute<Trabajadores, Compras> comprasList;
    public static volatile ListAttribute<Trabajadores, Codven> codvenList;
    public static volatile SingularAttribute<Trabajadores, Integer> traId;
    public static volatile ListAttribute<Trabajadores, Ventas> ventasList;
    public static volatile SingularAttribute<Trabajadores, Integer> traHor;
    public static volatile SingularAttribute<Trabajadores, Personas> traPerId;
    public static volatile SingularAttribute<Trabajadores, Cartrab> traCarId;
    public static volatile SingularAttribute<Trabajadores, Integer> traSalario;

}