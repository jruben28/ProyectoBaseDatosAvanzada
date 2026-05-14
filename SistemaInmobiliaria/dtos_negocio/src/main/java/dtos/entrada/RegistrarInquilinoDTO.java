/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.entrada;

/**
 *
 * @author joser
 */
public record RegistrarInquilinoDTO (
        String nombres,
        String apellidoPaterno,
        String apellidoMaterno,
        Float ingresoMensual,
        String telefono){
    
}
