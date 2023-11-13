package com.polytech.covid.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polytech.covid.Model.Personne;
import com.polytech.covid.Repository.PersonneRepository;

@Service
public class PersonneService {
    
    @Autowired
    private PersonneRepository personneRepository;

    public void create(Personne personne){
        personneRepository.save(personne);
    }

    public Personne findByName(String name){
        return personneRepository.findByName(name);
    }

}
