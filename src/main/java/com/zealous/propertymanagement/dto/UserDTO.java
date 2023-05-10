package com.zealous.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private String ownerName;
    @NotNull(message = "OwnerEmail is mandatory")
    @NotEmpty(message = "OwnerEmail can not be empty")
    @Size(min = 1,max = 50, message = "OwnerEmail should be 1 to 50 char in length")
    private String ownerEmail;
    private String mobile;
    @NotNull(message = "Password can not be null")
    @NotEmpty(message = "Password can not be empty")
    private String password;
    private String houseNo;
    private String street;
    private String city;
    private String postalCode;
    private String country;
}
