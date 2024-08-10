package com.ResourceManagement.IT.model;


import com.ResourceManagement.IT.enums.EquipmentStatus;
import com.ResourceManagement.IT.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long equipmentId;
    private String name;
    private String description;
    private String image;
    private String type;
    private EquipmentStatus equipmentStatus;



    @ManyToOne
    @JoinColumn(name = "admin_id")
     private Admin admin;

    @OneToMany(mappedBy = "equipment")
    private Set <Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    @ManyToMany(mappedBy = "equipment")
    Set<Failure> failures;



}
