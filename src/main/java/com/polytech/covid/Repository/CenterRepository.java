package com.polytech.covid.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polytech.covid.Model.Center;
import com.polytech.covid.Model.Ville;

@Repository
public interface CenterRepository extends JpaRepository<Center, Long>{

    //List<Center> findByVilleName(String ville);
    List<Center> findByVille(Ville ville);
}
