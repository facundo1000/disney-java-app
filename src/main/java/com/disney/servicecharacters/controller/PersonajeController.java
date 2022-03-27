package com.disney.servicecharacters.controller;

import com.disney.servicecharacters.model.Personaje;
import com.disney.servicecharacters.repository.PersonajeDao;
import com.disney.servicecharacters.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;
    @Autowired
    private PersonajeDao personajeDao;


    @GetMapping("/list")
    public ResponseEntity<Page<Personaje>> getPersonajes(
            @RequestParam(required = false, value = "page", defaultValue = "0") int page,
            @RequestParam(required = false, value = "size", defaultValue = "5") int size
    ) {
        return new ResponseEntity<>(personajeService.getAll(page, size), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Personaje createPersonaje(@RequestBody Personaje personaje) {
        return personajeDao.save(personaje);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Personaje updatePersonaje(@PathVariable("id") Long id, @RequestBody Personaje personaje) {
        Personaje personajeUno = personajeDao.getById(id);
        personajeUno.setName(personaje.getName());
        personajeUno.setAge(personaje.getAge());
        personajeUno.setWeight(personaje.getWeight());
        personajeUno.setImage(personaje.getImage());
        return personajeDao.save(personajeUno);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersonaje(@PathVariable Long id) {
        personajeService.deletePersonaje(id);
    }
}
