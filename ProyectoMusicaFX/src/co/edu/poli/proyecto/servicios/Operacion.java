package co.edu.poli.proyecto.servicios;

import co.edu.poli.proyecto.modelo.Cancion;

public interface Operacion {
    public String create(Cancion cancion);
    public Cancion leer(String nombre);
    public String update(String nombre, Cancion cancion);
    public Cancion eliminar(String nombre);
    public Cancion[] getArr();
}