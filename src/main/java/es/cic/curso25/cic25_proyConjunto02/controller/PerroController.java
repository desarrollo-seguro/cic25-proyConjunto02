package es.cic.curso25.cic25_proyConjunto02.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.cic25_proyConjunto02.model.Perro;
import es.cic.curso25.cic25_proyConjunto02.service.PerroService;

@RestController
@RequestMapping("/perro")
public class PerroController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerroController.class);

    @Autowired
    private PerroService perroService;

    @GetMapping("/{id}")
    public Optional<Perro> get(@PathVariable Long id) {
        LOGGER.info("Leo el perro con id " + id);

        Optional<Perro> perro = perroService.get(id);

        return perro;
    }

    @GetMapping
    public List<Perro> get() {
        LOGGER.info("Leo todos los perros");

        return perroService.get();
    }

    @PostMapping
    public Perro create(@RequestBody Perro perro) {

        if (perro.getId() != null) {
            throw new ModificacionSecurityException("No puedes pasar un id distinto de 0");
        }

        LOGGER.info("Creo un perro");

        perro = perroService.create(perro);

        return perro;
    }

    @PutMapping
    public void update(@RequestBody Perro perro) {
        LOGGER.info("Actualizo un perro");

        if (perro.getId() == null) {
            throw new CreacionSecurityException();
        }

        perroService.update(perro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info("Borro un perro");

        perroService.delete(id);
    }

}
