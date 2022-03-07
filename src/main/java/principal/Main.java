/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import modelos.ListaDeEntero;
import modelos.Reporte;
import ui.MenuPrincipal;

/**
 *
 * @author Luis Monterroso
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Reporte reporteSerivicio2 = new Reporte(0, 0, 0, new ListaDeEntero());
        Reporte reporteServicio3 = new Reporte(0, 0, 0, new ListaDeEntero());
        Reporte reporteServicio4 = new Reporte(0, 0, 0, new ListaDeEntero());
        MenuPrincipal menuPrincipal = new MenuPrincipal(reporteSerivicio2, reporteServicio3, reporteServicio4);
        menuPrincipal.setVisible(true);
    }

}
