package com.ResourceManagement.IT.controller;


import com.ResourceManagement.IT.model.Ticket;
import com.ResourceManagement.IT.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/two")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.addTicket(ticket);
    }
    @GetMapping("/test")
    public String test() {
        return "ticketService.addTicket(ticket)";
    }



}
