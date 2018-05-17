package com.github.kamilpiatkowski.eventmanager.service;

import com.github.kamilpiatkowski.eventmanager.model.Event;

import java.util.Optional;

public interface EventService {

    Iterable<Event> list();

    Event add(Event event);

    Optional<Event> view(Long id);

    Event update(Long id, Event event);

    void delete(Long id);

}
