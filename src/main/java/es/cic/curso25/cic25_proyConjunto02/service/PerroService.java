package es.cic.curso25.cic25_proyConjunto02.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso25.cic25_proyConjunto02.model.Perro;
import es.cic.curso25.cic25_proyConjunto02.repository.PerroRepository;
import es.cic.curso25.cic25_proyConjunto02.repository.PersonaRepository;

@Service
@Transactional
public class PerroService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerroService.class);

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PerroRepository perroRepository;

    @Transactional(readOnly = true)
    public Optional<Perro> get(Long id) {
        LOGGER.info("Leo el perro con id " + id);

        Optional<Perro> perro = perroRepository.findById(id);

        return perro;
    }

    @Transactional(readOnly = true)
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
        Optional<Perro> perro = perroRepository.findById(id);

        // if (hasPersona(perro)) {
        //     personaRepository.delete(perro.get().getPersona());           
        // }


        perroRepository.deleteById(id);

    }

    private boolean hasPersona(Optional<Perro> perro) {
        boolean resultado = false;
        if (perro.isPresent()) {
            resultado =  perro.get().getPersona() != null;
        } 
        return resultado;
    }
}
