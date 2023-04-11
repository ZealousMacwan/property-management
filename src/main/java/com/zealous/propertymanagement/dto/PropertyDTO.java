package com.zealous.propertymanagement.dto;

import lombok.Data;

@Data   //generates getters and setters
public class PropertyDTO {
    private Long id;
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private Double price;
    private String address;
}
