package com.definitivo.definitivo.controller;


import com.definitivo.definitivo.models.User;
import com.definitivo.definitivo.services.user.UserDto;
import com.definitivo.definitivo.services.user.UserService;
import com.definitivo.definitivo.utils.GeralUtillities;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Page<User>> getAllUsers(@RequestParam int page, @RequestParam int size){
        Page<User> users = userService.getUser(page, size);
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/users/{username}")   public ResponseEntity<User> getSpecificUser(@PathVariable("username") String name){
        return ResponseEntity.ok().body(userService.getUser(name));
    }

    @PostMapping("/users/post/{role}")
    public  ResponseEntity<User> createUser(@RequestBody UserDto userDto, @PathVariable("role") String role){
        URI uri = GeralUtillities.toUri("/user/create/{role}");
        return ResponseEntity.created(
                uri
        ).body(userService.postUser(userDto, role));
    }
}
