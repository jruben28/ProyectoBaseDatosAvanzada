/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidadesMongo.InmuebleMongoEntidad;
import org.bson.codecs.configuration.CodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author joser
 */
public class ConexionMongo {
    private static final String URL = "mongodb://localhost:27017";
        private static final String NOMBRE_BASE_DATOS = "guia_restaurantes";
    private static final String COLECCION_INMOBILIARIA = "";
    private static final String COLECCION_MANTENIMIENTO = "";
    
    private static MongoClient cliente;
    
    private ConexionMongo() {
    }
    
    /**
     * Metodo que obtiene el cliente a espera
     * @return 
     */
    public static MongoClient obtenerCliente() {

        if (cliente == null) {
            CodecProvider proveedorPojo = PojoCodecProvider.builder()
                    .automatic(true) // Esto permite que MongoDB Java Driver convierta automáticamente tus clases de Java a documentos BSON y viceversa, sin necesidad de escribir mapeadores manuales.
                    .build();

            CodecRegistry registroCodecs = fromRegistries( // Combina el registro de codecs por defecto de MongoDB con el nuevo proveedor de POJOs
                    MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(proveedorPojo)
            );

            // Se utiliza MongoClientSettings para encapsular la cadena de conexión (URL) y el registro de codecs, permitiendo una creación de cliente limpia y centralizada.
            MongoClientSettings configuracion = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(URL)) // a veces se lo pueden encontrar como URI lo cual e sun identificador unico de acceso a un recurso
                    .codecRegistry(registroCodecs)
                    .build();
            // Crea la instancia única del cliente
            cliente = MongoClients.create(configuracion);
        }

        return cliente;
    }

    /**
     * Obtenemos base de datos
     * @return bdd
     */
    public static MongoDatabase obtenerBaseDatos() {
        return obtenerCliente().getDatabase(NOMBRE_BASE_DATOS); //manejamos la misma bd para to2 el sistema
    }


    /**
     * Obtenemos colexxión de inmuebles ya convertida a clase gracias al pojoprovider.
     * @return 
     */
    public static MongoCollection<InmuebleMongoEntidad> obtenerColeccionInmuebles() {
        return obtenerBaseDatos()
                .getCollection(COLECCION_INMOBILIARIA, InmuebleMongoEntidad.class);
    }
    
    
// mausqueherramienta que me servira más tarde 
//    public static MongoCollection<MantenimientoMongoEntidad> obtenerColeccionMantenimiento() {
//        return obtenerBaseDatos()
//                .getCollection(COLECCION_MANTENIMIENTO, MantenimientoMongoEntidad.class);
//    }

}
