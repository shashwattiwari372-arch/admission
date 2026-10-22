package com.example.employeecrud.config;

import com.example.employeecrud.auth.AppUser;
import com.example.employeecrud.auth.AppUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/** Creates the first login user when the users table is empty. */
@Component
public class AdminSeeder implements CommandLineRunner {

    private final AppUserRepository users;
    private final PasswordEncoder encoder;
    private final String username, password, fullName, email;

    public AdminSeeder(AppUserRepository users, PasswordEncoder encoder,
                       @Value("${app.admin.username}") String username,
                       @Value("${app.admin.password}") String password,
                       @Value("${app.admin.full-name}") String fullName,
                       @Value("${app.admin.email}") String email) {
        this.users = users;
        this.encoder = encoder;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

    @Override
    public void run(String... args) {
        if (users.count() == 0) {
            AppUser u = new AppUser();
            u.setUsername(username);
            u.setPassword(encoder.encode(password));
            u.setFullName(fullName);
            u.setEmail(email);
            users.save(u);
            System.out.println(">> Created default login: " + username + " / " + password + "  (change it!)");
        }
    }
}
