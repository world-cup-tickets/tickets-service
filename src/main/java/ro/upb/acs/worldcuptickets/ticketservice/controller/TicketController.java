package ro.upb.acs.worldcuptickets.ticketservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import ro.upb.acs.worldcuptickets.ticketservice.dto.CreateTicketRequest;
import ro.upb.acs.worldcuptickets.ticketservice.dto.TicketResponse;
import ro.upb.acs.worldcuptickets.ticketservice.service.TicketService;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/users/{userId}")
    public List<TicketResponse> getTicketsByUser(@PathVariable UUID userId) {
        return ticketService.getTicketsByUser(userId);
    }

    @PostMapping("matches/{matchId}")
    public TicketResponse createTicket(@PathVariable UUID matchId, @RequestBody CreateTicketRequest createTicketRequest) {
        return ticketService.createTicket(matchId, createTicketRequest);
    }
}
