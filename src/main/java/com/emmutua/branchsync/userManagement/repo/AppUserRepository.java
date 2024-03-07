package com.emmutua.branchsync.userManagement.repo;

import com.emmutua.branchsync.userManagement.model.AppUser;
import com.emmutua.branchsync.userManagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
     boolean existsAppUserByEmail(String email);
     Optional<AppUser> findByEmail(String email);

     List<AppUser> findAllByRoleAndEnabled(Role role, boolean enabled);
}
