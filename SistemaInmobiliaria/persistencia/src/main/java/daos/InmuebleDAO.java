/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class InmuebleDAO implements IInmuebleDAO{

    @Override
    public List<ReporteInmuebleSinInquilino> listarInmueblesDisponibles() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Inmueble buscarInmueblePorId(String idInmueble) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Inmueble registrarInquilino(String idInmueble, Inquilino inquilino) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
