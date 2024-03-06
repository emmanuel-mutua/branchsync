package com.emmutua.branchsync.userManagement.service;

import com.emmutua.branchsync.userManagement.dtos.AuthenticationResponse;
import com.emmutua.branchsync.userManagement.dtos.LoginRequest;
import com.emmutua.branchsync.userManagement.dtos.RegisterRequest;
import com.emmutua.branchsync.userManagement.model.AppUser;
import com.emmutua.branchsync.userManagement.model.Role;
import com.emmutua.branchsync.userManagement.repo.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse registerUser(RegisterRequest registerRequest) {
        var existsByEmailErrorMessage = "User exists";
        var creationMessage = "Account created successfully";
        var token = "lkdkldlkalfnaddeereefeat.ereraercatervrrcssrcsrcsr.rsvrscsrcsrscrcsysrvy";
        if (userRepository.existsAppUserByEmail(registerRequest.getEmail())) {
            return AuthenticationResponse.error(existsByEmailErrorMessage);
        }
        var appUser = AppUser.builder()
                .firstname(registerRequest.getFirstname())
                .lastname(registerRequest.getLastname())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(appUser);
        return AuthenticationResponse.success(token, creationMessage);
    }

    @Override
    public AuthenticationResponse loginUser(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            var loggedUser = userRepository.findByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
            var token = "lkdkldlkalfnaddeereefeat.ereraercatervrrcssrcsrcsr.rsvrscsrcsrscrcsysrvy";
            return AuthenticationResponse.success(token, "Login Success");
        }catch (Exception e){
            return AuthenticationResponse.error(e.getMessage());
        }
    }
}
