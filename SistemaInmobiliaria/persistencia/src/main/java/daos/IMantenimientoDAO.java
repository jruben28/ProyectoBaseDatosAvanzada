/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidades.Mantenimiento;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author joser
 */
public interface IMantenimientoDAO {
    List<Mantenimiento> listarMantenimientosPendientes() throws PersistenciaException;
    
    List<Mantenimiento> listarMantenimientos() throws PersistenciaException;
    
    boolean finalizarMantenimiento(Mantenimiento mantenimiento) throws PersistenciaException;
    
    Mantenimiento crearMantenimiento(Mantenimiento mantenimiento) throws PersistenciaException;
    
    Mantenimiento obtenerMantenimiento(String idMantenimiento) throws PersistenciaException;
}
