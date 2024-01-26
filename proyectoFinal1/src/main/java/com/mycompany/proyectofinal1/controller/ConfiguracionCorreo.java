/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;
//Los objetos FileInputStream típicamente representan ficheros de 
//texto accedidos en orden secuencial, byte a byte. Con FileInputStream, 
//se puede elegir acceder a un byte, varios bytes o al fichero completo.
import java.io.FileInputStream;
//Importacion para hacer excepciones
import java.io.IOException;
// permite manipular archivos que almacenen de manera permanente una serie de 
//valores emparejados cada uno de ellos a un nombre, de manera similar a los nombre 
//de variables que almacenan valores en memoria.
import java.util.Properties;
//Contine toda la inforcmacin del estado de la solicitud que esta relacionada<a con 
//procedimiento de una unca solicitud de JSF.la respuesta es modificada en cada fase del
//ciclo de vida del prodedimiento de solicitud
import javax.faces.context.FacesContext;
//compartir información entre los distintos componentes web como Servlets y JSP.
//Los Servlets pueden dar soporte al contenido dinámico de páginas web, proporcionar acceso 
//a bases de datos, dar servicio a varios clientes al mismo tiempo y filtrar datos.
import javax.servlet.ServletContext;
//importamos el archivo CorreoBean
import com.mycompany.proyectofinal1.controller.CorreoBean;
//Creamos una clase publica ConfiguracionCorreo
public class ConfiguracionCorreo {

    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
    String PROPERTIES_FILE = servletContext.getRealPath("/resources/correo.properties");
    private Properties properties;
    
    public ConfiguracionCorreo() {
        properties = new Properties();   
        try {            
            properties.load(new FileInputStream(PROPERTIES_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSmtpHost() {
        return properties.getProperty("mail.smtp.host");
    }

    public int getSmtpPort() {
        return Integer.parseInt(properties.getProperty("mail.smtp.port"));
    }

    public boolean isSmtpAuth() {
        return Boolean.parseBoolean(properties.getProperty("mail.smtp.auth"));
    }

    public boolean isStartTlsEnabled() {
        return Boolean.parseBoolean(properties.getProperty("mail.smtp.starttls.enable"));
    }

    public String getSmtpUser() {
        return properties.getProperty("mail.smtp.user");
    }

    public String getSmtpPassword() {
        return properties.getProperty("mail.smtp.password");
    }
}
