package com.emmutua.branchsync.userManagement.auth.service;

import com.emmutua.branchsync.userManagement.auth.dtos.AuthenticationResponse;
import com.emmutua.branchsync.userManagement.auth.dtos.LoginRequest;
import com.emmutua.branchsync.userManagement.auth.dtos.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse registerUser(RegisterRequest registerRequest);

    AuthenticationResponse loginUser(LoginRequest loginRequest);
}
