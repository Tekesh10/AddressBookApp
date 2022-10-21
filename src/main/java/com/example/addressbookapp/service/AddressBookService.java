package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.exception.AddressBookException;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{
    @Autowired
    private AddressBookRepository addressBookRepository;
    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookRepository.findAll();
    }
    @Override
    public AddressBookData getAddressBookById(int id) {
        return addressBookRepository.findById(id).orElseThrow(() -> new AddressBookException("Address Book With Id."+id+" does not Exists"));
    }
    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }
    @Override
    public AddressBookData updateAddressBookData(int id, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookById(id);
        addressBookData.updateAddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }
    @Override
    public void deleteAddressBookData(int id) {
        AddressBookData addressBookData = this.getAddressBookById(id);
        addressBookRepository.delete(addressBookData);
    }
}