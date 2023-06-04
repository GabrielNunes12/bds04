package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventService {
  @Autowired
  private EventRepository eventRepository;

  public Page<EventDTO> findPaginated(Pageable pageable) {
    Page<Event> eventPaginated =  eventRepository.findAll(pageable);
    return eventPaginated.map(event -> new EventDTO(event));
  }

  public EventDTO save(EventDTO event) {
    Event entity = new Event();
    City city = new City();
    city.setId(event.getCityId());
    entity.setName(event.getName());
    entity.setCity(city);
    entity.setDate(event.getDate());
    entity.setUrl(event.getUrl());
    entity = eventRepository.save(entity);
    return new EventDTO(entity);
  }
}
