package es.cic.curso25.cic25_proyConjunto02.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso25.cic25_proyConjunto02.model.Perro;
import es.cic.curso25.cic25_proyConjunto02.repository.PerroRepository;

@Service
public class PerroService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerroService.class);

    @Autowired
    private PerroRepository perroRepository;

    public Optional<Perro> get(Long id) {
        LOGGER.info("Leo el perro con id " + id);

        Optional<Perro> perro = perroRepository.findById(id);

        return perro;
    }

    public List<Perro> get() {
        LOGGER.info("Leo todos los perros");

        return perroRepository.findAll();
    }

    public Perro create(Perro perro) {
        LOGGER.info("Creo un perro");

        perroRepository.save(perro);

        return perro;
    }

    public Perro update(Perro perro) {
        LOGGER.info("Actualizo un perro");
        perroRepository.save(perro);

        return perro;
    }

    public void delete(Long id) {
        LOGGER.info("Borro un perro");

        perroRepository.deleteById(id);
    }

}
