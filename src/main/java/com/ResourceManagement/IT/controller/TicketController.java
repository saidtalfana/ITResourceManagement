package com.ResourceManagement.IT.controller;


import com.ResourceManagement.IT.model.Equipment;
import com.ResourceManagement.IT.model.Failure;
import com.ResourceManagement.IT.model.Ticket;
import com.ResourceManagement.IT.model.User;
import com.ResourceManagement.IT.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;




    @PostMapping("/add_ticket")
    public Ticket addTicket(@RequestBody Ticket ticket,
                            @RequestParam long equipment_id,
                            @RequestParam long failure_id,
                            @RequestParam long user_id) {

        return ticketService.addTicket(ticket,equipment_id,failure_id,user_id);
    }

    @PutMapping("/update_ticket_admin")
    public Ticket updateTicketByAdmin(@RequestBody Ticket ticket,@PathVariable long id){
        return ticketService.updateTicketByAdmin(ticket,id);
    }

    @GetMapping("/all_ticket_technician_id/{technician_id}")
    public List<Ticket> getAllTicketByTechnicianId(@PathVariable long technician_id){
        return ticketService.getAllTicketsByTechnician(technician_id);
    }

    @PutMapping("/update_ticket_technician/{id}")
    public Ticket updateTicketByTechnician(@RequestBody Ticket ticket,@PathVariable long id){
        return ticketService.updateTicketByTechnician(ticket,id);
    }


}
