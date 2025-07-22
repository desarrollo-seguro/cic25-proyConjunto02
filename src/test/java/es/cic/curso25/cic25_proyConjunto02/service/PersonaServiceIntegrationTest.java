package es.cic.curso25.cic25_proyConjunto02.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import es.cic.curso25.cic25_proyConjunto02.model.Persona;

@SpringBootTest
public class PersonaServiceIntegrationTest {
    
    @Autowired
    private PersonaService personaService;

    @Test
    void testCreate() {
        //creamos un objeto de tipo persona
        Persona persona = new Persona();
        persona.setDni("12345678a");
        persona.setNombre("Javier");
        persona.setApellidos("Martínez Samperio");
        persona.setEdad(30);
        //llamamos al método de crear y recogemos la persona
        Persona personaCreada = personaService.create(persona);
        assertTrue(persona.getId() == personaCreada.getId());

    }


    @Test
    void testDelete() {
        //creamos un objeto de tipo persona
        Persona persona = new Persona();
        persona.setDni("12345678a");
        persona.setNombre("Javier");
        persona.setApellidos("Martínez Samperio");
        persona.setEdad(30);
        //llamamos al método de crear y recogemos el id de la persona creada
        Long idGenerado = personaService.create(persona).getId();
        //booramos el registro con ese id
        personaService.delete(idGenerado);
        //probamos a buscar el registro y vemos si el optional esta vacío
        Optional<Persona> personaBorrada = personaService.get(idGenerado);
        assertTrue(personaBorrada.isEmpty());
        
    }

    @Test
    void testGet() {
        //creamos un objeto de tipo persona
        Persona persona = new Persona();
        persona.setDni("12345678a");
        persona.setNombre("Javier");
        persona.setApellidos("Martínez Samperio");
        persona.setEdad(30);
        //creamos la persona y recogemos el id
        Long idGenerado = personaService.create(persona).getId();
        //llamamos al método de búsqueda
        personaService.get(idGenerado);
        //probamos a buscar el registro y ver si el optional no está vacío
        Optional<Persona> personaBorrada = personaService.get(idGenerado);
        assertTrue(personaBorrada.isPresent());
    }

    @Test
    void testGet2() {
        //creamos dos objetos de tipo persona
        Persona persona = new Persona();
        persona.setDni("12345678a");
        persona.setNombre("Javier");
        persona.setApellidos("Martínez Samperio");
        persona.setEdad(30);

        Persona persona1 = new Persona();
        persona1.setDni("12345678a");
        persona1.setNombre("Javier");
        persona1.setApellidos("Martínez Samperio");
        persona1.setEdad(30);

        //creamos los registros
        personaService.create(persona1);
        personaService.create(persona);
        //como el método de buscar todas devuelve una lista, comprobamos que el tamaño de esa lista es mayor que 0
        List<Persona> personas = personaService.get();
        assertTrue(personas.size() > 0);
    }

    @Test
    void testUpdate() {
        //creamos un objeto de tipo persona
        Persona persona = new Persona();
        persona.setDni("12345678a");
        persona.setNombre("Javier");
        persona.setApellidos("Martínez Samperio");
        persona.setEdad(30);
        //llamamos al método de crear y recogemos el id de la persona creada
        Long idGenerado = personaService.create(persona).getId();
        //le ponemos a nuestro objeto persona el id que sea ha creado en el registro y modificamos el nombre
        persona.setId(idGenerado);
        persona.setNombre("YaNoSoyJavier");
        //actualizamos el registro y lo recogemos para comparar nombres
        Persona personaActualizada = personaService.update(persona);
        
        assertEquals(personaActualizada.getNombre(), "YaNoSoyJavier");
    }
}
