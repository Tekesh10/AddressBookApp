package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.UserRegistrationDTO;
import com.example.addressbookapp.model.UserData;
import com.example.addressbookapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserData userLogin(String userName, String password) {
        return userRepository.loginValidation(userName, password);
    }
    @Override
    public UserData userRegistration(UserRegistrationDTO userRegistrationDTO) {
        UserData userData = new UserData(userRegistrationDTO);
        return userRepository.save(userData);
    }
}