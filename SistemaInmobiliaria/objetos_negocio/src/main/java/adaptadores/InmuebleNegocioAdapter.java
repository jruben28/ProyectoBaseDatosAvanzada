/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import dtos.comunes.InquilinoDTO;
import dtos.salida.InmuebleSalidaDTO;
import entidades.Inmueble;
import entidades.Inquilino;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joser
 */
public class InmuebleNegocioAdapter {
    
    
    /**
     * Convierte entidad inmueble a inbuemlesalidaDTO
     * @param inmueble
     * @return 
     */
    public InmuebleSalidaDTO entidadASalida(Inmueble inmueble){
        if (inmueble == null) {
            return null;
        }
        InmuebleSalidaDTO inmuebleDTO = new InmuebleSalidaDTO(inmueble.getId(),
                inmueble.getDireccion(),
                inmueble.isEstado(),
                inmueble.getTipo(),
                inmueble.getRentaMensual(),
                entidadInquilinoaDTO(inmueble.getInquilino()));
        
        return inmuebleDTO;
    }
    
    /**
     * convierte una lista de inmuebles en una lista de inmuebleSalidaDTO
     * @param inmuebles
     * @return 
     */
    public List<InmuebleSalidaDTO> entidadesASalidas(List<Inmueble> inmuebles){
        List<InmuebleSalidaDTO> salidas = new ArrayList<>();
        
        if (inmuebles == null) {
            return salidas;
        }
        
        for (Inmueble inmueble: inmuebles) {
            InmuebleSalidaDTO inmuebleDTO = entidadASalida(inmueble);
            
            if (inmuebleDTO != null) {
                salidas.add(inmuebleDTO);
            }
        }
        
        return salidas;
    }
    
    public Inquilino inquilinoDTOAEntidad(InquilinoDTO inquilinoDTO){
        Inquilino inquilino = new Inquilino();
        
        if (inquilinoDTO == null) {
            return inquilino;
        }
        
        inquilino.setNombre(inquilinoDTO.getNombre());
        inquilino.setApellidoPaterno(inquilinoDTO.getApellidoPaterno());
        inquilino.setApellidoMaterno(inquilino.getApellidoMaterno());
        inquilino.setIngresoMensual(inquilinoDTO.getIngresoMensual());
        inquilino.setTelefono(inquilinoDTO.getTelefono());
        
        return inquilino;
    
    }
    
    
    public InquilinoDTO entidadInquilinoaDTO(Inquilino inquilino){
        InquilinoDTO inquilinoDTO = new InquilinoDTO();
        
        if (inquilino == null) {
            return inquilinoDTO;
        }
        
        inquilinoDTO.setNombre(inquilino.getNombre());
        inquilinoDTO.setApellidoPaterno(inquilino.getApellidoPaterno());
        inquilinoDTO.setApellidoMaterno(inquilino.getApellidoMaterno());
        inquilinoDTO.setIngresoMensual(inquilino.getIngresoMensual());
        inquilinoDTO.setTelefono(inquilino.getTelefono());
        
        return inquilinoDTO;
        
    }
}
