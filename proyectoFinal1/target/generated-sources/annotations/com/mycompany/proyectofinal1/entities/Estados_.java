package com.mycompany.proyectofinal1.entities;

import com.mycompany.proyectofinal1.entities.Soporte;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-12-14T19:37:29")
@StaticMetamodel(Estados.class)
public class Estados_ { 

    public static volatile SingularAttribute<Estados, Integer> estId;
    public static volatile SingularAttribute<Estados, String> estNom;
    public static volatile ListAttribute<Estados, Soporte> soporteList;

}