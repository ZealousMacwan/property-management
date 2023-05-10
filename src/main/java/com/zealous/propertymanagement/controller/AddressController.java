package com.zealous.propertymanagement.controller;

import com.zealous.propertymanagement.dto.AddressDTO;
import com.zealous.propertymanagement.dto.PropertyDTO;
import com.zealous.propertymanagement.entity.AddressEntity;
import com.zealous.propertymanagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{userId}")
    public ResponseEntity<AddressDTO> getAddressByUserId(@PathVariable("userId") Long userId){
        AddressDTO addressDTO = addressService.getAddressByUserId(userId);
        ResponseEntity<AddressDTO> responseEntity = new ResponseEntity<>(addressDTO, HttpStatus.OK);
        return responseEntity;
    }
}
