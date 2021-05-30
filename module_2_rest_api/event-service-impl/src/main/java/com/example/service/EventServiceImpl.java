package com.example.service;

import com.example.EventService;
import com.example.dto.EventDTO;
import com.example.exception.ResourceAlreadyExistException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Event;
import com.example.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EventServiceImpl implements EventService {
    private final EventRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public EventDTO createEvent(EventDTO eventDto) {
        if (repository.findById(eventDto.getId()).isPresent()) {
            throw new ResourceAlreadyExistException();
        }
        Event event = modelMapper.map(eventDto, Event.class);
        return modelMapper.map(repository.save(event), EventDTO.class);
    }

    @Override
    public EventDTO updateEvent(EventDTO eventDto, Long id) {
        Event event = modelMapper.map(eventDto, Event.class);
        return repository.findById(id)
                .map(employee -> {
                    return modelMapper.map(repository.save(event), EventDTO.class);
                })
                .orElseGet(() -> {
                    event.setId(id);
                    return modelMapper.map(repository.save(event), EventDTO.class);
                });
    }

    @Override
    public EventDTO getEventById(Long id) {
        Event event = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return modelMapper.map(event, EventDTO.class);
    }

    @Override
    public void deleteEvent(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<EventDTO> getAllEvents() {
        List<Event> events = repository.findAll();
        return modelMapper.map(events, new TypeToken<List<EventDTO>>() {
        }.getType());
    }

    @Override
    public List<EventDTO> getAllEventsByTitle(String title) {
        List<Event> events = repository.findAllByTitle(title);
        return modelMapper.map(events, new TypeToken<List<EventDTO>>() {
        }.getType());
    }
}
