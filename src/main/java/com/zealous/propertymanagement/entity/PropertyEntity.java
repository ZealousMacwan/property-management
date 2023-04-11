package com.zealous.propertymanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PROPERTY_TABLE")
@Data
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PROPERTY_TITLE", nullable = false)
    private String title;

    private String description;
    private String ownerName;

    @Column(name = "EMAIL", nullable = false)
    private String ownerEmail;

    private Double price;
    private String address;

}
