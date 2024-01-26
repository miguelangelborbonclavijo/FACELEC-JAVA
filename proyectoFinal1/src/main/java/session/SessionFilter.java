/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
//Importacion para hacer una excepcion
import java.io.IOException;
//¿Qué es y para qué sirve servlet?
//Los Servlets pueden dar soporte al contenido dinámico de páginas web, 
//proporcionar acceso a bases de datos, dar servicio a varios clientes al mismo tiempo y filtrar datos. 


import javax.servlet.Filter;

import javax.servlet.FilterChain;
// puede utilizarse para invocar el filtro siguiente en la cadena de filtros.
import javax.servlet.FilterConfig;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//Define una clase llamada SessionFilter que implementa la interfaz Filter, lo 
//que significa que esta clase actuará como un filtro en una aplicación web.
public class SessionFilter implements Filter {

    @Override
    //ebe anular un método de una superclase
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialización del filtro (opcional)
        //Método de inicialización del filtro. Este método se llama cuando el filtro 
        //se inicializa. Puedes realizar cualquier tarea de configuración aquí.

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //Método de inicialización del filtro. Este método se llama cuando el filtro se inicializa. 
        //Puedes realizar cualquier tarea de configuración aquí.
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        //Se convierten los objetos request y response a tipos más específicos 
        //(HttpServletRequest y HttpServletResponse) para acceder a funcionalidades específicas de HTTP.
        HttpSession session = httpRequest.getSession(false);
        // Verificar si la solicitud es para la página de inicio de sesión
        if (httpRequest.getRequestURI().endsWith("/index.xhtml")) {
            // Continuar con la solicitud
            chain.doFilter(request, response);
        } else if (session == null || session.getAttribute("usuario") == null) {
            // La sesión o la variable de sesión "usuario" es nula, redirigir a la página de inicio de sesión
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.xhtml");
        } else {
            // Continuar con la solicitud
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Limpieza del filtro (opcional)
    }
}