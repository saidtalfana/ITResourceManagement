package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.model.*;
import com.ResourceManagement.IT.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TechnicianRepository  technicianRepository;

    @Autowired
    private EquipmentRepository   equipmentRepository;

    @Autowired
    private FailureRepository failureRepository;

    public Ticket addTicket(Ticket ticket, Long equipmentId, Long failureId, Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(equipmentId);
        Optional<Failure> optionalFailure = failureRepository.findById(failureId);

        if (optionalUser.isEmpty() || optionalEquipment.isEmpty() || optionalFailure.isEmpty()) {
            throw new IllegalArgumentException("User, equipment, or failure not found");
        }

        User user = optionalUser.get();
        Equipment equipment = optionalEquipment.get();
        Failure failure = optionalFailure.get();

        ticket.setUser(user);
        ticket.setEquipment(equipment);
        ticket.setFailure(failure);
        ticket.setDate(new Date(System.currentTimeMillis()));
        ticket.setTime(new Time(System.currentTimeMillis()));

        return ticketRepository.save(ticket);
    }


    public Ticket updateTicketByAdmin(Long id,Long technician_id){
        Ticket updateticket = ticketRepository.findById(id).get();
        Technician technician = technicianRepository.findById(technician_id).get();
        updateticket.setTechnician(technician);
        return ticketRepository.save(updateticket);

    }

    public List<Ticket> getAllTicketsByTechnician(Long technician_id) {
        return ticketRepository.getTicketsByTechnicianId(technician_id);
    }

    public Ticket updateTicketByTechnician(Ticket ticket, Long id){
        Ticket updateticket = ticketRepository.findById(id).get();
        updateticket.setTicketStatus(ticket.getTicketStatus());
        return ticketRepository.save(updateticket);
    }

    public List<Ticket> getAllTicketsByUser(Long user_id) {
        return ticketRepository.getTicketsByUserId(user_id);
    }

    public List<Ticket> allTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicket(Long ticketId) {
        return ticketRepository.findById(ticketId).get();
    }
}
