package com.ResourceManagement.IT.model;

import com.ResourceManagement.IT.enums.FailureType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Failures")
public class Failure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long failureId;
    private FailureType failureType;
    private String description;

 @OneToMany(mappedBy = "failure")
 @JsonIgnore
    private Set<Ticket> tickets;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "equipment_failures",
            joinColumns = @JoinColumn(name = "failure_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    Set<Equipment> equipment;

}
