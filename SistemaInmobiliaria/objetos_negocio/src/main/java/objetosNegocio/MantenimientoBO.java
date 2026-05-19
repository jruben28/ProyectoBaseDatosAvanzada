/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import adaptadores.MantenimientoNegocioAdapter;
import daos.IMantenimientoDAO;
import daos.MantenimientoDAO;
import dtos.comunes.MantenimientoDTO;
import dtos.entrada.RegistrarMantenimientoDTO;
import dtos.salida.MantenimientoSalidaDTO;
import entidades.Mantenimiento;
import excepcion.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author joser
 */
public class MantenimientoBO implements IMantenimientoBO{
    
    public final IMantenimientoDAO mantenimientoDAO;
    public final MantenimientoNegocioAdapter mantenimientoAdapter;
    private static final Logger LOG = Logger.getLogger(MantenimientoBO.class.getName());
    

    public MantenimientoBO() {
        this.mantenimientoDAO = new MantenimientoDAO();
        this.mantenimientoAdapter = new MantenimientoNegocioAdapter();
    }
    
    

    @Override
    public List<MantenimientoSalidaDTO> listarMantenimientosPendientes() throws NegocioException {
        try{
        
            return mantenimientoAdapter.entidadesASalidas(mantenimientoDAO.listarMantenimientosPendientes());
        }
        catch(PersistenciaException ex){
            throw new NegocioException("", ex);
        }
    }

    @Override
    public List<MantenimientoSalidaDTO> listarMantenimientos() throws NegocioException {
        try{
            return mantenimientoAdapter.entidadesASalidas(mantenimientoDAO.listarMantenimientos());
        }
        catch(PersistenciaException ex){
            throw new NegocioException("", ex);
        }
    }

    @Override
    public boolean finalizarMantenimiento(MantenimientoDTO mantenimientoDTO) throws NegocioException {
        try{
            //validar dto
            validarCamposMantenimientoDTO(mantenimientoDTO);
            return mantenimientoDAO.finalizarMantenimiento(mantenimientoAdapter.DTOAEntidad(mantenimientoDTO));
        }
        catch(PersistenciaException ex){
            throw new NegocioException("", ex);
        }
    }

    @Override
    public RegistrarMantenimientoDTO crearMantenimiento(RegistrarMantenimientoDTO mantenimientoDTO) throws NegocioException {
        try{
            //validar dto
            validarCamposRegistrarMantenimientoDTO(mantenimientoDTO);
            mantenimientoDAO.crearMantenimiento(mantenimientoAdapter.registroDTOAEntidad(mantenimientoDTO));
            
            return mantenimientoDTO;
            
        }
        catch(PersistenciaException ex){
            throw new NegocioException("", ex);
        }
    }

    @Override
    public MantenimientoSalidaDTO obtenerMantenimiento(String idMantenimiento) throws NegocioException {
        try{
            MantenimientoSalidaDTO salida = mantenimientoAdapter.entidadASalida(mantenimientoDAO.obtenerMantenimiento(idMantenimiento));
            
            return salida;
        }
        catch(PersistenciaException ex){
            throw new NegocioException("", ex);
        }
    }

    public void validarCamposMantenimientoDTO(MantenimientoDTO mantenimiento) throws IllegalArgumentException {

        String descripcion = mantenimiento.getDescripcion();
        String prioridad  = mantenimiento.getPrioridad();
        String tipo = mantenimiento.getTipo();
        String estado = mantenimiento.getEstado();
        Float costo = mantenimiento.getCosto();
        
        // 1. Validación de campos obligatorios (Strings)
        // Verificamos que no sean nulos y que no estén vacíos tras quitar espacios
        if (mantenimiento.getIdInmueble() == null || mantenimiento.getIdInmueble().isEmpty()) {
            throw new IllegalArgumentException("El ID del inmueble es obligatorio.");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción es obligatoria.");
        }
        if (prioridad == null || prioridad.trim().isEmpty()) {
            throw new IllegalArgumentException("La prioridad es obligatoria.");
        }
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de mantenimiento es obligatorio.");
        }
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado es obligatorio.");
        }

        // 2. Validación del campo numérico (Float)
        // Verificamos que no sea nulo (para evitar NullPointerException) y que sea positivo
        if (costo == null) {
            throw new IllegalArgumentException("El costo no puede ser nulo.");
        }
        if (costo < 0) {
            throw new IllegalArgumentException("El costo debe ser un valor positivo o cero.");
        }


    }
    
    public void validarCamposRegistrarMantenimientoDTO(RegistrarMantenimientoDTO mantenimiento) throws IllegalArgumentException {

        String descripcion = mantenimiento.descripcion();
        String prioridad  = mantenimiento.prioridad();
        String tipo = mantenimiento.tipo();
        String estado = mantenimiento.estado();
        Float costo = mantenimiento.costo();
                ;
        
        // 1. Validación de campos obligatorios (Strings)
        // Verificamos que no sean nulos y que no estén vacíos tras quitar espacios
        if (mantenimiento.idInmueble() == null || mantenimiento.idInmueble().isEmpty()) {
            throw new IllegalArgumentException("El ID del inmueble es obligatorio.");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción es obligatoria.");
        }
        if (prioridad == null || prioridad.trim().isEmpty()) {
            throw new IllegalArgumentException("La prioridad es obligatoria.");
        }
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de mantenimiento es obligatorio.");
        }
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado es obligatorio.");
        }

        // 2. Validación del campo numérico (Float)
        // Verificamos que no sea nulo (para evitar NullPointerException) y que sea positivo
        if (costo == null) {
            throw new IllegalArgumentException("El costo no puede ser nulo.");
        }
        if (costo < 0) {
            throw new IllegalArgumentException("El costo debe ser un valor positivo o cero.");
        }


    }
    
}
