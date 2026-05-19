/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package objetosNegocio;

import dtos.comunes.MantenimientoDTO;
import dtos.entrada.RegistrarMantenimientoDTO;
import dtos.salida.MantenimientoSalidaDTO;
import excepcion.NegocioException;
import java.util.List;

/**
 *
 * @author joser
 */
public interface IMantenimientoBO {
    
    /**
     * Lista mantenimientos pendientes
     * @return
     * @throws NegocioException 
     */
    List<MantenimientoSalidaDTO> listarMantenimientosPendientes() throws NegocioException;
    
    /**
     * Lista mantenimientos
     * @return
     * @throws NegocioException 
     */
    List<MantenimientoSalidaDTO> listarMantenimientos() throws NegocioException;
    
    /**
     * Finaliza un mantenimiento
     * @param mantenimientoDTO
     * @return
     * @throws NegocioException 
     */
    boolean finalizarMantenimiento(MantenimientoDTO mantenimientoDTO) throws NegocioException;
    
    /**
     * Registramos nuevo mantenimiento
     * @param mantenimientoDTO
     * @return
     * @throws NegocioException 
     */
    RegistrarMantenimientoDTO crearMantenimiento(RegistrarMantenimientoDTO mantenimientoDTO) throws NegocioException;
    
    /**
     * Obtenemos mantenimiento por id
     * @param idMantenimiento
     * @return
     * @throws NegocioException 
     */
    MantenimientoSalidaDTO obtenerMantenimiento(String idMantenimiento) throws NegocioException;
}
