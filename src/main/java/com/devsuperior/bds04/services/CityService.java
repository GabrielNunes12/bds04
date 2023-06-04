package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
  @Autowired
  private CityRepository cityRepository;
  public CityDTO insertCity(CityDTO cityDTO) {
    City newCity = new City();
    newCity.setId(cityDTO.getId());
    newCity.setName(cityDTO.getName());
    newCity = cityRepository.save(newCity);
    return new CityDTO(newCity);
  }

  public List<City> findAllSortedByASC(Sort sort) {
    if (sort != null) {
      return cityRepository.findAll(Sort.by("name").ascending());
    } else {
      return cityRepository.findAll();
    }
  }
}
