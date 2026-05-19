/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import adaptadores.MantenimientoPersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import conexion.ConexionMongo;
import entidades.Mantenimiento;
import entidadesMongo.MantenimientoMongoEntidad;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author joser
 */
public class MantenimientoDAO implements IMantenimientoDAO{
    private final MongoCollection<MantenimientoMongoEntidad> coleccionMantenimientos;
    private final MantenimientoPersistenciaAdapter mantenimientoAdapter;

    public MantenimientoDAO() {
        
        this.coleccionMantenimientos = ConexionMongo.obtenerColeccionMantenimiento();
        this.mantenimientoAdapter = new MantenimientoPersistenciaAdapter();
    }

    @Override
    public List<Mantenimiento> listarMantenimientosPendientes() throws PersistenciaException {
        try{
            List<MantenimientoMongoEntidad> entidadesMongo = coleccionMantenimientos
                    .find(eq("estado", "pendiente"))
                    .into(new ArrayList<>());
            
            return mantenimientoAdapter.convertirListaADominio(entidadesMongo);
        }
        catch(MongoException ex){
            throw new PersistenciaException("Se produjo un error al listar los mantenimientos disponibles disponibles.", ex);
        }
    }

    @Override
    public List<Mantenimiento> listarMantenimientos() throws PersistenciaException {
        try{
            List<MantenimientoMongoEntidad> entidadesMongo = coleccionMantenimientos
                    .find()
                    .into(new ArrayList<>());
            
            return mantenimientoAdapter.convertirListaADominio(entidadesMongo);
        }
        catch(MongoException ex){
            throw new PersistenciaException("Se produjo un error al listar los mantenimientos disponibles disponibles.", ex);
        }
        
    }

    @Override
    public boolean finalizarMantenimiento(Mantenimiento mantenimiento) throws PersistenciaException {
        ObjectId id = mantenimientoAdapter.convertirStringAObjectId(mantenimiento.getIdMantenimiento());

        if (id == null) {
            return false;
        }

        try {
            UpdateResult resultado = coleccionMantenimientos.updateOne(
                    eq("_id", id),
                    combine(
                            set("estado", mantenimiento.getEstado()),
                            set("notas", mantenimiento.getNotas())
                    )
            );

            return resultado.getModifiedCount() > 0;

        } catch (MongoException ex) {
            throw new PersistenciaException(
                    "No fue posible completar mantenimiento", ex
            );
        }
    }

    @Override
    public Mantenimiento obtenerMantenimiento(String idMantenimiento) throws PersistenciaException {
        ObjectId id = mantenimientoAdapter.convertirStringAObjectId(idMantenimiento);

        if (id == null) {
            return null;
        }

        try {
            MantenimientoMongoEntidad entidadMongo = coleccionMantenimientos
                    .find(eq("_id", id))
                    .first();

            return mantenimientoAdapter.convertirADominio(entidadMongo);

        } catch (MongoException ex) {
            throw new PersistenciaException(
                    "No fue posible obtener el mantenimiento por id.", ex
            );
        }
    }

    @Override
    public Mantenimiento crearMantenimiento(Mantenimiento mantenimiento) throws PersistenciaException {
        if (mantenimiento == null) {
            throw new PersistenciaException("El mantenimiento no puede ser null.");
        }

        try {
            MantenimientoMongoEntidad entidadMongo
                    = mantenimientoAdapter.convertirAMongo(mantenimiento);

            if (entidadMongo.getIdMantenimiento() == null) {
                entidadMongo.setIdMantenimiento(new ObjectId());
            }

            coleccionMantenimientos.insertOne(entidadMongo);

            return mantenimientoAdapter.convertirADominio(entidadMongo);

        } catch (MongoException ex) {
            throw new PersistenciaException(
                    "No fue posible guardar el restaurante en MongoDB.", ex
            );
        }
    }
}
