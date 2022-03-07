/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Luis Monterroso
 */
public class ListaDeEntero extends Lista<Integer> {

    public ListaDeEntero() {
        super();
    }

    public void insertarNodo(Integer valorAInsertar) {
        Nodo nodoAInsertar = new Nodo(valorAInsertar);//creamos un nuevo nodo a partir del valor que se encie
        if (raiz == null) {//si la raiz es nula entonces solo debemos insertar en la raiz y al final
            raiz = nodoAInsertar;//
            cola = nodoAInsertar;//
            size++;
        } else {//si no esta nula la raiz entonces debemos insertar un nodo en el siguiente de la cola
            cola.setSiguiente(nodoAInsertar);//insertar siguiente de la cola
            cola.getSiguiente().setAnterior(cola);//el anteiror del siguiente de la cola sera la cola misma
            cola = cola.getSiguiente();//ahora la cola sera el siguiente de la cola
            size++;//sumamos el tano de la lista
        }
    }

    @Override
    public Integer[] toArray() {
        Integer[] enteros = new Integer[size];//creamos un array con el tamano del array actual
        Nodo nodoPrincipal = raiz;//el nodo principal sera el comienzo
        for (int x = 0; x < size; x++) {//itermaos dentro de los nodos de esta lista
            enteros[x] = (Integer) nodoPrincipal.getValor();//asiganos el valor del nodo en una posicion del array
            nodoPrincipal = nodoPrincipal.getSiguiente();
        }
        return enteros;//retornar el array
    }
}
