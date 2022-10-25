package com.example.addressbookapp.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UserRegistrationDTO {
    public String userName;

    @Pattern(regexp = "^[a-z0-9]+([.+_-]?[a-z0-9]+)?@[a-z0-9]+[.]([a-z0-9]+[.])?[a-z]{2,}$", message = "Email is Invalid")
    @NotNull(message = "Email should not be Empty")
    public String userEmail;

    public String password;
}