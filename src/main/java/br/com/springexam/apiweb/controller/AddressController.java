package br.com.springexam.apiweb.controller;

import br.com.springexam.apiweb.model.Address;
import br.com.springexam.apiweb.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping(method = RequestMethod.POST, value ="/addresses")
    public ResponseEntity<List<Address>> insert(@RequestBody List<Address> addressList) {
        addressService.save(addressList);
        System.out.println("Addresses: " + addressList.toString() + " saved!");
        return new ResponseEntity<>(addressList, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/addresses")
    public ResponseEntity<Collection<Address>> getAll(){
        Collection<Address> addresses = addressService.selectAll();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addresses/{id}")
    public ResponseEntity<Address> getById(@PathVariable int id) {
        Address result = addressService.selectById(id);
        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/addresses/{id}")
    public ResponseEntity<Address> delete(@PathVariable int id) {
        Address address = addressService.selectById(id);
        if(address == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        addressService.delete(address);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/addresses")
    public ResponseEntity<Address> update(@RequestBody Address address) {
        Address result = addressService.selectById(address.getAddressId());
        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        addressService.update(address);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}
