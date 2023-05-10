package com.zealous.propertymanagement.repository;

import com.zealous.propertymanagement.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
    Optional<AddressEntity> findByUserEntityId(Long id);
}
