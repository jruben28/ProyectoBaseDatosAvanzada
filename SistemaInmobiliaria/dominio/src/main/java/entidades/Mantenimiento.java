/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author joser
 */
public class Mantenimiento {
    private String idMantenimiento;
    private String idInmueble;
    private String descripcion;
    private String prioridad;
    private String tipo;
    private String estado;
    private Float costoMensual;
    private String notas;

    /**
     * Constructor con id.
     * @param idMantenimiento
     * @param idInmueble
     * @param descripcion
     * @param prioridad
     * @param tipo
     * @param estado
     * @param costoMensual
     * @param notas 
     */
    public Mantenimiento(String idMantenimiento, String idInmueble, String descripcion, String prioridad, String tipo, String estado, Float costoMensual, String notas) {
        this.idMantenimiento = idMantenimiento;
        this.idInmueble = idInmueble;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.tipo = tipo;
        this.estado = estado;
        this.costoMensual = costoMensual;
        this.notas = notas;
    }

    /**
     * Constructor sin id.
     * @param idInmueble
     * @param descripcion
     * @param prioridad
     * @param tipo
     * @param estado
     * @param costoMensual
     * @param notas 
     */
    public Mantenimiento(String idInmueble, String descripcion, String prioridad, String tipo, String estado, Float costoMensual, String notas) {
        this.idInmueble = idInmueble;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.tipo = tipo;
        this.estado = estado;
        this.costoMensual = costoMensual;
        this.notas = notas;
    }

    /**
     * Constructor por omisión.
     */
    public Mantenimiento() {
    }

    public String getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(String idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public String getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(String idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Float getCostoMensual() {
        return costoMensual;
    }

    public void setCostoMensual(Float costoMensual) {
        this.costoMensual = costoMensual;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Mantenimiento{" + "idMantenimiento=" + idMantenimiento + ", idInmueble=" + idInmueble + ", descripcion=" + descripcion + ", prioridad=" + prioridad + ", tipo=" + tipo + ", estado=" + estado + ", costoMensual=" + costoMensual + ", notas=" + notas + '}';
    }
    
    
    
}
