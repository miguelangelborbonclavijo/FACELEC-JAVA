package com.mycompany.proyectofinal1.entities;

import com.mycompany.proyectofinal1.entities.Compras;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-12-14T19:37:29")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile SingularAttribute<Proveedores, String> prDirr;
    public static volatile ListAttribute<Proveedores, Compras> comprasList;
    public static volatile SingularAttribute<Proveedores, Long> prCel;
    public static volatile SingularAttribute<Proveedores, Integer> prId;
    public static volatile SingularAttribute<Proveedores, String> prNomPr;

}