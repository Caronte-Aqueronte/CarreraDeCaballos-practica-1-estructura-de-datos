package lector;

import java.io.*;
import modelos.Caballo;
import modelos.Apuesta;
import modelos.ListaDeApuestas;

public class LectorDeTexto {

    private ListaDeApuestas apuestas;
    private Reader reader;

    public LectorDeTexto(ListaDeApuestas apuestas, Reader reader) {
        this.apuestas = apuestas;
        this.reader = reader;
    }

    public boolean leerArchivo() throws FileNotFoundException, IOException, NumberFormatException, IndexOutOfBoundsException {
        String linea;
        BufferedReader bufferedReader = new BufferedReader((reader));
        while ((linea = bufferedReader.readLine()) != null) { //se repetira hasta que lea la utima linea del archivo
            try {
                String[] camposSeparados = separarCampos(linea);//mandamos la linea leida a separar
                //creamos el array de caballos segun las ultimas 10 posiciones de la entrada de texto
                Caballo[] caballos = new Caballo[10];
                for (int x = 0; x < 10; x++) {
                    caballos[x] = new Caballo(Integer.valueOf(camposSeparados[x + 2]));
                }
                //creamos una nueva apuesta y la insertamos dentro del la lista de apuestas
                Apuesta apuesta = new Apuesta(camposSeparados[0], Double.parseDouble(camposSeparados[1]),
                        caballos);//creamos un objeto apuesta que tendra todos los datos de la misma
                apuestas.insertarNodo(apuesta);
            } catch (Exception e) {
            }
        }
        bufferedReader.close();
        return true;
    }

    public String[] separarCampos(String linea) {
        String[] componentes = linea.split(",");//separamos las entradas por las comas
        return componentes;//retornamos los componentes
    }
}
