/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.controller;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
//import org.apache.commons.codec.net.;

import java.net.InetAddress;

/**
 *  Controlador para obtener la hora legal de un servidor NTP.
 * Utiliza la biblioteca Apache Commons Net para la conexión y consulta al servidor NTP.
 *
 * @author MIGUEL ANGEL BORBON
 */
public class ControllerHoraLegal {

    // Dirección del servidor NTP
    String servidor = "ntp2.inm.gov.co";

     // Método para establecer la conexión al servidor NTP y obtener la hora legal
    public String conexion() {
        try {
            // Creamos un cliente NTP
            NTPUDPClient timeClient = new NTPUDPClient();

            // Obtenemos la información de tiempo del servidor NTP
            InetAddress inetAddress = InetAddress.getByName(servidor);
            TimeInfo timeInfo = timeClient.getTime(inetAddress);

            // Obtenemos la hora del servidor y la imprimimos
            long serverTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
            
            // Convertimos la hora del servidor a una representación legible
            String formattedTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(serverTime));
            System.out.println("Hora formateada: " + formattedTime);

            // Cerramos el cliente NTP
            timeClient.close();
            
            return formattedTime;
        } catch (Exception e) {
            // En caso de error, se imprime el mensaje de error
            System.err.println(e);
            return "";
        }
    }
}
