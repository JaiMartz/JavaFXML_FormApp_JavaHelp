/**
 * Módulo: Formulario
 * Archivo: Tarea02_DI.java
 * Objetivo: Lanzar la aplicación
 * Equipo/Persona: Jairo Martínez Garrido
 */
package tarea06_di;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *Clase principal. Ejecuta el programa.
 * @author Jairo
 * version 1.0 final
 */
public class Tarea06_DI extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("vista.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }   
}
