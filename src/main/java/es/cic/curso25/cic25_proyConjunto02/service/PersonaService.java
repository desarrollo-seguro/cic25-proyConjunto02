package es.cic.curso25.cic25_proyConjunto02.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso25.cic25_proyConjunto02.controller.PersonaController.Amistad;
import es.cic.curso25.cic25_proyConjunto02.model.Perro;
import es.cic.curso25.cic25_proyConjunto02.model.Persona;
import es.cic.curso25.cic25_proyConjunto02.repository.PerroRepository;
import es.cic.curso25.cic25_proyConjunto02.repository.PersonaRepository;

@Service
@Transactional
public class PersonaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonaService.class);

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PerroRepository perroRepository;    

    public Optional<Persona> get(Long id) {
        LOGGER.info(String.format("Buscando la persona con id %d", id));
        return personaRepository.findById(id);
    }

    public List<Persona> get() {
        LOGGER.info("Buscando todas las personas");
        return personaRepository.findAll();
    }

    public Persona create(Persona persona){
        LOGGER.info("Creando una persona");
        return personaRepository.save(persona);
    }

    public Amistad create(Amistad amistad){
        LOGGER.info("Creando una persona");
        Persona personaCreada = personaRepository.save(amistad.getPersona());

        if (true)
            throw new RuntimeException();

        Perro perroCreado = perroRepository.save(amistad.getPerro());

        Amistad amistadCreada = new Amistad();
        amistadCreada.setPersona(personaCreada);
        amistadCreada.setPerro(perroCreado);
        
        return amistadCreada;
    }    

    public Persona update(Persona persona){
        LOGGER.info(String.format("Actualizando la perosna con id %d",persona.getId()));
        return personaRepository.save(persona);
    }

    public void delete(Long id){
        personaRepository.deleteById(id);
    }
}
