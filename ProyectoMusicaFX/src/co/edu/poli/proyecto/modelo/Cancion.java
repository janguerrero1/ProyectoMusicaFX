package co.edu.poli.proyecto.modelo;

public class Cancion {
  private String nombre;
  private String artista;
  private String album;
  private String genero;
  
public Cancion(String nombre, String artista, String album, String genero) {
	super();
	this.nombre = nombre;
	this.artista = artista;
	this.album = album;
	this.genero = genero;
}



public String getNombre() {
	return nombre;
}



public void setNombre(String nombre) {
	this.nombre = nombre;
}



public String getArtista() {
	return artista;
}

public void setArtista(String artista) {
	this.artista = artista;
}

public String getAlbum() {
	return album;
}

public void setAlbum(String album) {
	this.album = album;
}

public String getGenero() {
	return genero;
}

public void setGenero(String genero) {
	this.genero = genero;
}

@Override
public String toString() {
	return "Cancion [nombre=" + nombre + ", artista=" + artista + ", album=" + album + ", genero=" + genero + "]";
}



  
  
}
