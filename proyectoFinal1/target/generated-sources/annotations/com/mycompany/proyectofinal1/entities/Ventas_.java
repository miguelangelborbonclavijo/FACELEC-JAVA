package com.mycompany.proyectofinal1.entities;

import com.mycompany.proyectofinal1.entities.Clientes;
import com.mycompany.proyectofinal1.entities.Codven;
import com.mycompany.proyectofinal1.entities.Productos;
import com.mycompany.proyectofinal1.entities.Trabajadores;
import com.mycompany.proyectofinal1.entities.Ventasacan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-12-14T19:37:29")
@StaticMetamodel(Ventas.class)
public class Ventas_ { 

    public static volatile SingularAttribute<Ventas, Integer> venId;
    public static volatile SingularAttribute<Ventas, Integer> venTot;
    public static volatile SingularAttribute<Ventas, Trabajadores> venTraId;
    public static volatile SingularAttribute<Ventas, Productos> venProId;
    public static volatile SingularAttribute<Ventas, Ventasacan> venAcId;
    public static volatile SingularAttribute<Ventas, Date> venFech;
    public static volatile SingularAttribute<Ventas, Clientes> venCliId;
    public static volatile SingularAttribute<Ventas, Codven> venCodId;
    public static volatile SingularAttribute<Ventas, Integer> venCan;

}