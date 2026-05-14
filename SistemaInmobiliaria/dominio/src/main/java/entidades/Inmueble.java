/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author joser
 */
public class Inmueble {
    private String id;
    private String direccion;
    private boolean estado;
    private String tipo;
    private Float rentaMensual;
    Inquilino inquilino;

    /**
     * Constructor con id.
     * @param id
     * @param direccion
     * @param estado
     * @param tipo
     * @param rentaMensual
     * @param inquilino 
     */
    public Inmueble(String id, String direccion, boolean estado, String tipo, Float rentaMensual, Inquilino inquilino) {
        this.id = id;
        this.direccion = direccion;
        this.estado = estado;
        this.tipo = tipo;
        this.rentaMensual = rentaMensual;
        this.inquilino = inquilino;
    }

    /**
     * Constructor sin id.
     * @param direccion
     * @param estado
     * @param tipo
     * @param rentaMensual
     * @param inquilino 
     */
    public Inmueble(String direccion, boolean estado, String tipo, Float rentaMensual, Inquilino inquilino) {
        this.direccion = direccion;
        this.estado = estado;
        this.tipo = tipo;
        this.rentaMensual = rentaMensual;
        this.inquilino = inquilino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Constructor por omisión.
     */
    public Inmueble() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Float getRentaMensual() {
        return rentaMensual;
    }

    public void setRentaMensual(Float rentaMensual) {
        this.rentaMensual = rentaMensual;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    
    /**
     * Metodo to string.
     * @return 
     */
    @Override
    public String toString() {
        return "Inmueble{" + "id=" + id + ", direccion=" + direccion + ", estado=" + estado + ", tipo=" + tipo + ", rentaMensual=" + rentaMensual + ", inquilino=" + inquilino + '}';
    }
}
