package com.agyanatma.plantscheduler.controllers;

import com.agyanatma.plantscheduler.dto.AuthenticationRequest;
import com.agyanatma.plantscheduler.dto.AuthenticationResponse;
import com.agyanatma.plantscheduler.dto.RegisterRequest;
import com.agyanatma.plantscheduler.models.User;
import com.agyanatma.plantscheduler.repositories.UserRepository;
import com.agyanatma.plantscheduler.services.AuthenticationService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest body) {
        return ResponseEntity.ok(authenticationService.authenticate(body));
    }

    @PostMapping("/register")
    public ResponseEntity<Optional<User>> register(@RequestBody RegisterRequest body) {
        return ResponseEntity.ok(authenticationService.register(body));
    }

}
