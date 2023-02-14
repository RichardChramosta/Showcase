package com.example.security.services;

import com.example.security.securities.ApplicationUserRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository("fake")
public class FakeApplicationUserDao implements ApplicationUserDao {
    private final PasswordEncoder passwordEncoder;

    public FakeApplicationUserDao(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers().stream()
                .filter(applicationUser -> username.equals((applicationUser.getUsername())))
                .findFirst();
    }
    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = new ArrayList<>(List.of(
               new ApplicationUser(ApplicationUserRole.STUDENT.getGrantedAuthorities(),
                       passwordEncoder.encode( "lala123"),"annath",
                       true,true,true,true),
                new ApplicationUser(ApplicationUserRole.ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode( "lala123"),"linda",
                        true,true,true,true),
                new ApplicationUser(ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities(),
                        passwordEncoder.encode( "lala123"),"tom",
                        true,true,true,true)
        ));
        return applicationUsers;
    }
}
