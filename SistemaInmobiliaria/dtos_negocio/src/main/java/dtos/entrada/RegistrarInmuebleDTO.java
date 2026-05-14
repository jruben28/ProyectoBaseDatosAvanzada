/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.entrada;

import dtos.comunes.InquilinoDTO;

/**
 *
 * @author joser
 */
public record RegistrarInmuebleDTO (
        String idInmueble,
        String direccion,
        boolean estado,
        String tipo,
        Float rentaMensual,
        InquilinoDTO inquilino) {
    
}
