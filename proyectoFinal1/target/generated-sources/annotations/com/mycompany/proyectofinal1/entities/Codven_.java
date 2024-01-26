package com.mycompany.proyectofinal1.entities;

import com.mycompany.proyectofinal1.entities.Clientes;
import com.mycompany.proyectofinal1.entities.Facturacion;
import com.mycompany.proyectofinal1.entities.Trabajadores;
import com.mycompany.proyectofinal1.entities.Ventas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-12-14T19:37:29")
@StaticMetamodel(Codven.class)
public class Codven_ { 

    public static volatile SingularAttribute<Codven, Date> codFec;
    public static volatile SingularAttribute<Codven, Trabajadores> codTraId;
    public static volatile SingularAttribute<Codven, Clientes> codVenCl;
    public static volatile ListAttribute<Codven, Ventas> ventasList;
    public static volatile SingularAttribute<Codven, Integer> codVenId;
    public static volatile ListAttribute<Codven, Facturacion> facturacionList;

}