package com.codecool.mavens;

import com.codecool.mavens.model.entity.Location;
import com.codecool.mavens.model.entity.PersonalInfo;
import com.codecool.mavens.model.entity.User;
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

            User user = User.builder()
                    .registrationTime(LocalDateTime.now())
                    .build();

            userRepository.save(user);
        };
    }
}
