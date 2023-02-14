package com.definitivo.definitivo.Auth;

import com.definitivo.definitivo.config.JwtService;
import com.definitivo.definitivo.models.User;
import com.definitivo.definitivo.repository.UserRepository;
import com.definitivo.definitivo.services.user.UserDto;
import com.definitivo.definitivo.services.user.UserService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired(required = true)
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;


    private UserDetailsService userDetailsService;

    public Response register(UserDto userDto, String role){
        User user = userService.postUser(userDto, role);
        String jwt = jwtService.generateToken(user);
        return Response.builder().token(jwt).build();
    }

    public Response login(AuthDTO authDTO){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.password())
        );
        var user = this.userDetailsService.loadUserByUsername(authDTO.login());
        String jwtToken = jwtService.generateToken(user);
        return Response.builder().token(jwtToken).build();
    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Response{
    private String token;
}








