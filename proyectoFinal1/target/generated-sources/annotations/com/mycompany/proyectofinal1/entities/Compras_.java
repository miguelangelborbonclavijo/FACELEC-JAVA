package com.mycompany.proyectofinal1.entities;

import com.mycompany.proyectofinal1.entities.Productos;
import com.mycompany.proyectofinal1.entities.Proveedores;
import com.mycompany.proyectofinal1.entities.Trabajadores;
import com.mycompany.proyectofinal1.entities.Ventasacan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-12-14T19:37:29")
@StaticMetamodel(Compras.class)
public class Compras_ { 

    public static volatile SingularAttribute<Compras, Trabajadores> comTraId;
    public static volatile SingularAttribute<Compras, Integer> comCan;
    public static volatile SingularAttribute<Compras, Productos> comPrId;
    public static volatile SingularAttribute<Compras, Ventasacan> comEs;
    public static volatile SingularAttribute<Compras, Proveedores> comPvId;
    public static volatile SingularAttribute<Compras, Integer> comId;
    public static volatile SingularAttribute<Compras, Date> comFec;

}