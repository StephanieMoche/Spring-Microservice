package com.example.employeeapp.Address;

import org.springframework.stereotype.Service;

@Service
public class AddressService {

    public AddressMapper addressMapper;
    public AddressRepository addressRepository;


    public AddressService(AddressMapper addressMapper, AddressRepository addressRepository) {
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }


    public AddressEntity getAddress(long id) {
        return addressRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
    }

    public AddressEntity addAddress(AddressDto addressDto) {
        AddressEntity address =  addressMapper.dtotoEntity(addressDto);
        return addressRepository.save(address);
    }








//    public AddressDto getAddressById(Long id) {
//        return addressRepository.findById(id)
//                .map(addressMapper::entitytoDto)
//                .orElse(null);
//
//    }
//
//    public AddressDto addAddress(AddressDto addressDto) {
//        AddressEntity addressEntity = new AddressEntity();
//        AddressEntity saveEntity = addressRepository.save(addressEntity);
//        return addressMapper.entitytoDto(saveEntity);
//    }


}
