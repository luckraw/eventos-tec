package com.luckraw.eventos_tec.controller;

import com.luckraw.eventos_tec.domain.event.Event;
import com.luckraw.eventos_tec.domain.event.EventRequestDTO;
import com.luckraw.eventos_tec.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody EventRequestDTO body) {
        Event event = this.eventService.createEvent(body);
        return ResponseEntity.ok(event);
    }
}
