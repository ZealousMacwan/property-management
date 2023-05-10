package com.zealous.propertymanagement.service.impl;

import com.zealous.propertymanagement.converter.UserConverter;
import com.zealous.propertymanagement.dto.UserDTO;
import com.zealous.propertymanagement.entity.AddressEntity;
import com.zealous.propertymanagement.entity.UserEntity;
import com.zealous.propertymanagement.exception.BusinessException;
import com.zealous.propertymanagement.exception.ErrorModel;
import com.zealous.propertymanagement.repository.AddressRepository;
import com.zealous.propertymanagement.repository.UserRepository;
import com.zealous.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(optionalUserEntity.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXISTS");
            errorModel.setMessage("Email already exists");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setHouseNo(userDTO.getHouseNo());
        addressEntity.setCity(userDTO.getCity());
        addressEntity.setPostalCode(userDTO.getPostalCode());
        addressEntity.setStreet(userDTO.getStreet());
        addressEntity.setCountry(userDTO.getCountry());
        addressEntity.setUserEntity(userEntity);

        addressRepository.save(addressEntity);

        userDTO = userConverter.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntiry = userRepository.findByOwnerEmailAndPassword(email, password);
        if(optionalUserEntiry.isPresent()){
            userDTO = userConverter.convertEntitytoDTO(optionalUserEntiry.get());
        }else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect email or password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        return userDTO;
    }
}
