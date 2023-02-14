package com.definitivo.definitivo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public interface GeralUtillities {

    public static URI toUri(String path){
        return URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath().path(path).toString());
    }

    public static String encode(String password){

        return new BCryptPasswordEncoder().encode(password);
    }
}
