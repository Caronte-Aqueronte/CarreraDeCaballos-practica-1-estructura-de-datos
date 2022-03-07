/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelos.Apuesta;
import modelos.ListaDeApuestas;
import modelos.Reporte;
import modelos.Resultado;

/**
 *
 * @author Luis Monterroso
 */
public class ControladorDeResultados extends Controlador {

    private ListaDeApuestas listaDeApuestas;
    private JTextField txtPos1;
    private JTextField txtPos10;
    private JTextField txtPos2;
    private JTextField txtPos3;
    private JTextField txtPos4;
    private JTextField txtPos5;
    private JTextField txtPos6;
    private JTextField txtPos7;
    private JTextField txtPos8;
    private JTextField txtPos9;
    private JFrame ventana;
    private Resultado[] resultados;
    private JTable tablaResultados;
    private Reporte reporteSerivicio2;
    private Reporte reporteServicio3;
    private Reporte reporteServicio4;

    public ControladorDeResultados(ListaDeApuestas listaDeApuestas, JTextField txtPos1,
            JTextField txtPos10, JTextField txtPos2, JTextField txtPos3, JTextField txtPos4,
            JTextField txtPos5, JTextField txtPos6, JTextField txtPos7, JTextField txtPos8, JTextField txtPos9,
            JFrame ventana, JTable tablaResultados, Reporte reporteSerivicio2, Reporte reporteServicio3, Reporte reporteServicio4) {
        this.listaDeApuestas = listaDeApuestas;
        this.txtPos1 = txtPos1;
        this.txtPos10 = txtPos10;
        this.txtPos2 = txtPos2;
        this.txtPos3 = txtPos3;
        this.txtPos4 = txtPos4;
        this.txtPos5 = txtPos5;
        this.txtPos6 = txtPos6;
        this.txtPos7 = txtPos7;
        this.txtPos8 = txtPos8;
        this.txtPos9 = txtPos9;
        this.ventana = ventana;
        this.reporteSerivicio2 = reporteSerivicio2;
        this.reporteServicio3 = reporteServicio3;
        this.reporteServicio4 = reporteServicio4;
        this.tablaResultados = tablaResultados;
        resultados = new Resultado[listaDeApuestas.getSize()];
    }

    public void comenzarAnalisis() {
        try {
            int[] resultadosReales = new int[10];
            resultadosReales[0] = Integer.parseInt(txtPos1.getText());
            resultadosReales[1] = Integer.parseInt(txtPos2.getText());
            resultadosReales[2] = Integer.parseInt(txtPos3.getText());
            resultadosReales[3] = Integer.parseInt(txtPos4.getText());
            resultadosReales[4] = Integer.parseInt(txtPos5.getText());
            resultadosReales[5] = Integer.parseInt(txtPos6.getText());
            resultadosReales[6] = Integer.parseInt(txtPos7.getText());
            resultadosReales[7] = Integer.parseInt(txtPos8.getText());
            resultadosReales[8] = Integer.parseInt(txtPos9.getText());
            resultadosReales[9] = Integer.parseInt(txtPos10.getText());
            Apuesta[] apuestasArray = listaDeApuestas.toArray();

            for (int x = 0; x < apuestasArray.length; x++) {
                resultados[x] = new Resultado(apuestasArray[x].getNombreApostador(), analizarResultados(resultadosReales, apuestasArray[x]));
            }

            //mostramos los resultaso en la tabla
            ordenarResultadosPorNombre();
            llenarTabla();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ventana, "Valores numéricos con formato inválido o nulo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int analizarResultados(int[] resultados, Apuesta apuesta) {
        long inicio = System.currentTimeMillis();//contamos el tiempo de ejecucion en este punto
        int canditadDePasos = 0;
        int total = 0;
        for (int x = 0; x < resultados.length; x++) {//por cada poscion de resultados obtenemos  el numero del caballao en la apuesta y asi logramos O(n)
            if (resultados[x] == apuesta.getCaballos()[x].getNumero()) {
                total += 10 - x;//restamos a 10 la posicion que se acerto y la sumamos al total
            }
            canditadDePasos++;
        }

        long fin = System.currentTimeMillis();//contamos el tiempo de ejecucion en este punto
        long tiempo = ((fin - inicio));//pasamos a segundos el tiempo que sera diferencia entre los dos
        reporteServicio3.setTotalDeTiempo(reporteServicio3.getTotalDeTiempo() + tiempo);//sumamos el total del tiempo para este servicio
        reporteServicio3.setTotalPasos(reporteServicio3.getTotalPasos() + canditadDePasos);//sumamos los pasos al total de pasos
        reporteServicio3.setVecesQueSeEjecuto(reporteServicio3.getVecesQueSeEjecuto() + 1);//sumamos la ejecucion al total de ejecuciones
        reporteServicio3.getListaDeEntero().insertarNodo(canditadDePasos);//anadimos los pasos a la lista del objeto

        return total;//retornamos el total
    }

    public void llenarTabla() {
        try {
            Object[] cabezeras = {"Nombre del apostador", "Punteo"};//seran el nombre delas columnas
            Object[][] resultadosData = new Object[resultados.length][cabezeras.length];//creamos una matriz de datos
            for (int x = 0; x < resultados.length; x++) {//por cada elemento de los resultados anadimos a los datos
                resultadosData[x][0] = resultados[x].getNombreapostador();
                resultadosData[x][1] = resultados[x].getPunteo();
            }
            DefaultTableModel defaultTableModel = new DefaultTableModel(resultadosData, cabezeras);//creamos un default table model con los cabezales y y los datos
            tablaResultados.setModel(defaultTableModel);//a la tabla le damos el modelo
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(ventana, "Datos nulos.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void ordenarResultadosPorNombre() {
        long inicio = System.currentTimeMillis();//contamos el tiempo de ejecucion en este punto
        int canditadDePasos = 0;
        int n = resultados.length;
        Resultado temp = new Resultado("", 0);
        try {
            //si implementa un bubble sort donde se compara los punteos y asi se va haciendo los cambios de posiciones
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    if (resultados[j - 1].getNombreapostador().compareTo(resultados[j].getNombreapostador()) > 0) {
                        temp = resultados[j - 1];
                        resultados[j - 1] = resultados[j];
                        resultados[j] = temp;
                    }
                    canditadDePasos++;
                }
                canditadDePasos++;
            }
            long fin = System.currentTimeMillis();//contamos el tiempo de ejecucion en este punto
            long tiempo = ((fin - inicio));//pasamos a segundos el tiempo que sera diferencia entre los dos
            reporteServicio4.setTotalDeTiempo(reporteServicio4.getTotalDeTiempo() + tiempo);//sumamos el total del tiempo para este servicio
            reporteServicio4.setTotalPasos(reporteServicio4.getTotalPasos() + canditadDePasos);//sumamos los pasos al total de pasos
            reporteServicio4.setVecesQueSeEjecuto(reporteServicio4.getVecesQueSeEjecuto() + 1);//sumamos la ejecucion al total de ejecuciones
            reporteServicio4.getListaDeEntero().insertarNodo(canditadDePasos);//anadimos los pasos a la lista del objeto
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(ventana, "Datos nulos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ordenarResultadosPorResultado() {
        long inicio = System.currentTimeMillis();//contamos el tiempo de ejecucion en este punto
        int canditadDePasos = 0;
        int n = resultados.length;
        Resultado temp = new Resultado("", 0);
        try {
            //si implementa un buebble sort donde se compara los punteos y asi se va haciendo los cambios de posiciones
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    if (resultados[j - 1].getPunteo() < resultados[j].getPunteo()) {
                        temp = resultados[j - 1];
                        resultados[j - 1] = resultados[j];
                        resultados[j] = temp;
                    }
                    canditadDePasos++;
                }
                canditadDePasos++;
            }
            long fin = System.currentTimeMillis();//contamos el tiempo de ejecucion en este punto
            long tiempo = ((fin - inicio));//pasamos a segundos el tiempo que sera diferencia entre los dos
            reporteServicio4.setTotalDeTiempo(reporteServicio4.getTotalDeTiempo() + tiempo);//sumamos el total del tiempo para este servicio
            reporteServicio4.setTotalPasos(reporteServicio4.getTotalPasos() + canditadDePasos);//sumamos los pasos al total de pasos
            reporteServicio4.setVecesQueSeEjecuto(reporteServicio4.getVecesQueSeEjecuto() + 1);//sumamos la ejecucion al total de ejecuciones
            reporteServicio4.getListaDeEntero().insertarNodo(canditadDePasos);//anadimos los pasos a la lista del objeto
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(ventana, "Datos nulos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void exportarDatos() {
        String textoAExportar = "";
        try {
            for (int x = 0; x < resultados.length; x++) {//iteramos dentro de los resultados
                textoAExportar += "Nombre del apostador: " + resultados[x].getNombreapostador()
                        + ", Punteo obtenido: " + resultados[x].getPunteo() + "\n";//por cada resultado escribir una linea en el string con las caracteristicas del objeto em x
            }
            exportarTexto(textoAExportar);//mandamos a exportar el texto
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(ventana, "Datos nulos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void otraCarrera() {
        MenuPrincipal menuPrincipal = new MenuPrincipal(reporteSerivicio2, reporteServicio3, reporteServicio4);
        menuPrincipal.setVisible(true);
        ventana.dispose();
    }
}
