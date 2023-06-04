package com.devsuperior.bds04.controllers;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {
  @Autowired
  private CityService cityService;
  @PostMapping
  @Transactional
  public ResponseEntity<CityDTO> insertCity(@Valid @RequestBody CityDTO cityDTO) {
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(cityDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(cityService.insertCity(cityDTO));
  }
  @GetMapping(produces = "application/json")
  public ResponseEntity<List<City>> findAllSorted() {

    Sort sort = Sort.by(Sort.Direction.ASC, "name");
    List<City> sortedCities = cityService.findAllSortedByASC(sort);
    return ResponseEntity.ok().body(sortedCities);
  }
}
