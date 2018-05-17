package com.github.kamilpiatkowski.eventmanager.repository;

import com.github.kamilpiatkowski.eventmanager.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

}
