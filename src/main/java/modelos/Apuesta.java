/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Luis Monterroso
 */
public class Apuesta {

    private String nombreApostador;//nombre del apostador
    private double apuesta;//candidad de la apuesta
    private Caballo[] caballos;//caballos en la apuesta

    public Apuesta(String nombreApostador, double apuesta, Caballo[] caballos) {
        this.nombreApostador = nombreApostador;
        this.apuesta = apuesta;
        this.caballos = caballos;
    }

    public String getNombreApostador() {
        return nombreApostador;
    }

    public void setNombreApostador(String nombreApostador) {
        this.nombreApostador = nombreApostador;
    }

    public double getApuesta() {
        return apuesta;
    }

    public void setApuesta(double apuesta) {
        this.apuesta = apuesta;
    }

    public Caballo[] getCaballos() {
        return caballos;
    }

    public void setCaballos(Caballo[] caballos) {
        this.caballos = caballos;
    }

   
}
