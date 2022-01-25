package com.codecool.mavens.model.dto;

import com.codecool.mavens.model.dto.CategoryDto;
import com.codecool.mavens.model.entity.Location;
import com.codecool.mavens.model.entity.Profession;
import lombok.Data;

@Data
public class ProfessionDto {

    private Long id;

    private CategoryDto category;

    private String name;

    public ProfessionDto(Profession profession) {
        this.id = profession.getId();
        this.category = new CategoryDto(profession.getCategory());
        this.name = profession.getName();
    }

}
