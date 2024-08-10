package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.model.Equipment;
import com.ResourceManagement.IT.model.Failure;
import com.ResourceManagement.IT.model.Ticket;
import com.ResourceManagement.IT.model.User;
import com.ResourceManagement.IT.repository.EquipmentRepository;
import com.ResourceManagement.IT.repository.FailureRepository;
import com.ResourceManagement.IT.repository.TicketRepository;
import com.ResourceManagement.IT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EquipmentRepository   equipmentRepository;

    @Autowired
    private FailureRepository failureRepository;

    public Ticket addTicket(Ticket ticket,long user_id,long equipment_id,long failure_id) {
                User user = userRepository.findById(user_id).get();
                Equipment equipment = equipmentRepository.findById(equipment_id).get();
                Failure failure = failureRepository.findById(failure_id).get();

                        ticket.setUser(user);
                        ticket.setEquipment(equipment);
                        ticket.setFailure(failure);
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket updateTicketByAdmin(Ticket ticket, long id){
        Ticket updateticket = ticketRepository.findById(id).get();
        updateticket.setTechnician(ticket.getTechnician());
        return ticketRepository.save(updateticket);

    }

    public List<Ticket> getAllTicketsByTechnician(long technician_id) {
        return ticketRepository.getTicketsByTechnicianId(technician_id);
    }

    public Ticket updateTicketByTechnician(Ticket ticket, long id){
        Ticket updateticket = ticketRepository.findById(id).get();
        updateticket.setTicketStatus(ticket.getTicketStatus());
        return ticketRepository.save(updateticket);
    }
}
