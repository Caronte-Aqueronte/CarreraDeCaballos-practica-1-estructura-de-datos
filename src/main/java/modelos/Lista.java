/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Luis Monterroso
 */
public class Lista<T> {

    protected Nodo<T> raiz;
    protected Nodo<T> cola;
    protected int size;

    public Lista() {
        this.raiz = null;
        this.cola = null;
        this.size = 0;
    }
    
    public Object toArray() {
        return null;//retornar el array
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }

    public Nodo<T> getCola() {
        return cola;
    }

    public void setCola(Nodo<T> cola) {
        this.cola = cola;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
}
