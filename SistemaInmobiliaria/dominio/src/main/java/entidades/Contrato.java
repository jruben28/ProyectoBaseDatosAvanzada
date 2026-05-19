/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.Instant;

/**
 *
 * @author joser
 */
public class Contrato {
    private Instant fechaInicio;
    private Instant fechaFin;
    private String idInmueble;
    private Float adeudo;
    private String motivo;
    private String observaciones;

    public Contrato() {
    }

    public Contrato(Instant fechaInicio, Instant fechaFin, String idInmueble, Float adeudo, String motivo, String observaciones) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idInmueble = idInmueble;
        this.adeudo = adeudo;
        this.motivo = motivo;
        this.observaciones = observaciones;
    }

    public Contrato(Instant fechaInicio, String idInmueble) {
        this.fechaInicio = fechaInicio;
        this.idInmueble = idInmueble;
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

    public String getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(String idInmueble) {
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
    
    
    
}
