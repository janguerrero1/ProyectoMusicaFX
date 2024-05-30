package co.edu.poli.proyecto.servicios;

import java.util.Arrays;

import co.edu.poli.proyecto.modelo.Cancion;

public class ImplementarOperacion implements Operacion {
    private Cancion[] arr = new Cancion[10];

    @Override
    public String create(Cancion cancion) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = cancion;
                return "Cancion creada exitosamente";
            }
        }
        arr = Arrays.copyOf(arr, arr.length * 2);
        arr[arr.length / 2] = cancion;
        return "Cancion creada exitosamente";
    }

    @Override
    public Cancion leer(String nombre) {
        for (Cancion cancion : arr) {
            if (cancion != null && cancion.getNombre().equals(nombre)) {
                return cancion;
            }
        }
        return null;
    }

    @Override
    public String update(String nombre, Cancion cancionActualizada) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].getNombre().equals(nombre)) {
                arr[i] = cancionActualizada;
                return "Cancion actualizada exitosamente";
            }
        }
        return "Cancion no encontrada";
    }

    @Override
    public Cancion eliminar(String nombre) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].getNombre().equals(nombre)) {
                Cancion cancionEliminada = arr[i];
                arr[i] = null;
                return cancionEliminada;
            }
        }
        return null;
    }

    @Override
    public Cancion[] getArr() {
        return arr;
    }
}