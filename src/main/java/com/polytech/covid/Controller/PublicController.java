package com.polytech.covid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polytech.covid.Model.Centre;
import com.polytech.covid.Model.Ville;
import com.polytech.covid.Service.CenterService;

@RestController
@RequestMapping("/public")
public class PublicController {
    
    @Autowired
    private CenterService centerService;

    @GetMapping("/centers")
    public List<Centre> centers(){
        return centerService.getAllCenters();
    }

    @GetMapping("/{ville}/centers")
    public List<Centre> centersByTown(@PathVariable("ville") Ville ville){
        return centerService.getCentersByTown(ville);
    }
}
