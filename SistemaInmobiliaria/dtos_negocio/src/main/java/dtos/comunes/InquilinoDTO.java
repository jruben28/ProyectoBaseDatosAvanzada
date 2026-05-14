/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.comunes;

/**
 *
 * @author joser
 */
public record InquilinoDTO (
        String nombres,
        String apellidoPaterno,
        String apellidoMaterno,
        Float ingresoMensual,
        String telefono
        ) {
    
}
