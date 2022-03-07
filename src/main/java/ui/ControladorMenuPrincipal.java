/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import lector.LectorDeTexto;
import modelos.Apuesta;
import modelos.ListaDeApuestas;
import modelos.Nodo;
import modelos.Reporte;

/**
 *
 * @author Luis Monterroso
 */
public class ControladorMenuPrincipal extends Controlador {

    private JButton btnBuscar;
    private JButton btnCerrar;
    private JTextArea txtEntrada;
    private JTextField txtPath;
    private JFrame ventana;
    private ListaDeApuestas listaDeApuestas;
    private Reporte reporteSerivicio2;
    private Reporte reporteServicio3;
    private Reporte reporteServicio4;

    public ControladorMenuPrincipal(JButton btnBuscar, JButton btnCerrar, JTextArea txtEntrada, JTextField txtPath, JFrame ventana,
             Reporte reporteSerivicio2, Reporte reporteServicio3, Reporte reporteServicio4) {
        this.btnBuscar = btnBuscar;
        this.btnCerrar = btnCerrar;
        this.txtEntrada = txtEntrada;
        this.txtPath = txtPath;
        this.ventana = ventana;
        this.reporteSerivicio2 = reporteSerivicio2;
        this.reporteServicio3 = reporteServicio3;
        this.reporteServicio4 = reporteServicio4;
        listaDeApuestas = new ListaDeApuestas(this.reporteSerivicio2);
    }

    public void seleccionarArchivo() {
        //creamos un JFileChoooser que es la ventanan que deja al ususario elegir el archivo
        JFileChooser filechooser = new JFileChooser();
        //creamos el filtro de txt
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
        FileNameExtensionFilter filtro2 = new FileNameExtensionFilter("*.CSV", "csv");
        //anadimos el filtro al jfilechoooser
         filechooser.setFileFilter(filtro);
         filechooser.setFileFilter(filtro2);
        //eliminamos la opcion todos los archivos delJFileChooser
        filechooser.setAcceptAllFileFilterUsed(false);
        //abrimos el filechosssr
        int seleccion = filechooser.showOpenDialog(ventana);
        //validamos la eleccion del ususairo
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //decimos que el fichero sera igual al archivo elegido
            File fichero = filechooser.getSelectedFile();
            //el txtxpatch escribira la direccion del archivo
            txtPath.setText(fichero.getAbsolutePath());
            //mandamos a cargar el texto al txt
            cargarTextoATxtArea(fichero);
        }
    }

    private void cargarTextoATxtArea(File archivo) {
        txtEntrada.setText("");//borramos el texto del textArea en caso lo haya
        String linea;//variable donde se guardara el texto dde las lineas leidas
        try {
            FileReader fr = new FileReader(archivo);//inicializamos el reader
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                txtEntrada.append(linea + "\n");
            }
        } catch (IOException ex) {
        }
    }

    public void mandarALeerElTexto() {
        listaDeApuestas = new ListaDeApuestas(reporteSerivicio2);//vaciamos la lista para ecitar errores
        String textoEntrda = txtEntrada.getText();
        if (!textoEntrda.isBlank()) {
            try {
                //verificamos que la entrada no este en blanco
                Reader reader = new StringReader(textoEntrda);//creamos el reader que contendra el texto a nalizar
                LectorDeTexto lectorDeTexto = new LectorDeTexto(listaDeApuestas, reader);//creamos un nuevo lector de texto
                lectorDeTexto.leerArchivo();//leemos el archivo
            } catch (IOException | NumberFormatException | IndexOutOfBoundsException ex) {//caso de error entonces hay un error en el archivo de entrada
                JOptionPane.showMessageDialog(ventana, "Error en la entrada.", "Error", JOptionPane.ERROR_MESSAGE);
                listaDeApuestas = new ListaDeApuestas(reporteSerivicio2);//vaciamos la lista para ecitar errores
            }
        } else {
            JOptionPane.showMessageDialog(ventana, "Texto vacio.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void exportarErrores() {
        ListaDeApuestas errores = listaDeApuestas.analizarApuestas();//mandamos a analizar las apuestas
        if (errores.getSize() > 0) {
            Nodo nodoActual = errores.getRaiz();
            String textoErrores = "";
            //ahora exportamos 
            for (int x = 0; x < errores.getSize(); x++) {
                Apuesta apuestaActual = (Apuesta) nodoActual.getValor();
                textoErrores += apuestaActual.getNombreApostador() + ", " + apuestaActual.getApuesta()
                        + ", ";
                for (int y = 0; y < apuestaActual.getCaballos().length; y++) {
                    if (y != apuestaActual.getCaballos().length - 1) {
                        textoErrores += apuestaActual.getCaballos()[y].getNumero() + ", ";
                    } else {
                        textoErrores += apuestaActual.getCaballos()[y].getNumero() + "\n";
                    }
                }
                nodoActual = nodoActual.getSiguiente();
            }
            exportarTexto(textoErrores);//mandamos a exportar el texto obtenido
        } else {
            JOptionPane.showMessageDialog(ventana, "No se rechazó ninguna apuesta.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public ListaDeApuestas getListaDeApuestas() {
        return listaDeApuestas;
    }

    public void setListaDeApuestas(ListaDeApuestas listaDeApuestas) {
        this.listaDeApuestas = listaDeApuestas;
    }

}
