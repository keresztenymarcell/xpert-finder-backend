package com.codecool.mavens;

import com.codecool.mavens.model.entity.*;
import com.codecool.mavens.model.types.Role;
import com.codecool.mavens.model.types.Status;
import com.codecool.mavens.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

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

//            PersonalInfo personalInfoReferer = PersonalInfo.builder()
//                    .role(Role.USER)
//                    .password("123")
//                    .profilePicture("mégnincs")
//                    .status(Status.ACTIVE)
//                    .phoneNumber("12334")
//                    .name("Rewier Revy")
//                    .username("revyke")
//                    .email("revy@gmail.com")
//                    .location(Location.builder().name("Miskolc").build())
//                    .build();
//
//            User reviewer = User.builder()
//                    .personalInfo(personalInfoReferer)
//                    .registrationTime(LocalDateTime.now())
//                    .lastLoginTime(LocalDateTime.now())
//                    .build();
//
//            Location location = Location.builder()
//                    .name("Budapest")
//                    .build();
//
//            Location location2 = Location.builder()
//                    .name("Békécsaba")
//                    .build();
//
//            PersonalInfo personalInfo = PersonalInfo.builder()
//                    .email("me@gmail.com")
//                    .name("Me Máté")
//                    .username("Mate11")
//                    .email("tibor.trial@gmail.com")
//                    .phoneNumber("222-444")
//                    .status(Status.ACTIVE)
//                    .role(Role.USER)
//                    .profilePicture("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.redd.it%2Fxjmijhw09dm11.jpg&f=1&nofb=1")
//                    .location(location)
//                    .build();
//
//            Category cat1 = Category.builder()
//                    .name("Ház körüli munkák")
//                    .build();
//
//            Category cat2 = Category.builder()
//                    .name("Egészségügy")
//                    .build();
//
//            Profession profession2 = Profession.builder()
//                    .name("Sebész")
//                    .category(cat2)
//                    .build();
//
//            cat2.setProfessions(Set.of(profession2));
//
//            Profession profession3 = Profession.builder()
//                    .name("Fűnyírós")
//                    .category(cat1)
//                    .build();
//
//            cat1.setProfessions(Set.of(profession3));
//
//
//            Reference ref1 = Reference.builder()
//                    .description("A nice dog I've walked")
//                    .imagePath("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2Fsd5TBJe8TkI%2Fhqdefault.jpg&f=1&nofb=1")
//                    .build();
//
//
//            Review rev1 = Review.builder()
//                    .reviewer(reviewer)
//                    .time(LocalDateTime.now())
//                    .message("He was very nice to my dog, would recommend 10/10!!!")
//                    .rating(5)
//                    .build();
//
//            Service service1 = Service.builder()
//                    .name("Dog walking-30min")
//                    .price("3000Ft")
//                    .description("I walk your dog like a pro for half an hour")
//                    .build();
//
//            Service service2 = Service.builder()
//                    .name("Dog walking-60min")
//                    .price("5500Ft")
//                    .description("I walk your dog like a pro for an hour")
//                    .build();
//
//            ExpertInfo expertInfo = ExpertInfo.builder()
//                    .description("I am a professional dog-walker. Don't worry, you won't regret contacting me! ;)")
//                    .rating(3.0)
//                    .jobCount(7)
//                    .reference(ref1)
//                    .location(location)
//                    .location(location2)
//                    .profession(profession2)
//                    .profession(profession3)
//                    .review(rev1)
//                    .service(service1)
//                    .service(service2)
//                    .build();
//
//
//            User user = User.builder()
//                    .personalInfo(personalInfo)
//                    .expertInfo(expertInfo)
//                    .registrationTime(LocalDateTime.now())
//                    .build();
//
//            Set<ExpertInfo> expertInfos = Set.of(expertInfo);
//
//
//
//            ref1.setExpertInfo(expertInfo);
//            rev1.setExpertInfo(expertInfo);
//
//            service1.setExpertInfo(expertInfo);
//            service2.setExpertInfo(expertInfo);
//
//            location.setExpertInfos(expertInfos);
//            location2.setExpertInfos(expertInfos);
//            profession2.setExpertInfos(expertInfos);
//            profession3.setExpertInfos(expertInfos);
//
//
//
//            rev1.setReviewer(reviewer);
//            userRepository.save(reviewer);
//
//            userRepository.save(user);



            /*categoryRepository.save(cat1);
            categoryRepository.save(cat2);

            Profession profession1 = Profession.builder()
                    .name("Állatorvos")
                    .category(cat2)
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

            locationRepository.saveAll(Arrays.asList(loc1, loc2, loc3, loc4));

            Set<Location> locations = Set.of(loc1, loc3);*/

//
//            User user = User.builder()
//                    .registrationTime(LocalDateTime.now())
//                    .personalInfo(PersonalInfo.builder()
//                            .name("Trial Tibor")
//                            .location(loc2)
//                            .build())
//                    .expertInfo(ExpertInfo.builder()
//                            .reference(Reference.builder()
//                                    .description("Nice job")
//                                    .build())
//                            .locations(locations)
//                            .build())
//                    .build();

//            userRepository.save(user);
        };
    }
}
