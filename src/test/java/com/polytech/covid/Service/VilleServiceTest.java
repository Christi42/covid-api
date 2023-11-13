package com.polytech.covid.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.polytech.covid.Model.Center;
import com.polytech.covid.Model.Ville;
import com.polytech.covid.Repository.CenterRepository;
import com.polytech.covid.Repository.VilleRepository;
import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;

import java.util.List;


@SpringBootTest
public class VilleServiceTest {

    @Autowired
    private VilleService villeService ;

    @Autowired
    private VilleRepository villeRepository;

    @Autowired
    private CenterRepository centerRepository;

    @Test
    void testGetCenters() {
        Ville ville = new Ville();
        ville.setName("Nancy");
        villeRepository.save(ville);

        Center center = new Center();
        center.setName("centre");
        center.setVille(ville);
        centerRepository.save(center);

        List<Center> list = villeService.getCenters(ville.getId());
        assertEquals(1, list.size());
        assertEquals(center.getId(), list.get(0).getId());
        assertEquals(center.getName(), list.get(0).getName());
    }

    @Test
    void testGetVilleById() {

    }
}
