package com.rodelindev.SuperMarketApi.security;

import com.rodelindev.SuperMarketApi.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final IUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findOneByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        String rol = user.getRole().getName();
        roles.add(new SimpleGrantedAuthority(rol));

        return new User(user.getUsername(), user.getPassword(), roles);
    }
}
