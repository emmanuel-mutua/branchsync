package com.emmutua.branchsync.userManagement.apis;

import com.emmutua.branchsync.userManagement.dtos.AuthenticationResponse;
import com.emmutua.branchsync.userManagement.dtos.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users-management/")
public class UserController {
    // TODO REGISTER USER
    @GetMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterRequest registerRequest) {
        return null;
    }
    // TODO LOGIN USER
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
