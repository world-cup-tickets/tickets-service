package ro.upb.acs.worldcuptickets.ticketservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.upb.acs.worldcuptickets.ticketservice.dto.dbservice.CreateTicketDto;
import ro.upb.acs.worldcuptickets.ticketservice.dto.dbservice.TicketDto;
import ro.upb.acs.worldcuptickets.ticketservice.repository.TicketRepository;
import ro.upb.acs.worldcuptickets.ticketservice.service.TicketService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TicketServiceTest {

    private TicketService ticketService;
    private TicketRepository ticketRepository;

    @BeforeEach
    void setUp() {
        ticketRepository = mock(TicketRepository.class);
        ticketService = new TicketService(ticketRepository);
    }

    @Test
    void testGetTicketsByUser() {
        UUID userId = UUID.randomUUID();
        TicketDto ticket1 = new TicketDto(UUID.randomUUID(), userId, UUID.randomUUID(), LocalDateTime.now());
        TicketDto ticket2 = new TicketDto(UUID.randomUUID(), userId, UUID.randomUUID(), LocalDateTime.now());
        List<TicketDto> ticketList = List.of(ticket1, ticket2);

        when(ticketRepository.getTicketsByUserId(userId)).thenReturn(ticketList);

        var tickets = ticketService.getTicketsByUser(userId);

        assertNotNull(tickets);
        assertEquals(2, tickets.size());
        assertEquals(ticket1.id(), tickets.get(0).id());
        assertEquals(ticket2.id(), tickets.get(1).id());
        verify(ticketRepository, times(1)).getTicketsByUserId(userId);
    }

    @Test
    void testCreateTicket() {
        UUID userId = UUID.randomUUID();
        UUID matchId = UUID.randomUUID();
        LocalDateTime reservationDate = LocalDateTime.now();
        CreateTicketDto createTicketDto = new CreateTicketDto(userId, matchId, reservationDate);
        TicketDto ticketDto = new TicketDto(UUID.randomUUID(), userId, matchId, reservationDate);

        when(ticketRepository.createTicket(createTicketDto)).thenReturn(ticketDto);

        var createdTicket = ticketService.createTicket(matchId, new ro.upb.acs.worldcuptickets.ticketservice.dto.CreateTicketRequest(userId, reservationDate));

        assertNotNull(createdTicket);
        assertEquals(ticketDto.id(), createdTicket.id());
        assertEquals(ticketDto.userId(), createdTicket.userId());
        assertEquals(ticketDto.matchId(), createdTicket.matchId());
        assertEquals(ticketDto.reservationDate(), createdTicket.reservationDate());
        verify(ticketRepository, times(1)).createTicket(createTicketDto);
    }

    @Test
    void testDeleteTicket() {
        UUID ticketId = UUID.randomUUID();

        doNothing().when(ticketRepository).deleteTicketById(ticketId);

        ticketService.deleteTicket(ticketId);

        verify(ticketRepository, times(1)).deleteTicketById(ticketId);
    }
}