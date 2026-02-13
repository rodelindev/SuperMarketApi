package com.rodelindev.SuperMarketApi.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService {

    public boolean hasAccess(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        log.info("username is {}", username);

        authentication.getAuthorities().forEach(authority -> log.info("authority is {}", authority));

        return true;
    }
}
