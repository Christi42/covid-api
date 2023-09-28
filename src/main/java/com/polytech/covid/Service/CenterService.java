package com.polytech.covid.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polytech.covid.Model.Centre;
import com.polytech.covid.Model.Ville;
import com.polytech.covid.Repository.CenterRepository;

@Service
public class CenterService {
    
    @Autowired
    private CenterRepository centerRepository;

    public List<Centre> getAllCenters(){
        return centerRepository.findAll();
    }

    public List<Centre> getCentersByTown(Ville ville){
        return centerRepository.findByVille(ville);
    }
}
