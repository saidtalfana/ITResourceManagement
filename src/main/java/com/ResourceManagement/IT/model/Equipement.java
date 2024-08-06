package com.ResourceManagement.IT.model;


import com.ResourceManagement.IT.enums.EquipmentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int equipmentId;
    private String name;
    private String description;
    private String image;
    private String type;
    private EquipmentStatus equipmentStatus;


}
