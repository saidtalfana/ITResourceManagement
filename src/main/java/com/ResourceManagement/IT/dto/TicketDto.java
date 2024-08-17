package com.ResourceManagement.IT.dto;


import com.ResourceManagement.IT.enums.TicketStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Date;
import java.sql.Time;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketId;
    private Date date;
    private Time time;
    private String description;
    private TicketStatus ticketStatus;


}
