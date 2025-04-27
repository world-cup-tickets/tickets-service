package ro.upb.acs.worldcuptickets.ticketservice.repository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;
import java.util.UUID;

import ro.upb.acs.worldcuptickets.ticketservice.dto.dbservice.CreateTicketDto;
import ro.upb.acs.worldcuptickets.ticketservice.dto.dbservice.TicketDto;

@HttpExchange(url = "/api/v1/tickets")
public interface TicketRepository {

    @GetExchange("/user/{userId}")
    List<TicketDto> getTicketsByUserId(@PathVariable UUID userId);

    @PostExchange("/create")
    TicketDto createTicket(@RequestBody CreateTicketDto ticketDto);

    @DeleteExchange("/{ticketId}/delete")
    void deleteTicketById(@PathVariable UUID ticketId);
}
