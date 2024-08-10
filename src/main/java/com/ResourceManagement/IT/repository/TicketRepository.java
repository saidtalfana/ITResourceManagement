package com.ResourceManagement.IT.repository;

import com.ResourceManagement.IT.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query(value = "select * from ticket WHERE technician_id =?" , nativeQuery = true)
    List<Ticket> getTicketsByTechnicianId(Long technician_id);

    @Query(value = "select * from ticket WHERE user_id =?" , nativeQuery = true)
    List<Ticket> getTicketsByUserId(Long userId);
}
