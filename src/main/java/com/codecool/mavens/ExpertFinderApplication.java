package com.codecool.mavens;

import com.codecool.mavens.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ExpertFinderApplication {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProfessionRepository professionRepository;

    public static void main(String[] args) {
        SpringApplication.run(ExpertFinderApplication.class, args);
    }


    @Bean
    BCryptPasswordEncoder BCryptPasswordEncoder (){
        return new BCryptPasswordEncoder();
    }
}
