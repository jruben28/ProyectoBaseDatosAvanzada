/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import adaptadores.InmueblePersistenciaAdapter;
import com.mongodb.client.MongoCollection;
import conexion.ConexionMongo;
import dtos.ReporteInmuebleSinInquilino;
import entidades.Inmueble;
import entidades.Inquilino;
import entidadesMongo.InmuebleMongoEntidad;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author joser
 */
public class InmuebleDAO implements IInmuebleDAO{
    private final MongoCollection<InmuebleMongoEntidad> coleccionInmuebles;
    private final InmueblePersistenciaAdapter inmuebleAdapter;
    
    private static final Logger LOG = Logger.getLogger(InmuebleDAO.class.getName());

    public InmuebleDAO() {
        this.coleccionInmuebles = ConexionMongo.obtenerColeccionInmuebles();
        this.inmuebleAdapter = new InmueblePersistenciaAdapter();
    }
    
    

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
