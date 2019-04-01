/**
 * Módulo: Formulario
 * Archivo: alumno.java
 * Objetivo: Generar un Java Bean para crear el patron de datos de los alumnos
 * Equipo/Persona: Jairo Martínez Garrido
 */
package Alumno;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *Clase Alumno. Datos relevantes de un alumno.
 * @author Jairo
 * @version  1.0 final
 */
public class alumno {
    
    public SimpleStringProperty dni = new SimpleStringProperty();
    public SimpleIntegerProperty nota = new SimpleIntegerProperty();
    public SimpleStringProperty modulo = new SimpleStringProperty();
    public SimpleIntegerProperty recuperacion = new SimpleIntegerProperty();
    
    /**
     * Constructor de la clase alumno
     * @param dni Almacena un valor tipo String
     * @param nota Almacena un valor tipo int
     * @param modulo Almacena un valor tipo String
     * @param recuperacion Almacena un valor tipo int
     */
    public alumno (String dni, String modulo, int nota, int recuperacion){
        this.dni = new SimpleStringProperty(dni);
        this.modulo = new SimpleStringProperty(modulo);
        this.nota = new SimpleIntegerProperty(nota);
        this.recuperacion = new SimpleIntegerProperty(recuperacion);
    }
    /**
     * Metodo que permite consultar el dni de un alumno.
     * @return Devuelve el valor del atributo dni.
     */
    public String getDNI(){
        return dni.get();
    }
    /**
     * Método que permite consultar el modulo de un alumno.
     * @return Devuelve el valor del atributo modulo.
     */
    public String getModulo(){
        return modulo.get();
    }
    /**
     * Método que permite consultar la nota de un alumno.
     * @return Devuelve el valor del atributo nota.
     */
    public int getNota(){
        return nota.get();
    }
    /**
     * Método que permite consultar la recuperación de un alumno.
     * @return Devuelve el valor del atributo recuperación.
     */
    public int getRecuperacion(){
        return recuperacion.get();
    }
    
    /**
     * Método que permite establecer el valor del dni de un alumno.
     * @param dni Parámetro que representa el dni del alumno que
     * se desea asignar.
     */
    public void setDNI(String dni){
        this.dni.set(dni);
    }
    /**
     * Método que permite establecer el valor del modulo de un alumno.
     * @param modulo Parámetro que representa el modulo del alumno que
     * se desea asignar.
     */
    public void setModulo(String modulo){
        this.modulo.set(modulo);
    }
    /**
     * Método que permite establecer el valor de la nota de un alumno
     * @param nota Parámetro que representa la nota del alumno que
     * se desea asignar.
     */
    public void setNota(int nota){
        this.nota.set(nota);
    }
    /**
     * Método que permite establecer el valor de la recuperacion de un alumno
     * @param recuperacion Parámetro que representa la recuperacion del alumno
     * que se desea asignar.
     */
    public void setRecuperacion(int recuperacion){
        this.recuperacion.set(recuperacion);  
    }
    
}
