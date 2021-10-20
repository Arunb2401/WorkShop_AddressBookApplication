package com.bridgelabz.addressbook.DTO;

import lombok.ToString;

public @ToString AdressBookDTO {

    @Pattern(regex = "[A-Z]{1}[a-zA-Z\\s]{2,}$",
                message = "User name is InValid")
     public String firstname;
     @NotNull(message = "Enter the last name ")
     public String lastname;
     @NotNull(message = "Enter the city name")
     public String city;
     @NotNull(message = "Enter State name")
     public String state;

     @Pattern(regex = "[0-9]{6}$",
                message = "ZipCode  is InValid")
     public int zipcode;
}
