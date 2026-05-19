/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.comunes;

/**
 *
 * @author joser
 */
public class MantenimientoDTO {
    private String idMantenimiento;
    private String idInmueble;
    private String descripcion;
    private String prioridad;
    private String tipo;
    private String estado;
    private Float costo;
    private String notas;

    public MantenimientoDTO(String idMantenimiento, String idInmueble, String descripcion, String prioridad, String tipo, String estado, Float costo, String notas) {
        this.idMantenimiento = idMantenimiento;
        this.idInmueble = idInmueble;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.tipo = tipo;
        this.estado = estado;
        this.costo = costo;
        this.notas = notas;
    }

    public MantenimientoDTO() {
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

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
    
    
}
