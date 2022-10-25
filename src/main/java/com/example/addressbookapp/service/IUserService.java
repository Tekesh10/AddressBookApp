package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.UserRegistrationDTO;
import com.example.addressbookapp.model.UserData;

public interface IUserService {
    UserData userLogin(String userName, String password);
    UserData userRegistration(UserRegistrationDTO userRegistrationDTO);
}
