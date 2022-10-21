package com.example.addressbookapp.repository;

import com.example.addressbookapp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {
}
