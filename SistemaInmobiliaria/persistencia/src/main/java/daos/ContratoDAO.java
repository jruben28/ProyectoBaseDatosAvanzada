/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import adaptadores.ContratoPersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import conexion.ConexionMongo;
import entidades.Contrato;
import entidadesMongo.ContratoMongoEntidad;
import excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author joser
 */
public class ContratoDAO implements IContratoDAO{

    private final MongoCollection<ContratoMongoEntidad> coleccionContratos;
    private final ContratoPersistenciaAdapter contratoAdapter;
    
    public ContratoDAO() {
        this.coleccionContratos = ConexionMongo.obtenerColeccionContrato();
        this.contratoAdapter = new ContratoPersistenciaAdapter();
    }

    @Override
    public Contrato crearContrato(Contrato contrato) throws PersistenciaException {
        if (contrato == null) {
            throw new PersistenciaException("El contrato no puede ser null.");
        }

        try {
            ContratoMongoEntidad entidadMongo
                    = contratoAdapter.convertirAMongo(contrato);


            coleccionContratos.insertOne(entidadMongo);

            return contratoAdapter.convertirADominio(entidadMongo);

        } catch (MongoException ex) {
            throw new PersistenciaException(
                    "No fue posible guardar el contrato en MongoDB.", ex
            );
        }
    }

    @Override
    public boolean editarContrado(Contrato contrato) throws PersistenciaException {
        ObjectId id = contratoAdapter.convertirStringAObjectId(contrato.getIdInmueble());

        if (id == null) {
            return false;
        }

        try {
            UpdateResult resultado = coleccionContratos.updateOne(
                    eq("_id", id),
                    combine(
                            set("fechaFin", contrato.getFechaFin()),
                            set("adeudo", contrato.getAdeudo()),
                            set("motivo", contrato.getMotivo()),
                            set("observaciones", contrato.getObservaciones())
                    )
            );
            
            System.out.println("llegamos aca" + (resultado.getModifiedCount() > 0));
            return resultado.getModifiedCount() > 0;

        } catch (MongoException ex) {
            throw new PersistenciaException(
                    "No fue posible completar mantenimiento", ex
            );
        }
    }

    @Override
    public Contrato buscarContrato(String idInmueble) throws PersistenciaException {
        ObjectId id = contratoAdapter.convertirStringAObjectId(idInmueble.trim());

        if (id == null) {
            return null;
        }

        try {
            
            ContratoMongoEntidad entidadMongo = coleccionContratos
                    .find(
                            eq("idInmueble", id)
                    )
                    .first();


            return contratoAdapter.convertirADominio(entidadMongo);

        } catch (MongoException ex) {
            throw new PersistenciaException(
                    "No fue posible obtener el contrato por id de inmueble.", ex
            );
        }
    }
}
