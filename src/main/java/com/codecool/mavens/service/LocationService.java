package com.codecool.mavens.service;


import com.codecool.mavens.model.entity.Location;
import com.codecool.mavens.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public List<Location> getAll(){
        return locationRepository.findAll();
    }



}
