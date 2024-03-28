package com.example.finalbmworder.Service.Impl;



import com.example.finalbmworder.Dto.UserDto;
import com.example.finalbmworder.Model.User;
import com.example.finalbmworder.Repository.UserRepository;
import com.example.finalbmworder.Service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public List<UserDto> listAllUser() {
        return null;
    }

    @Override
    public UserDto findById(Long id) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public void update(UserDto userDto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> filter() {
        return null;
    }
}
