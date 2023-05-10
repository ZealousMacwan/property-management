package com.zealous.propertymanagement.service.impl;

import com.zealous.propertymanagement.converter.PropertyConverter;
import com.zealous.propertymanagement.dto.PropertyDTO;
import com.zealous.propertymanagement.entity.PropertyEntity;
import com.zealous.propertymanagement.entity.UserEntity;
import com.zealous.propertymanagement.exception.BusinessException;
import com.zealous.propertymanagement.exception.ErrorModel;
import com.zealous.propertymanagement.repository.PropertyRepository;
import com.zealous.propertymanagement.repository.UserRepository;
import com.zealous.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //to make this class as singleton class
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        Optional<UserEntity> userEntity = userRepository.findById(propertyDTO.getUserId());
        if(userEntity.isPresent()){
            PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
            pe.setUserEntity(userEntity.get());
            pe = propertyRepository.save(pe);
            propertyDTO = propertyConverter.convertEntitytoDTO(pe);
        }else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("USER_ID_DOES_NOT_EXIST");
            errorModel.setMessage("User does not exist");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> list_of_properties =  (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> result_list_of_properties = new ArrayList<>();
        for(PropertyEntity pe: list_of_properties){
            PropertyDTO propertyDTO = propertyConverter.convertEntitytoDTO(pe);
            result_list_of_properties.add(propertyDTO);
        }
        return result_list_of_properties;
    }

    @Override
    public List<PropertyDTO> getAllPropertiesForUser(Long userId) {
        List<PropertyEntity> list_of_properties =  (List<PropertyEntity>)propertyRepository.findAllByUserEntityId(userId);
        List<PropertyDTO> result_list_of_properties = new ArrayList<>();
        for(PropertyEntity pe: list_of_properties){
            PropertyDTO propertyDTO = propertyConverter.convertEntitytoDTO(pe);
            result_list_of_properties.add(propertyDTO);
        }
        return result_list_of_properties;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        //Optional helps to check null
        Optional<PropertyEntity> pe = propertyRepository.findById(propertyId);
        PropertyDTO response_result_dto = null;
        if(pe.isPresent()){
            //get existing record and update
            PropertyEntity result_pe = pe.get();
            result_pe.setTitle(propertyDTO.getTitle());
            result_pe.setAddress(propertyDTO.getAddress());
            result_pe.setPrice(propertyDTO.getPrice());
            result_pe.setDescription(propertyDTO.getDescription());
            response_result_dto = propertyConverter.convertEntitytoDTO(result_pe);
            propertyRepository.save(result_pe);
        }
        return response_result_dto;
    }

    @Override
    public PropertyDTO updatePropertyUpdateDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> pe = propertyRepository.findById(propertyId);
        PropertyDTO response_property_dto = null;
        if(pe.isPresent()){
            PropertyEntity result_pe = pe.get();
            result_pe.setDescription(propertyDTO.getDescription());
            propertyRepository.save(result_pe);
            response_property_dto = propertyConverter.convertEntitytoDTO(result_pe);
        }

        return response_property_dto;
    }

    @Override
    public PropertyDTO updatePropertyUpdatePrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> pe = propertyRepository.findById(propertyId);
        PropertyDTO response_property_dto = null;
        if(pe.isPresent()){
            PropertyEntity result_pe = pe.get();
            result_pe.setPrice(propertyDTO.getPrice());
            propertyRepository.save(result_pe);
            response_property_dto = propertyConverter.convertEntitytoDTO(result_pe);
        }

        return response_property_dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }


}
