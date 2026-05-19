/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import entidades.Contrato;
import entidadesMongo.ContratoMongoEntidad;
import excepciones.PersistenciaException;
import org.bson.types.ObjectId;

/**
 *
 * @author joser
 */
public class ContratoPersistenciaAdapter {

    public ContratoMongoEntidad convertirAMongo(Contrato contrato) throws PersistenciaException {
        if (contrato == null) {
            throw new PersistenciaException("No se puede agregar contrato nulo.");
        }
        
        ContratoMongoEntidad entidadMongo = new ContratoMongoEntidad();
        
        entidadMongo.setFechaInicio(contrato.getFechaInicio());
        entidadMongo.setFechaFin(contrato.getFechaFin());
        entidadMongo.setIdInmueble(convertirStringAObjectId(contrato.getIdInmueble()));
        entidadMongo.setAdeudo(contrato.getAdeudo());
        entidadMongo.setMotivo(contrato.getMotivo());
        entidadMongo.setObservaciones(contrato.getObservaciones());
        
        return entidadMongo;
    }

    public Contrato convertirADominio(ContratoMongoEntidad entidadMongo) {
        if (entidadMongo == null) {
            return null;
        }

        Contrato contrato = new Contrato();
        
        contrato.setFechaInicio(entidadMongo.getFechaInicio());
        contrato.setFechaFin(entidadMongo.getFechaFin());
        contrato.setIdInmueble(convertirObjectIdAString(entidadMongo.getIdInmueble()));
        contrato.setAdeudo(entidadMongo.getAdeudo());
        contrato.setMotivo(entidadMongo.getMotivo());
        contrato.setObservaciones(entidadMongo.getObservaciones());
        
        return contrato;
    }
    
    
    public ObjectId convertirStringAObjectId(String id) throws PersistenciaException {
        if (id == null || id.isBlank()) {
            return null;
        }

        if (!ObjectId.isValid(id)) {
            throw new PersistenciaException(
                    "El id recibido no tiene formato válido de ObjectId."
            );
        }

        return new ObjectId(id);
    }
    
    
    /**
     * Convierte un ObjectId a String.
     *
     * @param id identificador ObjectId.
     * @return identificador como texto.
     */
    public String convertirObjectIdAString(ObjectId id) {

        if (id == null) {
            return null;
        }

        return id.toHexString();
    }
}
