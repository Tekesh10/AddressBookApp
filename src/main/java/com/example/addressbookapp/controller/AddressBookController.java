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
    @GetMapping(value = {"/sortByCity"})
    public ResponseEntity<ResponseDTO> sortAddressBookDataByCity() {
        List<AddressBookData> addressBookDataList = iAddressBookService.sortAddressBookDataByCity();
        ResponseDTO responseDTO = new ResponseDTO("Sort by City call was Successful", addressBookDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping(value = {"/sortByState"})
    public ResponseEntity<ResponseDTO> sortAddressBookDataByState() {
        List<AddressBookData> addressBookDataList = iAddressBookService.sortAddressBookDataByState();
        ResponseDTO responseDTO = new ResponseDTO("Sort by State call was Successful", addressBookDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping(value = {"/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData(@RequestHeader String token) {
        ResponseDTO responseDTO = new ResponseDTO("Get by Id call was Successful", iAddressBookService.getAddressBookById(token));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Address Book data added and email sent Successfully", iAddressBookService.createAddressBookData(addressBookDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@RequestHeader String token, @RequestBody AddressBookDTO addressBookDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Address Book data updated Successfully", iAddressBookService.updateAddressBookData(token, addressBookDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@RequestHeader String token) {
        iAddressBookService.deleteAddressBookData(token);
        ResponseDTO responseDTO = new ResponseDTO("Address Book data deleted Successfully", "Id Deleted");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}