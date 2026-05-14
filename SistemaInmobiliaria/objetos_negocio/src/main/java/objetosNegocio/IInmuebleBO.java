/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package objetosNegocio;

import dtos.comunes.InmuebleDTO;
import dtos.comunes.InquilinoDTO;
import dtos.entrada.RegistrarInmuebleDTO;
import dtos.salida.InmuebleSalidaDTO;
import excepcion.NegocioException;
import java.util.List;

/**
 *
 * @author joser
 */
public interface IInmuebleBO{
    
    /**
     * Lista inmuebles con estado en disponible
     * @return lista con inmuebles sin inquilino 
     * @throws excepcion.NegocioException 
     */
    List<InmuebleSalidaDTO> listarInmueblesDisponibles() throws NegocioException;
    
    /**
     * Obtiene el inmueble buscado según su id.
     * @param idInmueble
     * @return 
     * @throws excepcion.NegocioException 
     */
    public InmuebleSalidaDTO buscarInmueblePorId(String idInmueble) throws NegocioException;
    
    /**
     * Registra un inquilino embebido al inmueble y cambia el estado. 
     * @param idInmueble
     * @param inquilinoDTO
     * @return 
     * @throws excepcion.NegocioException 
     */
    public boolean registrarInquilino(String idInmueble, InquilinoDTO inquilinoDTO) throws NegocioException;
    
}
