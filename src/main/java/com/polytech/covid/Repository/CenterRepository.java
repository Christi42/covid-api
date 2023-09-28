package com.polytech.covid.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polytech.covid.Model.Centre;
import com.polytech.covid.Model.Ville;

@Repository
public interface CenterRepository extends JpaRepository<Centre, Integer>{

    List<Centre> findByVille(Ville ville);
}
