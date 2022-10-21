package com.example.addressbookapp.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressBookDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$", message = "First Name Invalid")
    @NotEmpty(message = "First Name Can't be Empty")
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$", message = "Last Name Invalid")
    @NotEmpty(message = "Last Name Can't be Empty")
    public String lastName;

    @NotBlank(message = "Address cannot be Empty")
    public String address;

    @NotEmpty(message = "City cannot be Empty")
    public String city;

    @NotEmpty(message = "State cannot be Empty")
    public String state;

    @Pattern(regexp = "^[0-9]{6}$", message = "Zip Code is Invalid")
    @NotEmpty(message = "Zip Code cannot be Empty")
    public String zipCode;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone Number is Invalid")
    @NotNull(message = "Phone Number should not be Empty")
    public String phoneNumber;

    @Pattern(regexp = "^[a-z0-9]+([.+_-]?[a-z0-9]+)?@[a-z0-9]+[.]([a-z0-9]+[.])?[a-z]{2,}$", message = "Email is Invalid")
    @NotNull(message = "Email should not be Empty")
    public String email;
}