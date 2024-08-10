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
@DiscriminatorValue("technician")
public class Technician extends Person{



    @OneToMany(mappedBy = "technician")
    @JsonIgnore
    private Set<Ticket> tickets= new HashSet<>();


}
