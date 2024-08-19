package com.luckraw.eventos_tec.domain.address;

import com.luckraw.eventos_tec.domain.event.Event;

public record AddressRequestDTO(String city, String uf, Event event) {
}
