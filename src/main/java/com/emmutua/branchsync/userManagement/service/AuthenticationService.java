package com.emmutua.branchsync.userManagement.service;

import com.emmutua.branchsync.userManagement.dtos.AuthenticationResponse;
import com.emmutua.branchsync.userManagement.dtos.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse registerUser(RegisterRequest registerRequest);
}