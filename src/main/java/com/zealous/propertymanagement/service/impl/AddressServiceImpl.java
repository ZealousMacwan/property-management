package com.zealous.propertymanagement.service.impl;

import com.zealous.propertymanagement.converter.AddressConverter;
import com.zealous.propertymanagement.dto.AddressDTO;
import com.zealous.propertymanagement.entity.AddressEntity;
import com.zealous.propertymanagement.exception.BusinessException;
import com.zealous.propertymanagement.exception.ErrorModel;
import com.zealous.propertymanagement.repository.AddressRepository;
import com.zealous.propertymanagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressConverter addressConverter;

    @Override
    public AddressDTO getAddressByUserId(Long id) {
        Optional<AddressEntity> addressEntity = addressRepository.findByUserEntityId(id);
        if(!addressEntity.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("ADDRESS_DOES_NOT_EXISTS");
            errorModel.setMessage("Address does not exist for given user id");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        AddressDTO addressDTO = addressConverter.convertEntityToDTO(addressEntity.get());
        return addressDTO;
    }
}
