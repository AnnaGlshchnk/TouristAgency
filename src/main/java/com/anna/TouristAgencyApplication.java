package com.anna;

import com.anna.dao.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TouristAgencyApplication {

    UserRepository userRepository;

    public TouristAgencyApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TouristAgencyApplication.class, args);
    }

}
