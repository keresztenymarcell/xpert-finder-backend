package com.codecool.mavens.controller;


import com.codecool.mavens.model.entity.Profession;
import com.codecool.mavens.service.ProfessionService;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/profession")
public class ProfessionController {

    @Autowired
    private ProfessionService professionService;

    @GetMapping("/all-by-categories")
    public Map<Category, List<Profession>> getAllProfessionsByCategories(){
        return professionService.getAllByCategories();
    }

    @GetMapping("/all")
    public List<Profession> getAll(){
        return professionService.getAll();
    }
}
