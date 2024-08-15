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
                            @RequestParam Long equipment_id,
                            @RequestParam Long failure_id,
                            @RequestParam Long user_id) {

        return ticketService.addTicket(ticket,equipment_id,failure_id,user_id);
    }
    @GetMapping("/all_ticket")
    public List<Ticket> getAllTicket() {
        return ticketService.allTickets();
    }
     @GetMapping("/get_ticket/{ticket_id}")
     public Ticket getTicket(@PathVariable Long ticket_id) {
        return ticketService.getTicket(ticket_id);

     }
    @PutMapping("/update_ticket_admin/{id}")
    public Ticket updateTicketByAdmin(@PathVariable Long id,@RequestParam Long technician_id){
        return ticketService.updateTicketByAdmin(id,technician_id);
    }

    @GetMapping("/all_ticket_technician_id/{technician_id}")
    public List<Ticket> getAllTicketByTechnicianId(@PathVariable Long technician_id){
        return ticketService.getAllTicketsByTechnician(technician_id);
    }

    @GetMapping("/all_ticket_user_id/{user_id}")
    public List<Ticket> getAllTicketByUserId(@PathVariable Long user_id){
        return ticketService.getAllTicketsByUser(user_id);
    }

    @PutMapping("/update_ticket_technician/{id}")
    public Ticket updateTicketByTechnician(@RequestBody Ticket ticket,@PathVariable Long id){
        return ticketService.updateTicketByTechnician(ticket,id);
    }


}
