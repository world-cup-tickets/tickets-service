package ro.upb.acs.worldcuptickets.ticketservice.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import ro.upb.acs.worldcuptickets.ticketservice.dto.TicketDto;
import ro.upb.acs.worldcuptickets.ticketservice.repository.TicketRepository;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<TicketDto> getTicketsByUser(UUID userId) {
        return ticketRepository.getTicketsByUserId(userId);
    }
}
