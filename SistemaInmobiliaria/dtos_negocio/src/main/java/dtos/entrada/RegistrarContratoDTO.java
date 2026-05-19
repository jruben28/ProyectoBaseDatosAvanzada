/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.entrada;

import java.time.Instant;

/**
 *
 * @author joser
 */
public record RegistrarContratoDTO(
        Instant fechaInicio,
        Instant fechaFin,
        String idInmueble,
        Float adeudo,
        String motivo,
        String observaciones) {
    
}
