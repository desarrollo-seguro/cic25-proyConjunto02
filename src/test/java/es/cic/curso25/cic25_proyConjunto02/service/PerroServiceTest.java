package es.cic.curso25.cic25_proyConjunto02.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.cic.curso25.cic25_proyConjunto02.model.Perro;

@SpringBootTest
public class PerroServiceTest {

    @Autowired
    private PerroService perroService;

    @Test
    void testCreate() {

        Perro perroTest = new Perro();
        perroTest.setNombre("Firulais");
        perroTest.setPeso(10);
        perroTest.setRaza("Galgo");
        
        Perro perroTest2 = perroService.create(perroTest);

        assertEquals(perroTest, perroTest2);

    }

    @Test
    void testDelete() {

        Perro perroTest = new Perro();
        perroTest.setNombre("Firulais");
        perroTest.setPeso(10);
        perroTest.setRaza("Galgo");

        Long id = perroService.create(perroTest).getId();

        perroService.delete(id);

        Optional<Perro> perroBorrado = perroService.get(id);
        assertTrue(perroBorrado.isEmpty());

    }

    @Test
    void testGet() {

        Perro perroTest = new Perro();
        perroTest.setNombre("Firulais");
        perroTest.setPeso(10);
        perroTest.setRaza("Galgo");

        Long id = perroService.create(perroTest).getId();

        Optional<Perro> perro = perroService.get(id);
        assertTrue(perro.isPresent());

    }

    @Test
    void testGetLista() {

        Perro perroTest1 = new Perro();
        perroTest1.setNombre("Firulais");
        perroTest1.setPeso(20);
        perroTest1.setRaza("Galgo");

        Perro perroTest2 = new Perro();
        perroTest2.setNombre("Croqueta");
        perroTest2.setPeso(15);
        perroTest2.setRaza("Bulldog");

        perroService.create(perroTest1);
        perroService.create(perroTest2);

        List<Perro> perros = perroService.get();

        assertTrue(perros.size() > 0);

    }

    @Test
    void testUpdate() {

        Perro perroTest = new Perro();
        perroTest.setNombre("Firulais");
        perroTest.setPeso(10);
        perroTest.setRaza("Galgo");

        Long id = perroService.create(perroTest).getId();

        perroTest.setId(id);
        perroTest.setNombre("Croqueta");

        perroTest = perroService.update(perroTest);

        assertEquals(perroTest.getNombre(), "Croqueta");

    }
}
