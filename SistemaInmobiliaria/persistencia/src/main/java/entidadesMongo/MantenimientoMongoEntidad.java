/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesMongo;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 *
 * @author joser
 */
public class MantenimientoMongoEntidad {
    @BsonId
    private ObjectId idMantenimiento;
    
    private ObjectId idInmueble;
    private String descripcion;
    private String prioridad;
    private String tipo;
    private String estado;
    private Float costo;
    private String notas;

    public MantenimientoMongoEntidad(ObjectId idMantenimiento, ObjectId idInmueble, String descripcion, String prioridad, String tipo, String estado, Float costo, String notas) {
        this.idMantenimiento = idMantenimiento;
        this.idInmueble = idInmueble;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.tipo = tipo;
        this.estado = estado;
        this.costo = costo;
        this.notas = notas;
    }

    public MantenimientoMongoEntidad(ObjectId idInmueble, String descripcion, String prioridad, String tipo, String estado, Float costo, String notas) {
        this.idInmueble = idInmueble;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.tipo = tipo;
        this.estado = estado;
        this.costo = costo;
        this.notas = notas;
    }

    public MantenimientoMongoEntidad() {
    }
    
    

    public ObjectId getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(ObjectId idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public ObjectId getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(ObjectId idInmueble) {
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

    @Override
    public String toString() {
        return "MantenimientoMongoEntidad{" + "idMantenimiento=" + idMantenimiento + ", idInmueble=" + idInmueble + ", descripcion=" + descripcion + ", prioridad=" + prioridad + ", tipo=" + tipo + ", estado=" + estado + ", costo=" + costo + ", notas=" + notas + '}';
    }
    
    
    
}
