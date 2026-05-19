/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import adaptadores.InmuebleNegocioAdapter;
import daos.IInmuebleDAO;
import daos.InmuebleDAO;
import dtos.comunes.InmuebleDTO;
import dtos.comunes.InquilinoDTO;
import dtos.entrada.RegistrarInmuebleDTO;
import dtos.salida.InmuebleSalidaDTO;
import entidades.Inmueble;
import entidades.Inquilino;
import excepcion.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joser
 */
public class InmuebleBO implements IInmuebleBO{
    
    private final IInmuebleDAO inmuebleDAO;
    private final InmuebleNegocioAdapter inmuebleAdapter;
    private static final Logger LOG = Logger.getLogger(InmuebleBO.class.getName());
    
    
    public InmuebleBO() {
        this.inmuebleDAO = new InmuebleDAO();
        this.inmuebleAdapter = new InmuebleNegocioAdapter();
    }
    
    

    @Override
    public List<InmuebleSalidaDTO> listarInmueblesDisponibles() throws NegocioException {
        try{
            return inmuebleAdapter.entidadesASalidas(inmuebleDAO.listarInmueblesDisponibles());
        }
        catch(PersistenciaException ex){
            LOG.log(Level.WARNING, "Error en capa de negocio al querer listar inmuebles disponibles.");
            throw new NegocioException("No se pudo listar los inmuebles disponibles.", ex);
                    
        }
    }

    @Override
    public InmuebleSalidaDTO buscarInmueblePorId(String idInmueble) throws NegocioException {
        try{
            validarIdInmueble(idInmueble);
            
            Inmueble inmueble = inmuebleDAO.buscarInmueblePorId(idInmueble);
            return inmuebleAdapter.entidadASalida(inmueble);
        
        } catch (PersistenciaException ex) {
            LOG.log(Level.WARNING, "Error en capa de negocio al querer buscar inmueble por id");
            throw new NegocioException("No se pudo buscar el inmueble por id.", ex);
        }
        catch(NegocioException ex){
            LOG.log(Level.WARNING, "Se intentó ingresar un valir de id no valido.");
            throw ex;
        }
    }

    @Override
    public boolean registrarInquilino(String idInmueble, InquilinoDTO inquilinoDTO) throws NegocioException {
        try{
            validarIdInmueble(idInmueble);
            validarInquilinoDTO(inquilinoDTO);
            Inquilino inquilino = inmuebleAdapter.inquilinoDTOAEntidad(inquilinoDTO);
            return inmuebleDAO.registrarInquilino(idInmueble, inquilino);
        }
        catch(PersistenciaException ex){
            LOG.log(Level.WARNING, "Error en capa de negocio al querer registrar inquilino.");
            throw new NegocioException("No se pudo registrar el inquilino.", ex);
        }
        catch(NegocioException ex){
            LOG.log(Level.WARNING, "Se intentó agregar datos no validos.");
            throw ex;
        }
    }

    
    private void validarIdInmueble(String idInmueble) throws NegocioException{
        if (idInmueble == null || idInmueble.isBlank()) {
            throw new NegocioException("El id ingresado no es valido.");
        }
    
    }
    
    
    public void validarInquilinoDTO(InquilinoDTO inquilino) throws NegocioException{

        if (inquilino == null) {
            throw new NegocioException("Inquilino no valido");
        }

        // Nombre
        if (inquilino.getNombre() == null || inquilino.getNombre().isBlank()) {
            throw new NegocioException("Nombre no valido");
        }

        // Apellido paterno
        if (inquilino.getApellidoPaterno() == null || inquilino.getApellidoPaterno().isBlank()) {
            throw new NegocioException("Apellido paterno no valido");
        }

        // Apellido materno
        if (inquilino.getApellidoMaterno() == null || inquilino.getApellidoMaterno().isBlank()) {
            throw new NegocioException("Apellido materno no valido");
        }

        // Ingreso mensual
        if (inquilino.getIngresoMensual() == null || inquilino.getIngresoMensual() < 0) {
            throw new NegocioException("Ingreso no valido");
        }

        // Teléfono
        if (inquilino.getTelefono() == null || inquilino.getTelefono().isBlank()) {
            throw new NegocioException("Telefono no valido");
        }

        // Validar teléfono de 10 dígitos
        if (!inquilino.getTelefono().matches("\\d{10}")) {
            throw new NegocioException("Telefono no valido");
        }
    }

    @Override
    public List<InmuebleSalidaDTO> listarInmueblesRentados() throws NegocioException {
        try{
            return inmuebleAdapter.entidadesASalidas(inmuebleDAO.listarInmueblesRentados());
        }
        catch(PersistenciaException ex){
            LOG.log(Level.WARNING, "Error en capa de negocio al querer listar inmuebles rentados.");
            throw new NegocioException("No se pudo listar los inmuebles rentados.", ex);
                    
        }
    }
    
}
