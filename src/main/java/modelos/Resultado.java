/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Luis Monterroso
 */
public class Resultado {
    private String nombreapostador;
    private int punteo;

    public Resultado(String nombreapostador, int punteo) {
        this.nombreapostador = nombreapostador;
        this.punteo = punteo;
    }

    public String getNombreapostador() {
        return nombreapostador;
    }

    public void setNombreapostador(String nombreapostador) {
        this.nombreapostador = nombreapostador;
    }

    public int getPunteo() {
        return punteo;
    }

    public void setPunteo(int punteo) {
        this.punteo = punteo;
    }
    
}
