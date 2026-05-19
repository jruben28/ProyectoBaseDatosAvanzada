/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidades.Contrato;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author joser
 */
public interface IContratoDAO {
    /**
     * Crea contrato
     * @param contrato
     * @return
     * @throws PersistenciaException 
     */
    Contrato crearContrato(Contrato contrato) throws PersistenciaException;
    
    /**
     * Modificamos un contrato existente.
     * @param contrato
     * @return
     * @throws PersistenciaException 
     */
    boolean editarContrado(Contrato contrato) throws PersistenciaException;
    
    /**
     * Busca un contrato según el id de Inmueble
     * @param idInmueble
     * @return
     * @throws PersistenciaException 
     */
    Contrato buscarContrato(String idInmueble) throws PersistenciaException;
    
}
