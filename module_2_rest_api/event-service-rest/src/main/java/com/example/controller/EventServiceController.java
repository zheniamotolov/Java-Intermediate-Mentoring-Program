package com.example.controller;

import com.example.dto.EventDTO;
import com.example.service.EventServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/events")
public class EventServiceController {
    private final EventServiceImpl eventService;

    @PostMapping("/")
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO event) {
        EventDTO eventDto = eventService.createEvent(event);
        return new ResponseEntity<>(eventDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEvent(@PathVariable Long id) {
        EventDTO event = eventService.getEventById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<EventDTO>> getEventByTitle(@PathVariable String title) {
        List<EventDTO> events = eventService.getAllEventsByTitle(title);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@RequestBody EventDTO event, @PathVariable Long id) {
        EventDTO updateEvent = eventService.updateEvent(event, id);
        return new ResponseEntity<>(updateEvent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventDTO> deleteEventById(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/")
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<EventDTO> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

}
