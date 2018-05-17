package com.github.kamilpiatkowski.eventmanager.controller;

import com.github.kamilpiatkowski.eventmanager.model.Event;
import com.github.kamilpiatkowski.eventmanager.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class EventController {

    @Autowired
    EventServiceImpl eventService;

    @GetMapping("events")
    public Iterable<Event> list() {
        return eventService.list();
    }

    @PostMapping("events")
    public Event create(@RequestBody Event event) {
        return eventService.add(event);
    }

    @GetMapping("events/{id}")
    public Optional<Event> get(@PathVariable("id") Long id) {
        return eventService.view(id);
    }

    @PutMapping("events/{id}")
    public Event update(@PathVariable("id") Long id, @RequestBody Event event) {
        return eventService.update(id, event);
    }

    @DeleteMapping("events/{id}")
    public void delete(@PathVariable("id") Long id) {
        eventService.delete(id);
    }

}
