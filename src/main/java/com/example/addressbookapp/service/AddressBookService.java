package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.exception.AddressBookException;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.repository.AddressBookRepository;
import com.example.addressbookapp.util.EmailSender;
import com.example.addressbookapp.util.JWTToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{
    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private JWTToken jwtToken;
    @Autowired
    EmailSender emailSender;
    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookRepository.findAll();
    }
    @Override
    public List<AddressBookData> sortAddressBookDataByCity() {
        return addressBookRepository.sortAddressBookDataByCity();
    }
    @Override
    public List<AddressBookData> sortAddressBookDataByState() {
        return addressBookRepository.sortAddressBookDataByState();
    }
    @Override
    public AddressBookData getAddressBookById(String token) {
        int id = jwtToken.parseJWT(token);
        return addressBookRepository.findById(id).orElseThrow(() -> new AddressBookException("Address Book With Id No."+id+" does not Exists"));
    }
    @Override
    public String createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        addressBookRepository.save(addressBookData);
        emailSender.sendEmail(addressBookData.getEmail(), "Address Book Email", "Address Book Data created Successfully "+addressBookData);
        return jwtToken.createToken(addressBookData.getId());
    }
    @Override
    public AddressBookData updateAddressBookData(String token, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookById(token);
        addressBookData.updateAddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }
    @Override
    public void deleteAddressBookData(String token) {
        AddressBookData addressBookData = this.getAddressBookById(token);
        addressBookRepository.delete(addressBookData);
    }
}