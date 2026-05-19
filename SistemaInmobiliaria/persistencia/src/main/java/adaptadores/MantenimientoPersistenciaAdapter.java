/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

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
public class MantenimientoPersistenciaAdapter {

    public List<Mantenimiento> convertirListaADominio(List<MantenimientoMongoEntidad> entidadesMongo) {
        List<Mantenimiento> mantenimientos = new ArrayList<>();
        
        if (entidadesMongo == null) {
            return mantenimientos;
        }
        
        for (MantenimientoMongoEntidad entidadMongo : entidadesMongo) {
            mantenimientos.add(convertirADominio(entidadMongo));
        }
        
        return mantenimientos;
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

    public MantenimientoMongoEntidad convertirAMongo(Mantenimiento mantenimiento) throws PersistenciaException {
        if (mantenimiento == null) {
            throw new PersistenciaException("No se puede agregar mantenimiento nulo.");
        }
        
        MantenimientoMongoEntidad entidadMongo = new MantenimientoMongoEntidad();
        
        entidadMongo.setIdMantenimiento(convertirStringAObjectId(mantenimiento.getIdMantenimiento()));
        entidadMongo.setIdInmueble(convertirStringAObjectId(mantenimiento.getIdInmueble()));
        entidadMongo.setDescripcion(mantenimiento.getDescripcion());
        entidadMongo.setPrioridad(mantenimiento.getPrioridad());
        entidadMongo.setTipo(mantenimiento.getTipo());
        entidadMongo.setEstado(mantenimiento.getEstado());
        entidadMongo.setCosto(mantenimiento.getCosto());
        entidadMongo.setNotas(mantenimiento.getNotas());
        
        return entidadMongo;
    }

    public Mantenimiento convertirADominio(MantenimientoMongoEntidad entidadMongo) {
        if (entidadMongo == null) {
            return null;
        }

        Mantenimiento mantenimiento = new Mantenimiento();
        
        mantenimiento.setIdMantenimiento(convertirObjectIdAString(entidadMongo.getIdMantenimiento()));
        mantenimiento.setIdInmueble(convertirObjectIdAString(entidadMongo.getIdInmueble()));
        mantenimiento.setDescripcion(entidadMongo.getDescripcion());
        mantenimiento.setPrioridad(entidadMongo.getPrioridad());
        mantenimiento.setTipo(entidadMongo.getTipo());
        mantenimiento.setEstado(entidadMongo.getEstado());
        mantenimiento.setCosto(entidadMongo.getCosto());
        mantenimiento.setNotas(entidadMongo.getNotas());
        
        return mantenimiento;
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
