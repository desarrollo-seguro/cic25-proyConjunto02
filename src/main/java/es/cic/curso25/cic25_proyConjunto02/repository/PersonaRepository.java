package es.cic.curso25.cic25_proyConjunto02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cic.curso25.cic25_proyConjunto02.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
