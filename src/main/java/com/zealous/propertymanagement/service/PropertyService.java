package com.zealous.propertymanagement.service;

import com.zealous.propertymanagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);
    PropertyDTO updatePropertyUpdateDescription(PropertyDTO propertyDTO, Long propertyId);
    PropertyDTO updatePropertyUpdatePrice(PropertyDTO propertyDTO, Long propertyId);
    void deleteProperty(Long propertyId);
}
