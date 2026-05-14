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
public class InmuebleMongoEntidad {
    @BsonId
    private ObjectId id;
    
    private String direccion;
    private String estado;
    private String rentaMensual;
    private InquilinoMongoEntidad inquilino;

    /**
     * Constructor con id de bson.
     * @param id
     * @param direccion
     * @param estado
     * @param rentaMensual
     * @param inquilino 
     */
    public InmuebleMongoEntidad(ObjectId id, String direccion, String estado, String rentaMensual, InquilinoMongoEntidad inquilino) {
        this.id = id;
        this.direccion = direccion;
        this.estado = estado;
        this.rentaMensual = rentaMensual;
        this.inquilino = inquilino;
    }

    /**
     * Constructor sin id.
     * @param direccion
     * @param estado
     * @param rentaMensual
     * @param inquilino 
     */
    public InmuebleMongoEntidad(String direccion, String estado, String rentaMensual, InquilinoMongoEntidad inquilino) {
        this.direccion = direccion;
        this.estado = estado;
        this.rentaMensual = rentaMensual;
        this.inquilino = inquilino;
    }

    public InmuebleMongoEntidad() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRentaMensual() {
        return rentaMensual;
    }

    public void setRentaMensual(String rentaMensual) {
        this.rentaMensual = rentaMensual;
    }

    public InquilinoMongoEntidad getInquilino() {
        return inquilino;
    }

    public void setInquilino(InquilinoMongoEntidad inquilino) {
        this.inquilino = inquilino;
    }

    @Override
    public String toString() {
        return "InmuebleMongoEntidad{" + "id=" + id + ", direccion=" + direccion + ", estado=" + estado + ", rentaMensual=" + rentaMensual + ", inquilino=" + inquilino + '}';
    }
    
    
    
}
