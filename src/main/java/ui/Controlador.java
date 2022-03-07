/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Luis Monterroso
 */
public class Controlador {

    public void exportarTexto(String texto) {
        JFileChooser chooser = new JFileChooser();//creamos el chooser
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");//este filtro muestra solo los .txt
        chooser.setFileFilter(filter);//este metodo setea el filtro al chooser
        chooser.setDialogTitle("Guardar apuestas rechazadas");//le damos titulo al dialog
        chooser.setAcceptAllFileFilterUsed(false);//quitamos la opcion de mostrar todos los archivos
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {//esperamos a que el chooser de una respuesta valida
            String ruta = chooser.getSelectedFile().toString().concat(".txt");//seleccionamos la ruta que eligio el usuario le concatenamos el .txt
            File archivoDeTexto = new File(ruta);//creamos un archivo con la ruta y nombre que le dio el usuario
            try {
                FileWriter exportador = new FileWriter(archivoDeTexto);//preparar el archivo que se exportara
                exportador.write(texto);//le escribimos al archivo el texto que se quiere exportar     
                exportador.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
