package com.ResourceManagement.IT.model;

import com.ResourceManagement.IT.enums.FailureType;
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
public class Failure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int failureId;
    private FailureType failureType;
    private String des
            ;
}
