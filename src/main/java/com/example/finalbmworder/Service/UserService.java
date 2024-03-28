package com.example.finalbmworder.Service;


import com.example.finalbmworder.Dto.ManufacturerDto;
import com.example.finalbmworder.Dto.UserDto;
import com.example.finalbmworder.Model.Manufacturer;
import com.example.finalbmworder.Model.User;

import java.util.List;

public interface UserService {
    List<UserDto> listAllUser();
    UserDto findById(Long id);
    User create(User user);
    void update(UserDto userDto);
    void delete(Long id);

    List<User> filter();
}
