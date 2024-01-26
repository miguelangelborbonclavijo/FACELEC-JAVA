/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
// permite manipular archivos que almacenen de manera permanente una serie de 
//valores emparejados cada uno de ellos a un nombre, de manera similar a los nombre 
//de variables que almacenan valores en memoria.
import java.util.Properties;
import com.mycompany.proyectofinal1.controller.ConfiguracionCorreo;

@Named(value = "correoBean")
//cuando solo se despliegan datos en la página asociada. 
@RequestScoped
//cremaos una clases publica CorreoBean
public class CorreoBean {
    
    //Llamamos a ConfigurcionCorreo y le asignamos un nombre
    // Atributo para la configuración de correo
    ConfiguracionCorreo configuracion;
    //Representamos los atributos de la clase
    // Atributos para la información del correo
    private String destinatario;
    private String asunto;
    private String mensaje;

    //Creamos los Getter and Setter
    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    //Creamos un metodo con un modificador publico de tipo entero con nombre de enviarCorreo
    // Método para enviar correo
    public String enviarCorreo() {
        //Creamos un objeto de archivo de ConfiguracionCorreo
        // Instancia de ConfiguracionCorreo
        //Se llama instancia a todo objeto que derive de algún otro. De esta forma, todos 
        //los objetos son instancias de algún otro, menos la clase Object que es la madre de todas.
        configuracion = new ConfiguracionCorreo();
        
         // Configuración de propiedades para la sesión de correo
        Properties props = new Properties();
        props.put("mail.smtp.host", configuracion.getSmtpHost());
        props.put("mail.smtp.port", configuracion.getSmtpPort());
        props.put("mail.smtp.auth", configuracion.isSmtpAuth());
        props.put("mail.smtp.starttls.enable", configuracion.isStartTlsEnabled());
        props.put("mail.smtp.ssl.trust", configuracion.getSmtpHost());
         // Creación de la sesión de correo
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        configuracion.getSmtpUser(),
                        configuracion.getSmtpPassword()
                );
            }
        });

        try {
            // Creación del mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(configuracion.getSmtpUser()));
            String[] correos = destinatario.split(" ");
            message.setSubject(asunto);
            message.setText(mensaje);
            // Envío del correo a cada destinatario
            for (String correo : correos) {
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
                Transport.send(message);
            }
            
            return "exito"; // Página de éxito
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "error"; // Página de error
        }
    }
}
