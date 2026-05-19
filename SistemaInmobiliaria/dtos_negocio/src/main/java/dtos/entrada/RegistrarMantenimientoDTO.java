/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.entrada;

/**
 *
 * @author joser
 */
public record RegistrarMantenimientoDTO(
        String idMantenimiento,
        String idInmueble,
        String descripcion,
        String prioridad,
        String tipo,
        String estado,
        Float costo,
        String notas) {

}
