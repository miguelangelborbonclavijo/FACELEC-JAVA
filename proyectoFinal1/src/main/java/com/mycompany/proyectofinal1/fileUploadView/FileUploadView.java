/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyectofinal1.fileUploadView;

import com.mycompany.proyectofinal1.entities.Tipodeproducto;
import com.mycompany.proyectofinal1.model.TipodeproductoFacadeLocal;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author MIGUEL ANGEL BORBON
 */
// Nombre del bean en el ámbito de JSF
@Named(value = "fileUploadView")
// Ámbito de vista, indicando que el bean vive mientras la vista está activa
@ViewScoped
public class FileUploadView implements Serializable {

    // Atributos de la clase
    private UploadedFile file;
    private Tipodeproducto Tipro;
    @EJB // Inyección de dependencia para el EJB que gestiona la entidad Tipodeproducto
    private TipodeproductoFacadeLocal TipProfl;

    // Constructor vacío
    public FileUploadView() {
    }

    // Métodos Getter y Setter para el atributo 'file'
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

     // Métodos Getter y Setter para el atributo 'Tipro'
    public Tipodeproducto getTipro() {
        return Tipro;
    }

    public void setTipro(Tipodeproducto Tipro) {
        this.Tipro = Tipro;
    }

     // Método que se ejecuta después de la construcción del bean
    @PostConstruct
    public void ini() {
        Tipro = new Tipodeproducto();
    }

     // Método para cargar Tipodeproducto desde un archivo Excel
    public void cargarTipodeproducto() {
        if (file.getSize() > 0) {
            try {
                // Obtener el flujo de entrada desde el archivo cargado
                InputStream InputStream = file.getInputStream();
                XSSFWorkbook libro = new XSSFWorkbook(InputStream);
                // Obtener la primera hoja del libro
                Sheet sheet = libro.getSheetAt(0);
                // Obtener un iterador para recorrer las filas de la hoja
                Iterator<Row> iterator = sheet.iterator();
                // Iterar sobre las filas del archivo Excel
                while (iterator.hasNext()) {
                    Row currentRow = iterator.next();
                    if (currentRow.getCell(0) != null) {
                         // Establecer el nombre del tipo de producto desde la primera celda de la fila
                        Tipro.setTipNom(currentRow.getCell(0).getStringCellValue());
                        this.TipProfl.create(Tipro);
                    } else {
                        break;// Salir del bucle si la primera celda es nula
                    }
                }
                libro.close(); // Cerrar el libro de Excel y mostrar un mensaje de éxito
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, " ", "Archivo cargado correctamente");
                FacesContext.getCurrentInstance().addMessage(null, fm);
            } catch (IOException ex) {
                // Manejar las excepciones de E/S
                Logger.getLogger(FileUploadView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Mostrar un mensaje si no se ha seleccionado ningún archivo
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, " ", "Debe seleccionar un archivo");
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }
}
