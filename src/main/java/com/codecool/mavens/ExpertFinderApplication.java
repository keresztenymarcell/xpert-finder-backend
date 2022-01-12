package com.codecool.mavens;

import com.codecool.mavens.model.entity.*;
import com.codecool.mavens.repository.*;
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
            Category cat1 = Category.builder()
                    .name("Ház körüli munkák")
                    .profession(Profession.builder().name("Fűnyírás").build())
                    .profession(Profession.builder().name("Kutyasétáltatás").build())
                    .build();

            Category cat2 = Category.builder()
                    .name("Egészségügy")
                    .profession(Profession.builder().name("Állatorvos").build())
                    .profession(Profession.builder().name("Sebész").build())
                    .build();

            categoryRepository.save(cat1);
            categoryRepository.save(cat2);

            Profession profession1 = Profession.builder()
                    .name("Állatorvos")
                    .category(cat2)
                    .build();

            Profession profession2 = Profession.builder()
                    .name("Sebész")
                    .category(cat2)
                    .build();

            Profession profession3 = Profession.builder()
                    .name("Fűnyírós")
                    .category(cat1)
                    .build();

            Profession profession4 = Profession.builder()
                    .name("Kutyasétáltató")
                    .category(cat1)
                    .build();

            professionRepository.save(profession1);
            professionRepository.save(profession2);
            professionRepository.save(profession3);
            professionRepository.save(profession4);

            Location loc1 = Location.builder()
                    .name("Zirc")
                    .build();

            Location loc2 = Location.builder()
                    .name("Budapest")
                    .build();

            Location loc3 = Location.builder()
                    .name("Tatabánya")
                    .build();

            Location loc4 = Location.builder()
                    .name("Debrecen")
                    .build();

            //locationRepository.save(loc1);
            //locationRepository.save(loc2);
            //locationRepository.save(loc3);
            // locationRepository.save(loc4);

            User user = User.builder()
                    .registrationTime(LocalDateTime.now())
                    .personalInfo(PersonalInfo.builder()
                            .name("Trial Tibor")
                            .location(loc2)
                            .build())
                    .expertInfo(ExpertInfo.builder()
                            .reference(Reference.builder()
                                    .description("Nice job")
                                    .build())
                            .location(loc1)
                            .location(loc3)
                            .build())
                    .build();

            userRepository.save(user);
        };
    }
}
