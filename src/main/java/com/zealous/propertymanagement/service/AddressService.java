package com.zealous.propertymanagement.service;

import com.zealous.propertymanagement.dto.AddressDTO;
import com.zealous.propertymanagement.entity.AddressEntity;

public interface AddressService {
    AddressDTO getAddressByUserId(Long id);
}
