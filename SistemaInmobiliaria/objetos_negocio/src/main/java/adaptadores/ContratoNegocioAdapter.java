/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import dtos.comunes.ContratoDTO;
import dtos.entrada.RegistrarContratoDTO;
import dtos.salida.ContratoSalidaDTO;
import entidades.Contrato;

/**
 *
 * @author joser
 */
public class ContratoNegocioAdapter {

    public Contrato RegistrarDTOAEntidad(RegistrarContratoDTO contratoDTO) {
        if (contratoDTO == null) {
            return null;
        }
        
        Contrato contrato = new Contrato();
        
        contrato.setIdInmueble(contratoDTO.getIdInmueble());
        contrato.setFechaInicio(contratoDTO.getFechaInicio());
        
        return contrato;
        
    }

    public Contrato DTOAEntidad(ContratoDTO contratoDTO) {
        if (contratoDTO == null) {
            return null;
        }
        
        Contrato contrato = new Contrato();
        
        
        contrato.setFechaInicio(contratoDTO.getFechaInicio());
        contrato.setFechaFin(contratoDTO.getFechaFin());
        contrato.setIdInmueble(contratoDTO.getIdInmueble());
        contrato.setAdeudo(contratoDTO.getAdeudo());
        contrato.setMotivo(contratoDTO.getMotivo());
        contrato.setObservaciones(contratoDTO.getObservaciones());
        
        return contrato;
        
    }

    public ContratoSalidaDTO entidadASalidaDTO(Contrato contrato) {
        if (contrato == null) {
            return null;
        }
        
        ContratoSalidaDTO salida = new ContratoSalidaDTO(
                contrato.getFechaInicio(),
                contrato.getFechaFin(),
                contrato.getIdInmueble(),
                contrato.getAdeudo(),
                contrato.getMotivo(),
                contrato.getObservaciones()
        );
        
        return salida;
    }
    
}
