package com.luckraw.eventos_tec.controller;

import com.luckraw.eventos_tec.domain.event.Event;
import com.luckraw.eventos_tec.domain.event.EventRequestDTO;
import com.luckraw.eventos_tec.domain.event.EventResponseDTO;
import com.luckraw.eventos_tec.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> getEvents(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        List<EventResponseDTO> events = eventService.getUpcomingEvents(page, size);
        return ResponseEntity.ok(events);
    }
}
