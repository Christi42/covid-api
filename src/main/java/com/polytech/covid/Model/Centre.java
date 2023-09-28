package com.polytech.covid.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "center")
public class Centre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Ville ville;

    @OneToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany
    private List<Medecin> medecins;

    @OneToMany(mappedBy = "center")
    private List<Reservation> reservations;
}
