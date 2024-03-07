package com.emmutua.branchsync.userManagement.service;

import com.emmutua.branchsync.userManagement.model.AppUser;
import com.emmutua.branchsync.userManagement.model.Role;
import com.emmutua.branchsync.userManagement.repo.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class  UserServiceImpl implements UserService  {
private final AppUserRepository appUserRepository;

    @Override
    public List<AppUser> getAllUsersEnabled(Role role, Boolean enabled) {
        try {
            return appUserRepository.findAllByRoleAndEnabled(role, enabled);
        }catch (Exception e){
            return Collections.emptyList();
        }
    }
}
