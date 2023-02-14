package com.definitivo.definitivo.services.user;

import com.definitivo.definitivo.models.User;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface UserService {

    Page<User> getUser(int page, int size);
    User postUser(UserDto userDto, String role);
    User getUser(String username);
}
