package com.definitivo.definitivo.Auth;

import com.definitivo.definitivo.services.user.UserDto;
import com.definitivo.definitivo.utils.GeralUtillities;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/teste")
    public String Teste(){
        return "teste";
    }

    @PostMapping("/register/{role}")
    public ResponseEntity<Response> register(@RequestBody UserDto userDto, @PathVariable String role){
        URI uri = GeralUtillities.toUri("/register/{role}");
        return ResponseEntity.created(uri).body(authService.register(userDto, role));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody AuthDTO authDTO){
        return ResponseEntity.ok().body(authService.login(authDTO));
    }
}
