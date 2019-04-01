/**
 * Módulo: Formulario
 * Archivo: vistaController.java
 * Objetivo: Crear una aplicación que recoja información desde un formulario
 * y la guarde en una lista.
 * Equipo/Persona: Jairo Martínez Garrido
 */
package tarea06_di;

import Alumno.alumno;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;

/**
 *Clase vistaController
 * @author Jairo
 * version 1.0 final
 */

public class vistaController implements Initializable {
    
    //Creamos los elementos
    @FXML public Button btnGuardar;
    @FXML public TextField txfDNI;
    @FXML public TextField txfModulo;
    @FXML public TextField txfNota;
    @FXML public TextField txfRecuperacion;
    
    //Añadimos la tabla
    @FXML public TableView<alumno> tablaAlumnos; 
    @FXML public TableColumn clDNI;
    @FXML public TableColumn clModulo;
    @FXML public TableColumn clNota;
    @FXML public TableColumn clRecuperacion;
    
    private final ObservableList<alumno>listaAlumnos = FXCollections.observableArrayList();
    
    
    /**
     * Limpia los campos de texto del formulario.
     */
    @FXML
    private void limpiarCampos(){
        txfDNI.setText("");
        txfModulo.setText("");
        txfRecuperacion.setText("");
        txfNota.setText("");
    }
    /**
     * Guarda la información introducida en los campos del formulario.
     * @param event Recoge la acción que activa el método.
     */
    @FXML
    private void accionGuardarNotas(ActionEvent event) {
        String dniRegExp = "\\d{8}[A-HJ-NP-TV-Z]";
        int parseNota = Integer.parseInt(txfNota.getText());
        int parseRecu = Integer.parseInt(txfRecuperacion.getText());
        
        String titError = "Error";
        String msgErrorInvalido = "El valor introducido no es válido, inténtelo de nuevo.\n"
                + "\n-Recuerde que la nota no puede ser mayor que 10"
                + "\n-Recuerde que la nota no puede ser menor que 0."
                + "\n-Recuerde que la nota de recuperacion no puede ser mayor que 5."
                + "\n-Recuerde que la nota de recuperacion no puede ser menor que 0."
                + "\n-Recuerde que DNI debe tener 8 digitos y 1 letra." ;
        String msgRecuError = "Si el alumno ha aprobado, no puede tener valor de recuperación";
        String msgDniError = "El DNI introducido no es valido, intentelo de nuevo.";
        
        if((parseNota<0) || (parseNota>10) || (parseRecu<0) ||(parseRecu>5)){
            JOptionPane.showConfirmDialog(null, msgErrorInvalido, titError, JOptionPane.ERROR_MESSAGE);
        }else if(!Pattern.matches(dniRegExp, txfDNI.getText())){
            JOptionPane.showConfirmDialog(null, msgDniError, titError, JOptionPane.ERROR_MESSAGE);
        }else if((parseNota>= 5)&&(parseRecu >= 5)){
            JOptionPane.showConfirmDialog(null, msgRecuError, titError, JOptionPane.ERROR_MESSAGE);
        }else{
            if(parseNota >= 5){
            parseRecu = 0;
            }
            alumno Alumno = new alumno(txfDNI.getText() ,txfModulo.getText(), Integer.parseInt(txfNota.getText()), parseRecu);
            listaAlumnos.add(Alumno);
            limpiarCampos();
        }
    }
    
    /**
     * Genera una ventana que pide permiso para cerrar el programa.
     * @param event Recoge la acción que activa el método.
     */
    @FXML
    public void archivoSalir(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Salir");
        alert.setHeaderText("Salir");
        alert.setContentText("¿Desea salir? La aplicación se cerrará.");
        Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                System.exit(1);
            }
        alert.show();
    }
    
    /**
     * Lanza una ventana modal para mostrar información.
     * @param event Recoge la acción que activa el método.
     */
    @FXML
    public void acercaDe(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de");
        alert.setHeaderText("Acerca de");
        alert.setContentText("Alumno: Jairo Martínez Garrido" + "\nDNI: 76652856C"+"\nPrograma desarrollado para mostrar la " +  
                "estructura que debemos seguir en la creación de una " +  
                "aplicación.");
        alert.show();
    } 
    /**
     * Simula el click en un botón tipo JButton de la librería swing.
     * @param event Recoge la acción que activa el método.
     */
    public void handleManual(ActionEvent event){
        try{
            javax.swing.JButton boton = new javax.swing.JButton();
            
            File fichero = new File("src\\Documentacion\\help_set.hs");
            
            URL hsURL = fichero.toURI().toURL();
            
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            
            HelpBroker hb = helpset.createHelpBroker();
            
            hb.enableHelpOnButton(boton, "formularioAplicacion", helpset);
            
            boton.doClick();
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }    
    
    }
    /**
     * Inicializa los diferentes elementos del codigo para su uso.
     * @param url Recoge una URL.
     * @param rb Recoge un ResourceBundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        clDNI.setCellValueFactory(new PropertyValueFactory<alumno, String>("DNI"));
        clModulo.setCellValueFactory(new PropertyValueFactory<alumno, String>("Modulo"));
        clNota.setCellValueFactory(new PropertyValueFactory<alumno, Integer>("Nota"));
        clRecuperacion.setCellValueFactory(new PropertyValueFactory<alumno, String>("Recuperacion"));

        tablaAlumnos.setItems(listaAlumnos);
    }    
    
}
