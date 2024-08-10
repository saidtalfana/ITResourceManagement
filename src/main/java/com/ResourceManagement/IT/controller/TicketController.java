package com.ResourceManagement.IT.controller;


import com.ResourceManagement.IT.model.Equipment;
import com.ResourceManagement.IT.model.Failure;
import com.ResourceManagement.IT.model.Ticket;
import com.ResourceManagement.IT.model.User;
import com.ResourceManagement.IT.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @GetMapping("/test")
    public String test(){
        return "said every thing will be ok";
    }

    @PostMapping("/add_ticket/{equipment_id}/{failure_id}/{user_id}")
    public Ticket addTicket(@RequestBody Ticket ticket,
                            @PathVariable long equipment_id,
                            @PathVariable long failure_id,
                            @PathVariable long user_id) {

        return ticketService.addTicket(ticket,equipment_id,failure_id,user_id);
    }




}
