//package com.example.employeeapp.Address;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class AddressController {
//
//    private final AddressService addressService;
//
//    public AddressController(AddressService addressService) {
//        this.addressService = addressService;
//    }
//
//    @GetMapping("/address")
//public AddressEntity getAddress(@RequestParam long id) {
//    return  addressService.getAddress(id);
//    }
//
//    @PostMapping("/address")
//    public AddressEntity addAddress(@RequestBody AddressEntity address){
//        return addressService.addAddress(address);
//    }
//}
//
//
////    @GetMapping("/address")
////    public ResponseEntity<AddressDto>
////    getAddressById(@PathVariable("id")  Long id){
////        AddressDto addressDto = addressService.getAddressById(id);
////        return ResponseEntity.ok(addressDto);
////    }
////
////    @PostMapping("/address")
////    public ResponseEntity<AddressDto>
////    addAddress(@RequestBody AddressDto addressDto){
////        AddressDto addAddress = addressService.addAddress(addressDto);
////        return ResponseEntity.status(HttpStatus.CREATED).body(addAddress);
////    }
////
////}