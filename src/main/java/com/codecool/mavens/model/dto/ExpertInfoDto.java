package com.codecool.mavens.model.dto;

import com.codecool.mavens.model.entity.ExpertInfo;
import com.codecool.mavens.model.entity.Reference;
import com.codecool.mavens.model.entity.Service;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;


@Data
public class ExpertInfoDto {

    private Long id;

    private Double rating;

    private int jobCount;

    private String description;

    private Set<LocationDto> locations;

    private Set<ProfessionDto> professions;

    private Set<Reference> references;

    private Set<Service> services;

    public ExpertInfoDto(ExpertInfo expertInfo) {
        this.id = expertInfo.getId();
        this.rating = expertInfo.getRating();
        this.jobCount = expertInfo.getJobCount();
        this.description = expertInfo.getDescription();
        this.locations = expertInfo.getLocations().stream().map(LocationDto::new).collect(Collectors.toSet());
        this.professions = expertInfo.getProfessions().stream().map(ProfessionDto::new).collect(Collectors.toSet());
        this.references = expertInfo.getReferences();
        this.services = expertInfo.getServices();
    }

}
