package com.codecool.mavens;

import com.codecool.mavens.model.entity.*;
import com.codecool.mavens.repository.UserRepository;
import com.codecool.mavens.repository.UserRepositoryMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ExpertFinderApplication {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ExpertFinderApplication.class, args);
    }


    @Bean
    public CommandLineRunner init() {
        return args -> {

            /*Location location = Location.builder()
                    .name("Budapest")
                    .build();

            PersonalInfo personalInfo = PersonalInfo.builder()
                    .email("me@gmail.com")
                    .name("Me Máté")
                    .location(location)
                    .build();

            User user = User.builder()
                    .personalInfo(personalInfo)
                    .registrationTime(LocalDateTime.now())
                    .build();*/


            Location loc1 = Location.builder()
                    .name("Zirc")
                    .build();

            User user = User.builder()
                    .registrationTime(LocalDateTime.now())
                    .personalInfo(PersonalInfo.builder()
                            .name("Me")
                            .location(Location.builder().name("Budapest").build())
                            .build())
                    .expertInfo(ExpertInfo.builder()
                            .reference(Reference.builder()
                                    .description("Nice job")
                                    .build())
                            .location(loc1)
                            .location(Location.builder()
                                    .name("Budpates")
                                    .build())
                            .build())
                    .build();

            userRepository.save(user);
        };
    }
}
