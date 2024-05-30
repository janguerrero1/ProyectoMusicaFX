module ProyectoMusica {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	
	opens co.edu.poli.proyecto.vista to javafx.graphics, javafx.fxml;
	opens co.edu.poli.proyecto.controlador to javafx.graphics, javafx.fxml;
	opens co.edu.poli.proyecto.modelo to javafx.base;
}
