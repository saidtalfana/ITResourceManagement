package com.ResourceManagement.IT.model;


import com.ResourceManagement.IT.enums.EquipmentStatus;
import com.ResourceManagement.IT.model.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int equipmentId;
    private String name;
    private String description;
    private String image;
    private String type;
    private EquipmentStatus equipmentStatus;



    @ManyToOne
    @JoinColumn(name = "admin_id")
     private Admin admin;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private Technician technician;



}
