/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.salida;

/**
 *
 * @author joser
 */
public record MantenimientoSalidaDTO(
        String idMantenimiento,
        String idInmueble,
        String descripcion,
        String prioridad,
        String tipo,
        String estado,
        Float costo,
        String notas) {

}
