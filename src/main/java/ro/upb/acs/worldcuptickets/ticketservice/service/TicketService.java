package ro.upb.acs.worldcuptickets.ticketservice.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import ro.upb.acs.worldcuptickets.ticketservice.dto.CreateTicketRequest;
import ro.upb.acs.worldcuptickets.ticketservice.dto.TicketResponse;
import ro.upb.acs.worldcuptickets.ticketservice.dto.dbservice.CreateTicketDto;
import ro.upb.acs.worldcuptickets.ticketservice.dto.dbservice.TicketDto;
import ro.upb.acs.worldcuptickets.ticketservice.repository.TicketRepository;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<TicketResponse> getTicketsByUser(UUID userId) {
        List<TicketDto> tickets = ticketRepository.getTicketsByUserId(userId);
        return tickets.stream()
            .map(ticket -> new TicketResponse(
                ticket.id(),
                ticket.userId(),
                ticket.matchId(),
                ticket.reservationDate()
            )).toList();
    }

    public TicketResponse createTicket(UUID matchId, CreateTicketRequest createTicketRequest) {
        CreateTicketDto createTicketDto = new CreateTicketDto(
            createTicketRequest.userId(),
            matchId,
            createTicketRequest.reservationDate()
        );
        TicketDto newTicket = ticketRepository.createTicket(createTicketDto);

        return new TicketResponse(
            newTicket.id(),
            newTicket.userId(),
            newTicket.matchId(),
            newTicket.reservationDate()
        );
    }
}
