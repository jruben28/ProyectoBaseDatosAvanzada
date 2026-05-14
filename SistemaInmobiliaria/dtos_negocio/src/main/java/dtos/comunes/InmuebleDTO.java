/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.comunes;

/**
 *
 * @author joser
 */
public record InmuebleDTO (
        String idInmueble,
        String direccion,
        boolean estado,
        String tipo,
        Float rentaMensual,
        InquilinoDTO inquilino
        ) {
    
}
