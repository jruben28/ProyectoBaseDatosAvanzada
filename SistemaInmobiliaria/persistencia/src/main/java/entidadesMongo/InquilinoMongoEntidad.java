/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesMongo;

/**
 *
 * @author joser
 */
public class InquilinoMongoEntidad {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Float ingresoMensual;
    private String telefono;

    public InquilinoMongoEntidad(String nombres, String apellidoPaterno, String apellidoMaterno, Float ingresoMensual, String telefono) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.ingresoMensual = ingresoMensual;
        this.telefono = telefono;
    }

    public InquilinoMongoEntidad() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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
        return "InquilinoMongoEntidad{" + "nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", ingresoMensual=" + ingresoMensual + ", telefono=" + telefono + '}';
    }
    
    
    
}
