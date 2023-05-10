package com.zealous.propertymanagement.dto;

import lombok.Data;

@Data   //generates getters and setters
public class PropertyDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String address;
    private Long userId;
}
