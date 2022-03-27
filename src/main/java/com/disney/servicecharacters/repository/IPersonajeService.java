package com.disney.servicecharacters.repository;

import com.disney.servicecharacters.model.Personaje;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IPersonajeService {
    //Get All
    public Page<Personaje> getAll(int page, int size);

    //GET
    public Optional<Personaje> getPersonajeByName(String name);

    //GET
    public Optional<Personaje> getPersonajeByAge(Integer age);

    //GET
    public Optional<Personaje> getPersonajeByWeight(Double weight);

    //POST
   // public Personaje create(Personaje personaje);

    //PUT
    public Personaje updatePersonaje(Long id, Personaje personaje);

    //DELETE
    public void deletePersonaje(Long id);
}
