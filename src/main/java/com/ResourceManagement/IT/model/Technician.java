package com.ResourceManagement.IT.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Technicians")
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int technicianId;



    @OneToMany(mappedBy = "technician")
    private Set<Ticket> tickets= new HashSet<>();

    @OneToMany(mappedBy = "technician")
    private Set<Equipment> equipments= new HashSet<>();
}
