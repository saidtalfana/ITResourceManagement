package com.ResourceManagement.IT.mapper;

import com.ResourceManagement.IT.dto.TicketDto;
import com.ResourceManagement.IT.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface  TicketMapper {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    Ticket toTicketEntity(TicketDto ticketDto);

    TicketDto toTicketDto(Ticket ticket);
}
