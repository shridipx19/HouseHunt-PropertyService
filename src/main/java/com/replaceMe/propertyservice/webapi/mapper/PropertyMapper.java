package com.replaceMe.propertyservice.webapi.mapper;

import com.replaceMe.propertyservice.webapi.entity.PropertyEntity;
import com.replaceMe.propertyservice.webapi.model.PropertyModel;
import com.replaceMe.propertyservice.webapi.model.request.PropertyRequest;
import com.replaceMe.propertyservice.webapi.model.response.PropertyResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // Ensures the mapper is available as a Spring Bean
public interface PropertyMapper {
    PropertyMapper INSTANCE = Mappers.getMapper(PropertyMapper.class); // MapStructs factory method for the mapper instance

    PropertyEntity toEntity(PropertyRequest propertyDetails);
    PropertyResponse toDto(PropertyEntity propertyEntity); // If needed, you can map the entity back to DTO as well
}
