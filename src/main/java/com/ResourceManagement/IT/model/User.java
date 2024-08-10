package com.ResourceManagement.IT.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@DiscriminatorValue("USER")
public class User extends Person {



    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Ticket> tickets = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Equipment> equipments = new HashSet<>();
}
