package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/addressBookService")
public class AddressBookController {
    @Autowired
    private IAddressBookService iAddressBookService;
    @GetMapping(value = {"/getAll"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> addressBookDataList = iAddressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get All call was Successful", addressBookDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping(value = {"/get/{id}"})
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("id") int id) {
        AddressBookData addressBookData = iAddressBookService.getAddressBookById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get by Id call was Successful", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = iAddressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Address Book data added Successfully", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("id") int id, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = iAddressBookService.updateAddressBookData(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Address Book data updated Successfully", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("id") int id) {
        iAddressBookService.deleteAddressBookData(id);
        ResponseDTO responseDTO = new ResponseDTO("Address Book data deleted Successfully", "Deleted id No."+id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
