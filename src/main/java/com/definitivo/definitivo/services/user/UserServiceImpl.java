package com.definitivo.definitivo.services.user;

import com.definitivo.definitivo.models.User;
import com.definitivo.definitivo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> getUser(int page, int size) {

        return userRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public User postUser(UserDto userDto, String role) {
        var newUser = (role.equals("STAFF")) ? userDto.addStaff(userDto): userDto.addCostumer(userDto);

        return userRepository.save(newUser);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username).get();
    }
}
