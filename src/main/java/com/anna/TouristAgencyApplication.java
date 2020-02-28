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

//    @Override
//    public void run(String... args) throws Exception {
//
//        List<User> users = userRepository.findAll();
//
//        for (User c : users) {
//            System.out.print(c.getName() + " " + c.getSurname());
//            for (Role r : c.getRoles()) {
//                System.out.print(r.getRoleName() + " ");
//            }
//            System.out.println();
//        }
//    }
}
