package com.codecool.mavens.controller;


import com.codecool.mavens.model.entity.Profession;
import com.codecool.mavens.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/profession")
public class ProfessionController {

    private ProfessionService professionService;

    @GetMapping("/all")
    public List<Profession> getAll(){
        return null;
    }
}
