/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import dtos.ReporteInmuebleSinInquilino;
import entidades.Inmueble;
import entidades.Inquilino;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author joser
 */
public interface IInmuebleDAO {
    
    /**
     * Lista inmuebles con estado en disponible
     * @return lista con inmuebles sin inquilino
     * @throws PersistenciaException 
     */
    List<Inmueble> listarInmueblesDisponibles() throws PersistenciaException;
    
    /**
     * Obtiene el inmueble buscado según su id.
     * @param idInmueble
     * @return
     * @throws PersistenciaException 
     */
    public Inmueble buscarInmueblePorId(String idInmueble) throws PersistenciaException;
    
    /**
     * Registra un inquilino embebido al inmueble y cambia el estado. 
     * @param idInmueble
     * @param inquilino
     * @return
     * @throws PersistenciaException 
     */
    public boolean registrarInquilino(String idInmueble, Inquilino inquilino) throws PersistenciaException;
    
    /**
     * Registrar inmueble metodo de depuracion no tiene uso en caso de uso.
     * @param inmueble
     * @return
     * @throws PersistenciaException 
     */
    public Inmueble registrarInmueble(Inmueble inmueble) throws PersistenciaException;
    
    /**
     * Lista inmuebles que esten no disponibles y tengan un inquilino.
     * @return
     * @throws PersistenciaException 
     */
    public List<Inmueble> listarInmueblesRentados() throws PersistenciaException;
}
