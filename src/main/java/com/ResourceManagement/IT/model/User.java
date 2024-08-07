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
public class User extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;



    @OneToMany(mappedBy = "user")
    private Set<Ticket> tickets= new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Equipment> Equipements= new HashSet<>();
}
