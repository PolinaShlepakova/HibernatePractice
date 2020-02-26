package com.polinashlepakova.practice6;

import com.polinashlepakova.practice6.entity.UserEntity;
import com.polinashlepakova.practice6.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Practice6Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Practice6Application.class, args);
        UserService userService = applicationContext.getBean(UserService.class);

        UserEntity johnDoe = userService.createUser("John", "Doe", "john-doe@example.com");
        UserEntity jennyDoe = userService.createUser("Jenny", "Doe", "jenn-doe@example.com");
        UserEntity billSmith = userService.createUser("Bill", "Smith", "b-smith@example.com");
        UserEntity annMilling = userService.createUser("Ann", "Milling", "milling@example.com");

        System.out.println("All users:");
        for (UserEntity u : userService.findAll()) {
            System.out.println(u);
        }
        System.out.println();

        System.out.println("All users with surname 'Doe':");
        for (UserEntity u : userService.findByLastName("Doe")) {
            System.out.println(u);
        }
        System.out.println();

        System.out.println("All users containing 'ill' in last or first name:");
        for (UserEntity u : userService.findByContainingInLastOrFirstName("ill")) {
            System.out.println(u);
        }
        System.out.println();

    }

}
