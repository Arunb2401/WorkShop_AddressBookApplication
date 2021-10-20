package com.bridgelabz.addressbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/addressbookservice")
@Slf4j
public class AddressBookController {
    
    @Autowired
    private IAddressBookService addressBookService;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData(){
            List<AddressbookData> userDataList = null;
            userDataList = addressBookService.getAddressBookData();
            ResponseDTO responseDTO = new ResponseDTO("GET call is Successful", employeeDataList);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{userId}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("userId") int userId) {
        AddressbookData userData = null;
        userData = addressBookService.getAddressBookDataById(userId);
        ResponseDTO responseDTO = new ResponseDTO("GET call for User ID is successfull for ID: ", userData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressBookData(
            @Valid @RequestBody AddressBookDTO addressbookDTO) {
        log.debug("AddressBook DTO:" + addressbookDTO.toString());
        AddressbookData userData = null;
        userData = addressBookService.createAddressbookData(addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Address Book Data Successfull !!", userData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    
    @PutMapping("/update/{userId}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("UserId") int userId,
            @Valid @RequestBody AddressBookDTO addressBookDTO) {
        log.debug("User DTO:" + addressBookDTO.toString());
        AddressbookData userData = null;
        userData = addressBookService.updateAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Address Book Data Successfully!!", userData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("userId") int userId) {
        addressBookService.deleteAddressBookData(userId);
        ResponseDTO responseDTO = new ResponseDTO("DELETED Successfully !!", "Deleted ID: " + userId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
