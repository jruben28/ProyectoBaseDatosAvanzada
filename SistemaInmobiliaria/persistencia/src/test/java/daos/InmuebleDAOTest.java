/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package daos;

import entidades.Inmueble;
import entidades.Inquilino;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author joser
 */
public class InmuebleDAOTest {
    
    public InmuebleDAOTest() {
    }

    /**
     * Test of listarInmueblesDisponibles method, of class InmuebleDAO.
     */
    @org.junit.jupiter.api.Test
    public void testListarInmueblesDisponibles() throws Exception {

        InmuebleDAO instance = new InmuebleDAO();

        Inmueble inmueble1 = new Inmueble(
                "Calle Reforma 120",
                true,
                "comercial",
                5000.0f,
                null
        );

        Inmueble inmueble2 = new Inmueble(
                "Avenida Obregon 450",
                true,
                "comercial",
                5000.0f,
                null
        );

        Inmueble inmueble3 = new Inmueble(
                "Boulevard Las Torres 88",
                true,
                "comercial",
                5000.0f,
                null
        );

        Inmueble inmueble4 = new Inmueble(
                "Privada Los Pinos 17",
                true,
                "comercial",
                5000.0f,
                null
        );

        Inmueble inmueble5 = new Inmueble(
                "Calle Morelos 1024",
                true,
                "comercial",
                5000.0f,
                null
        );
        
        instance.registrarInmueble(inmueble1);
        instance.registrarInmueble(inmueble2);
        instance.registrarInmueble(inmueble3);
        instance.registrarInmueble(inmueble4);
        instance.registrarInmueble(inmueble5);
        
        
    }

    /**
     * Test of buscarInmueblePorId method, of class InmuebleDAO.
     */
    @org.junit.jupiter.api.Test
    public void testBuscarInmueblePorId() throws Exception {
        InmuebleDAO instance = new InmuebleDAO();
        
        Inmueble inmueble1 = new Inmueble(
                "Calle Tamal 120",
                true,
                "comercial",
                5000.0f,
                null
        );
        
        Inmueble inmuebleInsertado = instance.registrarInmueble(inmueble1);
        
        
        Inmueble inmueble = instance.buscarInmueblePorId(inmuebleInsertado.getId());
        
        
        
        assertEquals( inmueble.getId(), inmuebleInsertado.getId());
    }

    /**
     * Test of registrarInquilino method, of class InmuebleDAO.
     */
    @org.junit.jupiter.api.Test
    public void testRegistrarInquilino() throws Exception {

        InmuebleDAO instance = new InmuebleDAO();
        
        Inmueble inmueble1 = new Inmueble(
                "Calle venado 120",
                true,
                "comercial",
                5000.0f,
                null
        );
        
        Inmueble inmuebleInsertado = instance.registrarInmueble(inmueble1);
        Inquilino inquilino = new Inquilino(
                "Ruben",
                "Valdez",
                "Vargas",
                5000.0f,
                "7352766700"
        );
        
        instance.registrarInquilino(inmuebleInsertado.getId() , inquilino);
        
        assertNotNull(instance.buscarInmueblePorId(inmuebleInsertado.getId()).getInquilino());
    }

    /**
     * Test of registrarInmueble method, of class InmuebleDAO.
     */
    @Test
    public void testRegistrarInmueble() throws Exception {

        InmuebleDAO instance = new InmuebleDAO();
        Inmueble inmueble = new Inmueble(
                "De los vinedos 2933",
                true,
                "comercial",
                5000.0f,
                null
        );
        
        Inmueble inmuebleInsertado = instance.registrarInmueble(inmueble);
        
        assertEquals(inmueble.getDireccion(), inmuebleInsertado.getDireccion());
        

    }
    
}
