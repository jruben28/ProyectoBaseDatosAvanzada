/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package framePrincipal;

import dtos.comunes.InquilinoDTO;
import dtos.salida.InmuebleSalidaDTO;

/**
 *
 * @author joser
 */
public class ControlObjetos {
    
    InquilinoDTO inquilino;
    
    InmuebleSalidaDTO inmuebleSeleccionado;

    public ControlObjetos() {
    }

    public InmuebleSalidaDTO getInmuebleSeleccionado() {
        return inmuebleSeleccionado;
    }

    public void setInmuebleSeleccionado(InmuebleSalidaDTO inmuebleSeleccionado) {
        this.inmuebleSeleccionado = inmuebleSeleccionado;
    }
    
    

    public InquilinoDTO getInquilino() {
        return inquilino;
    }

    public void setInquilino(InquilinoDTO inquilino) {
        this.inquilino = inquilino;
    }
    
    
    
    
    
}
