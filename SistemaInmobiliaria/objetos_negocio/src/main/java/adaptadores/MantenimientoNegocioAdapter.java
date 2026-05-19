/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import dtos.comunes.MantenimientoDTO;
import dtos.entrada.RegistrarMantenimientoDTO;
import dtos.salida.MantenimientoSalidaDTO;
import entidades.Mantenimiento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joser
 */
public class MantenimientoNegocioAdapter {

    public List<MantenimientoSalidaDTO> entidadesASalidas(List<Mantenimiento> listarMantenimientosPendientes) {
        List<MantenimientoSalidaDTO> salidas = new ArrayList<>();
        
        for (Mantenimiento mantenimiento: listarMantenimientosPendientes) {
            salidas.add(entidadASalida(mantenimiento));
        }
        
        return salidas;
    }

    public Mantenimiento DTOAEntidad(MantenimientoDTO mantenimientoDTO) {
        if (mantenimientoDTO == null) {
            return null;
        }
        
        Mantenimiento mantenimiento = new Mantenimiento();
        
        mantenimiento.setIdMantenimiento(mantenimientoDTO.getIdMantenimiento());
        mantenimiento.setIdInmueble(mantenimientoDTO.getIdInmueble());
        mantenimiento.setDescripcion(mantenimientoDTO.getDescripcion());
        mantenimiento.setPrioridad(mantenimientoDTO.getPrioridad());
        mantenimiento.setTipo(mantenimientoDTO.getTipo());
        mantenimiento.setEstado(mantenimientoDTO.getEstado());
        mantenimiento.setCosto(mantenimientoDTO.getCosto());
        mantenimiento.setNotas(mantenimientoDTO.getNotas());
        
        return mantenimiento;
        
    }

    public Mantenimiento registroDTOAEntidad(RegistrarMantenimientoDTO mantenimientoDTO) {
        if (mantenimientoDTO == null) {
            return null;
        }
        
        Mantenimiento mantenimiento = new Mantenimiento();
        
        mantenimiento.setIdMantenimiento(mantenimientoDTO.getIdMantenimiento());
        mantenimiento.setIdInmueble(mantenimientoDTO.getIdInmueble());
        mantenimiento.setDescripcion(mantenimientoDTO.getDescripcion());
        mantenimiento.setPrioridad(mantenimientoDTO.getPrioridad());
        mantenimiento.setTipo(mantenimientoDTO.getTipo());
        mantenimiento.setEstado(mantenimientoDTO.getEstado());
        mantenimiento.setCosto(mantenimientoDTO.getCosto());
        mantenimiento.setNotas(mantenimientoDTO.getNotas());
        
        return mantenimiento;
        
        
        
    }

    public MantenimientoSalidaDTO entidadASalida(Mantenimiento mantenimiento) {
        if (mantenimiento == null) {
            return null;
        }
        MantenimientoSalidaDTO mantenimientoDTO = new MantenimientoSalidaDTO(
                mantenimiento.getIdMantenimiento(),
                mantenimiento.getIdInmueble(),
                mantenimiento.getDescripcion(),
                mantenimiento.getPrioridad(),
                mantenimiento.getTipo(),
                mantenimiento.getEstado(),
                mantenimiento.getCosto(),
                mantenimiento.getNotas());
        
        return mantenimientoDTO;
    }
    
}
