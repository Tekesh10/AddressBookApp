package com.example.addressbookapp.model;

import com.example.addressbookapp.dto.UserRegistrationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_data")
public @Data class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String userEmail;
    private String password;
    public UserData(UserRegistrationDTO userRegistrationDTO) {
        this.userName = userRegistrationDTO.getUserName();
        this.userEmail = userRegistrationDTO.getUserEmail();
        this.password = userRegistrationDTO.getPassword();
    }
}