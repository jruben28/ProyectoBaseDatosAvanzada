/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 * Clase inquilino
 * @author joser
 */
public class Inquilino {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Float ingresoMensual;
    private String telefono;

    /**
     * Constructor con todos los datos del inquilino.
     * @param nombre 
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param ingresoMensual
     * @param telefono 
     */
    public Inquilino(String nombre, String apellidoPaterno, String apellidoMaterno, Float ingresoMensual, String telefono) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.ingresoMensual = ingresoMensual;
        this.telefono = telefono;
    }

    /**
     * Constructor por omisión.
     */
    public Inquilino() {
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Float getIngresoMensual() {
        return ingresoMensual;
    }

    public void setIngresoMensual(Float ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Inquilino{" + "nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", ingresoMensual=" + ingresoMensual + ", telefono=" + telefono + '}';
    }
    
    
    
    
}
