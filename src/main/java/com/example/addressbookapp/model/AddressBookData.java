package com.example.addressbookapp.model;

import com.example.addressbookapp.dto.AddressBookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "address_book")
@NoArgsConstructor
public @Data class AddressBookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_book_id")
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;

    public AddressBookData(AddressBookDTO addressBookDTO) {
        this.updateAddressBookData(addressBookDTO);
    }
    public void updateAddressBookData(AddressBookDTO addressBookDTO) {
        this.firstName = addressBookDTO.firstName;
        this.lastName = addressBookDTO.lastName;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zipCode = addressBookDTO.zipCode;
        this.phoneNumber = addressBookDTO.phoneNumber;
        this.email = addressBookDTO.email;
    }
}