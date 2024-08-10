package com.ResourceManagement.IT.dto;

import com.ResourceManagement.IT.enums.FailureType;
import com.ResourceManagement.IT.model.Ticket;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FailureDto {

    private Long failureId;
    private FailureType failureType;
    private String description;
    private Set<Ticket> tickets;
}
