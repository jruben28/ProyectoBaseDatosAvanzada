/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import adaptadores.InmueblePersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import conexion.ConexionMongo;
import dtos.ReporteInmuebleSinInquilino;
import entidades.Inmueble;
import entidades.Inquilino;
import entidadesMongo.InmuebleMongoEntidad;
import entidadesMongo.InquilinoMongoEntidad;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

/**
 *
 * @author joser
 */
public class InmuebleDAO implements IInmuebleDAO{
    private final MongoCollection<InmuebleMongoEntidad> coleccionInmuebles;
    private final InmueblePersistenciaAdapter inmuebleAdapter;
    
    private static final Logger LOG = Logger.getLogger(InmuebleDAO.class.getName());

    /**
     * Constructos que inicializa las variables.
     */
    public InmuebleDAO() {
        this.coleccionInmuebles = ConexionMongo.obtenerColeccionInmuebles();
        this.inmuebleAdapter = new InmueblePersistenciaAdapter();
    }
    
    

    /**
     * Accede a la coleccion de inmuebles, las mapea a entidades y regresa la lista de entidades de inmuebles.
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public List<Inmueble> listarInmueblesDisponibles() throws PersistenciaException {
        
        try{
            List<InmuebleMongoEntidad> entidadesMongo = coleccionInmuebles
                    .find(eq("estado", true))
                    .into(new ArrayList<>());
            
            return inmuebleAdapter.convertirListaADominio(entidadesMongo);
        }
        catch(MongoException ex){
            throw new PersistenciaException("Se produjo un error al listar los inmuebles disponibles.", ex);
        }
        
    }

    /**
     * Busca el inmueble según su id y lo devuelve.
     * @param idInmueble
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Inmueble buscarInmueblePorId(String idInmueble) throws PersistenciaException {
        ObjectId id = inmuebleAdapter.convertirStringAObjectId(idInmueble);
        
        if (id == null) {
            return null;
        }
        
        try {
            InmuebleMongoEntidad entidadMongo = coleccionInmuebles
                    .find(eq("_id", id))
                    .first();

            return inmuebleAdapter.convertirADominio(entidadMongo);

        } catch (MongoException ex) {
            throw new PersistenciaException(
                    "No fue posible obtener el inmueble por id.", ex
            );
        }
        
    }

    /**
     * Registra un inquilino dentro de el inmueble con el que coincida el id.
     * @param idInmueble
     * @param inquilino
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public boolean registrarInquilino(String idInmueble, Inquilino inquilino) throws PersistenciaException {
        
        ObjectId id = inmuebleAdapter.convertirStringAObjectId(idInmueble);
        
        if (id == null) {
            return false;
        }
        
        if (inquilino == null) {
            throw new PersistenciaException("No se puede registrar un inquilino nulo");
        }
        
        
        try{
            InquilinoMongoEntidad inquilinoMongo = new InquilinoMongoEntidad(
                    inquilino.getNombre(),
                    inquilino.getApellidoPaterno(),
                    inquilino.getApellidoMaterno(),
                    inquilino.getIngresoMensual(),
                    inquilino.getTelefono()
            );
            
            
            UpdateResult resultado = coleccionInmuebles.updateOne(
                    eq("_id", id),
                    combine(
                            set("inquilino", inquilinoMongo),
                            set("estado", false)
                    )
            );
            
            LOG.log(Level.INFO, "Se agregó un inquilino en el inmueble.");
            return resultado.getModifiedCount() > 0;
            
            
        }
        catch(MongoException ex){
            LOG.log(Level.WARNING, "Se intentó regisrar un inquilino en un inmueble sin éxito.");
            throw new PersistenciaException("Error al registrar inquilino.", ex);
        }
        
    }

    /**
     * Registra inmueble, metodo de momento de depuracion.
     * @param inmueble
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Inmueble registrarInmueble(Inmueble inmueble) throws PersistenciaException {
        if (inmueble == null) {
            throw new PersistenciaException("No puede ser null el inmueble.");
        }
        
        try{
            InmuebleMongoEntidad entidadMongo = inmuebleAdapter.convertirAMongo(inmueble);
            
            if (entidadMongo.getId() == null) {
                entidadMongo.setId(new ObjectId());
            }
            
            coleccionInmuebles.insertOne(entidadMongo);
            
            LOG.log(Level.INFO, "ID de inmueble:  " + inmuebleAdapter.convertirObjectIdAString(entidadMongo.getId()));
            return inmuebleAdapter.convertirADominio(entidadMongo);
        }
        catch(MongoException ex){
            throw new PersistenciaException("Error al registrar inmueble.");
        }
    }
    
}
