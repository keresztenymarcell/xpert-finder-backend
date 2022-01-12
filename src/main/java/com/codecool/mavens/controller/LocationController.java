package com.codecool.mavens.controller;


import com.codecool.mavens.model.entity.Location;
import com.codecool.mavens.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/location")
public class LocationController {

    private LocationService locationService;

    @CrossOrigin("*")
    @GetMapping("/all-trial")
    public List<String> getLocationsTrial(){
        return Arrays.asList("Budapest", "Kecskemét", "Békéscsaba");
    }

    @GetMapping("/all")
    public List<Location> getLocations(){
        return locationService.getAll();
    }
}
