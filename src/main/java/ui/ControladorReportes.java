/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.JLabel;
import modelos.Reporte;

/**
 *
 * @author Luis Monterroso
 */
public class ControladorReportes {

    private JLabel labelMayorPasos2;
    private JLabel labelMayorPasos3;
    private JLabel labelMayorPasos4;
    private JLabel labelMenorPasos2;
    private JLabel labelMenorPasos3;
    private JLabel labelMenorPasos4;
    private JLabel labelPromPasos2;
    private JLabel labelPromPasos3;
    private JLabel labelPromPasos4;
    private JLabel labelTiempo2;
    private JLabel labelTiempo3;
    private JLabel labelTiempo4;
    private Reporte reporteSerivicio2;
    private Reporte reporteServicio3;
    private Reporte reporteServicio4;

    public ControladorReportes(JLabel labelMayorPasos2, JLabel labelMayorPasos3,
            JLabel labelMayorPasos4, JLabel labelMenorPasos2, JLabel labelMenorPasos3, 
            JLabel labelMenorPasos4, JLabel labelPromPasos2, JLabel labelPromPasos3, 
            JLabel labelPromPasos4, JLabel labelTiempo2, JLabel labelTiempo3, 
            JLabel labelTiempo4, Reporte reporteSerivicio2, Reporte reporteServicio3, Reporte reporteServicio4) {
        this.labelMayorPasos2 = labelMayorPasos2;
        this.labelMayorPasos3 = labelMayorPasos3;
        this.labelMayorPasos4 = labelMayorPasos4;
        this.labelMenorPasos2 = labelMenorPasos2;
        this.labelMenorPasos3 = labelMenorPasos3;
        this.labelMenorPasos4 = labelMenorPasos4;
        this.labelPromPasos2 = labelPromPasos2;
        this.labelPromPasos3 = labelPromPasos3;
        this.labelPromPasos4 = labelPromPasos4;
        this.labelTiempo2 = labelTiempo2;
        this.labelTiempo3 = labelTiempo3;
        this.labelTiempo4 = labelTiempo4;
        this.reporteSerivicio2 = reporteSerivicio2;
        this.reporteServicio3 = reporteServicio3;
        this.reporteServicio4 = reporteServicio4;
    }

    public void reporteParaServicio2() {
        try {
            labelPromPasos2.setText(reporteSerivicio2.getTotalPasos() / reporteSerivicio2.getVecesQueSeEjecuto() + " pasos");//seteamos el texto con el primedio
            labelTiempo2.setText(reporteSerivicio2.getTotalDeTiempo() / reporteSerivicio2.getVecesQueSeEjecuto() + " milisegundos");//seteamos el tiempo promedio
            labelMayorPasos2.setText(ordenarDesendentemente(reporteSerivicio2.getListaDeEntero().toArray())[0] + " pasos");
            labelMenorPasos2.setText(ordenarAsendentemente(reporteSerivicio2.getListaDeEntero().toArray())[0] + " pasos");
        } catch (Exception e) {
        }

    }

    public void reporteParaServicio3() {
        try {
            labelPromPasos3.setText(reporteServicio3.getTotalPasos() / reporteServicio3.getVecesQueSeEjecuto() + " pasos");//seteamos el texto con el primedio
            labelTiempo3.setText(reporteServicio3.getTotalDeTiempo() / reporteServicio3.getVecesQueSeEjecuto() + " milisegundos");//seteamos el tiempo promedio
            labelMayorPasos3.setText(ordenarDesendentemente(reporteServicio3.getListaDeEntero().toArray())[0] + " pasos");
            labelMenorPasos3.setText(ordenarAsendentemente(reporteServicio3.getListaDeEntero().toArray())[0] + " pasos");
        } catch (Exception e) {
        }

    }

    public void reporteParaServicio4() {
        try {
            labelPromPasos4.setText(reporteServicio4.getTotalPasos() / reporteServicio4.getVecesQueSeEjecuto() + " pasos");//seteamos el texto con el primedio
            labelTiempo4.setText(reporteServicio4.getTotalDeTiempo() / reporteServicio4.getVecesQueSeEjecuto() + " milisegundos");//seteamos el tiempo promedio
            labelMayorPasos4.setText(ordenarDesendentemente(reporteServicio4.getListaDeEntero().toArray())[0] + " pasos");
            labelMenorPasos4.setText(ordenarAsendentemente(reporteServicio4.getListaDeEntero().toArray())[0] + " pasos");
        } catch (Exception e) {
        }

    }

    public Integer[] ordenarAsendentemente(Integer[] cantidadDePasos) {
        int n = cantidadDePasos.length;
        Integer temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (cantidadDePasos[j - 1] > cantidadDePasos[j]) {
                    temp = cantidadDePasos[j - 1];
                    cantidadDePasos[j - 1] = cantidadDePasos[j];
                    cantidadDePasos[j] = temp;
                }
            }
        }
        return cantidadDePasos;
    }

    public Integer[] ordenarDesendentemente(Integer[] cantidadDePasos) {
        int n = cantidadDePasos.length;
        Integer temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (cantidadDePasos[j - 1] < cantidadDePasos[j]) {
                    temp = cantidadDePasos[j - 1];
                    cantidadDePasos[j - 1] = cantidadDePasos[j];
                    cantidadDePasos[j] = temp;
                }
            }
        }
        return cantidadDePasos;
    }
}
