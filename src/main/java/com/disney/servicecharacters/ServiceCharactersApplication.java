package com.disney.servicecharacters;

import com.disney.servicecharacters.config.FakerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class ServiceCharactersApplication implements ApplicationRunner {

    @Autowired
    private FakerTemplate fakerTemplate;

    public static void main(String[] args) {

        SpringApplication.run(ServiceCharactersApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        fakerTemplate.setFaker();
    }
}
