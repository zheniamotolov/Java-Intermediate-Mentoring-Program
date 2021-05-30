package com.example;

import com.example.dto.EventDTO;

import java.util.List;

public interface EventService {
    EventDTO createEvent(EventDTO event);

    EventDTO updateEvent(EventDTO event, Long id);

    EventDTO getEventById(Long id);

    void deleteEvent(Long id);

    List<EventDTO> getAllEvents();

    List<EventDTO> getAllEventsByTitle(String title);

}
