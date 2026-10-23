package com.example.employeecrud.auth;

import com.example.employeecrud.security.JwtService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    public record LoginRequest(
            @NotBlank(message = "Username is required") String username,
            @NotBlank(message = "Password is required") String password) {}

    private final AppUserRepository users;
    private final JwtService jwt;

    public AuthController(AppUserRepository users, JwtService jwt) {
        this.users = users;
        this.jwt = jwt;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req) {
        AppUser u = users.findByUsernameIgnoreCase(req.username().trim()).orElse(null);

        if (u == null || !req.password().equals(u.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Wrong username or password."));
        }

        // field names match LoginResponse in auth.service.ts
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "Login successful");
        body.put("userId", u.getId());
        body.put("fullName", u.getFullName() != null ? u.getFullName() : u.getUsername());
        body.put("username", u.getUsername());
        body.put("email", u.getEmail() != null ? u.getEmail() : "");
        body.put("token", jwt.generate(u.getUsername(), u.getId()));

        return ResponseEntity.ok(body);
    }
}