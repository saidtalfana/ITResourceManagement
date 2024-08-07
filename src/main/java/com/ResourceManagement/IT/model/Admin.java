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
@Table(name = "users")
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int adminId;


    @OneToMany(  mappedBy = "admin")
    private Set<Equipment> equipment= new HashSet<>();
}
