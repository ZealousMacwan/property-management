package com.zealous.propertymanagement.converter;

import com.zealous.propertymanagement.dto.AddressDTO;
import com.zealous.propertymanagement.entity.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {
    public AddressDTO convertEntityToDTO(AddressEntity addressEntity){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(addressEntity.getId());
        addressDTO.setHouseNo(addressEntity.getHouseNo());
        addressDTO.setStreet(addressEntity.getStreet());
        addressDTO.setCity(addressEntity.getCity());
        addressDTO.setCountry(addressEntity.getCountry());
        addressDTO.setPostalCode(addressEntity.getPostalCode());
        addressDTO.setUserId(addressEntity.getUserEntity().getId());

        return  addressDTO;
    }
}
