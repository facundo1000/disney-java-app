package com.disney.servicecharacters.repository;

import com.disney.servicecharacters.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonajeDao extends JpaRepository<Personaje, Long> {

    public Optional<Personaje> findByName(String name);

    public Optional<Personaje> findById(Long id);

    public Optional<Personaje> findByAge(Integer age);

    public Optional<Personaje> findByWeight(Double weight);


}
