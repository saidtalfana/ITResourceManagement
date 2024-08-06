package com.ResourceManagement.IT.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class User extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
}
