package com.codecool.mavens.model.dto;

import com.codecool.mavens.model.entity.Location;
import lombok.Data;

@Data
public class LocationDto {

    private long id;
    private String name;

    public LocationDto(Location location) {
        this.id = location.getId();
        this.name = location.getName();
    }
}
