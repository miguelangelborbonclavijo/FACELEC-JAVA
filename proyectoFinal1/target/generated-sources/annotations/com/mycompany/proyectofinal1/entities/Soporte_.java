package com.mycompany.proyectofinal1.entities;

import com.mycompany.proyectofinal1.entities.Clientes;
import com.mycompany.proyectofinal1.entities.Estados;
import com.mycompany.proyectofinal1.entities.Tipodesoporte;
import com.mycompany.proyectofinal1.entities.Tipodeusuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-12-14T19:37:29")
@StaticMetamodel(Soporte.class)
public class Soporte_ { 

    public static volatile SingularAttribute<Soporte, String> sopDesc;
    public static volatile SingularAttribute<Soporte, Estados> sopEstId;
    public static volatile SingularAttribute<Soporte, Tipodesoporte> sopTiS;
    public static volatile SingularAttribute<Soporte, Integer> sopoId;
    public static volatile SingularAttribute<Soporte, Clientes> sopDoCl;
    public static volatile SingularAttribute<Soporte, Tipodeusuario> sopTiCl;
    public static volatile SingularAttribute<Soporte, Date> sopFe;

}