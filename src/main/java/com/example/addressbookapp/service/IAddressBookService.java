package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAddressBookData();
    List<AddressBookData> sortAddressBookDataByCity();
    List<AddressBookData> sortAddressBookDataByState();
    AddressBookData getAddressBookById(int id);
    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);
    AddressBookData updateAddressBookData(int id, AddressBookDTO addressBookDTO);
    void deleteAddressBookData(int id);
}
