package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.model.Ticket;
import com.ResourceManagement.IT.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
