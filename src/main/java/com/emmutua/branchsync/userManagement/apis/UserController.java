package com.emmutua.branchsync.userManagement.apis;

import com.emmutua.branchsync.userManagement.model.Role;
import com.emmutua.branchsync.userManagement.service.UserService;
import com.emmutua.branchsync.userManagement.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-management/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // TODO DELETE USER
    // TODO EDIT USER
    // TODO GET USERS
    @GetMapping("/users")
    public List<AppUser> getAllUsers(){
        return userService.getAllUsersEnabled(Role.USER, true);
    }
}
