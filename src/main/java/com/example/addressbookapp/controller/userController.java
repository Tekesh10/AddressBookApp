package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.dto.UserRegistrationDTO;
import com.example.addressbookapp.model.UserData;
import com.example.addressbookapp.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    IUserService iUserService;
    @GetMapping("/login")
    public ResponseEntity<ResponseDTO> userLogin(@RequestParam String userName, @RequestParam String password) {
        UserData userData = iUserService.userLogin(userName, password);
        ResponseDTO responseDTO = new ResponseDTO("Logged in Successfully", userData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> userRegistration(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        UserData userData = iUserService.userRegistration(userRegistrationDTO);
        ResponseDTO responseDTO = new ResponseDTO("User Successfully registered", userData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}