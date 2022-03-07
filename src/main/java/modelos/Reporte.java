/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Luis Monterroso
 */
public class Reporte {
    
    private double totalDeTiempo;
    private double totalPasos;
    private double vecesQueSeEjecuto;
    private ListaDeEntero listaDeEntero;

    public Reporte(double totalDeTiempo, double totaPasos, double vecesQueSeEjecuto, ListaDeEntero listaDeEntero) {
        this.totalDeTiempo = totalDeTiempo;
        this.totalPasos = totaPasos;
        this.vecesQueSeEjecuto = vecesQueSeEjecuto;
        this.listaDeEntero = listaDeEntero;
    }

    public double getTotalDeTiempo() {
        return totalDeTiempo;
    }

    public void setTotalDeTiempo(double totalDeTiempo) {
        this.totalDeTiempo = totalDeTiempo;
    }

    public double getTotalPasos() {
        return totalPasos;
    }

    public void setTotalPasos(double totaPasos) {
        this.totalPasos = totaPasos;
    }

    public double getVecesQueSeEjecuto() {
        return vecesQueSeEjecuto;
    }

    public void setVecesQueSeEjecuto(double vecesQueSeEjecuto) {
        this.vecesQueSeEjecuto = vecesQueSeEjecuto;
    }

    public ListaDeEntero getListaDeEntero() {
        return listaDeEntero;
    }

    public void setListaDeEntero(ListaDeEntero listaDeEntero) {
        this.listaDeEntero = listaDeEntero;
    }
    
    
}
