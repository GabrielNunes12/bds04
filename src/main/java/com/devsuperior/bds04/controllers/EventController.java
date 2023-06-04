package com.devsuperior.bds04.controllers;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/events")
public class EventController {
  @Autowired
  private EventService eventService;

  @GetMapping
  public ResponseEntity<Page<EventDTO>> getAllEventsPaginated(Pageable pageable) {
    Page<EventDTO> eventsDTOPaginated = eventService.findPaginated(pageable);
    return new ResponseEntity<>(eventsDTOPaginated, HttpStatus.OK);
  }
  @PostMapping
  public ResponseEntity<EventDTO> postEvent(@Valid @RequestBody EventDTO eventDTO) {
    EventDTO event = eventService.save(eventDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(event.getId()).toUri();
    return ResponseEntity.created(uri).body(event);
  }
}
