package es.cic.curso25.cic25_proyConjunto02.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    }

    @Test
    void testGet() {

    }

    @Test
    void testGetLista() {

    }

    @Test
    void testUpdate() {

    }
}
