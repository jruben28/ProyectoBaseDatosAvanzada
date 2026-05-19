/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesMongo;

import java.time.Instant;
import org.bson.types.ObjectId;

/**
 *
 * @author joser
 */
public class ContratoMongoEntidad {
    private Instant fechaInicio;
    private Instant fechaFin;
    private ObjectId idInmueble;
    private Float adeudo;
    private String motivo;
    private String observaciones;

    public ContratoMongoEntidad(Instant fechaInicio, Instant fechaFin, ObjectId idInmueble, Float adeudo, String motivo, String observaciones) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idInmueble = idInmueble;
        this.adeudo = adeudo;
        this.motivo = motivo;
        this.observaciones = observaciones;
    }

    public ContratoMongoEntidad(Instant fechaInicio, ObjectId idInmueble) {
        this.fechaInicio = fechaInicio;
        this.idInmueble = idInmueble;
    }

    public ContratoMongoEntidad() {
    }

    public Instant getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Instant fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Instant getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Instant fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ObjectId getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(ObjectId idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Float getAdeudo() {
        return adeudo;
    }

    public void setAdeudo(Float adeudo) {
        this.adeudo = adeudo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "ContratoMongoEntidad{" + "fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", idInmueble=" + idInmueble + ", adeudo=" + adeudo + ", motivo=" + motivo + ", observaciones=" + observaciones + '}';
    }
    
    
    
}
