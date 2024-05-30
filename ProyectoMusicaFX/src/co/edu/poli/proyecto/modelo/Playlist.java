package co.edu.poli.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nombre;
    private List<Cancion> canciones;
    private String artistaFav;
    private String creador;
    private int calificacion;

    public Playlist(String nombre, List<Cancion> canciones, String artistaFav, String creador, int calificacion) {
        this.nombre = nombre;
        this.canciones = canciones != null ? canciones : new ArrayList<>();
        this.artistaFav = artistaFav;
        this.creador = creador;
        this.calificacion = calificacion;
    }

    public void agregarCancion(Cancion cancion) {
        if (canciones.contains(cancion)) {
            System.out.println("La canción ya está en la lista.");
            return;
        }
        canciones.add(cancion);
    }

    public void eliminarCancion(Cancion cancion) {
        if (canciones.remove(cancion)) {
            System.out.println("Canción eliminada exitosamente.");
        } else {
            System.out.println("La canción no se encontró en la lista.");
        }
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtistaFav() {
        return artistaFav;
    }

    public void setArtistaFav(String artistaFav) {
        this.artistaFav = artistaFav;
    }

    @Override
    public String toString() {
        return "Playlist [nombre=" + nombre + ", canciones=" + canciones + ", artistaFav=" + artistaFav + ", creador="
                + creador + ", calificacion=" + calificacion + "]";
    }
}