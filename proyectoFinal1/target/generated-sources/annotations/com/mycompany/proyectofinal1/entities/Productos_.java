package com.mycompany.proyectofinal1.entities;

import com.mycompany.proyectofinal1.entities.Compras;
import com.mycompany.proyectofinal1.entities.Reporteproductos;
import com.mycompany.proyectofinal1.entities.Tipodeproducto;
import com.mycompany.proyectofinal1.entities.Ventas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-12-14T19:37:29")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, Integer> proPreCo;
    public static volatile SingularAttribute<Productos, Integer> proPreVe;
    public static volatile ListAttribute<Productos, Compras> comprasList;
    public static volatile SingularAttribute<Productos, Tipodeproducto> proTip;
    public static volatile SingularAttribute<Productos, Integer> proId;
    public static volatile ListAttribute<Productos, Ventas> ventasList;
    public static volatile SingularAttribute<Productos, String> proDes;
    public static volatile ListAttribute<Productos, Reporteproductos> reporteproductosList;

}