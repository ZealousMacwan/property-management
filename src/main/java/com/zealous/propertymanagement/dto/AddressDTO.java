package com.zealous.propertymanagement.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private Long id;
    private String houseNo;
    private String street;
    private String city;
    private String postalCode;
    private String country;
    private Long userId;
}
