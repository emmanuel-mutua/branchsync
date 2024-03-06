package com.emmutua.branchsync.userManagement.apis;

import com.emmutua.branchsync.userManagement.dtos.AuthenticationResponse;
import com.emmutua.branchsync.userManagement.dtos.LoginRequest;
import com.emmutua.branchsync.userManagement.dtos.RegisterRequest;
import com.emmutua.branchsync.userManagement.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users-management/")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> createUserAccount(@RequestBody RegisterRequest registerRequest) {
        var registerResponse = authenticationService.registerUser(registerRequest);
        return ResponseEntity.status(HttpStatus.OK).body(registerResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody LoginRequest loginRequest){
        var loginResponse = authenticationService.loginUser(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
    }

    // TODO DELETE USER
    // TODO EDIT USER
    // TODO GET USERS
    @GetMapping("/users")
    public List<String> getUsers() {
        List<String> users = new ArrayList<>();
        users.add("Emmanuel");
        users.add("Jacob");
        users.add("Juma");
        return users;
    }
}
