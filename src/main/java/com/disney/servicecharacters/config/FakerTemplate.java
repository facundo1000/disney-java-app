package com.disney.servicecharacters.config;


import com.disney.servicecharacters.model.Personaje;
import com.disney.servicecharacters.repository.PersonajeDao;
import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Builder
@Slf4j
public class FakerTemplate {

    @Autowired
    private Faker faker;
    @Autowired
    private PersonajeDao personajeDao;

    public void setFaker() {

        for (int i = 0; i < 20; i++) {
            Personaje personaje = new Personaje();
            personaje.setId(faker.number().numberBetween(1L, 50L));
            personaje.setAge(faker.number().numberBetween(1, 60));
            personaje.setWeight(faker.number().randomDouble(2, 20L, 60L));
            personaje.setName(faker.name().fullName());
            personaje.setImage(faker.avatar().image());
            log.info("User {} created", personaje.getName());
            personajeDao.save(personaje);
        }
    }
}
