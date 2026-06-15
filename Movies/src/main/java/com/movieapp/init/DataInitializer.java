package com.movieapp.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.movieapp.model.Movie;
import com.movieapp.model.User;
import com.movieapp.repository.MovieRepository;
import com.movieapp.repository.UserRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner init(UserRepository userRepo,
                                  MovieRepository movieRepo,
                                  PasswordEncoder passwordEncoder) {

        return args -> {

            // Create ADMIN
            if (userRepo.findByUsername("admin") == null) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ROLE_ADMIN");
                userRepo.save(admin);
                System.out.println("Created admin/admin123");
            }

            // Create USER
            if (userRepo.findByUsername("user") == null) {
                User user = new User();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("user123"));
                user.setRole("ROLE_USER");
                userRepo.save(user);
                System.out.println("Created user/user123");
            }

            // Add sample movie if no movies exist
            if (movieRepo.count() == 0) {
                Movie m1 = new Movie();
                m1.setTitle("The Sample Adventure");
                m1.setDescription("An exciting sample movie used for demo.");
                m1.setPosterUrl("https://via.placeholder.com/300x450.png");
                m1.setVideoUrl("https://www.w3schools.com/html/mov_bbb.mp4");
                movieRepo.save(m1);
                System.out.println("Created sample movie");
            }
        };
    }
}