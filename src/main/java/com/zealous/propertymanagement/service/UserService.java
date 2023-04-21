package com.zealous.propertymanagement.service;

import com.zealous.propertymanagement.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password);

}
