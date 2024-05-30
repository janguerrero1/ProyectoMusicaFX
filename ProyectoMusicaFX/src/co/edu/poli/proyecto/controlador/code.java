package co.edu.poli.proyecto.controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import co.edu.poli.proyecto.modelo.Cancion;

public class code {

    @FXML
    private Button bttactualizar;

    @FXML
    private Button bttagregarCancion;

    @FXML
    private Button bttbuscar_leer;

    @FXML
    private Button btteliminar;

    @FXML
    private Button bttsalir;

    @FXML
    private TextField txtAlbum;

    @FXML
    private TextField txtartista;

    @FXML
    private TextField txtgenero;

    @FXML
    private TextField txtingresar_cancion_leer;

    @FXML
    private TextField txtingrese_cancion_actualizar;

    @FXML
    private TextField txtingrese_cancion_eliminar;

    @FXML
    private TextField txtnombreCancion;

    private ObservableList<Cancion> canciones;

    @FXML
    public void initialize() {
        // Inicializa la lista de canciones
        canciones = FXCollections.observableArrayList();
    }

    @FXML
    void pressactualizar(ActionEvent event) {
        String nombre = txtingrese_cancion_actualizar.getText();
        String artista = txtartista.getText();
        String album = txtAlbum.getText();
        String genero = txtgenero.getText();

        if (!nombre.isEmpty() && !artista.isEmpty() && !album.isEmpty() && !genero.isEmpty()) {
            boolean found = false;
            for (Cancion cancion : canciones) {
                if (cancion.getNombre().equalsIgnoreCase(nombre)) {
                    cancion.setArtista(artista);
                    cancion.setAlbum(album);
                    cancion.setGenero(genero);

                    // Mostrar alerta y mensaje en la consola
                    showAlert(AlertType.INFORMATION, "Canción actualizada", "La canción ha sido actualizada exitosamente.");
                    System.out.println("Canción actualizada: " + cancion.toString());
                    found = true;
                    break;
                }
            }
            if (!found) {
                showAlert(AlertType.ERROR, "Canción no encontrada", "La canción no se encontró en la lista.");
                System.out.println("Error: Canción no encontrada.");
            }
        } else {
            showAlert(AlertType.WARNING, "Campos vacíos", "Por favor, complete todos los campos de la canción.");
            System.out.println("Error: Campos vacíos al actualizar canción.");
        }
    }

    @FXML
    void pressagregarCancion(ActionEvent event) {
        String nombre = txtnombreCancion.getText();
        String artista = txtartista.getText();
        String album = txtAlbum.getText();
        String genero = txtgenero.getText();

        if (!nombre.isEmpty() && !artista.isEmpty() && !album.isEmpty() && !genero.isEmpty()) {
            Cancion nuevaCancion = new Cancion(nombre, artista, album, genero);
            canciones.add(nuevaCancion);

            // Limpiar los campos de texto después de agregar la canción
            txtnombreCancion.clear();
            txtartista.clear();
            txtAlbum.clear();
            txtgenero.clear();

            // Mostrar alerta y mensaje en la consola
            showAlert(AlertType.INFORMATION, "Canción agregada", "La canción ha sido agregada exitosamente.");
            System.out.println("Canción agregada: " + nuevaCancion.toString());
        } else {
            showAlert(AlertType.WARNING, "Campos vacíos", "Por favor, complete todos los campos de la canción.");
            System.out.println("Error: Campos vacíos al agregar canción.");
        }
    }

    @FXML
    void pressbuscar_leer(ActionEvent event) {
        String nombreBuscar = txtingresar_cancion_leer.getText();
        boolean found = false;
        for (Cancion cancion : canciones) {
            if (cancion.getNombre().equalsIgnoreCase(nombreBuscar)) {
                // Mostrar alerta y mensaje en la consola
                showAlert(AlertType.INFORMATION, "Canción encontrada", "Canción encontrada: " + cancion.toString());
                System.out.println("Canción encontrada: " + cancion.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            showAlert(AlertType.ERROR, "Canción no encontrada", "La canción no fue encontrada en la lista.");
            System.out.println("Error: Canción no encontrada.");
        }
    }

    @FXML
    void presselilminar(ActionEvent event) {
        String nombreEliminar = txtingrese_cancion_eliminar.getText();
        Cancion cancionAEliminar = null;
        for (Cancion cancion : canciones) {
            if (cancion.getNombre().equalsIgnoreCase(nombreEliminar)) {
                cancionAEliminar = cancion;
                break;
            }
        }
        if (cancionAEliminar != null) {
            canciones.remove(cancionAEliminar);
            showAlert(AlertType.INFORMATION, "Canción eliminada", "La canción ha sido eliminada exitosamente.");
            System.out.println("Canción eliminada: " + cancionAEliminar.toString());
        } else {
            showAlert(AlertType.ERROR, "Canción no encontrada", "La canción no se encontró en la lista.");
            System.out.println("Error: Canción no encontrada.");
        }
    }

    @FXML
    void presssalir(ActionEvent event) {
        System.out.println("Saliendo de la aplicación...");
        showAlert(AlertType.INFORMATION, "SALIENDO DE LA APP...", "VUELVA PRONTO.");
        System.exit(0);
    }

    // Método para mostrar alertas
    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}