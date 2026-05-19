/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import adaptadores.ContratoNegocioAdapter;
import daos.ContratoDAO;
import daos.IContratoDAO;
import dtos.comunes.ContratoDTO;
import dtos.entrada.RegistrarContratoDTO;
import dtos.salida.ContratoSalidaDTO;
import entidades.Contrato;
import excepcion.NegocioException;
import excepciones.PersistenciaException;
import java.time.Instant;
import java.util.logging.Logger;

/**
 *
 * @author joser
 */
public class ContratoBO implements IContratoBO{
    
    public final IContratoDAO contratoDAO;
    public final ContratoNegocioAdapter contratoAdaper;
    private static final Logger LOG = Logger.getLogger(ContratoBO.class.getName());
    

    public ContratoBO() {
        this.contratoDAO = new ContratoDAO(); 
        this.contratoAdaper = new ContratoNegocioAdapter();
    }
    
    

    @Override
    public RegistrarContratoDTO crearContrato(RegistrarContratoDTO contrato) throws NegocioException {
        try{
            //validar contratodto, solo necesita fecha de inicio y id inmueble.
            
            contratoDAO.crearContrato(contratoAdaper.RegistrarDTOAEntidad(contrato));
            
            return contrato;
        }
        catch(PersistenciaException ex){
            throw new NegocioException("No se pudo crear el contrato", ex);
        }
    }

    @Override
    public boolean editarContrato(ContratoDTO contrato) throws NegocioException {
        try{
            //validar datos contrato
            System.out.println("llegamos aca");
            return contratoDAO.editarContrado(contratoAdaper.DTOAEntidad(contrato));
        
        }
        catch(PersistenciaException ex){
            throw new NegocioException("No se pudo editar el contrato.", ex);
        }
    }

    @Override
    public ContratoSalidaDTO buscarContrato(String idInmueble) throws NegocioException {
        try{
            
            Contrato contratoEncontrado = contratoDAO.buscarContrato(idInmueble);
            if (contratoEncontrado == null) {
                throw new NegocioException("No se pudo encontrar el contrato.");
            }
            
            return contratoAdaper.entidadASalidaDTO(contratoEncontrado);
        }
        catch(PersistenciaException ex){
            throw new NegocioException("", ex);
        }
    }

    public void validarContrato(ContratoDTO contrato) throws IllegalArgumentException {

        Instant fechaInicio = contrato.getFechaInicio();
        Instant fechaFin = contrato.getFechaFin();
        String idInmueble = contrato.getIdInmueble();
        Float adeudo = contrato.getAdeudo();
        String motivo = contrato.getMotivo();

        // 1. Validar Fechas (Obligatorias y coherentes)
        if (fechaInicio == null) {
            throw new IllegalArgumentException("La fecha de inicio es obligatoria.");
        }
        if (fechaFin == null) {
            throw new IllegalArgumentException("La fecha de fin es obligatoria.");
        }
        // Verificamos que la fecha de fin sea posterior a la de inicio
        if (fechaFin.isBefore(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio.");
        }

        // 2. Validar ID del Inmueble (Obligatorio)
        if (idInmueble == null || idInmueble.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del inmueble es obligatorio.");
        }

        // 3. Validar Adeudo (No nulo y no negativo)
        if (adeudo == null) {
            throw new IllegalArgumentException("El adeudo no puede ser nulo (use 0 si no hay deuda).");
        }
        if (adeudo < 0) {
            throw new IllegalArgumentException("El adeudo no puede ser un valor negativo.");
        }

        // 4. Validar Motivo (Obligatorio)
        if (motivo == null || motivo.trim().isEmpty()) {
            throw new IllegalArgumentException("El motivo del contrato es obligatorio.");
        }
    }
    
}
