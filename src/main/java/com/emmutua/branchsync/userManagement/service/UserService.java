package com.emmutua.branchsync.userManagement.service;

import com.emmutua.branchsync.userManagement.model.AppUser;
import com.emmutua.branchsync.userManagement.model.Role;

import java.util.List;

public interface UserService {

    List<AppUser> getAllUsersEnabled(Role role, Boolean enabled);
}

