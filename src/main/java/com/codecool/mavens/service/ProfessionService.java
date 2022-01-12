package com.codecool.mavens.service;

import com.codecool.mavens.model.entity.Profession;
import com.codecool.mavens.repository.ProfessionRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ProfessionService {

    @Autowired
    ProfessionRepository professionRepository;

    public List<Profession> getAll(){
        return professionRepository.findAll();
    }

    public Map<Category, List<Profession>> getAllByCategories() {
        return null;
    }
}
