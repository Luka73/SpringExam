package br.com.springexam.apiweb.service;

import br.com.springexam.apiweb.model.Address;
import br.com.springexam.apiweb.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<Address> save(List<Address> addressList) {
        return addressRepository.saveAll(addressList);
    }

    public Address update(Address address) {
        return addressRepository.save(address);
    }

    public Address selectById(int id) {
        return addressRepository.findById(id).orElse(null);
    }

    public List<Address> selectAll(){
        return addressRepository.findAll();
    }

    public void delete(Address address) {
        addressRepository.delete(address);
    }
}
