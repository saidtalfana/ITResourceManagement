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

    public List<Ticket> getTicketsByUserId(long user_id) {
        return ticketRepository.getTicketsByUserId(user_id);
    }
}
