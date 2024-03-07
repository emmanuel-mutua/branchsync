package com.emmutua.branchsync.userManagement.auth.apis;

import com.emmutua.branchsync.userManagement.auth.dtos.AuthenticationResponse;
import com.emmutua.branchsync.userManagement.auth.dtos.LoginRequest;
import com.emmutua.branchsync.userManagement.auth.dtos.RegisterRequest;
import com.emmutua.branchsync.userManagement.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class AuthController {
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
}
