package com.ResourceManagement.IT.model;

import com.ResourceManagement.IT.enums.FailureType;
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
public class Failure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int failureId;
    private FailureType failureType;
    private String description;

 @OneToMany(mappedBy = "failure")
    private Set<Ticket> tickets;

}
