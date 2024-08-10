package com.ResourceManagement.IT.dto;

import com.ResourceManagement.IT.enums.FailureType;
import com.ResourceManagement.IT.model.Ticket;

import java.util.Set;

public class FailureDto {

    private Long failureId;
    private FailureType failureType;
    private String description;
    private Set<Ticket> tickets;
}
