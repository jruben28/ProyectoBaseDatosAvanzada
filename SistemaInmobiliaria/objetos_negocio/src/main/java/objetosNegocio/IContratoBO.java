/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package objetosNegocio;

import dtos.comunes.ContratoDTO;
import dtos.entrada.RegistrarContratoDTO;
import dtos.salida.ContratoSalidaDTO;
import excepcion.NegocioException;

/**
 *
 * @author joser
 */
public interface IContratoBO {
    
    /**
     * Creamos contrato
     * @param contrato
     * @return
     * @throws NegocioException 
     */
    RegistrarContratoDTO crearContrato(RegistrarContratoDTO contrato) throws NegocioException;
    
    /**
     * Editar contrato
     * @param contrato
     * @return
     * @throws NegocioException 
     */
    boolean editarContrato(ContratoDTO contrato) throws NegocioException;
    
    /**
     * Buscar contrato activo
     * @param contrato
     * @return
     * @throws NegocioException 
     */
    ContratoSalidaDTO buscarContrato(String idInmueble) throws NegocioException;
    
}
