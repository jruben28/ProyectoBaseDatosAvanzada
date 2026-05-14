/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import entidades.Inmueble;
import entidades.Inquilino;
import entidadesMongo.InmuebleMongoEntidad;
import entidadesMongo.InquilinoMongoEntidad;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author joser
 */
public class InmueblePersistenciaAdapter {
    
    /**
     * Convierte lista de inmuebles mongo a entidades.
     * @param entidadesMongo
     * @return 
     */
    public List<Inmueble> convertirListaADominio(List<InmuebleMongoEntidad> entidadesMongo){
        
        List<Inmueble> inmuebles = new ArrayList<>();
        
        if (entidadesMongo == null) {
            return inmuebles;
        }
        
        for (InmuebleMongoEntidad entidadMongo : entidadesMongo) {
            inmuebles.add(convertirADominio(entidadMongo));
        }
        
        return inmuebles;
        
    }

    /**
     * Convierte de entidad mongo a entidad dominio.
     * @param entidadMongo
     * @return 
     */
    private Inmueble convertirADominio(InmuebleMongoEntidad entidadMongo) {
        if (entidadMongo == null) {
            return null;
        }

        Inmueble inmueble = new Inmueble();
        
        inmueble.setId(convertirObjectIdAString(entidadMongo.getId()));
        inmueble.setDireccion(entidadMongo.getDireccion());
        inmueble.setEstado(entidadMongo.isEstado());
        inmueble.setTipo(entidadMongo.getTipo());
        inmueble.setRentaMensual(entidadMongo.getRentaMensual());
        inmueble.setInquilino(convertirInquilinoADominio(entidadMongo.getInquilino()));
        
        return inmueble;
    }
    
    
    /**
     * Convierte entidad mongo de inquilino a entidad.
     * @param entidadMongo
     * @return 
     */
    private Inquilino convertirInquilinoADominio(InquilinoMongoEntidad entidadMongo){
        if (entidadMongo == null) {
            return null;
        }
        
        return new Inquilino(
                entidadMongo.getNombres(),
                entidadMongo.getApellidoPaterno(),
                entidadMongo.getApellidoMaterno(),
                entidadMongo.getIngresoMensual(),
                entidadMongo.getTelefono()
        );
    }
    
    
    /**
     * Convierte un id de texto a ObjectId.
     *
     * Este método se usa únicamente dentro de persistencia.
     *
     * Si el id viene null o vacío, se regresa null para permitir que MongoDB
     * genere un nuevo ObjectId al insertar.
     *
     * @param id identificador como texto.
     * @return ObjectId correspondiente.
     * @throws PersistenciaException si el id no tiene formato válido.
     */
    public ObjectId convertirStringAObjectId(String id)
            throws PersistenciaException {

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
