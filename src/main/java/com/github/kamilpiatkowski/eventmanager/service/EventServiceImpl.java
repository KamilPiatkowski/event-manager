package com.github.kamilpiatkowski.eventmanager.service;

import com.github.kamilpiatkowski.eventmanager.model.Event;
import com.github.kamilpiatkowski.eventmanager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    EventRepository eventRepository;

    @Override
    public Iterable<Event> list() {
        return eventRepository.findAll();
    }

    @Override
    public Event add(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Optional<Event> view(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Event update(Long id, Event event) {
        if(!(eventRepository.findById(id).equals(event))) {
            eventRepository.deleteById(id);
            eventRepository.save(event);
        }
        return event;
    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
