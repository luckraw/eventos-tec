package com.luckraw.eventos_tec.services;

import com.luckraw.eventos_tec.domain.event.Event;
import com.luckraw.eventos_tec.domain.event.EventRequestDTO;
import com.luckraw.eventos_tec.domain.event.EventResponseDTO;
import com.luckraw.eventos_tec.repositories.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AddressService addressService;

    public Event createEvent(EventRequestDTO data) {
        Event newEvent = new Event();
        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setEventUrl(data.eventUrl());
        newEvent.setDate(new Date(data.date()));
        newEvent.setImgUrl(data.image());
        newEvent.setRemote(data.remote());

        eventRepository.save(newEvent);

        if(!data.remote()) {
            this.addressService.createAddress(data, newEvent);
        }

        return newEvent;
    }


    public List<EventResponseDTO> getUpcomingEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Event> eventsPage = eventRepository.findUpcomingEvents(new Date(), pageable);
        return eventsPage.map(event -> new EventResponseDTO(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getDate(),
                "",
                "",
                event.getRemote(),
                event.getEventUrl(),
                event.getImgUrl())).stream().toList();
    }


    public List<EventResponseDTO> getFilteredEvents(int page, int size, String title, String city, String uf, Date startDate, Date endDate) {

        title = (title != null) ? title : "";
        city = (city != null) ? city : "";
        uf = (uf != null) ? uf : "";
        startDate = (startDate != null) ? startDate : new Date(0);
        endDate = (endDate != null) ? endDate : new Date();

        Pageable pageable = PageRequest.of(page, size);
        Page<Event> eventsPage = eventRepository.findFilteredEvents(title, city, uf, startDate, endDate,  pageable);
        return eventsPage.map(event -> new EventResponseDTO(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getDate(),
                event.getAddress() != null ? event.getAddress().getCity() : "",
                event.getAddress() != null ? event.getAddress().getUf() : "",
                event.getRemote(),
                event.getEventUrl(),
                event.getImgUrl())).stream().toList();
    }
}
