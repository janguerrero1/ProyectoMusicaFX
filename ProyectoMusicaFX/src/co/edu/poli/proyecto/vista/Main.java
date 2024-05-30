package co.edu.poli.proyecto.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // Cargar el archivo FXML
            AnchorPane root = FXMLLoader.load(getClass().getResource("/co/edu/poli/proyecto/vista/SCENE_BUILDER.fxml"));
            
            // Configurar la escena
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            
            // Configurar el escenario principal
            primaryStage.setTitle("ProyectoMusicaFX");  // Establecer el título de la ventana
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}