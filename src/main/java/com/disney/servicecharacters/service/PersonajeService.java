package com.disney.servicecharacters.service;

import com.disney.servicecharacters.model.Personaje;
import com.disney.servicecharacters.repository.IPersonajeService;
import com.disney.servicecharacters.repository.PersonajeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PersonajeService implements IPersonajeService {

    @Autowired
    private PersonajeDao personajeDao;

    @Override
    public Page<Personaje> getAll(int page, int size) {
        return personajeDao.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Personaje> getPersonajeByName(String name) {
        return personajeDao.findByName(name);
    }

    @Override
    public Optional<Personaje> getPersonajeByAge(Integer age) {
        return personajeDao.findByAge(age);
    }

    @Override
    public Optional<Personaje> getPersonajeByWeight(Double weight) {
        return personajeDao.findByWeight(weight);
    }

//    @Override
//    public Personaje createPersonaje(Personaje personaje) {
//        Optional<Personaje> personajeOptional = personajeDao.findById(personaje.getId());
//        if (personajeOptional.isPresent()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
//        return personajeDao.save(personaje);
//    }


    @Override
    public Personaje updatePersonaje(Long id, Personaje personaje) {
        Optional<Personaje> personajeOptional = personajeDao.findById(personaje.getId());
        if (personajeOptional.isPresent()) {
            return personajeDao.save(personaje);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Personaje ID %d does not exit", id));
        }
    }

    @Override
    public void deletePersonaje(Long id) {
        Optional<Personaje> personajeOptional = personajeDao.findById(id);
        if (personajeOptional.isPresent()) {
            personajeDao.delete(personajeOptional.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Personaje ID %d does not exit", id));
        }
    }
}
