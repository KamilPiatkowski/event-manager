package com.github.kamilpiatkowski.eventmanager.service;

import com.github.kamilpiatkowski.eventmanager.model.Event;
import com.github.kamilpiatkowski.eventmanager.repository.EventRepository;
import org.springframework.beans.BeanUtils;
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
        Optional<Event> existingEvent = eventRepository.findById(id);
        BeanUtils.copyProperties(event, existingEvent);
        return eventRepository.save(existingEvent.get());
    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
