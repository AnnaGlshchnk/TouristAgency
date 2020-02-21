package com.anna;

import com.anna.dao.UserRepository;
import com.anna.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TouristAgencyApplication implements CommandLineRunner {

    final
    UserRepository userRepository;

    public TouristAgencyApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TouristAgencyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> userList = userRepository.findAll();
        userList.forEach(System.out::println);
    }
}
