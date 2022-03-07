/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Luis Monterroso
 */
public class ListaDeApuestas extends Lista<Apuesta> {

    private Reporte reporteSerivicio2;

    public ListaDeApuestas(Reporte reporteSerivicio2) {
        super();
        this.reporteSerivicio2 = reporteSerivicio2;
    }

    public void insertarNodo(Apuesta valorAInsertar) {
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

    public ListaDeApuestas analizarApuestas() {
        ListaDeApuestas apuestasErroneas = new ListaDeApuestas(reporteSerivicio2);//creamos una nueva lista de los errores que encontraremos
        Nodo nodoPrincipal = raiz;//comenzamos analizando la raiz
        int sizeAux = size;//esta sera la pauta de las iteraciones
        for (int x = 0; x < sizeAux; x++) {//iteramos por los nodos de la raiz
            Apuesta apuesta = (Apuesta) nodoPrincipal.getValor();//traemos la apuesta que da valor al nodo
            if (verRepetido(apuesta)) {//si algo se encuentra repetido 
                apuestasErroneas.insertarNodo(apuesta);//insertamos el nodo en los errores
                nodoPrincipal = nodoPrincipal.getSiguiente();//cambiamos el nodo a analizar al siguiente del actual
                eliminarNodo(apuesta);//mandamos a eliminar el nodo que contenga el valor de la apuesta actual
            } else {
                nodoPrincipal = nodoPrincipal.getSiguiente();//si no entoncro solo nos movemos a otro nodo
            }
        }
        return apuestasErroneas;//retornamos la lista con  los nodos fallidos
    }

    public boolean verRepetido(Apuesta apuesta) {
        long inicio = System.currentTimeMillis();//contamos el tiempo de ejecucion en este punto
        int canditadDePasos = 0;
        Caballo[] caballos = apuesta.getCaballos();//traemos la lista de posiciones de los caballos
        boolean banderaCaballo1 = false;//banderas que indicaran si ya fue analizado un numero
        boolean banderaCaballo2 = false;//
        boolean banderaCaballo3 = false;//
        boolean banderaCaballo4 = false;//
        boolean banderaCaballo5 = false;//
        boolean banderaCaballo6 = false;//
        boolean banderaCaballo7 = false;//
        boolean banderaCaballo8 = false;//
        boolean banderaCaballo9 = false;//
        boolean banderaCaballo10 = false;//
        boolean banderaError = false;
        forPosicion:
        for (int x = 0; x < caballos.length; x++) {//iteramos por los caballos de la apuesta
            switch (caballos[x].getNumero()) {//segun el valor numerico del caballo en la posicion analizada mandaremos a un caso
                //independientemente del caso se analiza si la bandera que corresponde al numero ya fue activada,
                //de ser asi entonces el numero ya fue evaluedo con anterioridad y podemos retornar tue paara indicar que hay un numero repetido
                //de lo contrario activamos la bandera.
                case 1:
                    if (banderaCaballo1 == false) {
                        banderaCaballo1 = true;
                    } else {
                        banderaError = true;
                        break forPosicion;
                    }
                    break;
                case 2:
                    if (banderaCaballo2 == false) {
                        banderaCaballo2 = true;
                    } else {
                        banderaError = true;
                        break forPosicion;
                    }
                    break;
                case 3:
                    if (banderaCaballo3 == false) {
                        banderaCaballo3 = true;
                    } else {
                        banderaError = true;
                        break forPosicion;
                    }
                    break;
                case 4:
                    if (banderaCaballo4 == false) {
                        banderaCaballo4 = true;
                    } else {
                        banderaError = true;
                        break forPosicion;
                    }
                    break;
                case 5:
                    if (banderaCaballo5 == false) {
                        banderaCaballo5 = true;
                    } else {
                        banderaError = true;
                        break forPosicion;
                    }
                    break;
                case 6:
                    if (banderaCaballo6 == false) {
                        banderaCaballo6 = true;
                    } else {
                        banderaError = true;
                        break forPosicion;
                    }
                    break;
                case 7:
                    if (banderaCaballo7 == false) {
                        banderaCaballo7 = true;
                    } else {
                        banderaError = true;
                        break forPosicion;
                    }
                    break;
                case 8:
                    if (banderaCaballo8 == false) {
                        banderaCaballo8 = true;
                    } else {
                        banderaError = true;
                        break forPosicion;
                    }
                    break;
                case 9:
                    if (banderaCaballo9 == false) {
                        banderaCaballo9 = true;
                    } else {
                        banderaError = true;
                        break forPosicion;
                    }
                    break;
                case 10:
                    if (banderaCaballo10 == false) {
                        banderaCaballo10 = true;
                    } else {
                        banderaError = true;
                        break forPosicion;
                    }
                    break;
                default:
                    return true;
            }
            canditadDePasos++;
        }
        long fin = System.currentTimeMillis();//contamos el tiempo de ejecucion para este punto
        long tiempo =  ((fin - inicio));//pasamos a segundos el tiempo que sera diferencia entre los dos
        reporteSerivicio2.setTotalDeTiempo(reporteSerivicio2.getTotalDeTiempo() + tiempo);//sumamos el total del tiempo para este servicio
        reporteSerivicio2.setTotalPasos(reporteSerivicio2.getTotalPasos() + canditadDePasos);//sumamos los pasos al total de pasos
        reporteSerivicio2.setVecesQueSeEjecuto(reporteSerivicio2.getVecesQueSeEjecuto() + 1);//sumamos la ejecucion al total de ejecuciones
        reporteSerivicio2.getListaDeEntero().insertarNodo(canditadDePasos);//anadimos los pasos a la lista del objeto
        return banderaError;//si llega aqui entonces no hay nada repetido y devolvemos false
    }

    public void eliminarNodo(Apuesta apuesta) {
        Nodo nodoPrincipal = raiz;//el nodo principal sera el comienzo
        for (int x = 0; x < size; x++) {//itermaos dentro de los nodos de esta lista
            if (nodoPrincipal.getValor() == apuesta) {//debedos detectar cunado el valor del nodo sea el mismo objeto que la apuesta que hay que eliminar
                if (nodoPrincipal.getSiguiente() == null && nodoPrincipal.getAnterior() == null) {//si el siguiente y el anteiror son nulos entonces se trata del primer elemento y debemos hacer que sean nulos
                    raiz = null;//eliminamos la raiz y la cola
                    cola = null;
                    size--;
                    break;
                } else if (nodoPrincipal.getSiguiente() == null && nodoPrincipal.getAnterior() != null) {
                    cola = nodoPrincipal.getAnterior();
                    nodoPrincipal.getAnterior().setSiguiente(null);//debemos cortar los lazos solo del anteior del actual
                    nodoPrincipal.setAnterior(null);//quitamos el vinculo del nodo actual
                    nodoPrincipal.setSiguiente(null);//quitamos el vinculo del nodo actual
                    size--;
                    break;
                } else if (nodoPrincipal.getSiguiente() != null && nodoPrincipal.getAnterior() == null) {
                    raiz = nodoPrincipal.getSiguiente();
                    raiz.setAnterior(null);
                    nodoPrincipal.setAnterior(null);//quitamos el vinculo del nodo actual
                    nodoPrincipal.setSiguiente(null);//quitamos el vinculo del nodo actual
                    size--;
                    break;
                } else {
                    nodoPrincipal.getSiguiente().setAnterior(nodoPrincipal.getAnterior());//si nada esta nulo entonces podmeos mover todo
                    nodoPrincipal.getAnterior().setSiguiente(nodoPrincipal.getSiguiente());
                    nodoPrincipal.setAnterior(null);//quitamos el vinculo del nodo actual
                    nodoPrincipal.setSiguiente(null);//quitamos el vinculo del nodo actual
                    size--;
                    break;
                }

            }
            nodoPrincipal = nodoPrincipal.getSiguiente();
        }
    }

    @Override
    public Apuesta[] toArray() {
        Apuesta[] apuestas = new Apuesta[size];//creamos un array con el tamano del array actual
        Nodo nodoPrincipal = raiz;//el nodo principal sera el comienzo
        for (int x = 0; x < size; x++) {//itermaos dentro de los nodos de esta lista
            apuestas[x] = (Apuesta) nodoPrincipal.getValor();//asiganos el valor del nodo en una posicion del array
            nodoPrincipal = nodoPrincipal.getSiguiente();
        }
        return apuestas;//retornar el array
    }

}
