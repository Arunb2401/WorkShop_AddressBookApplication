package com.bridgelabz.addressbook.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "address_book")
public @Data class AddressBookData {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_id")
    private int user_Id;

    @Column(name = "FirstName")
    private String firstName;
    


}
