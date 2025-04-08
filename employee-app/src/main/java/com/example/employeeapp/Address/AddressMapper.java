package com.example.employeeapp.Address;

import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

    //entity to dto
    public AddressDto entitytoDto(AddressEntity addressEntity){
        AddressDto addressDto = new AddressDto();

// can't set ID, it returns a null pointer exception...
        addressDto.setId(addressEntity.getId());
        addressDto.setStreet(addressEntity.getStreet());
        addressDto.setCity(addressEntity.getCity());
        addressDto.setZipcode(addressEntity.getZipcode());

        return addressDto;
    }

    //POST: dto to entity
    public AddressEntity dtotoEntity(AddressDto addressDto){
        AddressEntity addressEntity = new AddressEntity();

        //can't set ID, returns null pointer exception
        addressEntity.setStreet(addressDto.getStreet());
        addressEntity.setCity(addressDto.getCity());
        addressEntity.setZipcode(addressDto.getZipcode());

        return addressEntity;
    }
}
