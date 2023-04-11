package com.zealous.propertymanagement.service.impl;

import com.zealous.propertymanagement.converter.PropertyConverter;
import com.zealous.propertymanagement.dto.PropertyDTO;
import com.zealous.propertymanagement.entity.PropertyEntity;
import com.zealous.propertymanagement.repository.PropertyRepository;
import com.zealous.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //to make this class as singleton class
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
        pe = propertyRepository.save(pe);
        return propertyConverter.convertEntitytoDTO(pe);
    }
}
