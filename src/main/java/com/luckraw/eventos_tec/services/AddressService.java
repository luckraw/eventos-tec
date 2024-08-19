package com.luckraw.eventos_tec.services;

import com.luckraw.eventos_tec.domain.address.Address;
import com.luckraw.eventos_tec.domain.address.AddressRequestDTO;
import com.luckraw.eventos_tec.domain.event.Event;
import com.luckraw.eventos_tec.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(AddressRequestDTO request, Event event) {
        Address address = new Address();
        address.setCity(request.city());
        address.setUf(request.uf());
        address.setEvent(request.event());

        return addressRepository.save(address);
    }
}
